package com.chetasmind.tutor.core.utility;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestAPICallFromApache {

	private static final Logger log = LoggerFactory.getLogger(RestAPICallFromApache.class);
	
	public static String getDatafromJavaAPI() { 
		
		log.debug("11111111111111111");
		sendGET();
		return "";
	}
	
	private static void sendGET()  {
		
		try {
			// https://www.baeldung.com/apache-httpclient-vs-closeablehttpclient
			log.debug("222222");
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/todos/1");
			//httpGet.addHeader("User-Agent", USER_AGENT);
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
	
			log.debug("GET Response Status:: "
					+ httpResponse.getStatusLine().getStatusCode());
	
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));
	
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
	
			// print result
			log.debug("response="+response.toString());
			httpClient.close();
			
		}catch(Exception e) {
			
		}
	} 
	
}
