package com.pms.deatils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.deatils.entity.PatientAndDemographicEntity;
import com.pms.deatils.entity.PatientDemogrphicEntity;
import com.pms.deatils.service.DemographicService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@RestController
public class DemographicController {

	@Autowired
	private DemographicService demographicService;
	
	@ApiOperation(value = "Fetching Patient By Id", notes = "This API fetch patient values by providing the id")
	@GetMapping(path = "/patientsdemographic/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PatientDemogrphicEntity> getPatientDemographicById(@PathVariable Integer id) {
		return demographicService.getDemographicsById(id);
	}
	
	@ApiOperation(value = "Saving Patient and Demographic", notes = "This API save all the patient and demographic values")
	@PostMapping(path="/saveDemographics", produces = MediaType.APPLICATION_JSON_VALUE)
	public void savePatientAndDemographicDetails(@RequestBody PatientAndDemographicEntity patientAndDemographicEntity) {
		System.out.println("Frontend Recived Data::::"+patientAndDemographicEntity);
		demographicService.saveDemographicDetails(patientAndDemographicEntity);
	}
}
