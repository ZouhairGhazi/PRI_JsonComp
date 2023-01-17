package json;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
			
		  boolean res;
		  String pathNew="/exempleFull.json";
		  String pathRef="/exempleFull2.json";
		  
		  String jsonTextNew = loadJson.load(pathNew);
		  String jsonTextRef = loadJson.load(pathRef);

		  res=verifJson.verif(jsonTextNew, jsonTextRef);

		  //String errorString = "\"idProposition\" : \"20220720_143549_QR_171_G410_20221017\"";
		  //searchJson.search(errorString,jsonTextNew);
	}
}

