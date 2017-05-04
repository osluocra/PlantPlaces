package org.ochoalara.dao;

import java.util.List;

import org.hibernate.Session;
import org.ochoalara.dto.Plant;

public class PlantDAO implements IPlantDAO{

	@Override
	public List<Plant> fetchPlants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(plant);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void update(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
