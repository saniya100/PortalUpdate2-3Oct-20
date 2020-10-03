package com.altran.hack100.app.portal.doctor.controller;


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

import com.altran.hack100.app.portal.doctor.model.DoctorModel;
import com.altran.hack100.app.portal.doctor.model.DoctorProjection;
import com.altran.hack100.app.portal.doctor.services.DoctorService;
import com.altran.hack100.app.portal.model.GenericResponseData;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class DoctorRestController {
	
	Logger log = LoggerFactory.getLogger(DoctorRestController.class);
	
	@Autowired
	Validator validator;
	
	@Autowired
	DoctorService doctorService; 
	

	@ApiOperation(value = "Post Doctor detail", notes = "Post a doctor data")
	@PostMapping(value = "/doctor", produces = "application/json")
	public GenericResponseData<String> saveDoctorData(@RequestBody DoctorModel doctorModel) throws BindException{
		log.info("Doctor Controller Reached");
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(doctorModel, doctorModel.getClass().getName());
		validator.validate(doctorModel, errors);
		if(errors.hasErrors()) {
			throw new BindException();
		}	
		return new GenericResponseData<>("Doctor's detail saved for ID " + doctorService.saveDoctor(doctorModel));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get Doctor for ID")
	@GetMapping(value = "/doctor/{doctorId}", produces = "application/json")
	public GenericResponseData<DoctorProjection> getDoctorForId(@PathVariable("doctorId") Long doctorId){
		return new GenericResponseData<DoctorProjection>(doctorService.getDoctorForId(doctorId));
	}
	
	@ApiOperation(value = "Delete for id")
	@DeleteMapping(value = "/doctor/{doctorId}", produces ="application/json")
	public GenericResponseData<String> deleteDoctor(@PathVariable("doctorId") Long doctorId) {
		doctorService.deleteDoctor(doctorId);
		return new GenericResponseData<>("Doctor's data deleted for ID: " + doctorId);
	}
	
	@ApiOperation(value = "Get Doctor for ID")
	@GetMapping(value = "/doctor/list", produces = "application/json")
	public GenericResponseData<List<DoctorProjection>> getDoctorList(){
		return new GenericResponseData<List<DoctorProjection>>(doctorService.getDoctorList());
	}
	

}
