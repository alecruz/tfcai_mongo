package com.tfcaimongo.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tfcaimongo.dto.AccidentDTO;
import com.tfcaimongo.dto.AccidentRequestDTO;
import com.tfcaimongo.dto.DistanceDTO;
import com.tfcaimongo.model.Common;
import com.tfcaimongo.model.Point;
import com.tfcaimongo.services.IAccidentService;

@RestController
public class AccidentController {

	@Inject
	private IAccidentService accidentsService;
	
	@GetMapping(value = "/api/accidents_by_date")
	public ResponseEntity<?> getAccidentsByDate(@RequestBody AccidentRequestDTO request) {
		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		result.addAll(this.getAccidentsService().getAccidentsByDate(request.getDesde(), request.getHasta()));
		response = ResponseEntity.ok(result);

		return response;
	}	
	
	@GetMapping(value = "/api/accidents_by_common_features")
	public ResponseEntity<?> getAccidentsByCommonFeatures() {
		ResponseEntity<?> response = null;
		Collection<Common> result = new ArrayList<Common>();
		result.addAll(this.getAccidentsService().getAccidentsByCommonFeatures());
		response = ResponseEntity.ok(result);

		return response;
	}
	
	@GetMapping(value = "/api/accidents_by_location")
	public ResponseEntity<?> getAccidentsByLocation(@RequestBody AccidentRequestDTO request) {
		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		result.addAll(this.getAccidentsService().getAccidentsByLocation(request.getLat(), request.getLon(), request.getRatio()));
		response = ResponseEntity.ok(result);

		return response;
	}
	
	@GetMapping(value = "/api/accidents_by_dangerous_points")
	public ResponseEntity<?> getAccidentsByDangerousPoints(@RequestBody AccidentRequestDTO request) {
		ResponseEntity<?> response = null;
		Collection<Point> result = new ArrayList<Point>();
		result.addAll(this.getAccidentsService().getAccidentsByDangerousPoints(request.getRatio()));
		response = ResponseEntity.ok(result);
		
		return response;
	}
	
	@GetMapping(value = "/api/accidents_by_average_distance")
	public ResponseEntity<?> getAccidentsByAverageDistance() {
		ResponseEntity<?> response = null;
		Collection<DistanceDTO> result = new ArrayList<DistanceDTO>();
		result.addAll(this.getAccidentsService().getAccidentsByAverageDistance());
		response = ResponseEntity.ok(result);

		return response;
	}
	
	public IAccidentService getAccidentsService() {
		return this.accidentsService;
	}
	

}
