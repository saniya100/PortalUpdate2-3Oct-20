package com.altran.hack100.app.portal.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altran.hack100.app.portal.patient.entity.PatientEntity;
import com.altran.hack100.app.portal.patient.model.PatientProjection;
import com.altran.hack100.app.portal.repository.BaseRepository;

@Repository
public interface PatientRepository extends BaseRepository<PatientEntity, Long>{

	@Query(value= "SELECT pen.name, pen.age, pen.gender, pen.bloodGroup, pen.mobileNumber, "
			+ "pen.mailId, pen.password, pen.confirmPassword FROM PatientEntity pen WHERE "
			+ "pen.id = :patientId")
	List<PatientProjection> getPatientById(@Param("patientId") Long patientId);	
	
	@Query(value = "SELECT pen FROM PatientEntity pen")
	List<PatientProjection> getPatientList();
	
	@Query(value = "SELECT a FROM PatientEntity a where a.name=:name")
	public List<PatientEntity> fetchSpecificpatientList( @Param("name") String name);
}
