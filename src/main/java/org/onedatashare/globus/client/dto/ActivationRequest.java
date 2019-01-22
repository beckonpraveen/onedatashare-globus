package org.onedatashare.globus.client.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivationRequest{
	
	
	@JsonProperty("DATA_TYPE")
	private String dataType = "activation_requirements";

	@JsonProperty("DATA")
	private List<TransferData> data;
	
	
}