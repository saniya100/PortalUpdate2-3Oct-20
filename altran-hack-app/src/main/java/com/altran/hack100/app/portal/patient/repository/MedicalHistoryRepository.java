package com.altran.hack100.app.portal.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.altran.hack100.app.portal.patient.entity.MedicalHistoryEntity;
import com.altran.hack100.app.portal.patient.model.MedicalHistoryProjection;
import com.altran.hack100.app.portal.repository.BaseRepository;

public interface MedicalHistoryRepository extends BaseRepository<MedicalHistoryEntity, Long>{

	@Query(value= "SELECT history.recordDateTime, history.chronicDisease, history.smoker, history.kidneyInfection, history.kidneyAttach, "
			+ "history.diabetes, history.diabeteseType, history.diabeteseAttach ,  history.diabeteseRemark , "
			+ "history.obesity, history.breathingDisease, history.breathingDiseaseAttach ,  history.highBP,  "
			+ "history.highBPAttacht, history.highCholestrol, history.highCholestrolAttach ,  history.Asthma,  "
			+ "history.asthmaAttach, history.patient "
			+ " FROM MedicalHistoryEntity history WHERE  "
			+ "history.id = :recordId")
	
	MedicalHistoryProjection getMedicalHistoryForId(@Param("recordId") Long recordId);	
	
	@Query(value = "SELECT history FROM MedicalHistoryEntity history")
	List<MedicalHistoryProjection> getMedicalHistoryList();
	
	
}
