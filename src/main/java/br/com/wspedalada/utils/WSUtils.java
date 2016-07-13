package br.com.wspedalada.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class WSUtils {
	
	public static String convertStreamToString(InputStream inputStream){

		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
				while ((line = in.readLine()) != null) {
					stringBuilder.append(line);	
				}
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		
		return stringBuilder.toString();
	}
	
	
	
	public static  JsonObject convertStreamToJSON(InputStream inputStream){
		
		JsonReader jsonReader = Json.createReader(inputStream);
		JsonObject object = jsonReader.readObject();
		jsonReader.close();
		
		return object;
	}
}
