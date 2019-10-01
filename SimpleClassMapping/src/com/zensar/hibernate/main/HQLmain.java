package com.zensar.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

//Hibernate Query Language(Object Oriented Query Language)
public class HQLmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration().configure();
		
		//single ton heavy and weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();//represents database connection and light weight
		Transaction t = s.beginTransaction();
		
		//JPA(Java Persistence API) Query
//		Query q = s.createQuery("from Product");
//		Query q = s.createQuery("from Product p where p.price>30000.00 and p.price<40000.00");
//		Query q = s.createQuery("from Product p where p.price between 10000 and 30000");
//		Query q = s.createQuery("from Product p where p.brand like 's%'");
//		Query q = s.createQuery("from Product p where p.name='Mobile'");
//		List<Product> products = q.getResultList();
//		for(Product list:products)
//		{
//			System.out.println(list);
//		}
//		
//		Query q = s.createQuery("select p.name,p.price from Product p");
//		Query q = s.createQuery("select p.productId,p.name,p.brand from Product p");
//		Query q = s.createQuery("select p.price,p.brand,p.name from Product p"); //Order different from table order
//		List <Object[]> objects = q.getResultList();
//		for(Object[] list:objects)
//			{
//				for(Object object:list)
//				{
//					System.out.print(object+"\t");
//				}
//				System.out.println();
//			}
		
		Query q = s.createQuery("select max(p.price) from Product p");
		Float maxPrice = (Float) q.getSingleResult();
		System.out.println("Max: "+maxPrice);
		
		Query q2 = s.createQuery("select min(p.price) from Product p");
		Float minPrice = (Float) q2.getSingleResult();
		System.out.println("Min: "+minPrice);
		
		Query q3 = s.createQuery("select sum(p.price) from Product p");
		Double sum = (Double) q3.getSingleResult();
		System.out.println("Sum: "+sum);
		
		Query q4 = s.createQuery("select count(p.price) from Product p");
		Long count = (Long) q4.getSingleResult();
		System.out.println("Count: "+count);
		
		Query q5 = s.createQuery("select avg(p.price) from Product p");
		Double avg = (Double) q5.getSingleResult();
		System.out.println("Avg: "+avg);
		
//		Depricated(Out dated code) code
//		Criteria cr = s.createCriteria(Product.class);
//		List<Product> products2 = cr.list();
//		for(Product list2:products2)
//			{
//				System.out.println(list2);
//			}	
		
		
		t.commit();
		s.close();
	}

}
