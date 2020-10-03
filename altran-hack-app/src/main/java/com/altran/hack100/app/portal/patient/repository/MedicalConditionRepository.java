package com.altran.hack100.app.portal.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altran.hack100.app.portal.patient.entity.MedicalConditionEntity;
import com.altran.hack100.app.portal.patient.model.MedicalConditionProjection;
import com.altran.hack100.app.portal.repository.BaseRepository;

@Repository
public interface MedicalConditionRepository extends BaseRepository<MedicalConditionEntity, Long>{

	@Query(value= "SELECT MedCondEn.id as id, MedCondEn.date as date, MedCondEn.directlyObserved as directlyObserved, "
			+ "MedCondEn.currentSymptoms as currentSymptoms, MedCondEn.temperature as temperature, "
			+ "MedCondEn.fever as fever, MedCondEn.cough as cough, MedCondEn.shortnessOfBreath as shortnessOfBreath, "
			+ "MedCondEn.chestPain as chestPain , MedCondEn.remarks as remarks, MedCondEn.day as day, "
			+ "MedCondEn.prescription as prescription, MedCondEn.patient.id as patientId "
			+ "FROM MedicalConditionEntity MedCondEn "
			+ "WHERE MedCondEn.id = :medicalConditionId")
	MedicalConditionProjection getMedicalConditionForId(@Param("medicalConditionId") Long medicalConditionId);	
	
	@Query(value = "SELECT docEn FROM MedicalConditionEntity docEn")
	List<MedicalConditionProjection> getMedicalConditionList();
}
