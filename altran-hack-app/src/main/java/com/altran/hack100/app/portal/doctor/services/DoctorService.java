package com.altran.hack100.app.portal.doctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.hack100.app.portal.doctor.entity.DoctorEntity;
import com.altran.hack100.app.portal.doctor.model.DoctorModel;
import com.altran.hack100.app.portal.doctor.model.DoctorProjection;
import com.altran.hack100.app.portal.doctor.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	public Long saveDoctor(DoctorModel doctorModel) {
		DoctorEntity doctor = doctorModel.toDoctorEntity();
		DoctorEntity doctorCreated = doctorRepository.save(doctor);
		return doctorCreated.getId();
	}
	
	
	public DoctorProjection getDoctorForId(Long doctorId){
		
		Optional<DoctorEntity> docExists = doctorRepository.findById(doctorId);
		DoctorProjection doctorDataById = null;
		if(docExists.isPresent()) {
			doctorDataById = doctorRepository.getDoctorForId(doctorId);
		}
		return doctorDataById;
	}
	
	public void deleteDoctor(Long docotrId) {
		doctorRepository.deleteById(docotrId);
	}
	
	public List<DoctorProjection> getDoctorList(){
		return doctorRepository.getDoctorList();
	}
	
	

}
