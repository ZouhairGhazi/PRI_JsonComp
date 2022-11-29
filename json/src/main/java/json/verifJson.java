package json;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class verifJson {
	
	public static boolean verif(String newJson, String refJson) {
		boolean res=false; 
		try {
				JSONAssert.assertEquals(newJson, refJson, JSONCompareMode.LENIENT);
				res=true;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		 return res;
	}
}
