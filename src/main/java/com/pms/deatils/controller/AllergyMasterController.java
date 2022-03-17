package com.pms.deatils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.deatils.entity.AllergyMasterEntity;
import com.pms.deatils.repository.AllergyMasterRepository;
import com.pms.deatils.service.AllergyMasterService;
import com.pms.deatils.service.AllergyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("http://localhost:4200")
@RestController
public class AllergyMasterController {

	@Autowired
	private AllergyMasterService allergyMasterService;
	
	
	@ApiOperation(value = "Fetching All Allergies", notes = "This API fetch all the allergies values")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched", response = AllergyMasterEntity.class) })
	@GetMapping(path = "/allergies", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AllergyMasterEntity> getAllergies() {
		return allergyMasterService.getAllMasterAllergy();
	}
	
	
	@ApiOperation(value = "Fetching Allergy By Code", notes = "This API fetch allergy by code")
	@GetMapping(path = "/allergies/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AllergyMasterEntity> getAllergiesByCode(@PathVariable String code) {
		return allergyMasterService.getAllergyByCode(code);
	}
	
	@ApiOperation(value = "Fetching Allergy By Name", notes = "This API fetch allergy by name")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched Allergy By Name", response = AllergyMasterEntity.class) })
	@GetMapping(path = "/allergiesname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AllergyMasterEntity> getAllergies(@PathVariable String name) {
		return allergyMasterService.getAllergyByName(name);
	}
	
	@ApiOperation(value = "Fetching Allergy By Type", notes = "This API fetch allergy by Type")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched Allergy By Type", response = AllergyMasterEntity.class) })
	@GetMapping(path = "/allergiestype/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AllergyMasterEntity> getAllergiesByType(@PathVariable String name) {
		return allergyMasterService.getAllergyByType(name);
	}
}
