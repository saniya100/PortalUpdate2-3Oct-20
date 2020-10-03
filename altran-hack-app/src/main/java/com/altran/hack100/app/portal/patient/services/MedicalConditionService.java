package com.altran.hack100.app.portal.patient.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.hack100.app.portal.patient.entity.MedicalConditionEntity;
import com.altran.hack100.app.portal.patient.model.MedicalConditionModel;
import com.altran.hack100.app.portal.patient.model.MedicalConditionProjection;
import com.altran.hack100.app.portal.patient.repository.MedicalConditionRepository;
import com.altran.hack100.app.portal.patient.repository.PatientRepository;
@Service
public class MedicalConditionService {
	
	@Autowired
	MedicalConditionRepository medicalConditionRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	public Long saveMedicalCondition(MedicalConditionModel medicalConditionModel) {
		if(patientRepository.existsById(medicalConditionModel.getPatientId())) {
			MedicalConditionEntity medicalCondition = medicalConditionModel.toMedicalConditionEntity();
			MedicalConditionEntity medicalConditionCreated = medicalConditionRepository.save(medicalCondition);
			return medicalConditionCreated.getId();
		}
		return -1L ;
		
	}
	
public MedicalConditionProjection getMedicalConditionForId(Long medicalConditionId){
		
		Optional<MedicalConditionEntity> docExists = medicalConditionRepository.findById(medicalConditionId);
		MedicalConditionProjection medicalConditionDataById = null;
		if(docExists.isPresent()) {
			medicalConditionDataById = medicalConditionRepository.getMedicalConditionForId(medicalConditionId);
			
		}
		return medicalConditionDataById;	
	}
	
	public void deleteMedicalCondition(Long docotrId) {
		medicalConditionRepository.deleteById(docotrId);
	}
	
	public List<MedicalConditionProjection> getMedicalConditionList(){
		return medicalConditionRepository.getMedicalConditionList();
	}

}
