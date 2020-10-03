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
import javax.persistence.ManyToOne;

@Entity
public class MedicalHistoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECORD_ID")
	private Long id;
	
	@Column(name = "RECORD_DATETIME")
	private LocalDateTime recordDateTime;
	
	@Column(name = "CHRONIC_DISEASE")
	private boolean chronicDisease;
	
	@Column(name = "SMOKER")
	private boolean smoker;
	
	@Column(name = "KIDNEY_PROBLEM")
	private boolean kidneyInfection;
	@Lob
	@Column(name = "KIDNEY_DETAILS_ATTACHMENT")
	private Blob kidneyAttach;
	
	@Column(name = "DIABETES")
	private boolean diabetes;
	@Column(name = "DIABETES_TYPE")
	private String diabeteseType;
	@Lob
	@Column(name = "DIABETES_DETAIL_ATTACHMENT")
	private Blob diabeteseAttach;
	@Column(name = "DIABETES_DETAIL_REMARK")
	private String diabeteseRemark;
	
	@Column(name = "OBESITY")
	private boolean obesity;
	
	@Column(name = "BREATHING_DISEASE")
	private boolean breathingDisease;
	@Lob
	@Column(name = "BREATHING_DISEASE_DETAIL_ATTACHMENT")
	private Blob breathingDiseaseAttach;
	
	
	@Column(name = "HIGH_BLOOD_PRESSUE")
	private boolean highBP;
	@Lob
	@Column(name = "HIGHBP_DETAIL_ATTACHMENT")
	private Blob highBPAttacht;
	
	@Column(name = "HIGH_CHOLESTEROL")
	private boolean highCholestrol;
	@Lob
	@Column(name = "HIGH_CHOLESTEROL_DETAIL_ATTACHMENT")
	private Blob highCholestrolAttach;
	
	@Column(name = "ASTHMA")
	private boolean Asthma;
	@Lob
	@Column(name = "ASTHMAL_DETAIL_ATTACHMENT")
	private Blob asthmaAttach;
	
	@ManyToOne
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "MedicalHistoryEntity [id=" + id + ", recordDateTime=" + recordDateTime + ", chronicDisease="
				+ chronicDisease + ", smoker=" + smoker + ", kidneyInfection=" + kidneyInfection + ", kidneyAttach="
				+ kidneyAttach + ", diabetes=" + diabetes + ", diabeteseType=" + diabeteseType + ", diabeteseAttach="
				+ diabeteseAttach + ", diabeteseRemark=" + diabeteseRemark + ", obesity=" + obesity
				+ ", breathingDisease=" + breathingDisease + ", breathingDiseaseAttach=" + breathingDiseaseAttach
				+ ", highBP=" + highBP + ", highBPAttacht=" + highBPAttacht + ", highCholestrol=" + highCholestrol
				+ ", highCholestrolAttach=" + highCholestrolAttach + ", Asthma=" + Asthma + ", asthmaAttach="
				+ asthmaAttach + ", patient=" + patient + "]";
	}
	
	
	
	
	

}
