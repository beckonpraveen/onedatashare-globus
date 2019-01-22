# onedatashare-globus
## A Java client to access Globus API

**Usage:**

*Instantiate a client:*  
  a) No access token, create a client object and then call authenticate to set access token  
  
      
      GlobusClient client = new GlobusClient();
      client.authenticate(authCode);
      
      
     
  b) Create client with already existing access token  
  
      GlobusClient client = new GlobusClient(accessToken);
      
      
*Fetch list of endpoints:*  

      
	Map<String, String> params = new HashMap<String, String>();
	params.put("offset", "0");
	params.put("limit", "100");
	params.put("filter_scope", "administered-by-me");
	List<EndPoint> endPointsList = client.endPoint().list(params);
      
*Fetch an EndPoint:*

  EndPoint endPoint = client.endPoint().detail("<end_point_id>");
  
*Get all files in an EndPoint:*

	Map<String, String> params = new HashMap<String, String>();
	params.put("format", "json");
	params.put("fields", "link_target,name,size,type");
	params.put("show_hidden", "false");
	params.put("path", "/~/");
	List<File> files = client.endPoint().listFiles("<end_point_id>", params);
    
 *Submit a task:*
 
 
    String taskId = client.task().submit();
   
    
 *Transfer a file:*
 
      TransferRequest request = new TransferRequest();
	  request.setSubmissionId(taskId);
	  request.setSourceEndpoint("<source_endpoint_id>");
	  request.setDestinationEndpoint("<destination_endpoint_id>");
	  List<TransferData> data = new ArrayList<TransferData>();
	  TransferData transferData1 = new TransferData();
	  transferData1.setDataType("transfer_item");
	  transferData1.setRecursive(false);
	  transferData1.setSourcePath("<source_file_path>");
	  transferData1.setDestinationPath("<destination_file_path>");
	  data.add(transferData1);
	  request.setData(data);
	  client.file().transfer(request);
  
 

