package com.tfcaimongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class Common {

	@Field("weather_condition")
	public List<WeatherCondition> weather_condition;
	
	@Field("City")
	public List<City> city;
	
	@Field("State")
	public List<State> state;
	
	public List<WeatherCondition> getWeather_condition() {
		return weather_condition;
	}

	public void setWeather_condition(List<WeatherCondition> weather_condition) {
		this.weather_condition = weather_condition;
	}	

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
	
	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}


	class WeatherCondition{
		
		private String id;

		private double count;

		public String getId() {
			return id;
		}

		public double getCount() {
			return count;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setCount(double count) {
			this.count = count;
		}		
		
	}

	class City{
		
		private String id;

		private double count;

		public String getId() {
			return id;
		}

		public double getCount() {
			return count;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setCount(double count) {
			this.count = count;
		}		
		
	}
	
	class State{
		
		private String id;

		private double count;

		public String getId() {
			return id;
		}

		public double getCount() {
			return count;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setCount(double count) {
			this.count = count;
		}		
		
	}
}

