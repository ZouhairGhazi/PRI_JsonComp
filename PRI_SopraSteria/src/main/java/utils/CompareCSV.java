package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* CompareCSV est la classe qui contient la méthode de comparaison des fichiers CSV
*
* @version 1.0
* @category Utility
* @since JDK version (1.8)
*/

public class CompareCSV {
	
	/**
	* verifCSV est la méthode de comparaison des fichiers CSV, renvoie sur la console les différences si éxistantes.
	* 
	* @param String path1, path2
	* @return boolean
	* @throws IOException
	*/
	public static boolean verifCSV(String path1, String path2) throws IOException {
    	
    	InputStream is1 = CompareCSV.class.getResourceAsStream(path1);
    	InputStream is2 = CompareCSV.class.getResourceAsStream(path2);
    	
    	BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
    	BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));

    	String line1;
    	String line2;
    	
    	int counter = 1;
    	
    	List<Integer> allDiffs = new ArrayList<Integer>();

    	while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
    	   if (!line1.equals(line2))
    		   allDiffs.add(counter);
    	   counter++;
    	}
    	
    	 br1.close();
         br2.close();
    	
    	if (allDiffs.isEmpty()) {
    		System.out.println("Pas de différence, fichiers identiques !");
    		return true;
    	}
    	
    	else {
    		for (Integer nLine : allDiffs) {
        		System.out.println("Une différence existe dans la ligne :" + nLine);
        		
        	}
    		return false;
    	}
    	
    }
}