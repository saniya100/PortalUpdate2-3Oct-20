package com.altran.hack100.app.portal.relative.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.altran.hack100.app.portal.patient.entity.PatientEntity;

@Entity
public class RelativeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RELATIVE_ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "AGE")
	private Integer age;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "BLOOD_GROUP")
	private String bloodGroup;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "EMAIL_ID")
	private String mailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CONFIRM_PASSWORD")
	private String confirmPassword;
	@Column(name = "RELATION")
	private String relation;
	@Column(name = "SELF")
	private boolean self;
	
	@OneToOne
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patient;

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

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "RelativeEntity [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", bloodGroup="
				+ bloodGroup + ", mobileNumber=" + mobileNumber + ", mailId=" + mailId + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", relation=" + relation + ", self=" + self + ", patient="
				+ patient + "]";
	}
	

	
	
	

}
