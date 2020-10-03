package com.altran.hack100.app.portal.patient.controller;

import java.io.IOException;
import java.net.BindException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.altran.hack100.app.portal.model.GenericResponseData;
import com.altran.hack100.app.portal.patient.model.MedicalConditionModel;
import com.altran.hack100.app.portal.patient.model.MedicalConditionProjection;
import com.altran.hack100.app.portal.patient.services.MedicalConditionService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class MedicalConditionRestController {
Logger log = LoggerFactory.getLogger(MedicalConditionRestController.class);
	
	@Autowired
	Validator validator;
	
	@Autowired
	MedicalConditionService medicalConditionService; 
	

	@ApiOperation(value = "Post MedicalCondition detail", notes = "Post a medicalCondition data")
	@PostMapping(value = "/medicalCondition", produces = "application/json")
	public GenericResponseData<String> saveMedicalConditionData(@RequestBody MedicalConditionModel medicalConditionModel) throws BindException{
		log.info("MedicalCondition Controller Reached");
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(medicalConditionModel, medicalConditionModel.getClass().getName());
		validator.validate(medicalConditionModel, errors);
		if(errors.hasErrors()) {
			throw new BindException();
		}	
		return new GenericResponseData<>("MedicalCondition's detail saved for ID " + medicalConditionService.saveMedicalCondition(medicalConditionModel));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get MedicalCondition for ID")
	@GetMapping(value = "/medicalCondition/{medicalConditionId}", produces = "application/json")
	public GenericResponseData<MedicalConditionProjection> getMedicalConditionForId(@PathVariable("medicalConditionId") Long medicalConditionId){
		return new GenericResponseData<MedicalConditionProjection>(medicalConditionService.getMedicalConditionForId(medicalConditionId));
	}
	
	@ApiOperation(value = "Delete for id")
	@DeleteMapping(value = "/medicalCondition/{medicalConditionId}", produces ="application/json")
	public GenericResponseData<String> deleteMedicalCondition(@PathVariable("medicalConditionId") Long medicalConditionId) {
		medicalConditionService.deleteMedicalCondition(medicalConditionId);
		return new GenericResponseData<>("MedicalCondition's data deleted for ID: " + medicalConditionId);
	}
	
	@ApiOperation(value = "Get MedicalCondition for ID")
	@GetMapping(value = "/medicalCondition/list", produces = "application/json")
	public GenericResponseData<List<MedicalConditionProjection>> getMedicalConditionList(){
		return new GenericResponseData<List<MedicalConditionProjection>>(medicalConditionService.getMedicalConditionList());
	}
	
//	@PostMapping("/upload")
//	public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		Path path = Paths.get(fileBasePath + fileName);
//		try {
//			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/files/download/")
//				.path(fileName)
//				.toUriString();
//		return ResponseEntity.ok(fileDownloadUri);
//	}
	
//	@PostMapping("/multi-upload")
//	public ResponseEntity multiUpload(@RequestParam("files") MultipartFile[] files) {
//		List<Object> fileDownloadUrls = new ArrayList<>();
//		Arrays.asList(files)
//				.stream()
//				.forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file).getBody()));
//		return ResponseEntity.ok(fileDownloadUrls);
//	}
	
	
//	@PostMapping("/upload/db")
//	public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file) {
//		Document doc = new Document();
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		doc.setDocName(fileName);
//		try {
//			doc.setFile(file.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		documentDao.save(doc);
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/files/download/")
//				.path(fileName).path("/db")
//				.toUriString();
//		return ResponseEntity.ok(fileDownloadUri);
//	}
}
