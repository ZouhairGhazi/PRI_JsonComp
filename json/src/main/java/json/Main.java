package json;
 
import org.json.JSONException;
import utils.FileDetection;

public class Main {

	public static void main(String[] args) throws JSONException {
			
		  boolean res;
		  String pathNew="/exempleFull.json";
		  String pathRef="/exempleFull2.json";
		  //System.out.println(FileDetection.extensionDetecter(pathNew));
		  
		  String jsonTextNew = LoadJson.load(pathNew);
		  String jsonTextRef = LoadJson.load(pathRef);

		  res=VerifJson.verif(jsonTextNew, jsonTextRef);
	}
}

