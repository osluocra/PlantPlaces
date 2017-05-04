package org.ochoalara.ui;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.ochoalara.dto.Plant;
import org.ochoalara.service.IPlantService;
import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("request")
public class AddPlant {
	final static Logger logger = Logger.getLogger(AddPlant.class);
	
	@Inject
	private Plant plant;

	@Inject
	private IPlantService plantService;

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

	public String execute() {
		logger.info("Entering the execute method");
		
		String returnValue = "success";
		FacesContext currentInstance = FacesContext.getCurrentInstance();

		try {
			plantService.save(plant);
			logger.info("Save sucessful " + plant.toString());
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Saved");

			currentInstance.addMessage(null, fm);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Save", "Plant not Saved");

			currentInstance.addMessage(null, fm);
			logger.error("Error while saving plant. Message:" + e.getMessage());
			
			returnValue = "fail";
		}
		System.out.println("before returning value: " + returnValue);
		return returnValue;
	}

}
