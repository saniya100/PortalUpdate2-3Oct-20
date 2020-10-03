package com.altran.hack100.app.portal.patient.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.altran.hack100.app.portal.model.GenericResponseData;
import com.altran.hack100.app.portal.patient.entity.PatientEntity;
import com.altran.hack100.app.portal.patient.model.PatientModel;
import com.altran.hack100.app.portal.patient.model.PatientProjection;
import com.altran.hack100.app.portal.patient.repository.PatientRepository;

@Service
public class PatientService {

	
	@Autowired
	PatientRepository patientRepository;

	public Long savePatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		PatientEntity patient = patientModel.toPatientEntity();
		PatientEntity patientCreated = patientRepository.save(patient);
		return patientCreated.getId();
	}
	
	
	public GenericResponseData<List<PatientProjection>> getPatientForId(Long patientId){
		
		Optional<PatientEntity> patientExists = patientRepository.findById(patientId);
		List<PatientProjection> patientDataById = null;
		if(patientExists.isPresent()) {
			patientDataById = patientRepository.getPatientById(patientId);
			
		}
		if(!CollectionUtils.isEmpty(patientDataById)) {
			return new GenericResponseData<>(patientDataById);
		} else {
			return new GenericResponseData<>(Collections.<PatientProjection>emptyList());
		}
		
		
	}
	
	public void deletePatient(Long patientId) {
		patientRepository.deleteById(patientId);
	}
	
	public GenericResponseData<List<PatientProjection>> getPatientList(){
		return new GenericResponseData<>(patientRepository.getPatientList());
	}
	
}
