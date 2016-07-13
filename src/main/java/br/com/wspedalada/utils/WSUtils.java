package br.com.wspedalada.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
}
