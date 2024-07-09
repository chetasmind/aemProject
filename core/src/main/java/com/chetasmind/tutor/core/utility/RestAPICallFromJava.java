package com.chetasmind.tutor.core.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestAPICallFromJava {

	
	private static final Logger logger = LoggerFactory.getLogger(RestAPICallFromJava.class);
	
	public static String getDatafromJavaAPI() {
		
		 String data="";
		 
		 try {
			 	logger.debug("inside try");
			 
	            // Creating a URL object
	            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
	            
	            // Opening a connection
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            
	            // Setting the request method to GET
	            connection.setRequestMethod("GET");

	            // Retrieving the response code
	            int responseCode = connection.getResponseCode();

	            logger.debug("responseCode: {}",responseCode);
	            
	            // Processing the response
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String inputLine;
	                StringBuilder response = new StringBuilder();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();

	                logger.debug("API Response: " + response.toString());
	                data =response.toString();
	                
	            } else {
	            	logger.debug("API Call Failed. Response Code: " + responseCode);
	            }
	            
	            // check for closing the connection.
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		return data;
	}
}
