package com.tfcaimongo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import com.tfcaimongo.dto.AccidentDTO;
import com.tfcaimongo.dto.DistanceDTO;
import com.tfcaimongo.dto.Point2DTO;
import com.tfcaimongo.dto.PointDTO;
import com.tfcaimongo.model.Common;
import com.tfcaimongo.repository.AccidentRepository;
import com.tfcaimongo.services.IAccidentService;

@Service
@Transactional
public class AccidentService implements IAccidentService {

	@Inject
	public AccidentRepository accidentRepository;
	
	@Autowired
    private final MongoTemplate mongoTemplate;
	
	public AccidentService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
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
	public Common getAccidentsByCommonFeatures() {
		return this.getAccidentRepository().findByCommonFeatures().get(0);
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
	
	public List<PointDTO> getAccidentsByDangerousPoints1(double ratio, List<PointDTO> points) {	
		//Paso el radio a metros
		ratio *= 1000;
		
		for(PointDTO p: points) {
			
			//Por cada punto ingresado por el usuario cuento la cantidad de accidentes teniendo en cuenta el radio
			p.setAccidents(this.getAccidentRepository().findByLocation(p.getLat(), p.getLon(), ratio).size());			
		}		
		
		//Ordeno la colección de forma descendente
		Collections.sort(points);
		
		//Retorno solo los primeros 5 elementos
		return points.stream().limit(5).collect(Collectors.toList());
	}
	
	@Override
	public List<Point2DTO> getAccidentsByDangerousPoints2() {
				
		//Obtengo la coleccion
		MongoCollection<Document> collection = mongoTemplate.getCollection("accident");
		
		//Agrupo por el campo "new_location", lo ordeno de forma desc y solo otengo los primeros 5
		AggregateIterable<Document> result =  collection.aggregate(
			      Arrays.asList(
			              Aggregates.group("$new_location", Accumulators.sum("accidents", 1)),
			              Aggregates.sort(Sorts.descending("accidents")),
			              Aggregates.limit(5)
			      )
			).allowDiskUse(true);	
		
		//Recorro los resultados y  voy creando y agregando a la lista los objetos Point2DTO 
		MongoCursor<Document> cursor = result.iterator();
		List<Point2DTO> res = new ArrayList<Point2DTO>();
	    while (cursor.hasNext()) {
	        Document doc = cursor.next();
	        var cars = new ArrayList<>(doc.values());        		
        	res.add(new Point2DTO(cars.get(0).toString(), Integer.parseInt(cars.get(1).toString())));
	    }		
		return res;
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
