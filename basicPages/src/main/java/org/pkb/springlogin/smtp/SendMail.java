package org.pkb.springlogin.smtp;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
@Component
public class SendMail {
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	public void sendVerificationMail(Integer id, String email, String randomString) {
		final String from="";
		//String host="localhost";
		Properties props=System.getProperties();
		 props.setProperty("mail.smtp.host", "smtp.gmail.com");
	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
	     props.setProperty("mail.smtp.port", "465");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.debug", "true");
	     props.put("mail.store.protocol", "pop3");
	     props.put("mail.transport.protocol", "smtp");
	     
		Session session=Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "");
             }});
		MimeMessage mimeMessage=new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.setSubject("email verification");
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			String text="Hi Please verify your account by clicking on following link "+
			"<a href=http://localhost:8080/springAssginement/verifyUser?verify="+randomString+">here</a>";
			mimeMessage.setText(text,"UTF-8","html");
			
			Transport.send(mimeMessage);
			System.out.println("message sent succesfully");
		
		} catch (AddressException e) {
		
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
