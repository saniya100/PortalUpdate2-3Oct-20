package com.altran.hack100.app.portal.doctor.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.altran.hack100.app.portal.doctor.entity.DoctorEntity;

public class DoctorModel {
	
	@NotBlank(message = "Name cannot be Null")
	private String name;
	@NotBlank(message = "Registration number cannot be blank")
	private String registrationNo;
	@NotBlank(message = "Mobile number cannot be blank")
	private String mobileNumber;
	@NotBlank(message = "E-mail Id cannot be blank")
	private String mailId;
	@NotBlank(message = "Password cannot be blank")
	private String password;
	@NotBlank(message = "Confirm password is mandatory")
	private String confirmPassword;
	@NotNull(message = "Years of Experience")
	private String yrsOfExp;
	@NotBlank(message = "Hospital Name is Mandatory")
	private String hospital;
	
	
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


	public DoctorEntity toDoctorEntity() {
		DoctorModel doctorModel = this;
		DoctorEntity doctorEntity = new  DoctorEntity();
		doctorEntity.setName(doctorModel.getName());
		doctorEntity.setRegistrationNo(doctorModel.getRegistrationNo());
		doctorEntity.setPassword(doctorModel.getPassword());
		doctorEntity.setHospital(doctorModel.getHospital());
		doctorEntity.setMobileNumber(doctorModel.getMobileNumber());
		doctorEntity.setMailId(doctorModel.getMailId());
		doctorEntity.setYrsOfExp(doctorModel.getYrsOfExp());
		return doctorEntity;
	}
}
