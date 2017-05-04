package org.ochoalara.ui.test;

import org.junit.Test;
import org.ochoalara.dto.Plant;
import org.ochoalara.ui.SearchPlants;

import junit.framework.TestCase;

public class TestSearchPlants extends TestCase {
	private SearchPlants searchPlants;
	private String execute;

	@Test
	public void testSearchPlantExecute(){
		givenSearchPlantCreatedWithRedbud();
		whenInvokeExecute();
		thenVerifyReturnSuccess();
	}

	
	@Test
	public void testSearchPlantsNoRedbud(){
		givenSearchPlantsCreatedWithoutRedBud();
		whenInvokeExecute();
		thenVerifyReturnNoResults();
	}
	
	@Test
	public void testSearchPlantsNull(){
		givenSearchPlantsCreatedWithNullPlant();
		whenInvokeExecute();
		thenVerifyReturnNoResults();
	}
	
	
	
	private void givenSearchPlantsCreatedWithNullPlant() {
		// TODO Auto-generated method stub
		searchPlants = new SearchPlants();
		
		
	}


	private void givenSearchPlantsCreatedWithoutRedBud() {
		// TODO Auto-generated method stub
		searchPlants = new SearchPlants();
		Plant plant = new Plant();
		plant.setName("Pawpaw");
		searchPlants.setPlant(plant);
		
	}


	private void thenVerifyReturnNoResults() {
		// TODO Auto-generated method stub
		assertEquals("noresults", execute);
		
	}


	private void givenSearchPlantCreatedWithRedbud() {
		// TODO Auto-generated method stub
		searchPlants = new SearchPlants();
		Plant plant = new Plant();
		plant.setName("Redbud");
		searchPlants.setPlant(plant);
		
		
	}

	private void whenInvokeExecute() {
		// TODO Auto-generated method stub
		execute = searchPlants.results();
	}

	private void thenVerifyReturnSuccess() {
		// TODO Auto-generated method stub
		assertEquals("search",execute);
		
	}
}
