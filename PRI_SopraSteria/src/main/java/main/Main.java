package main;

import java.io.IOException;

import utils.CompareCSV;
import utils.FileDetection;
import config.Constants;

/**
* Main est la classe qui principale du projet, �a d�marre en d�tectant l'extension des fichiers � comparer,
* et puis renvoie sur la console True pour des fichiers identiques, et false pour des fichiers diff�rents.
*
* @version 1.0
* @category Main
* @since JDK version (1.8)
*/

public class Main {

	public static void main(String[] args) throws IOException {
			
		  boolean res;		  
		  if (FileDetection.extensionDetecter(Constants.PATHNEW).equals("json") && FileDetection.extensionDetecter(Constants.PATHREF).equals("json") ) {  // Si les 2 fichiers sont des fichiers JSON
			  String jsonTextNew = LoadJson.load(Constants.PATHNEW); // On récupère leur contenu dans un String
			  String jsonTextRef = LoadJson.load(Constants.PATHREF);
			  res = VerifJson.verif(jsonTextNew, jsonTextRef); // On compare le contenu des 2 fichiers
			  System.out.println(res);
		  }
		  else if (FileDetection.extensionDetecter(Constants.PATHNEW).equals("csv") && FileDetection.extensionDetecter(Constants.PATHREF).equals("csv")) { // Si les 2 fichiers sont des fichiers CSV
			  res = CompareCSV.verifCSV(Constants.PATHNEW, Constants.PATHREF); // On compare le contenu des 2 fichiers
			  System.out.println(res);
		  }
		  else {
			  System.out.println("Extension non reconnu !"); 
		  }
	}

}
