package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Sushma Kumari
 * @Creation_date 27th Sept 2019 4:44 PM
 * @version 1.0
 * @modification_date 27th Sept 2019 4:45 PM
 * @description It is a POJO class.
 * 				It is a Persistence class.
 *
 */
@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songId;
	private String songName;
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	
	
	
	public Song(String songName) {
		super();
		this.songName = songName;
		
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(int songId, String songName) {
		super();
		this.songId = songId;
		this.songName = songName;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}
	
	
	

}
