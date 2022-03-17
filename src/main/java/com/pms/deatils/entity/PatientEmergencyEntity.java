package com.pms.deatils.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EMERGENENCY_CONTACT_INFO")
public class PatientEmergencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer emergencyId;
	
	@Column(name = "emergencyFirstName")
	private String emergencyFirstName;

	@Column(name = "emergencyLastName")
	private String emergencyLastName;

	@Column(name = "emergencyEmail")
	private String emergencyEmail;

	@Column(name = "emergencyCountryCode")
	private String emergencyCountryCode;

	@Column(name = "emergencyContactNo")
	private String emergencyContactNo;

	@Column(name = "emergencyAddress")
	private String emergencyAddress;

	@Column(name = "emergencyAccessToPortal")
	@Check(constraints = "emergencyAccessToPortal in ('Yes', 'No'")
	private String emergencyAccessToPortal;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_relation_id")
	private RelationShipEntity relationShipEntity;
	
	@ManyToOne
    @JoinColumn(name="patientId", nullable=false,referencedColumnName="patient_id")
    private PatientUserEntity patient;
}
