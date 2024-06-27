package com.chetasmind.tutor.core.config;

import java.util.List;

public interface VaccineConfig {
	
	public String getCompanyName();
	public String getCompanyID();
	public String getVaccineName();
	public List<VaccineConfig> getAllConfig();
	public VaccineConfig getConfig(String companyID);
	
}
