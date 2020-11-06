package com.tfcaimongo.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class Point2DTO{

	@Field("dangerous_points")
	public List<DangerousPoint> dangerous_points;
	
	public List<DangerousPoint> getDangerous_points() {
		return dangerous_points;
	}

	public void setDangerous_points(List<DangerousPoint> dangerous_points) {
		this.dangerous_points = dangerous_points;
	}
	
	class DangerousPoint {	
		
		private String id;
		
		private int accidents;
			
		public DangerousPoint(String id, int accidents) {
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
	
}