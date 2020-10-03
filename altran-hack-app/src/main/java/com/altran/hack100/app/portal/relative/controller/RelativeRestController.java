package com.altran.hack100.app.portal.relative.controller;

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

import com.altran.hack100.app.portal.relative.controller.RelativeRestController;
import com.altran.hack100.app.portal.relative.model.RelativeModel;
import com.altran.hack100.app.portal.relative.model.RelativeProjection;
import com.altran.hack100.app.portal.model.GenericResponseData;
import com.altran.hack100.app.portal.relative.services.RelativeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class RelativeRestController {

Logger log = LoggerFactory.getLogger(RelativeRestController.class);
	
	@Autowired
	Validator validator;
	
	@Autowired
	RelativeService relativeService;
	
	@ApiOperation(value = "Post Relative's detail", notes = "Post a Relative data")
	@PostMapping(value = "/relative", produces = "application/json")
	public GenericResponseData<String> saveRelativeData(@RequestBody RelativeModel relativeModel) throws BindException{
		log.info("Relative Controller Reached");
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(relativeModel, relativeModel.getClass().getName());
		validator.validate(relativeModel, errors);
		if(errors.hasErrors()) {
			throw new BindException();
		}	
		return new GenericResponseData<>("Relative's detail saved for ID " + relativeService.saveRelative(relativeModel));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get Relative for ID")
	@GetMapping(value = "/relative/{relativeId}", produces = "application/json")
	public GenericResponseData<List<RelativeProjection>> getRelativeForId(@PathVariable("relativeId") Long relativeId){
		return new GenericResponseData<List<RelativeProjection>>(relativeService.getRelativeForId(relativeId));
	}
	
	@ApiOperation(value = "Delete for id")
	@DeleteMapping(value = "/relative/{relativeId}", produces ="application/json")
	public GenericResponseData<String> deleteRelative(@PathVariable("relativeId") Long relativeId) {
		relativeService.deleteRelative(relativeId);
		return new GenericResponseData<>("Relative's data deleted for ID ");
	}
	
	@ApiOperation(value = "Get Relative for ID")
	@GetMapping(value = "/relative/list", produces = "application/json")
	public GenericResponseData<List<RelativeProjection>> getRelativeList(){
		return new GenericResponseData<List<RelativeProjection>>(relativeService.getRelativeList());
	}
	
	
	
	
	
}
