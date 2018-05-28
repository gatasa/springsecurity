package es.alfa.centauri.springSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Datapoint {
	
	
	private String name;
	private String genre;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
