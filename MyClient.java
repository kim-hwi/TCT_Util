package com.lgcns.test;



import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

public class MyClient {
	
	public String send(String message,String path, String method) throws Exception {
		HttpMethod httpMethod = HttpMethod.GET;
		if(method.equals("post")) httpMethod = HttpMethod.POST;
		HttpClient httpClient = new HttpClient();
		httpClient.start();
				
		
		ContentResponse contentRes = httpClient.newRequest((String) path).method(httpMethod).send();

        httpClient.stop();
        return contentRes.getContentAsString();
		
			    
	   	}

}
