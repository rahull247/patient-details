package com.pms.deatils.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="ALLERGY_MASTER")
public class AllergyMasterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allergy_id", nullable = false)
	private Integer allergyId;
	
	@Column(name = "allergy_code", nullable = false)
	private String allergyCode;

	@Check(constraints = "allergy_type in ('Food', 'Drug', 'Enviornemnt', 'Parasite', 'Venom or Salivary', 'Plant', 'Contact', 'Bacteria skin', 'Bacteria airway', 'Mite', 'Insect', 'Fungi', 'Animal'")
	@Column(name = "allergy_type", nullable = false)
	private String allergyType;

	@Column(name = "allergy_name", nullable = false)
	private String allergyName;

	@Column(name = "allergen_source")
	private String allergySource;
	
	@Column(name = "isoformsofallergen")
	private String isoformsofallergen;
	
	@Column(name = "allerginicity")
	private String allerginicity;

}
