package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchJson {

	static int i = 0 ;
	static String return1 = "null";
	static String return2 = "null";
	static String errorString2 ="";
	
	public static String extractString(String patternStr, String input) {
	    Pattern pattern = Pattern.compile(patternStr);
	    Matcher matcher = pattern.matcher(input);
	    if (matcher.find()) {
	        return matcher.group(1);
	    }
	    return null;
	}
	
	public static String search(String errorString,String json,String json2,String pathRef,String pathNew) throws IOException {
		System.out.println("start reggex");
		//On récupère que les éléments qui sont uniques dans le message d'erreur
		Pattern pattern = Pattern.compile("\\[(.*?idProposition.*?|.*?dateHeureDebutReal.*?|.*?idElementJournee.*?)\\]");
		Matcher matcher = pattern.matcher(errorString);
		ArrayList<String> list = new ArrayList<String>();
		while (matcher.find()) {
		    list.add(matcher.group(1));
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
			list.set(j, "\""+list.get(j).replace("=", "\" : \"")+"\"");
			System.out.println(list.get(j));
		}
		
		
		System.out.println("start searching");
		Stream<String> linesFromString = json.lines();
		linesFromString.forEach(l -> {
			i++;
			if(l.contains(list.get(list.size()-1))) {
				System.out.println(i);
				return1= "\nFichier : " + pathNew +" - Objet : " + list.get(list.size()-1) +" - Ligne : " +Integer.toString(i); 

				}; 
			}	
		);
		i=0;
		Stream<String> linesFromString2 = json2.lines();
		linesFromString2.forEach(l -> {
			i++;
			if(l.contains(list.get(list.size()-1))) {
					System.out.println(i);
					return2 ="\nFichier : " + pathRef +" - Objet : " + list.get(list.size()-1) +" - Ligne : " +Integer.toString(i)+"\n"; 
			}; 
		}
		
		);
		i=0;
		System.out.println(return1 + return2);
		return return1 + return2;

	}
}
