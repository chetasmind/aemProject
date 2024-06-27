package com.chetasmind.tutor.core.config.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chetasmind.tutor.core.config.FurnitureConfig;

@Component(service=FurnitureConfig.class, immediate = true)
@Designate(ocd=FurnitureConfigImpl.Config.class)
public class FurnitureConfigImpl implements FurnitureConfig {
 
private static final Logger log = LoggerFactory.getLogger(FurnitureConfigImpl.class);
 
	private String furnitureID;
	private String companyID;
	private String companyName;
	 
 
	@ObjectClassDefinition(
            name = "Furniture Company Details",
            description = "Configuration for adding the furniture company details"
    )
 
	@interface Config {
 
        @AttributeDefinition(
                name = "Furniture ID",
                description = "Enter ID"
        )
        String furnitureID() default "fur123";
        
        @AttributeDefinition(
                name = "Company ID",
                description = "Enter Company ID"
        )
        String companyID() default "123";
        
        @AttributeDefinition(
                name = "Company Name",
                description = "Enter Name"
        )
        String companyName() default "dummyCompany" ;
 
 
	}
 
	@Activate
	@Modified
	protected void activate(Config config) {
	 
		log.debug("------------- activate method of FurnitureConfigImpl");
		 
		furnitureID = config.furnitureID();
		companyID = config.companyID();
		companyName = config.companyName();
	 
	}
 
	@Override
	public String getFurnitureID() {
		
		return furnitureID;
	}
 
	@Override
	public String getCompanyName() {
		
		return companyName;
	}
	 
	@Override
	public String getCompanyID() {
		
		return companyID;
	}
	 
}