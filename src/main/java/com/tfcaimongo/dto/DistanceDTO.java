package com.tfcaimongo.dto;

import com.tfcaimongo.model.Accident;

public class DistanceDTO {

	private String id;
	
	private String identificador;
	
	private double distance;
	
	public DistanceDTO(Accident anAccident) {
		this.setId(anAccident.getId());
		this.setIdentificador(anAccident.getIdentificador());
		this.setDistance(anAccident.getDistance());
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
