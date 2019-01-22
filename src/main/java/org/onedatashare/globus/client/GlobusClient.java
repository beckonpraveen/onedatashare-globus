package org.onedatashare.globus.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.onedatashare.globus.client.config.GlobusConfig;
import org.onedatashare.globus.client.constants.Constants;
import org.onedatashare.globus.client.dto.TransferRequest;
import org.onedatashare.globus.client.http.RequestUtils;
import org.onedatashare.globus.client.json.JacksonUtils;
import org.onedatashare.globus.client.model.EndPoint;
import org.onedatashare.globus.client.model.File;
import org.onedatashare.globus.client.model.TaskSubmission;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;


/*
 * Request and Response DTOs - In Progress
 * Close the clients in finally - done
 * Apply defaults whereever necessary
 * Set authToken in context, do not pass around, Have a notion of session - done
 * Have request utils, that will send request and give back response - done
 * Handle errors, return clear error messages, can use http status codes
 * Config file to be yml in classpath
 * Have enums whereever appropriate
 * make things modular - In progress
 * Add some unit tests
 * documentation to describe Methods 
 */

public class GlobusClient {
	
	private String accessToken;
	
	private EndPointController endPoint;
	
	private TaskController task;
		
	private FileController file;
	
	public GlobusClient(){
		
		initNamespaces();
	}
	
	public GlobusClient(String token){
		
		this.accessToken = token;
		initNamespaces();
	}
	
	public EndPointController endPoint() {
		
		return this.endPoint;
	}

	public TaskController task() {
		
		return this.task;
	}
	
	public FileController file(){
		
		return this.file;
	}
	
	private void initNamespaces(){
		
		this.endPoint = new EndPointController();
		this.task = new TaskController();
		this.file = new FileController();
	}
	
	public String getAuthToken() {
		return accessToken;
	}

	public void setAuthToken(String authToken) {
		this.accessToken = authToken;
	}

	public String authenticate(String authCode) {

		try {
			TokenResponse response = new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
					new GenericUrl(GlobusConfig.TOKEN_SERVER_URL), authCode).setRedirectUri(GlobusConfig.REDIRECT_URI)
							.set(Constants.CLIENT_ID, GlobusConfig.CLIENT_ID).set(Constants.CLIENT_SECRET, GlobusConfig.CLIENT_SECRET)
							.execute();
			String accessToken = response.getAccessToken();
			this.accessToken = accessToken;
			return accessToken;
		} catch (TokenResponseException e) {
			System.out.println("Error while recieving the token");
			e.printStackTrace();
		} catch (IOException ioe) {
			System.err.println("IO error occured while trying to fetch the token");
			ioe.printStackTrace();
		}
		return null;
	}
	
	public class EndPointController{
		
		public EndPoint detail (String id){
			
			String url = GlobusConfig.END_POINT_DETAILS;
			url = url.replace("{id}", id);
			String entityAsString = RequestUtils.get(accessToken, url, null);
			return (EndPoint)JacksonUtils.convertStringToEntity(entityAsString, EndPoint.class);
		}
		
		public List<EndPoint> list(Map<String, String> params){
			
			String url = GlobusConfig.END_POINT_SEARCH;
			String entityAsString = RequestUtils.get(accessToken, url, params); 
			return (List<EndPoint>)(Object)JacksonUtils.convertStringToEntityList(entityAsString, EndPoint.class);
		}
		
		public List<File> listFiles (String endPointId, Map<String, String> params){
			
			String url = GlobusConfig.LIST_FILES;
			url = url.replace("{id}", endPointId);
			String entityAsString = RequestUtils.get(accessToken, url, params);
			return (List<File>)(Object) JacksonUtils.convertStringToEntityList(entityAsString, File.class);
		}
		
//		public String activate(String endPointId, ActivationRequest activationRequest){
//			
//			String endPoint = GlobusConfig.ACTIVATE_END_POINT;
////			endPoint = endPoint.replace("{id}",endPointId);
//			
//		}
	}
	
	public class TaskController{
		
		public String submit(){
			
			String url = GlobusConfig.SUBMISSION_END_POINT;
			String entityAsString = RequestUtils.get(accessToken, url, null); 
			System.out.println("Response is::"+entityAsString);
			TaskSubmission submission = (TaskSubmission)JacksonUtils.convertStringToEntity(entityAsString, TaskSubmission.class); 
			return submission.getValue();
		}
		
		public String detail (String taskId){
			
			String url = GlobusConfig.TASK_DETAILS;
			url = url.replace("{id}", taskId);
			return RequestUtils.get(accessToken, url, null);
		}
	}

	
	public class FileController{
		
		public String transfer(TransferRequest transferRequest){
			
			String url = GlobusConfig.TRANSFER_END_POINT;
			return RequestUtils.post(accessToken, url, transferRequest, null);
		}
	}	
}