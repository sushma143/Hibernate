package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMppingDemo {
	
	public static void main(String[] args) {
Configuration c = new Configuration().configure();
		
		//single ton heavy and weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();//represents database connection and light weight
		Transaction t = s.beginTransaction();
		
		Country co= new Country();
		
		co.setName("India");
		co.setLanguage("Hindi");
		co.setPopulation(10300000);
		
		
		Flag fl= new Flag();
		fl.setFlagName("Tiranga");
		fl.setDescription("Tricolor");
		
		co.setFlag(fl);
		fl.setCountry(co);
		
		s.save(co);
		s.save(fl);
		
		
		
		t.commit();
		s.close();
	}

}
