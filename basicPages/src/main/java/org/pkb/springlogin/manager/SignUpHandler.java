package org.pkb.springlogin.manager;

import org.pkb.springlogin.dao.CompanyInfoDao;
import org.pkb.springlogin.model.CompanyRegVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("signUpHandler")
public class SignUpHandler {
	@Autowired
	CustomValidaor customValidator;
	@Autowired
	CompanyInfoDao companyDao;

	public Integer process(CompanyRegVO user) throws Exception {
		Integer id=null;
		if(customValidator.validate(user)){
			if(companyDao.isExistingUser(user.getEmail())){
				System.out.println("user is not exisiting");
				id=companyDao.saveUserInfo(user);
			}
		}
return id;
	}

	public void verifyUser(String verificationValue) {
		Integer id=companyDao.getUserId(verificationValue);
		if(id!=null){
			companyDao.enableUser(id);
		}
		
	}

}
