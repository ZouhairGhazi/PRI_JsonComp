package json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils; 
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public class main {

	public static void main(String[] args) throws JSONException {
		
		//Fonctionnement de JSONAssert
		String result = "[1,2,3,4,5]";
		try {
			JSONAssert.assertEquals("[1,2,3,4,5]", result, true);
			System.out.println("réussi");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// Loading Json + détection des keys/values
        InputStream is = 
                main.class.getResourceAsStream( "/test.json");
        String jsonTxt = null;
		try {
			jsonTxt = IOUtils.toString(is,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );        
		String test = json.getString( "test" );
		JSONArray recs = json.getJSONObject("locations").getJSONArray("record");
		
		
		System.out.println(recs);
		
		for (int i = 0; i < recs.size(); ++i) {
		    JSONObject rec = recs.getJSONObject(i);
		    int id = rec.getInt("id");
		    String loc = rec.getString("loc");
		    System.out.println(id + loc);
		}
					
	}

}

