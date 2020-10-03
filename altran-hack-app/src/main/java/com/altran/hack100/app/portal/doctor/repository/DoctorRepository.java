package com.altran.hack100.app.portal.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altran.hack100.app.portal.doctor.entity.DoctorEntity;
import com.altran.hack100.app.portal.doctor.model.DoctorProjection;
import com.altran.hack100.app.portal.repository.BaseRepository;


@Repository
public interface DoctorRepository extends BaseRepository<DoctorEntity, Long>{

	@Query(value= "SELECT docEn.id as id, docEn.name as name, docEn.registrationNo as registrationNo, "
			+ "docEn.mobileNumber as mobileNumber, docEn.mailId as mailId, docEn.password as password, "
			+ "docEn.confirmPassword as confirmPassword, docEn.yrsOfExp as yrsOfExp, "
			+ "docEn.hospital as hospital FROM DoctorEntity docEn "
			+ "WHERE docEn.id = :doctorId")
	DoctorProjection getDoctorForId(@Param("doctorId") Long doctorId);	
	
	@Query(value = "SELECT docEn FROM DoctorEntity docEn")
	List<DoctorProjection> getDoctorList();
	
}
