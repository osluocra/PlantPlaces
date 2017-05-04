package org.ochoa.service.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.ochoalara.dao.IPlantDAO;
import org.ochoalara.dto.Plant;
import org.ochoalara.service.PlantServiceImpl;

import junit.framework.TestCase;

public class TestPlantService extends TestCase {

	private PlantServiceImpl plantService;
	private IPlantDAO mock;
	private List<Plant> filterPlants;
	private IPlantDAO plantDAO;

	@Test
	public void testFilterPlants() {
		givenThatPlantServiceIsPopulatedWithPlantDAO();
		whenFilterWithRed();
		thenVerifyTwoResults();
	}

	private void thenVerifyTwoResults() {
		// TODO Auto-generated method stub
		assertEquals(2, filterPlants.size());

	}

	private void whenFilterWithRed() {
		// TODO Auto-generated method stub
		
		filterPlants = plantService.filterPlants("Red");
		verify(plantDAO, times(3)).fetchPlants();		
	}

	private void givenThatPlantServiceIsPopulatedWithPlantDAO() {
		// TODO Auto-generated method stub

		plantService = new PlantServiceImpl();

		plantDAO = mock(IPlantDAO.class);
		List<Plant> allPlants = constructPlantList();
		when(plantDAO.fetchPlants()).thenReturn(allPlants);
		plantService.setPlantDAO(plantDAO);

	}

	private List<Plant> constructPlantList() {
		List<Plant> allPlants = new ArrayList<Plant>();

		// Create plants and add them to the collection.
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		redbud.setGenus("Cercis");
		redbud.setSpecies("canadensis");
		redbud.setCommon("Redbubd");
		allPlants.add(redbud);

		Plant pawpaw = new Plant();
		pawpaw.setCommon("Paw Paw");
		pawpaw.setGenus("Asimina");
		pawpaw.setSpecies("triloba");
		allPlants.add(pawpaw);

		Plant nasturtium = new Plant();
		nasturtium.setCommon("nasturtium");
		nasturtium.setGenus("Trapoleanum");
		nasturtium.setSpecies("spp.");
		allPlants.add(nasturtium);

		Plant redMaple = new Plant();
		redMaple.setGenus("Acer");
		redMaple.setSpecies("rubrum");
		redMaple.setCommon("Red Maple");
		allPlants.add(redMaple);

		return allPlants;
	}

}
