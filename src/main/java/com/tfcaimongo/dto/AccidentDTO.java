package com.tfcaimongo.dto;

import com.tfcaimongo.model.Accident;
import com.tfcaimongo.model.Location;

public class AccidentDTO {

	private String id;
	
	private String identificador;
	
	private String city;
	
	private String state;
	
	private String start_time;
	
	private Location location;
		
	public AccidentDTO(Accident anAccident) {
		this.setId(anAccident.getId());
		this.setCity(anAccident.getCity());
		this.setIdentificador(anAccident.getIdentificador());
		this.setState(anAccident.getState());
		this.setStart_time(anAccident.getStart_time());
		this.setLocation(anAccident.getLocation());		
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
		
}
