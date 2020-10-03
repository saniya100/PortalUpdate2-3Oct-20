package com.altran.hack100.app.portal.patient.model;

import javax.validation.constraints.NotBlank;

import com.altran.hack100.app.portal.patient.entity.PatientEntity;

public class PatientModel {

	@NotBlank(message = "Name cannot be Null")
	private String name;

	@NotBlank(message = "Age cannot be Null")
	private Integer age;
	
	@NotBlank(message = "Gender cannot be Null")
	private String gender;
	
	@NotBlank(message = "BloodGroup cannot be Null")
	private String bloodGroup;
	
	@NotBlank(message = "MobileNumber cannot be Null")
	private String mobileNumber;
	
	@NotBlank(message = "Mailid cannot be Null")
	private String mailId;

	@NotBlank(message = "Password cannot be Null")
	private String password;
	
	@NotBlank(message = "ConfirmPassword cannot be Null")
	private String confirmPassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	
	public PatientEntity toPatientEntity() {
		PatientModel patientModel = this;
		PatientEntity patientEntity = new  PatientEntity();
		patientEntity.setName(patientModel.getName());
		patientEntity.setAge(patientModel.getAge());
		patientEntity.setGender(patientModel.getGender());
		patientEntity.setBloodGroup(patientModel.getBloodGroup());
		patientEntity.setMobileNumber(patientModel.getMobileNumber());
		patientEntity.setMailId(patientModel.getMailId());
		patientEntity.setPassword(patientModel.getPassword());
		patientEntity.setConfirmPassword(patientModel.getConfirmPassword());
		return patientEntity;
	}
}
