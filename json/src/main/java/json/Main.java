package json;
 
import org.json.JSONException;

public class Main {

	public static void main(String[] args) throws JSONException {
			
		  boolean res;
		  String pathNew="/exempleFull.json";
		  String pathRef="/exempleFull2.json";
		  
		  String jsonTextNew = loadJson.load(pathNew);
		  String jsonTextRef = loadJson.load(pathRef);

		  res=verifJson.verif(jsonTextNew, jsonTextRef);
	}
}

