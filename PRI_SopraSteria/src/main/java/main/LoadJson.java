package main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class LoadJson {
	
	/**
	* load est la m�thode de transformation du contenu d'un fichier JSON en String
	* 
	* @param path
	* @return String
	*/
	public static String load(String path) {
		 InputStream is = 
				 LoadJson.class.getResourceAsStream(path); // On récupère le fichier JSON dans un Inputstream en se placant dans le dossier ressources du projet et en fournissant le chemin d'accès
	        String jsonTxt = null;
			try {
				jsonTxt = IOUtils.toString(is,"UTF-8"); // On stocke le JSON dans un String
			} catch (IOException e) {
				e.printStackTrace();
			}
		return jsonTxt; // On renvoi le JSON dans un format String
	}
	
}
