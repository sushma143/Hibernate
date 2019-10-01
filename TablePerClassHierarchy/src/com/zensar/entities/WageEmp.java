package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Sushma Kumari
 * @Creation_date 27th Sept 2019 11:49
 * @version 1.0
 * @modification_date 27th Sept 2019 11:49
 * @Description It is a Persistent Class.
 * 				It is a POJO class. 
 *
 */
@Entity
@DiscriminatorValue("2")
public class WageEmp extends Employee {
	
	private int hours;
	private float rate;
	
	public WageEmp() {
		// TODO Auto-generated constructor stub
	}

	public WageEmp(int id, String name, LocalDate joinDate, double salary, int hours, float rate) {
		super(id, name, joinDate, salary);
		this.hours = hours;
		this.rate = rate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "WageEmp [hours=" + hours + ", rate=" + rate + "]";
	}



}
