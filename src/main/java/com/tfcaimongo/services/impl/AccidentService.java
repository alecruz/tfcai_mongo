package com.tfcaimongo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfcaimongo.dto.AccidentDTO;
import com.tfcaimongo.dto.DistanceDTO;
import com.tfcaimongo.model.Accident;
import com.tfcaimongo.model.Common;
import com.tfcaimongo.model.Point;
import com.tfcaimongo.repository.AccidentRepository;
import com.tfcaimongo.services.IAccidentService;

@Service
@Transactional
public class AccidentService implements IAccidentService {

	@Inject
	public AccidentRepository accidentRepository;
	
	
	@Override
	public List<AccidentDTO> getAccidentsByDate(String desde, String hasta) {		
		List<AccidentDTO> result = new ArrayList<AccidentDTO>();
		desde += " 00:00:00";
		hasta += " 23:59:59";					
		this.getAccidentRepository().findByDate(desde, hasta).stream().map(a -> new AccidentDTO(a))
			.collect(Collectors.toCollection(() -> result));
		System.out.println("#################: " + result.size());
		return result;
	}		

	
	@Override
	public List<Common> getAccidentsByCommonFeatures() {
		return this.getAccidentRepository().findByCommonFeatures();
	}
	
	@Override
	public List<AccidentDTO> getAccidentsByLocation(double lat, double lon, double ratio) {
		
		List<AccidentDTO> result = new ArrayList<AccidentDTO>();
		ratio *= 1000;
		this.getAccidentRepository().findByLocation(lat, lon, ratio).stream().map(a -> new AccidentDTO(a))			
		.collect(Collectors.toCollection(() -> result));	
		System.out.println("#################: " + result.size());	
		return result;
	}
	
	
	public List<Point> getAccidentsByDangerousPoints(double ratio) {		
		List<Point> result = new ArrayList<Point>();
		List<Accident> accidents = this.accidentRepository.findAll();			
		Point p;			
		for(Accident a : accidents) { 		
			p = new Point(a.getId(), a.getIdentificador(), a.getLocation(), this.getAccidentRepository().findByLocationDangerousPoint(a.getLocation().getCoordinates()[1], a.getLocation().getCoordinates()[0], ratio * 1000).size()); 
			result.add(p);
		}		
		return result;
	}
	
	
	@Override
	public List<DistanceDTO> getAccidentsByAverageDistance() {
		List<DistanceDTO> result = new ArrayList<DistanceDTO>();
		this.getAccidentRepository().findByAverageDistance().stream().map(a -> new DistanceDTO(a))	
		.collect(Collectors.toCollection(() -> result));
		System.out.println("#################: " + result.size());
		return result;
	}
	
	
	public AccidentRepository getAccidentRepository() {
		return this.accidentRepository;
	}

	public void setAccidentRepository(AccidentRepository aRepository) {
		this.accidentRepository = aRepository;
	}

	
	
}
