package com.tfcaimongo.services;

import java.util.List;

import com.tfcaimongo.dto.AccidentDTO;
import com.tfcaimongo.dto.DistanceDTO;
import com.tfcaimongo.model.Common;
import com.tfcaimongo.model.Point;

public interface IAccidentService {

	public List<AccidentDTO> getAccidentsByDate(String desde, String hasta);
	
	public List<Common> getAccidentsByCommonFeatures();
	
	public List<AccidentDTO> getAccidentsByLocation(double lat, double lon, double ratio);
	
	public List<DistanceDTO> getAccidentsByAverageDistance();
	
	public List<Point> getAccidentsByDangerousPoints(double ratio);
	
}
