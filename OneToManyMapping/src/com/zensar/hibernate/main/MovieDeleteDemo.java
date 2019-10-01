package com.zensar.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class MovieDeleteDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		Session s=f.openSession();
		
		Transaction t= s.beginTransaction();
		
		Movie m=s.get(Movie.class, 1);
		System.out.println(m.getMovieTitle());
		System.out.println(m.getReleaseDate());
		
		List<Song>  songs=m.getSongs();
		for(Song s1:songs)
		{
			System.out.println(s1);
		}
		if(m!=null)
		{
			s.delete(m);
		}
		else
			System.out.println("Sorry! movie not found.");
		
	
		t.commit();		
		s.close();
		System.exit(0);

		

	}


}
