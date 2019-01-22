package org.onedatashare.globus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.onedatashare.globus.client.GlobusClient;
import org.onedatashare.globus.client.model.File;

public class Application {

	public static void main(String[] args) throws Exception{
		
		String accessToken = "AgvPXmv93VdQWGEDyajVekKjbGxDOYm39jb2d2E56Jz1dY84eJhzC9jo7EeMON92p37DqXWVqoMe8nS9X87OWs84jM";
		
//		String authCode = "bWdzcnkarhmmz7VVrjs4lOwC8ULYN1";
//		GlobusClient client = new GlobusClient();
//		String accessToken = client.login(authCode);
//		System.out.println("Access token is"+accessToken);
		

		
		
		GlobusClient client = new GlobusClient(accessToken);
		
		//Get endPoint detail
//		EndPoint endPoint = client.endPoint().detail("957ed806-1d00-11e9-9fa0-0a06afd4a22e");
//		
//		
//		System.out.println(endPoint.getId()+"::"+endPoint.getName());
		
		//Get all endpoints administered by the user
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("offset", "0");
//		params.put("limit", "100");
//		params.put("filter_scope", "administered-by-me");
//		List<EndPoint> endPointsList = client.endPoint().list(params);
//		System.out.println(endPointsList.size());
//		for (EndPoint endPoint:endPointsList){
//			System.out.println(endPoint.getId()+"::"+endPoint.getName());
//		}

		//Get all files in an endPoint
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("format", "json");
//		params.put("fields", "link_target,name,size,type");
//		params.put("show_hidden", "false");
//		params.put("path", "/~/");
//		List<File> files = client.endPoint().listFiles("957ed806-1d00-11e9-9fa0-0a06afd4a22e", params);
//		for (File file: files){
//			System.out.println(file.getName());
//		}
//		System.out.println(files);
		
//		Submit a task
		String taskId = client.task().submit();
		System.out.println("Task id is::"+taskId);
		
		Thread.sleep(5000);
		
		//Get task details 
		String taskDetails = client.task().detail(taskId);
		System.out.println("Details::"+taskDetails);
//		
//		String submissionId = "edf51af5-1dca-11e9-9835-0262a1f2f698";
//		if(submissionId!=null){
//			TransferRequest request = new TransferRequest();
//			request.setSubmissionId(submissionId);
//			request.setSourceEndpoint("957ed806-1d00-11e9-9fa0-0a06afd4a22e");
//			request.setDestinationEndpoint("cf845850-1d00-11e9-934e-0e3d676669f4");
//			List<TransferData> data = new ArrayList<TransferData>();
//			TransferData transferData1 = new TransferData();
//			transferData1.setDataType("transfer_item");
//			transferData1.setRecursive(false);
//			transferData1.setSourcePath("/~/solr_scratch_pad");
//			transferData1.setDestinationPath("/~/solr_scratch_pad");
//			data.add(transferData1);
//			request.setData(data);
//			String response = client.file().transfer(request);
//			System.out.println("Response is::"+response);
//		}
	}
}
