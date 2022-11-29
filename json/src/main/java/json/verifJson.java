package json;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class verifJson {
	
	public static void verif(String newJson, String refJson) {
		 try {
				JSONAssert.assertEquals(newJson, refJson, JSONCompareMode.LENIENT);
				System.out.println("réussi");
			} catch (JSONException e) {
				e.printStackTrace();
			}
	}
}
