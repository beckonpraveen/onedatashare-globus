package org.onedatashare.globus.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EndPoint{
	
	private String id;
	
	private String name;
	
	@JsonProperty("canonical_name")
	private String canonicalName;
	
	@JsonProperty("expire_time")
	private String expiryTime;
	
	@JsonProperty("expires_in")
	private String expiresIn;
	
	@JsonProperty("myproxy_dn")
	private String myProxyDomainName;
	
	@JsonProperty("myproxy_server")
	private String myProxyServer;
	
	private String activated;
	
	@JsonProperty("DATA")
	private List<Server> data;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCanonicalName() {
		return canonicalName;
	}


	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}


	public String getExpiryTime() {
		return expiryTime;
	}


	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}


	public String getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}


	public String getMyProxyDomainName() {
		return myProxyDomainName;
	}


	public void setMyProxyDomainName(String myProxyDomainName) {
		this.myProxyDomainName = myProxyDomainName;
	}


	public String getMyProxyServer() {
		return myProxyServer;
	}


	public void setMyProxyServer(String myProxyServer) {
		this.myProxyServer = myProxyServer;
	}


	public String getActivated() {
		return activated;
	}


	public void setActivated(String activated) {
		this.activated = activated;
	}


	public List<Server> getData() {
		return data;
	}


	public void setData(List<Server> data) {
		this.data = data;
	}

	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Server{
		
		@JsonProperty("hostname")
		private String hostName;
		
		@JsonProperty("uri")
		private String uri;
		
		private String port;
		
		private String scheme;

		public String getHostName() {
			return hostName;
		}

		public void setHostName(String hostName) {
			this.hostName = hostName;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getScheme() {
			return scheme;
		}

		public void setScheme(String scheme) {
			this.scheme = scheme;
		}
		
	}

}