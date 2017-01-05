package org.pkb.springlogin.util;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceUtil {
	private static final Logger logger =
			LoggerFactory.getLogger(ServiceUtil.class);
	private static final char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWX0123456789".toCharArray();

public static java.sql.Date stringToDateConverter(String string){
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	logger.debug("dob:"+string);
	Date date=new Date();
	java.sql.Date sqlDate=null;
	try {
	date=sdf.parse(string);
 sqlDate=new java.sql.Date(date.getTime());
 System.out.println("sql date:"+sqlDate);
		
	} catch (ParseException e) {
		logger.debug("exception in parsing date");
		
	}
	return sqlDate;
}
public static String getRandomString() {
	 Random random = new SecureRandom();
     char[] result = new char[10];
     for (int i = 0; i < result.length; i++) {
         // picks a random index out of character set > random character
         int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
         result[i] = CHARSET_AZ_09[randomCharIndex];
     }
     return new String(result);


	
}
}
