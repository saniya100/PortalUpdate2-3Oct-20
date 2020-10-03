package com.altran.hack100.app.portal.relative.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altran.hack100.app.portal.relative.entity.RelativeEntity;
import com.altran.hack100.app.portal.relative.model.RelativeProjection;
import com.altran.hack100.app.portal.repository.BaseRepository;

@Repository
public interface RelativeRepository extends BaseRepository<RelativeEntity, Long>{
	
	@Query(value= "SELECT relEn.id as id, relEn.name as name, relEn.age as age, "
			+ " relEn.mobileNumber as mobileNumber, relEn.mailId as mailId, relEn.password as password, "
			+ " relEn.confirmPassword as confirmPassword, relEn.gender as gender, "
			+ " relEn.bloodGroup as bloodGroup, relEn.relation as relation, "
			+ " relEn.self as self, relEn.patient.id as patientId FROM RelativeEntity relEn "
			+ " LEFT JOIN PatientEntity pEn ON pEn.id = relEn.patient.id "
			+ " WHERE relEn.id = :relativeId")
	List<RelativeProjection> getRelativeForId(@Param("relativeId") Long relativeId);	
	
	
	@Query(value = "SELECT relEn FROM RelativeEntity relEn")
	List<RelativeProjection> getRelativeList();

}
