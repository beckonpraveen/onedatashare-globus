package org.onedatashare.globus.client.config;


//TODO:Externalise constants to a file

public interface GlobusConfig {

	String AUTH_SERVER_URL = "https://auth.globus.org/v2/oauth2/authorize";
	String TOKEN_SERVER_URL = "https://auth.globus.org/v2/oauth2/token";
	String TRANSFER_END_POINT = "https://transfer.api.globusonline.org/v0.10/transfer";
	String END_POINT_DETAILS = "https://transfer.api.globusonline.org/v0.10/endpoint/{id}";
	String TASK_DETAILS = "https://transfer.api.globusonline.org/v0.10/task/{id}";
	String LIST_FILES = "https://transfer.api.globusonline.org/v0.10/endpoint/{id}/ls";
	String END_POINT_SEARCH = "https://transfer.api.globusonline.org/v0.10/endpoint_search";
	String ACTIVATE_END_POINT = "https://transfer.api.globusonline.org/v0.10/endpoint/{id}/activate";
	String SUBMISSION_END_POINT = "https://transfer.api.globusonline.org/v0.10/submission_id";
	String REDIRECT_URI = "https://110a00c3.ngrok.io/callback";
    String CLIENT_ID = "<insert_client_id>";
    String CLIENT_SECRET = "<insert_client_secret>";
    String SCOPE = "email";
}
