package com.altran.hack100.app.portal.patient.model;

import java.sql.Blob;
import java.time.LocalDateTime;

public interface MedicalConditionProjection {
	

	public Long getId();
	public LocalDateTime getDate();
	public boolean getDirectlyObserved();
	public String getCurrentSymptoms();
	public Long getTemperature();
	public boolean getFever();
	public boolean getCough();
	public boolean getShortnessOfBreath();
	public boolean getChestPain();
	public String getRemarks();
	public Integer getDay();
	public String getPrescription();
	public Blob getPrescriptionAttach();
	public Long getPatientId();

}
