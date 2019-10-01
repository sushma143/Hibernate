package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;



public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Configuration c = new Configuration().configure();
				
				//singleton heavy and weight session factory
				SessionFactory f = c.buildSessionFactory();
				Session s = f.openSession();//represents database connection and light weight
				Transaction t = s.beginTransaction();
				
				Employee e = new Employee();
				e.setName("Sushma");
				e.setJoinDate(LocalDate.of(2019, 8, 26));
				e.setSalary(25000);
				
				s.save(e);
				
				WageEmp we =new WageEmp();
				we.setName("Janwi");
				we.setJoinDate(LocalDate.of(2019, 7, 12));
				we.setSalary(30000);
				we.setHours(8);
				we.setRate(1000.f);
				
				s.save(we);

				t.commit();
				s.close();

	}

}
