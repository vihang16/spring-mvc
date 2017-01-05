package org.pkb.springlogin.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.pkb.springlogin.model.CompanyRegVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class CustomValidaor {
	private static final Logger logger =LoggerFactory.getLogger(CustomValidaor.class);
	public boolean validate(CompanyRegVO user) throws Exception {
		
		if(validateEmail(user.getEmail())&&
				validateDoB(user.getDob())&&
				validateName(user.getCompanyName())
				&& validatePassowrdAndConfirmPassword(user.getConfirmPassword(),user.getPassword())
				&& validateUserType(user.getType())){
					return true;
				}
		
		return false;
		
	}
private boolean validateUserType(String type) throws Exception {
	if(type!=null && !("".equalsIgnoreCase(type))){
		logger.debug("in side usertype validation");
		System.out.println("in side usertype validation");
		return true;
	}else{
		throw new Exception("please select user type");
	}
	}
private boolean validatePassowrdAndConfirmPassword(String confirmPassword, String password) throws Exception {
		if(password.equals(confirmPassword))
			return true;
		throw new Exception("Password and confirm passowrd does not match");
		
	}
private boolean validateName(String userName) throws Exception {
	if(userName!=null && !("".equalsIgnoreCase(userName))){
		return true;
	}else{
		throw new Exception("user name required");
	}
	}
private boolean validateDoB(String dob) throws Exception {
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	Date date=null;
	try {
		date=sdf.parse(dob);
		if(!dob.equals(sdf.format(date)))
			date=null;
		
	} catch (ParseException e) {
		throw new Exception("date of birth is required");
	}
	return date!=null;
		
	}
private boolean validateEmail(String email) throws Exception{
	String regex="[0-9a-zA-Z\\+]+([_0-9a-zA-Z\\.\\+]*)@[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})";
	if(email.matches(regex))
		return true;
	else{
		throw new Exception("invalid email");
	}

	
}


}
