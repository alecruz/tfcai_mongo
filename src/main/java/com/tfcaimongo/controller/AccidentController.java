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
import com.tfcaimongo.dto.Point2DTO;
import com.tfcaimongo.dto.PointDTO;
import com.tfcaimongo.model.Common;
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
		Common result = this.getAccidentsService().getAccidentsByCommonFeatures();
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
	
	@GetMapping(value = "/api/accidents_by_dangerous_points1")
	public ResponseEntity<?> getAccidentsByDangerousPoints1(@RequestBody AccidentRequestDTO request) {
		ResponseEntity<?> response = null;
		Collection<PointDTO> result = new ArrayList<PointDTO>();
		result.addAll(this.getAccidentsService().getAccidentsByDangerousPoints1(request.getRatio(), request.getPoints()));
		response = ResponseEntity.ok(result);
		
		return response;
	}
	
	@GetMapping(value = "/api/accidents_by_dangerous_points2")
	public ResponseEntity<?> getAccidentsByDangerousPoints2() {
		ResponseEntity<?> response = null;
		Collection<Point2DTO> result = new ArrayList<Point2DTO>();
		result.addAll(this.getAccidentsService().getAccidentsByDangerousPoints2());
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
