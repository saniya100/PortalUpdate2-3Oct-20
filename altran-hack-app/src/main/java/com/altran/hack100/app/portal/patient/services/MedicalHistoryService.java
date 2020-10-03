package com.altran.hack100.app.portal.patient.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.altran.hack100.app.portal.model.GenericResponseData;
import com.altran.hack100.app.portal.patient.entity.MedicalHistoryEntity;
import com.altran.hack100.app.portal.patient.model.MedicalHistoryModel;
import com.altran.hack100.app.portal.patient.model.MedicalHistoryProjection;
import com.altran.hack100.app.portal.patient.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {

	@Autowired
	MedicalHistoryRepository historyRepository;

	public Long saveHistory(MedicalHistoryModel historyModel) {
		MedicalHistoryEntity history = historyModel.toMedicalHistoryEntity();
		MedicalHistoryEntity historyCreated = historyRepository.save(history);
		return historyCreated.getId();
	}
	
	
	public MedicalHistoryProjection getMedicalHistoryForId(Long recordId){
		
		Optional<MedicalHistoryEntity> historyExists = historyRepository.findById(recordId);
		MedicalHistoryProjection historyDataById = null;
		if(historyExists.isPresent()) {
			historyDataById = historyRepository.getMedicalHistoryForId(recordId);
			
		}
		return historyDataById;
	}
	
	public void deleteMedicalHistory(Long recordId) {
		historyRepository.deleteById(recordId);
	}
	
	public GenericResponseData<List<MedicalHistoryProjection>> getMedicalHistoryList(){
		return new GenericResponseData<>(historyRepository.getMedicalHistoryList());
	}
	
}
