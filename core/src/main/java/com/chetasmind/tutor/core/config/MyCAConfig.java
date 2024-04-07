package com.chetasmind.tutor.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;


@Configuration(label="CA Configuration", description="CA Description")
public @interface MyCAConfig {
 
	@Property(label="site name", description="Describe Site Name")
	String siteName();
	    
	@Property(label="content type", description="Describe Content Type")
	String contentType() default "general";
	    
}
 