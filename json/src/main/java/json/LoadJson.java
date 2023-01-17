package json;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class loadJson {

	public static String load(String path) {
		 InputStream is = 
				 loadJson.class.getResourceAsStream(path);
	        String jsonTxt = null;
			try {
				jsonTxt = IOUtils.toString(is,"UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
		return jsonTxt;
	}
}
