package com.altran.hack100.app.portal.patient.entity;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class MedicalConditionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURRENT_RECORD_ID")
	private Long id;
	
	@Column(name = "CURRENT_RECORD_DATE")
	private LocalDateTime date;
	
	@Column(name = "DIRECTLY_OBSERVED")
	private boolean directlyObserved;
	@Column(name = "CURRENT_SYMPTOMS")
	private String currentSymptoms;
	@Column(name = "TEMPERATURE")
	private Long temperature;
	@Column(name = "FEVER")
	private boolean fever;
	@Column(name = "COUGH")
	private boolean cough;
	@Column(name = "SHORTNESS_OF_BREATH")
	private boolean shortnessOfBreath;
	@Column(name = "CHESTPAIN")
	private boolean chestPain;
	@Column(name = "REMARK")
	private String remarks;
	@Column(name = "DAY")
	private Integer day;
	
	@Column(name = "PRESCRIPTION")
	private String prescription;
	
	@Lob
	@Column(name = "PRESCRIPTION_ATTACH")
	private Blob prescriptionAttach;
	
	@OneToOne
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patient;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public boolean isDirectlyObserved() {
		return directlyObserved;
	}
	public void setDirectlyObserved(boolean directlyObserved) {
		this.directlyObserved = directlyObserved;
	}
	public String getCurrentSymptoms() {
		return currentSymptoms;
	}
	public void setCurrentSymptoms(String currentSymptoms) {
		this.currentSymptoms = currentSymptoms;
	}
	public Long getTemperature() {
		return temperature;
	}
	public void setTemperature(Long temperature) {
		this.temperature = temperature;
	}
	public boolean isFever() {
		return fever;
	}
	public void setFever(boolean fever) {
		this.fever = fever;
	}
	public boolean isCough() {
		return cough;
	}
	public void setCough(boolean cough) {
		this.cough = cough;
	}
	public boolean isShortnessOfBreath() {
		return shortnessOfBreath;
	}
	public void setShortnessOfBreath(boolean shortnessOfBreath) {
		this.shortnessOfBreath = shortnessOfBreath;
	}
	public boolean isChestPain() {
		return chestPain;
	}
	public void setChestPain(boolean chestPain) {
		this.chestPain = chestPain;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Blob getPrescriptionAttach() {
		return prescriptionAttach;
	}
	public void setPrescriptionAttach(Blob prescriptionAttach) {
		this.prescriptionAttach = prescriptionAttach;
	}
	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "MedicalConditionEntity [id=" + id + ", date=" + date + ", directlyObserved=" + directlyObserved
				+ ", currentSymptoms=" + currentSymptoms + ", temperature=" + temperature + ", fever=" + fever
				+ ", cough=" + cough + ", shortnessOfBreath=" + shortnessOfBreath + ", chestPain=" + chestPain
				+ ", remarks=" + remarks + ", day=" + day + ", prescription=" + prescription + ", prescriptionAttach="
				+ prescriptionAttach + ", patient=" + patient + "]";
	}

}
