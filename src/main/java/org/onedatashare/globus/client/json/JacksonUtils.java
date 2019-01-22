package org.onedatashare.globus.client.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils{
	
	public static Object convertStringToEntity(String jsonString, Class entityClass){
		
		System.out.println("String to process");
		System.out.println(jsonString);
		try{
			ObjectMapper mapper = new ObjectMapper();
		    return mapper.readValue(jsonString, entityClass);
		}
		catch(IOException ioe){
			System.out.println("Exception occured while parsing json string");
			ioe.printStackTrace();
		}
		return null;
	}
	
	public static List<Object> convertStringToEntityList(String jsonString, Class entityClass){
		
		System.out.println("String to process");
		System.out.println(jsonString);
		List<Object> entities = new ArrayList<Object>();
		
		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(jsonString);
			JsonNode entityData = jsonNode.get("DATA");
		    for (JsonNode jsonEntity: entityData){
		    	
		    	Object entity = convertStringToEntity(jsonEntity.toString(), entityClass);
		    	entities.add(entity);
		    }
		    return entities;
		}
		catch(IOException ioe){
			System.out.println("Exception occured while parsing json string");
			ioe.printStackTrace();
		}
		return null;
	}
	
	
}