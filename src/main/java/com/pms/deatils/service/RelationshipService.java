package com.pms.deatils.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.deatils.entity.RelationShipEntity;
import com.pms.deatils.repository.RelationshipRepository;

@Service
public class RelationshipService {

	@Autowired
	private RelationshipRepository relationshipRepository;
	
	public List<RelationShipEntity> getAllRelationship(){
		return relationshipRepository.findAll();
	}
}
