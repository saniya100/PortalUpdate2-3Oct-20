package com.altran.hack100.app.portal.relative.model;

import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

import com.altran.hack100.app.portal.patient.entity.PatientEntity;
import com.altran.hack100.app.portal.patient.model.PatientModel;
import com.altran.hack100.app.portal.patient.repository.PatientRepository;
import com.altran.hack100.app.portal.relative.entity.RelativeEntity;

public class RelativeModel {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PatientModel patientModel;

	
	private String name;
	
	private Integer age;

	private String gender;
	
	private String bloodGroup;
	
	private String mobileNumber;

	private String mailId;
	
	private String password;
	
	private String confirmPassword;
	
	private String relation;
	
	private boolean self;
	
	private Long patientId;

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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public boolean isSelf() {
		return self;
	}

	public void setSelf(boolean self) {
		this.self = self;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public RelativeEntity toRelativeEntity() {
		RelativeModel relativeModel = this;
		RelativeEntity relativeEntity = new RelativeEntity();
		if(relativeModel.isSelf() == true) {
			Optional<PatientEntity> patientEntity = patientRepository.findById(relativeModel.getPatientId());
			
			relativeEntity.setName(patientEntity.get().getName());
			relativeEntity.setAge(patientEntity.get().getAge());
			relativeEntity.setBloodGroup(patientEntity.get().getBloodGroup());
			relativeEntity.setGender(patientEntity.get().getGender());
			relativeEntity.setMailId(patientEntity.get().getMailId());
			relativeEntity.setPassword(patientEntity.get().getPassword());
			relativeEntity.setConfirmPassword(patientEntity.get().getConfirmPassword());
			relativeEntity.setRelation("Self");
		} else {
			relativeEntity.setName(relativeModel.getName());
			relativeEntity.setAge(relativeModel.getAge());
			relativeEntity.setBloodGroup(relativeModel.getBloodGroup());
			relativeEntity.setGender(relativeModel.getGender());
			relativeEntity.setMailId(relativeModel.getMailId());
			relativeEntity.setPassword(relativeModel.getPassword());
			relativeEntity.setConfirmPassword(relativeModel.getConfirmPassword());
			relativeEntity.setRelation(relativeModel.getRelation());
		}
		
		
		return relativeEntity;
		
	}
	
	
	
}
