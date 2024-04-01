package com.chetasmind.tutor.core.models;

import javax.annotation.PostConstruct;
 


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
 
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ListMapExample {
 
	private List<String> sportsList;
	 
	private Map<String, String>celebrityMap;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PostConstruct
	protected void init() {
	 
		sportsList = new ArrayList<>();
		sportsList.add("Cricket");
		sportsList.add("Football");
		sportsList.add("Hockey");
		 
		celebrityMap = new HashMap<>();
		celebrityMap.put("Football", "Pele");
		celebrityMap.put("Cricket", "Sachin");
		celebrityMap.put("Hockey", "Dhyan");
	 
	 
	}
	 
	public List<String> getSportsList() {
		return sportsList;
	}
	 
	 
	public Map<String, String> getCelebrityMap() {
		return celebrityMap;
	}
 
}
