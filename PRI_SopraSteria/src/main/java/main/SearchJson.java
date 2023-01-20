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
	
	//cette fonction permet de extraire des substrings
	public static String extractString(String patternStr, String input) {
	    Pattern pattern = Pattern.compile(patternStr);
	    Matcher matcher = pattern.matcher(input);
	    if (matcher.find()) {
	        return matcher.group(1);
	    }
	    return null;
	}
	
	//cette fonction a pour but de chercher les lignes des erreurs qui sont apparus lors de la comparaison des Json
	public static String search(String errorString,String json,String json2,String pathRef,String pathNew) throws IOException {
		System.out.println("start reggex");
		//On récupère que les éléments qui sont uniques dans le message d'erreur
		Pattern pattern = Pattern.compile("\\[(.*?idProposition.*?|.*?dateHeureDebutReal.*?|.*?idElementJournee.*?)\\]");
		Matcher matcher = pattern.matcher(errorString);
		ArrayList<String> list = new ArrayList<String>();
		while (matcher.find()) {
		    list.add(matcher.group(1));
		}
		//on met les éléments récupérés sous le bon format pour pouvoir les exploiter
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
			list.set(j, "\""+list.get(j).replace("=", "\" : \"")+"\"");
			System.out.println(list.get(j));
		}
		
		
		System.out.println("start searching");
		//on cherche dans le fichier la position des erreurs en regardant ligne par ligne si l'élément se trouve dans cette ligne
		Stream<String> linesFromString = json.lines();
		linesFromString.forEach(l -> {
			i++;//permet de compter la ligne à laquelle on se trouve
			if(l.contains(list.get(list.size()-1))) {
				System.out.println(i);
				//on crée l'objet qui sera mis dans le log
				return1= "\nFichier : " + pathNew +" - Objet : " + list.get(list.size()-1) +" - Ligne : " +Integer.toString(i); 

				}; 
			}	
		);
		//on réinitialise le compteur
		i=0;
		
		//On fait la même recherche dans le deuxième fichier
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
