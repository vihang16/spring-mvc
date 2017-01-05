package org.pkb.springlogin.manager;

import org.pkb.springlogin.dao.CompanyInfoDao;
import org.pkb.springlogin.smtp.SendMail;
import org.pkb.springlogin.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailHandler {
	@Autowired
	SendMail sendMail;
	@Autowired
	CompanyInfoDao companyInfoDao;

	
	public String sendVerificationMail(Integer id, String email) {
	String randomString=	ServiceUtil.getRandomString();
	
	companyInfoDao.setVerificationData(id,randomString.trim());
	sendMail.sendVerificationMail(id,email,randomString);
		return randomString;
		
		
		
	}

}
