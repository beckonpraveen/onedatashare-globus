package org.onedatashare.globus.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferData {

	@JsonProperty("DATA_TYPE")
	String dataType = "transfer_item";

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public String getDestinationPath() {
		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}

	public boolean isRecursive() {
		return isRecursive;
	}

	public void setRecursive(boolean isRecursive) {
		this.isRecursive = isRecursive;
	}

	@JsonProperty("source_path")
	String sourcePath;

	@JsonProperty("destination_path")
	String destinationPath;

	@JsonProperty("recursive")
	boolean isRecursive;
}
