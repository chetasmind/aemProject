package com.chetasmind.tutor.core.config.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chetasmind.tutor.core.config.VaccineConfig;

@Component(service=VaccineConfig.class, immediate=true, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd=VaccineConfigImpl.VaccineConfiguration.class, factory=true)
public class VaccineConfigImpl implements VaccineConfig {
 
	private static final Logger log = LoggerFactory.getLogger(VaccineConfigImpl.class);
 
	private String companyName;
	private String companyID;
	private String vaccineName;
	private List<VaccineConfig> configList;
 
 
 
	@ObjectClassDefinition(name="Vaccine Company Configuration Details", 
			description = "Configuration for capturing vaccine company details")
	
	public @interface VaccineConfiguration {
	 
		@AttributeDefinition(name="Company Name", description="Enter the Company name", type= AttributeType.STRING)
		public String companyName() ;
		 
		@AttributeDefinition(name = "Company ID", description = "Enter the Company ID", type = AttributeType.STRING)
		public String companyID();
		 
		@AttributeDefinition(name = "Vaccine Name", description = "Enter the Vaccine name", type = AttributeType.STRING)
		public String vaccineName();
	 
	}
 
	@Activate
	@Modified
	protected void activate(final VaccineConfiguration config) {
	 
		log.debug("inside the activate method");
		 
		companyName = config.companyName();
		companyID = config.companyID();
		if (StringUtils.isBlank(companyID)) {
				throw new IllegalArgumentException("ID should not be blank/empty");
		}
		vaccineName = config.vaccineName();
	 
	}
 
	
	@Reference(service=VaccineConfig.class, cardinality=ReferenceCardinality.MULTIPLE, policy=ReferencePolicy.DYNAMIC)
	public void bindElasticSerachConfig(final VaccineConfig config) {
	 
		log.debug("------------- inside bindElasticSerachConfig" );
		if(configList ==null) {
			configList = new ArrayList<>();
		}
		configList.add(config);
	 
	}
 
	public void unbindElasticSerachConfig(final VaccineConfig config) {
		 
			configList.remove(config);
	}
		 
	public String getCompanyName() {
			return companyName;
	}
 
	public String getCompanyID() {
		
		return companyID;
	}
	 
	 
	public String getVaccineName() {
		
		return vaccineName;
	}
	 
	@Override
	public List<VaccineConfig> getAllConfig() {
	 
		return configList;
	}
 
	@Override
	public VaccineConfig getConfig(String companyID) {
	 
		log.debug("companyID is="+companyID);
		 
		for(VaccineConfig searchConfig: configList) {
			log.debug("searchConfig language is="+searchConfig.getCompanyID());
			if(companyID.equalsIgnoreCase(searchConfig.getCompanyID())) {
				return searchConfig;
			}
		}
		return null;
	}
 
}