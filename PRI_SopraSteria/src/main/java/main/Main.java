package main;

import java.io.IOException;

import utils.CompareCSV;
import utils.FileDetection;
import config.Constants;

/**
* Main est la classe qui principale du projet, ça démarre en détectant l'extension des fichiers à comparer,
* et puis renvoie sur la console True pour des fichiers identiques, et false pour des fichiers différents.
*
* @version 1.0
* @category Main
* @since JDK version (1.8)
*/

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
			  res = CompareCSV.verifCSV(Constants.PATHNEW, Constants.PATHREF);
			  System.out.println(res);
		  }
		  else {
			  System.out.println("Extension non reconnu !");
		  }
	}

}
