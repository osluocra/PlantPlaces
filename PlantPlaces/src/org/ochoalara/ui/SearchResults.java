package org.ochoalara.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.ochoalara.dto.Plant;
import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class SearchResults {
	
	@Inject
	private Plant plant;
	
	public String results(){
		if(plant!=null && plant.getName().equalsIgnoreCase("Amapola")){
			return "search";
		}else{
			return "noresults";
		}
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
}
