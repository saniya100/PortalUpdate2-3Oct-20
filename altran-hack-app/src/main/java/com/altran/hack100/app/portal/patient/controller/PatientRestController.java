package com.altran.hack100.app.portal.patient.controller;

import java.net.BindException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altran.hack100.app.portal.model.GenericResponseData;
import com.altran.hack100.app.portal.patient.model.PatientModel;
import com.altran.hack100.app.portal.patient.model.PatientProjection;
import com.altran.hack100.app.portal.patient.services.PatientService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class PatientRestController {
Logger log = LoggerFactory.getLogger(PatientRestController.class);
	
	@Autowired
	Validator validator;
	
	@Autowired
	PatientService patientService; 
	
	@ApiOperation(value = "Post Patient detail", notes = "Post a patient data")
	@PostMapping(value = "/patient", produces = "application/json")
	public GenericResponseData<String> savePatientData(@RequestBody PatientModel patientModel) throws BindException{
		log.info("Patient Controller Reached");
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(patientModel, patientModel.getClass().getName());
		validator.validate(patientModel, errors);
		if(errors.hasErrors()) {
			throw new BindException();
		}	
		return new GenericResponseData<>("Patient's detail saved for ID " + patientService.savePatient(patientModel));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get Patient for ID")
	@GetMapping(value = "/patient/{patientId}", produces = "application/json")
	public GenericResponseData<List<PatientProjection>> getPatientForId(@PathVariable("patientId") Long patientId){
		return new GenericResponseData<List<PatientProjection>>((List<PatientProjection>) patientService.getPatientForId(patientId));
	}
	
	@ApiOperation(value = "Delete for id")
	@DeleteMapping(value = "/patient/{patientId}", produces ="application/json")
	public GenericResponseData<String> deletePatient(@PathVariable("patientId") Long patientId) {
		patientService.deletePatient(patientId);
		return new GenericResponseData<>("Patient's data deleted for ID ");
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get Patient for ID")
	@GetMapping(value = "/patient/list", produces = "application/json")
	public GenericResponseData<List<PatientProjection>> getPatientList(){
		return new GenericResponseData<List<PatientProjection>>((List<PatientProjection>) patientService.getPatientList());
	}
	
}
