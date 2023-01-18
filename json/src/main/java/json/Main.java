package json;

import java.io.IOException;

public class Main {

	public static final String pathNew = "/exempleFull.json";
	public static final String pathRef = "/exempleFull2.json";


	public static void main(String[] args) throws IOException {
			
		  boolean res;		  
		  String jsonTextNew = loadJson.load(pathNew);
		  String jsonTextRef = loadJson.load(pathRef);

		  res=verifJson.verif(jsonTextNew, jsonTextRef);
	}
}

