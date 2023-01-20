package utils;

public class FileDetection {
	
	/**
	* extensionDetecter est la méthode de détection des extensions des fichiers à comparer
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