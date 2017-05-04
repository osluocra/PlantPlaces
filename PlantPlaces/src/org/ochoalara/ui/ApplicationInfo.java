package org.ochoalara.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;


import org.springframework.context.annotation.Scope;




@Named
@ManagedBean
@Scope("session")

public class ApplicationInfo {
	private String slogan="Promoting Plant Diversity Through Education";

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
}
