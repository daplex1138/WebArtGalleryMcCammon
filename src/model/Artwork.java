package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artwork")

public class Artwork {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="ARTIST_NAME")
	private String artist_name;
	@Column(name="MEDIA")
	private String media;
	@Column(name="YEAR")
	private String year;
	@Column(name="value")
	private double value;
	
	public Artwork() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artwork(String title, String artist_name, String media, String year, double value) {
		super();
		this.title = title;
		this.artist_name = artist_name;
		this.media = media;
		this.year = year;
		this.value = value;
	}

	public Artwork(String title, String artist_name) {
		super();
		this.title = title;
		this.artist_name = artist_name;
	}

	public int getId() {
		return id;
	}

	//setId not necessary since its auto generated

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String returnItemDetails() {
		return String.format("%-8s%-18s%-18s%-18s%-18s%-18s", id, title, artist_name, media, year, value);
	}
	
	
	
}
