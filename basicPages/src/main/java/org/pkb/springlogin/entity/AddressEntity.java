package org.pkb.springlogin.entity;

import java.io.Serializable;

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
@Table(name="address")
public class AddressEntity implements Serializable {
/**
	 * 
	 */
private static final long serialVersionUID = 7014443741929191140L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Integer addressId;
@Column(nullable=false)
private String line1;
@Column
private String line2;
@Column(nullable=false)
private Integer zipCode;
@Column
private String state;
@Column
private String country;

public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}
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
