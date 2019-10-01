package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration().configure();
		SessionFactory f= c.buildSessionFactory();
		Session s=f.openSession();
		
		Transaction t= s.beginTransaction();
		
		Movie m=new Movie();
		m.setMovieTitle("Yaariyan");
		m.setReleaseDate(LocalDate.of(2015, 6, 12));
		
		Song sn=new Song("Barrish");
		Song sn2=new Song("Blue hai pani");
		Song sn3=new Song("Allah Wariyan");
		
		sn.setMovie(m);
		sn2.setMovie(m);
		sn3.setMovie(m);
		
		ArrayList<Song> songs=new ArrayList<Song>();
		songs.add(sn);
		songs.add(sn2);
		songs.add(sn3);
		s.save(m);
		s.save(sn);
		s.save(sn2);
		s.save(sn3);
		
		
	
		t.commit();		
		s.close();
		System.exit(0);

		

	}

}
