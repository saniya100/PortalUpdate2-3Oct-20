package com.altran.hack100.app.portal.patient.model;

import java.sql.Blob;
import java.time.LocalDateTime;

import com.altran.hack100.app.portal.patient.entity.MedicalConditionEntity;

public class MedicalConditionModel {

	private Long id;
	
	private LocalDateTime date;
	
	private boolean directlyObserved;
	
	private String currentSymptoms;
	
	private Long temperature;
	
	private boolean fever;
	
	private boolean cough;
	
	private boolean shortnessOfBreath;
	
	private boolean chestPain;
	
	private String remarks;
	
	private Integer day;
	
	private String prescription;
	
	private Blob prescriptionAttach;
	
	private Long patientId;

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

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public MedicalConditionEntity toMedicalConditionEntity() {
		MedicalConditionModel medicalConditionModel = this;
		MedicalConditionEntity medicalConditionEntity = new MedicalConditionEntity();
		medicalConditionEntity.setDay(medicalConditionModel.getDay());
		medicalConditionEntity.setDate(medicalConditionModel.getDate());
		medicalConditionEntity.setDirectlyObserved(medicalConditionModel.isDirectlyObserved());
		medicalConditionEntity.setFever(medicalConditionModel.isFever());
		medicalConditionEntity.setCough(medicalConditionModel.isCough());
		medicalConditionEntity.setChestPain(medicalConditionModel.isChestPain());
		medicalConditionEntity.setRemarks(medicalConditionModel.getRemarks());
		medicalConditionEntity.setCurrentSymptoms(medicalConditionModel.getCurrentSymptoms());
		medicalConditionEntity.setPrescription(medicalConditionModel.getPrescription());
		medicalConditionEntity.setPrescriptionAttach(medicalConditionModel.getPrescriptionAttach());
		//medicalConditionEntity.setPatient(medicalConditionModel.getPatientId());
		
		return medicalConditionEntity;
	}

}
