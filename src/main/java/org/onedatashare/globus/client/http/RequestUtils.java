package org.onedatashare.globus.client.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.onedatashare.globus.client.constants.Constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class RequestUtils{
	
	public static String get(String accessToken, String url, Map<String, String> params){
		
		String responseString = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			if(params!=null){
				url = appendQueryParams(url, params);
			}
			HttpGet request = new HttpGet(url);
			request.setHeader(Constants.AUTHORIZARION, Constants.BEARER+accessToken);	
			HttpResponse httpResponse = httpClient.execute(request);
			responseString = EntityUtils.toString(httpResponse.getEntity());
		}
		catch(Exception e){
			System.out.println("Exception occured while fetching the url::"+url);
		}
		finally{
			try{
				httpClient.close();
			}
			catch(Exception e){
				System.out.println("Exception while trying to close connection");
			}
		}
		return responseString;
	}	
	
	
	public static String post(String accessToken, String url, Object entity, Map<String, String> params){
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String requestJson = ow.writeValueAsString(entity);
			HttpPost request = new HttpPost(url);
			request.setEntity(new StringEntity(requestJson));
			request.setHeader(HttpHeaders.CONTENT_TYPE, Constants.JSON_TYPE);
			request.setHeader("Authorization", "Bearer "+accessToken);
			HttpResponse httpResponse = httpClient.execute(request);
			String responseString = EntityUtils.toString(httpResponse.getEntity());
			return responseString;
		}
		catch(JsonProcessingException jpe) {
			System.out.println("Exception occured while processing request entity");
			jpe.printStackTrace();
		}
		catch(UnsupportedEncodingException uee){
			System.out.println("Exception occured while processing request entity");
			uee.printStackTrace();
		}
		catch(ClientProtocolException cpe){
			System.out.println("Exception while sending the post request for::"+url);
			cpe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Exception while sending the post request for::"+url);
			ioe.printStackTrace();
		}
		return null;
	}
	
	private static String appendQueryParams(String url, Map<String, String> params) throws URISyntaxException{
		
		URIBuilder uriBuilder = new URIBuilder(url);
		for (Map.Entry<String, String> param : params.entrySet()){
			uriBuilder.addParameter(param.getKey(), param.getValue());
		}
		return uriBuilder.build().toString();
	}

	
	
	
}