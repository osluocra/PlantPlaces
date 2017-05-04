package org.ochoalara.dao;

import java.util.List;

import org.ochoalara.dto.Plant;

public interface IPlantDAO {
	public List<Plant> fetchPlants();
	
	public void insert(Plant plant) throws Exception;
	
	public void update(Plant plant ) throws Exception;
	
	public void delete(Plant plant ) throws Exception;

}
