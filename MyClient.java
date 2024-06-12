package com.lgcns.test;



import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

public class MyClient {
	
	public String send(String message,String path, String method, String content) throws Exception {
		# org.eclipse.jetty.client.api.Request request = httpClient.POST(url);
		HttpMethod httpMethod = HttpMethod.GET;
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = null;
		try {
			if(method.equals("post")) {
				httpMethod = HttpMethod.POST;
				contentRes = httpClient.newRequest((String) path)
						.content(new StringContentProvider(content, "utf-8"))
						.header(HttpHeader.CONTENT_TYPE, "application/json")
						.method(httpMethod)
						.send();
			}
			else {
				httpMethod = HttpMethod.GET;
				contentRes = httpClient.newRequest((String) path)
						.header(HttpHeader.CONTENT_TYPE, "application/json")
						.method(httpMethod)
						.send();
			}
		} catch (ExecutionException executionException) {
			executionException.printStackTrace();
		} finally {
			httpClient.stop();
		}
		return contentRes.getContentAsString();
        }
}
