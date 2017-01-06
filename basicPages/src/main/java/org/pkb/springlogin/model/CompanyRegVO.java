package org.pkb.springlogin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CompanyRegVO {
private String companyName;
private Integer regNumber;
private String password;
private String confirmPassword;
private String type;
private String email;
private String dob;
private Boolean enabled;
private AddressVO address;

/*private String line1;
private String line2;
private Integer zipCode;
private String state;
private String country;


public String getLine1() {
	return line1;
}
public void setLine1(String line1) {
	this.line1 = line1;
}
public String getLine2() {
	return line2;
}
public void setLine2(String line2) {
	this.line2 = line2;
}
public Integer getZipCode() {
	return zipCode;
}
public void setZipCode(Integer zipCode) {
	this.zipCode = zipCode;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}*/


public AddressVO getAddress() {
	return address;
}
public void setAddress(AddressVO address) {
	this.address = address;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String userName) {
	this.companyName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public Integer getRegNumber() {
	return regNumber;
}
public void setRegNumber(Integer regNumber) {
	this.regNumber = regNumber;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "SignUpInfo [userName=" + companyName + ", password=" + password + ", confirmPassword=" + confirmPassword
			+ ", type=" + type + "]";
}

}
