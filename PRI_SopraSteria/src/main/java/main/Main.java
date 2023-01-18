package main;

import java.io.IOException;

import utils.FileDetection;
import config.Constants;

public class Main {

	public static void main(String[] args) throws IOException {
			
		  boolean res;		  
		  if (FileDetection.extensionDetecter(Constants.PATHNEW).equals("json") && FileDetection.extensionDetecter(Constants.PATHREF).equals("json") ) {
			  String jsonTextNew = LoadJson.load(Constants.PATHNEW);
			  String jsonTextRef = LoadJson.load(Constants.PATHREF);
			  res = VerifJson.verif(jsonTextNew, jsonTextRef);
			  System.out.println(res);
		  }
		  else if (FileDetection.extensionDetecter(Constants.PATHNEW).equals("csv") && FileDetection.extensionDetecter(Constants.PATHREF).equals("csv")) {
			  String jsonTextNew = LoadJson.load(Constants.PATHNEW);
			  String jsonTextRef = LoadJson.load(Constants.PATHREF);

			  res = VerifJson.verif(jsonTextNew, jsonTextRef);
			  System.out.println(res);
		  }
		  else {
			  System.out.println("Extension non reconnu !");
		  }
	}

}
