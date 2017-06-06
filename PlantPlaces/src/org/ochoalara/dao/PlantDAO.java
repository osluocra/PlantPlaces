package org.ochoalara.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ochoalara.dto.Plant;

public class PlantDAO implements IPlantDAO {

	@SuppressWarnings("unchecked")
	public List<Plant> fetchPlants(Plant plant) {

//		List<Plant> allPlants = new ArrayList<Plant>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Plants where common = :common");
//		query.setParameter("common", plant.getCommon());
		query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Plant> allPlants = Collections.checkedList(list, Plant.class);
		
		return allPlants;
	}
	
	

	@Override
	public List<Plant> fetchPlants() {
		// TODO Auto-generated method stub
		
		System.out.println("Before calling");

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Plant where common = :common");
		query.setParameter("common", "amapola");
		

		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Plant> allPlants = Collections.checkedList(list, Plant.class);
		
		System.out.println(allPlants.size());
		
		return allPlants;

		
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
