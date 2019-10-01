package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		
		//single ton heavy and weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();//represents database connection and light weight
		Transaction t = s.beginTransaction();
		//insert new record
//		Product p = new Product(1004,"Charger","MI",300);
//		s.save(p);
		
		//get record according to primary key
//		Product p = s.get(Product.class, 1044);
//		if(p!=null)
//		{
//			System.out.println(p);
//		}
//		else
//			System.out.println("This row is not present in the table.");
		//Product p = s.load(Product.class, 1004);
		//update record
		Product p = s.get(Product.class, 1004);
//		if(p!=null)
//		{
//			p.setPrice(p.getPrice()-700);
//			//p.setPrice(1000);
//			s.update(p);
//			System.out.println("Done!");
//		}
//		else
//			System.out.println("This row is not present in the table.");
		
		//delete record
		if(p!=null) 
		{
			s.delete(p);
		}
		else
     		System.out.println("This row is not present in the table.");
		
		t.commit();
		s.close();
	}
}
