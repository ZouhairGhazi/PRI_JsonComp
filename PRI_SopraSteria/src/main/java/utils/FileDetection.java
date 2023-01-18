package utils;

public class FileDetection {
	
	public static String extensionDetecter(String filename) {	
		int dotIndex = filename.lastIndexOf(".");
		String extension = filename.substring(dotIndex+1);
		return extension;
	}
}