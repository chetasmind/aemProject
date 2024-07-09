
/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.chetasmind.tutor.core.models;


import javax.annotation.PostConstruct;
import javax.inject.Named;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.designer.Style;
import com.chetasmind.tutor.core.config.FurnitureConfig;
import com.chetasmind.tutor.core.config.MyCAConfig;
import com.chetasmind.tutor.core.config.VaccineConfig;
import com.chetasmind.tutor.core.service.TestService;
import com.chetasmind.tutor.core.utility.RestAPICallFromApache;
import com.chetasmind.tutor.core.utility.RestAPICallFromJava;

import java.util.Optional;
import org.json.JSONObject;
import org.json.JSONArray;


@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ThirdPartyAPICall {
 

    @SlingObject
    private Resource currentResource;
    
    @SlingObject
    private ResourceResolver resourceResolver;
    
    @ValueMapValue
    @Named("myText")
    private String textVal;
    
    @OSGiService
    private TestService testService; // This is custom service class
    
    @OSGiService
    protected ModelFactory modelFactory;
    
    @SlingObject
    private SlingHttpServletRequest slingHttpServletRequest;
    
    @ScriptVariable
    private Page currentPage;   
    
    @ScriptVariable
    private PageManager pageManager;
    
    @ScriptVariable
    private Style currentStyle;
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @OSGiService
    private VaccineConfig vaccineConfig;
    
    @OSGiService
    private FurnitureConfig furnitureConfig;
    
    private String message;

    @PostConstruct
    protected void init() { 
    	
    	logger.debug("inside init of ThirdPartyAPICall");
//    	String response = RestAPICallFromJava.getDatafromJavaAPI();
//    	
//    	logger.debug("response="+response);
//    	String title = getMyTitle(response);
//    	logger.debug("title="+title);
    	
    	String response = RestAPICallFromApache.getDatafromJavaAPI();
    }

    public String getMessage() {
        return message;
    }
    
    private String getMyTitle(String response) {
    	
    	JSONObject obj = new JSONObject(response);
    	
    	String title = obj.getString("title");
    	return title;
    }

}

