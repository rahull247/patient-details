package com.pms.deatils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.deatils.entity.EmergencyContact;
import com.pms.deatils.entity.PatientAndDemographicEntity;
import com.pms.deatils.entity.PatientDemogrphicEntity;
import com.pms.deatils.entity.PatientEmergencyEntity;
import com.pms.deatils.entity.PatientUserEntity;
import com.pms.deatils.entity.RelationShipEntity;
import com.pms.deatils.service.AllergyService;
import com.pms.deatils.service.DemographicService;
import com.pms.deatils.service.EmergencyContactService;
import com.pms.deatils.service.PatientService;
import com.pms.deatils.service.RelationshipService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("http://localhost:4200")
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private AllergyService allergyService;

	@Autowired
	private RelationshipService relationshipService;

	@ApiOperation(value = "Fetching All Patient Details", notes = "This API fetch all the patient values")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched", response = PatientUserEntity.class) })
	@RequestMapping(path = "/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PatientUserEntity> getPatients() {
		System.out.println("*****************" + patientService.getAllPatients());
		return patientService.getAllPatients();
	}

	@ApiOperation(value = "Fetching Patient By Id", notes = "This API fetch patient values by providing the id")
	@GetMapping(path = "/patients/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PatientUserEntity> getPatientById(@PathVariable Integer id) {
		System.out.println("****** patient by id******");
		return patientService.getPatientById(id);
	}

	@ApiOperation(value = "Fetching All Relations", notes = "This API fetch all the relationship values")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched", response = RelationShipEntity.class) })
	@GetMapping(path = "/relations", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RelationShipEntity> getRelationships() {
		return relationshipService.getAllRelationship();
	}

	@GetMapping(path = "/patientsdetails/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<PatientUserEntity> getPatientsWithDetails(@PathVariable Integer id) {
		return patientService.getPatientAllDetails(id);
	}

}
