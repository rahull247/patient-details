package com.pms.deatils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.deatils.entity.PatientAllergyEntity;
import com.pms.deatils.entity.PatientAndAllergyEntity;
import com.pms.deatils.service.AllergyService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@RestController
public class AllergyController {

	@Autowired
	private AllergyService allergyService;
	
	@ApiOperation(value = "Fetching allergies by patient id", notes = "This API fetch all allergies of patient by id")
	@GetMapping(path = "/patientsallergies/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<PatientAllergyEntity>> getAllergiesByPatientId(@PathVariable Integer id) {
		   return allergyService.getAllByPatientId(id);
	}
	
	@ApiOperation(value = "Save allergy of patient", notes = "This API save allergy against patient d")
	@PostMapping(path = "/patientsallergies", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void saveAllergyOfPatientId(@RequestBody PatientAndAllergyEntity patientAndAllergyEntity) {
		    allergyService.saveAllergyOfPatient(patientAndAllergyEntity);
	}
	
	@ApiOperation(value = "Save allergy of patient", notes = "This API save allergy against patient d")
	@DeleteMapping(path = "/patientsallergies/{allergyId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void deleteAllergyOfPatientId(@PathVariable Integer allergyId) {
		    allergyService.deleteAllergyById(allergyId);
	}
	
	@ApiOperation(value = "Updates the patient allergy", notes = "This API update allergy against patient d")
	@PutMapping(path = "/patientsallergies", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void updatePatientAllergy(@RequestBody PatientAndAllergyEntity patientAndAllergyEntity) {
		    allergyService.updatePatientAllergyById(patientAndAllergyEntity);
	}
	
}
