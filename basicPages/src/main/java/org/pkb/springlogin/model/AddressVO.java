package org.pkb.springlogin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AddressVO {
 private String line1;
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
}
 
 
	
}