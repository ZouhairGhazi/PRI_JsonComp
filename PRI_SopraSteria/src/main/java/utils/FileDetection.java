package utils;

public class FileDetection {
	
	/**
	* extensionDetecter est la m�thode de d�tection des extensions des fichiers � comparer
	* 
	* @param String filename
	* @return String
	*/
	public static String extensionDetecter(String filename) {	
		int dotIndex = filename.lastIndexOf(".");
		String extension = filename.substring(dotIndex+1);
		return extension;
	}
}