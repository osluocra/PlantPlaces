package org.ochoalara.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.ochoalara.dao.IPlantDAO;
import org.ochoalara.dao.PlantDAOStub;
import org.ochoalara.dto.Plant;

@Named
public class PlantServiceImpl implements IPlantService {

	@Inject
	private IPlantDAO plantDAO;

	private List<Plant> allPlants;

	@Override
	public List<Plant> filterPlants(String filter) {
		// TODO Auto-generated method stub
		if (allPlants == null) {
			allPlants = getPlantDAO().fetchPlants();
		}

		System.out.println("allPlants: " + allPlants);
		List<Plant> returnPlants = new ArrayList<Plant>();
		//filter the list
		for (Plant plant : allPlants) {
			if(plant.toString().contains(filter)){
				//this plant matches our criteria, so add it to the collection that will be returned from the this method.
				returnPlants.add(plant);
			}
		}
		return returnPlants;
	}

	public IPlantDAO getPlantDAO() {
		return plantDAO;
	}

	public void setPlantDAO(IPlantDAO plantDAO) {
		this.plantDAO = plantDAO;
	}

	public void save(Plant plant) throws Exception{
		if (plant.getGenus()==null || plant.getGenus().isEmpty()){
			
			throw new Exception ("Genius required");
		}
			plantDAO.insert(plant);
			
	}
	
}
