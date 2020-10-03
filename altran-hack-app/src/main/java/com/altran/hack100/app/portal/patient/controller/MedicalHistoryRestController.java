package com.altran.hack100.app.portal.patient.controller;

import java.net.BindException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altran.hack100.app.portal.model.GenericResponseData;
import com.altran.hack100.app.portal.patient.model.MedicalHistoryModel;
import com.altran.hack100.app.portal.patient.model.MedicalHistoryProjection;
import com.altran.hack100.app.portal.patient.services.MedicalHistoryService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MedicalHistoryRestController {

Logger log = LoggerFactory.getLogger(MedicalHistoryRestController.class);
	
	@Autowired
	Validator validator;
	
	@Autowired
	MedicalHistoryService historyService; 
	
	@ApiOperation(value = "Post Medical History of Patient", notes = "Post a medical history data")
	@PostMapping(value = "/history", produces = "application/json")
	public GenericResponseData<String> saveMedicalHistoryData(@RequestBody MedicalHistoryModel historyModel) throws BindException{
		log.info("MedicalHistory Controller  Reached");
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(historyModel, historyModel.getClass().getName());
		validator.validate(historyModel, errors);
		if(errors.hasErrors()) {
			throw new BindException();
		}	
		return new GenericResponseData<>("Medical History's detail saved for ID " + historyService.saveHistory(historyModel));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get Medical History for ID")
	@GetMapping(value = "/history/{recordId}", produces = "application/json")
	public GenericResponseData<MedicalHistoryProjection> getMedicalHistoryForId(@PathVariable("recordId") Long recordId){
		return new GenericResponseData<MedicalHistoryProjection>(historyService.getMedicalHistoryForId(recordId));
		
	}
	
	@ApiOperation(value = "Delete for id")
	@DeleteMapping(value = "/history/{recordId}", produces ="application/json")
	public GenericResponseData<String> deleteMedicalHistory(@PathVariable("recordId") Long recordId) {
		historyService.deleteMedicalHistory(recordId);
		return new GenericResponseData<>("MedicalHistory's data deleted for ID ");
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get MedicalHistory for ID")
	@GetMapping(value = "/history/list", produces = "application/json")
	public GenericResponseData<List<MedicalHistoryProjection>> getMedicalHistoryList(){
		return new GenericResponseData<List<MedicalHistoryProjection>>((List<MedicalHistoryProjection>) historyService.getMedicalHistoryList());
	}
	

}
