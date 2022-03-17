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

import com.pms.deatils.entity.EmergencyContact;
import com.pms.deatils.entity.PatientEmergencyEntity;
import com.pms.deatils.service.EmergencyContactService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@RestController
public class EmergencyController {

	@Autowired
	private EmergencyContactService emergencyContactService;
	
	@GetMapping(path = "/patientsemergency/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PatientEmergencyEntity> getPatientsEmergency(@PathVariable Integer id) {
		return emergencyContactService.getEmergencyContactById(id);
	}

	@ApiOperation(value = "Saving Patient Emergency Contact Details", notes = "This API save all the patient emergency contact values")
	@PostMapping(path = "/saveEmergencyContact", produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveEmergencyDetails(@RequestBody EmergencyContact emergencyContact) {
		System.out.println("Emergency Related Frontend Recived Data::::" + emergencyContact);
		emergencyContactService.saveEmergencyDetails(emergencyContact);
	}
}
