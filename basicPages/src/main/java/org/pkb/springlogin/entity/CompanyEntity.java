package org.pkb.springlogin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="company")
public class CompanyEntity implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = -8212569256812972650L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="reg_id")
private Integer regId;
@Column
private Integer regNumber;
@Column
private String name;
@Column(nullable=false,unique=false)
private String email;
@Column(name="date_of_birth")
private Date dob;
@Column(nullable=false)
private String password;

@Column(nullable=false)
private Boolean acitve;
@OneToOne(fetch=FetchType.LAZY,mappedBy="id",cascade=CascadeType.ALL)
private AddressEntity address;

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Boolean getAcitve() {
	return acitve;
}
public void setAcitve(Boolean acitve) {
	this.acitve = acitve;
}
public Integer getRegId() {
	return regId;
}
public void setRegId(Integer regId) {
	this.regId = regId;
}
public Integer getRegNumber() {
	return regNumber;
}
public void setRegNumber(Integer regNumber) {
	this.regNumber = regNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDob() {
	return dob;
}
public AddressEntity getAddress() {
	return address;
}
public void setAddress(AddressEntity address) {
	this.address = address;
}
public void setDob(Date dob) {
	this.dob = dob;
}



}
