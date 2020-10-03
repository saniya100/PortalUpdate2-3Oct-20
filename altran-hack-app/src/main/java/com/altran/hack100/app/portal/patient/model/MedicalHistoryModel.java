package com.altran.hack100.app.portal.patient.model;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.altran.hack100.app.portal.patient.entity.MedicalHistoryEntity;
import com.altran.hack100.app.portal.patient.entity.PatientEntity;

public class MedicalHistoryModel {

	private LocalDateTime recordDateTime;

	@NotBlank(message = "chronicDisease cannot be Null")
	private boolean chronicDisease;

	@NotBlank(message = "smoker cannot be Null")
	private boolean smoker;

	@NotBlank(message = "kidneyInfection cannot be Null")
	private boolean kidneyInfection;
	
	@NotBlank(message = "kidneyAttach cannot be Null")
	private Blob kidneyAttach;

	@NotBlank(message = "diabetes cannot be Null")
	private boolean diabetes;
	
	@NotBlank(message = "diabeteseType cannot be Null")
	private String diabeteseType;
	
	@NotBlank(message = "diabeteseAttach cannot be Null")
	private Blob diabeteseAttach;
	
	@NotBlank(message = "diabeteseRemark cannot be Null")
	private String diabeteseRemark;

	@NotBlank(message = "obesity cannot be Null")
	private boolean obesity;

	@NotBlank(message = "breathingDisease cannot be Null")
	private boolean breathingDisease;
	
	@NotBlank(message = "breathingDiseaseAttach cannot be Null")
	private Blob breathingDiseaseAttach;


	@NotBlank(message = "highBP cannot be Null")
	private boolean highBP;
	
	@NotBlank(message = "highBPAttacht cannot be Null")
	private Blob highBPAttacht;

	@NotBlank(message = "highCholestrol cannot be Null")
	private boolean highCholestrol;
	
	@NotBlank(message = "highCholestrolAttach cannot be Null")
	private Blob highCholestrolAttach;

	@NotBlank(message = "Asthma cannot be Null")
	private boolean Asthma;
	
	@NotBlank(message = "asthmaAttach cannot be Null")
	private Blob asthmaAttach;

	@NotBlank(message = "patient cannot be Null")
	private PatientEntity patient;

	public LocalDateTime getRecordDateTime() {
		return recordDateTime;
	}

	public void setRecordDateTime(LocalDateTime recordDateTime) {
		this.recordDateTime = recordDateTime;
	}

	public boolean isChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(boolean chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public boolean isKidneyInfection() {
		return kidneyInfection;
	}

	public void setKidneyInfection(boolean kidneyInfection) {
		this.kidneyInfection = kidneyInfection;
	}

	public Blob getKidneyAttach() {
		return kidneyAttach;
	}

	public void setKidneyAttach(Blob kidneyAttach) {
		this.kidneyAttach = kidneyAttach;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public String getDiabeteseType() {
		return diabeteseType;
	}

	public void setDiabeteseType(String diabeteseType) {
		this.diabeteseType = diabeteseType;
	}

	public Blob getDiabeteseAttach() {
		return diabeteseAttach;
	}

	public void setDiabeteseAttach(Blob diabeteseAttach) {
		this.diabeteseAttach = diabeteseAttach;
	}

	public String getDiabeteseRemark() {
		return diabeteseRemark;
	}

	public void setDiabeteseRemark(String diabeteseRemark) {
		this.diabeteseRemark = diabeteseRemark;
	}

	public boolean isObesity() {
		return obesity;
	}

	public void setObesity(boolean obesity) {
		this.obesity = obesity;
	}

	public boolean isBreathingDisease() {
		return breathingDisease;
	}

	public void setBreathingDisease(boolean breathingDisease) {
		this.breathingDisease = breathingDisease;
	}

	public Blob getBreathingDiseaseAttach() {
		return breathingDiseaseAttach;
	}

	public void setBreathingDiseaseAttach(Blob breathingDiseaseAttach) {
		this.breathingDiseaseAttach = breathingDiseaseAttach;
	}

	public boolean isHighBP() {
		return highBP;
	}

	public void setHighBP(boolean highBP) {
		this.highBP = highBP;
	}

	public Blob getHighBPAttacht() {
		return highBPAttacht;
	}

	public void setHighBPAttacht(Blob highBPAttacht) {
		this.highBPAttacht = highBPAttacht;
	}

	public boolean isHighCholestrol() {
		return highCholestrol;
	}

	public void setHighCholestrol(boolean highCholestrol) {
		this.highCholestrol = highCholestrol;
	}

	public Blob getHighCholestrolAttach() {
		return highCholestrolAttach;
	}

	public void setHighCholestrolAttach(Blob highCholestrolAttach) {
		this.highCholestrolAttach = highCholestrolAttach;
	}

	public boolean isAsthma() {
		return Asthma;
	}

	public void setAsthma(boolean asthma) {
		Asthma = asthma;
	}

	public Blob getAsthmaAttach() {
		return asthmaAttach;
	}

	public void setAsthmaAttach(Blob asthmaAttach) {
		this.asthmaAttach = asthmaAttach;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	
	public MedicalHistoryEntity toMedicalHistoryEntity() {
		MedicalHistoryModel historyModel = this;
		MedicalHistoryEntity historyEntity = new  MedicalHistoryEntity();
		historyEntity.setRecordDateTime(historyModel.getRecordDateTime());
		historyEntity.setChronicDisease(historyModel.isChronicDisease());
		historyEntity.setSmoker(historyModel.isSmoker());
		historyEntity.setKidneyInfection(historyModel.isKidneyInfection());
		historyEntity.setKidneyAttach(historyModel.getKidneyAttach());
		historyEntity.setDiabetes(historyModel.isDiabetes());
		historyEntity.setDiabeteseType(historyModel.getDiabeteseType());
		
		historyEntity.setDiabeteseAttach(historyModel.getDiabeteseAttach());
		historyEntity.setDiabeteseRemark(historyModel.getDiabeteseRemark());
		historyEntity.setObesity(historyModel.isObesity());
		historyEntity.setBreathingDisease(historyModel.isBreathingDisease());
		historyEntity.setBreathingDiseaseAttach(historyModel.getBreathingDiseaseAttach());
		historyEntity.setHighBP(historyModel.isHighBP());
		historyEntity.setHighBPAttacht(historyModel.getHighBPAttacht());
		historyEntity.setHighCholestrol(historyModel.isHighCholestrol());
		historyEntity.setHighCholestrolAttach(historyModel.getHighCholestrolAttach());
		historyEntity.setAsthma(historyModel.isAsthma());
		historyEntity.setAsthmaAttach(historyModel.getAsthmaAttach());
		historyEntity.setPatient(historyModel.getPatient());
		return historyEntity;
	}
}
