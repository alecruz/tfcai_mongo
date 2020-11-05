package com.tfcaimongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Accident {

	@Id
	public String id;
	
	@Field("ID")
	public String identificador;
	
	@Field("City")
	public String city;	
	
	@Field("State")
	public String state;
			
	@Field("start_location")	
	public Location location;
	
	public double distance;
		
	public Accident() {}
	
	public Accident(String id, String identificador, String city, String state, Location location) {
		this.setId(id);
		this.setIdentificador(identificador);
		this.setCity(city);
		this.setState(state);
		this.setLocation(location);
	}
	
	public Accident(String id, String identificador, double distance) {
		this.setId(id);
		this.setIdentificador(identificador);
		this.setDistance(distance);
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}	

}