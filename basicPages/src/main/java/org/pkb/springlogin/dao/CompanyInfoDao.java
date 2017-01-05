package org.pkb.springlogin.dao;

import java.util.List;

import org.pkb.springlogin.model.CompanyRegVO;

public interface CompanyInfoDao {

	CompanyRegVO findUserInfo(String username);

	List<String> getUserRoles(String username);

	boolean isExistingUser(String email);

	Integer saveUserInfo(CompanyRegVO user);

	void setVerificationData(Integer id, String trim);

	Integer getUserId(String verificationValue);

	void enableUser(Integer id);

}
