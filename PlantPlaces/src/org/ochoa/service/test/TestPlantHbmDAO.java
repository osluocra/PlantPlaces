package org.ochoa.service.test;

import java.util.List;

import org.junit.Test;
import org.ochoalara.dao.PlantDAO;
import org.ochoalara.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {
	private PlantDAO plantHbmDAO;
	private List<Plant> plants;

	@Test
	public void verifyFetchByCommonName(){
		givenPlantDAOInstantieated();
		whenCommonNameIsRedbud();
		thenVerifyResults();
	}

	private void whenCommonNameIsRedbud() {
		// TODO Auto-generated method stub
		Plant p = new Plant();
		p.setCommon("Redbubd");
		plants = plantHbmDAO.fetchPlants(p);
		
	}

	private void givenPlantDAOInstantieated() {
		// TODO Auto-generated method stub
		plantHbmDAO = new PlantDAO();
	}

	private void thenVerifyResults() {
		// TODO Auto-generated method stub
		assertTrue(plants.size() > 0 );
		System.out.println(plants.size());
		
		for(Plant plant : plants){
			System.out.println(plant.getName());
			assertEquals("Redbubd", plant.getCommon());
			
		}
		
	}

}
