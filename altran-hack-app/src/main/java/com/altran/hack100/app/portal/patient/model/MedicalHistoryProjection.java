package com.altran.hack100.app.portal.patient.model;

import java.sql.Blob;
import java.time.LocalDateTime;

import com.altran.hack100.app.portal.patient.entity.PatientEntity;

public interface MedicalHistoryProjection {

	public LocalDateTime getRecordDateTime();
	public boolean isChronicDisease();
	public boolean isSmoker();
	public boolean isKidneyInfection();
	public Blob getKidneyAttach();
	public boolean isDiabetes();
	public String getDiabeteseType();
	
	public Blob getDiabeteseAttach();
	public String getDiabeteseRemark();
	public boolean isObesity();
	public boolean isBreathingDisease();
	public Blob getBreathingDiseaseAttach();
	public boolean isHighBP();
	public Blob getHighBPAttacht();
	public boolean isHighCholestrol();
	public Blob getHighCholestrolAttach();
	public boolean isAsthma();
	public Blob getAsthmaAttach();
	public PatientEntity getPatient();
}
