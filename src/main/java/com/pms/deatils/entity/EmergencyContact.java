package com.pms.deatils.entity;

import lombok.Data;

@Data
public class EmergencyContact {

	private int patientId;
	
	private int emergencyId;
	
	private String emergencyFirstName;
	
	private String emergencyLastName;
	
	private String emergencyEmail;
	
	private String emergencyCountryCode;
	
	private String emergencyContactNo;
	
	private String emergencyAddress;
	
	private String emergencyAccessToPortal;
	
	private RelationShipEntity relationShipEntity;

	@Override
	public String toString() {
		return "EmergencyContact [patientId=" + patientId + ", emergencyId=" + emergencyId + ", emergencyFirstName="
				+ emergencyFirstName + ", emergencyLastName=" + emergencyLastName + ", emergencyEmail=" + emergencyEmail
				+ ", emergencyCountryCode=" + emergencyCountryCode + ", emergencyContactNo=" + emergencyContactNo
				+ ", emergencyAddress=" + emergencyAddress + ", emergencyAccessToPortal=" + emergencyAccessToPortal
				+ ", relationShipEntity=" + relationShipEntity + "]";
	}

		
	
}
