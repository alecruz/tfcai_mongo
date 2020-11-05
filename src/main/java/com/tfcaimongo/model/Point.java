package com.tfcaimongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Point {

	@Id
	public String id;
	
	@Field("ID")
	public String identificador;
			
	@Field("start_location")	
	public Location location;
	
	public int count;
			
	public Point() {}
	
	public Point(String id, String identificador, Location location, int count) {
		this.setId(id);
		this.setIdentificador(identificador);
		this.setLocation(location);
		this.setCount(count);
	}	
	
	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
		this.id = anId;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}	
	
	

}