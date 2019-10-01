package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Sushma Kumari
 * @Creation_date 27th Sept 2019 3:03 PM
 * @version 1.0
 * @modification_date 27th Sept  2019 3:03 PM
 * @description It is Persistent class
 * 				It is POJO class
 *
 */
@Entity

public class Flag {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int flagId;
	private String flagName;
	private String description;
	@OneToOne(mappedBy = "flag")
	@JoinColumn(name = "country_id") 
	 private Country country;
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	

}
