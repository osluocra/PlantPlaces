package org.ochoalara.service;

import java.util.List;

import org.ochoalara.dao.IPlantDAO;
import org.ochoalara.dto.Plant;

/**
 * IPlantService includes all business related functions for a Plant and related entities
 * 
 * @author Oscar Ochoa
 *
 */

public interface IPlantService {
	/**
	 * Return a collection of Plant objects that contain the given filter text
	 * @param filter a substring that shoulb be contained in return plants.
	 * @return
	 */
	
	
	
	public List<Plant> filterPlants(String filter);

	/**
	 * Save the plant and perform a validation check.
	 * @param plant the plant we are persistance
	 * @throws Exception if unable to save
	 */
	void save(Plant plant) throws Exception; 

}
