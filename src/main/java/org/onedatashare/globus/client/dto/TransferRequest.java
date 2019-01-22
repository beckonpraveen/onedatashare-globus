package org.onedatashare.globus.client.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferRequest {
	
	@JsonProperty("DATA_TYPE")
	private String dataType = "transfer";

	@JsonProperty("submission_id")
	private String submissionId;

	@JsonProperty("source_endpoint")
	private String sourceEndpoint;

	@JsonProperty("destination_endpoint")
	private String destinationEndpoint;

	@JsonProperty("DATA")
	private List<TransferData> data;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public String getSourceEndpoint() {
		return sourceEndpoint;
	}

	public void setSourceEndpoint(String sourceEndpoint) {
		this.sourceEndpoint = sourceEndpoint;
	}

	public String getDestinationEndpoint() {
		return destinationEndpoint;
	}

	public void setDestinationEndpoint(String destinationEndpoint) {
		this.destinationEndpoint = destinationEndpoint;
	}
	
	public List<TransferData> getData() {
		return data;
	}

	public void setData(List<TransferData> data) {
		this.data = data;
	}
	
}
