package com.tfcaimongo.services;

import java.util.List;

import com.tfcaimongo.dto.AccidentDTO;
import com.tfcaimongo.dto.DistanceDTO;
import com.tfcaimongo.dto.Point2DTO;
import com.tfcaimongo.dto.PointDTO;
import com.tfcaimongo.model.Common;

public interface IAccidentService {

	public List<AccidentDTO> getAccidentsByDate(String desde, String hasta);
	
	public Common getAccidentsByCommonFeatures();
	
	public List<AccidentDTO> getAccidentsByLocation(double lat, double lon, double ratio);
	
	public List<DistanceDTO> getAccidentsByAverageDistance();
	
	public List<PointDTO> getAccidentsByDangerousPoints1(double ratio, List<PointDTO> points);
	
	public List<Point2DTO> getAccidentsByDangerousPoints2();
	
}
