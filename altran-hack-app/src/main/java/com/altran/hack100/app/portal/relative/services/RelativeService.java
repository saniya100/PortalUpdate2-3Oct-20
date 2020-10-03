package com.altran.hack100.app.portal.relative.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.altran.hack100.app.portal.relative.entity.RelativeEntity;
import com.altran.hack100.app.portal.relative.model.RelativeProjection;
import com.altran.hack100.app.portal.patient.repository.PatientRepository;
import com.altran.hack100.app.portal.relative.entity.RelativeEntity;
import com.altran.hack100.app.portal.relative.model.RelativeModel;
import com.altran.hack100.app.portal.relative.repository.RelativeRepository;

@Service
public class RelativeService {
	
	@Autowired
	RelativeRepository relativeRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	public Long saveRelative(RelativeModel relativeModel) {
		if(patientRepository.existsById(relativeModel.getPatientId())) {
			RelativeEntity relative = relativeModel.toRelativeEntity();
			RelativeEntity relativeCreated = relativeRepository.save(relative);
			return relativeCreated.getId();
		}
		return -1L ;
		
	}
	
public List<RelativeProjection> getRelativeForId(Long relativeId){
		
		Optional<RelativeEntity> docExists = relativeRepository.findById(relativeId);
		List<RelativeProjection> relativeDataById = null;
		if(docExists.isPresent()) {
			relativeDataById = relativeRepository.getRelativeForId(relativeId);
			
		}
		if(!CollectionUtils.isEmpty(relativeDataById)) {
			return relativeDataById;
		} else {
			return Collections.<RelativeProjection>emptyList();
		}
		
		
	}
	
	public void deleteRelative(Long docotrId) {
		relativeRepository.deleteById(docotrId);
	}
	
	public List<RelativeProjection> getRelativeList(){
		return relativeRepository.getRelativeList();
	}
	
	
	

}
