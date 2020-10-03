package com.altran.hack100.app.portal.doctor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCTOR_ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNo;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "EMAIL_ID")
	private String mailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CONFIRM_PASSWORD")
	private String confirmPassword;
	@Column(name = "YEARS_OF_EXPERIENCE")
	private String yrsOfExp;
	@Column(name = "HOSPITAL")
	private String hospital;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getYrsOfExp() {
		return yrsOfExp;
	}
	public void setYrsOfExp(String yrsOfExp) {
		this.yrsOfExp = yrsOfExp;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", name=" + name + ", registrationNo=" + registrationNo + ", mobileNumber="
				+ mobileNumber + ", mailId=" + mailId + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", yrsOfExp=" + yrsOfExp + ", hospital=" + hospital + "]";
	}
	
	

}
