package com.tfcaimongo.dto;

public class Point2DTO{

	private String id;
	
	private int accidents;
		
	public Point2DTO(String id, int accidents) {
		this.setId(id);
		this.setAccidents(accidents);
	}

	public String getId() {
		return id;
	}

	public int getAccidents() {
		return accidents;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAccidents(int accidents) {
		this.accidents = accidents;
	}
	
}