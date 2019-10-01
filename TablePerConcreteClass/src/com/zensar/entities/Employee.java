package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Sushma Kumari
 * @Creation_date 27th Sept 2019 11:26
 * @version 2 .0
 * @modification_date 27th Sept 2019 2:18 PM
 * @Description It is a Persistent Class.
 * 				It is a POJO class. 
 *
 */
@Entity
@Table(name="Emp_Master1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private LocalDate joinDate;
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, LocalDate joinDate, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joinDate=" + joinDate + ", salary=" + salary + "]";
	}
	
	

}
