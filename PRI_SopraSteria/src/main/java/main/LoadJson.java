package main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class LoadJson {
	
	public static String load(String path) {
		 InputStream is = 
				 LoadJson.class.getResourceAsStream(path);
	        String jsonTxt = null;
			try {
				jsonTxt = IOUtils.toString(is,"UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
		return jsonTxt;
	}
	
}
