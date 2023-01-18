package json;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class searchJson {
	static int i = 0 ;
	static ArrayList<String> a;
	static String errorString2 ="";
	
	public static String extractString(String patternStr, String input) {
	    Pattern pattern = Pattern.compile(patternStr);
	    Matcher matcher = pattern.matcher(input);
	    if (matcher.find()) {
	        return matcher.group(1);
	    }
	    return null;
	}
	
	public static ArrayList<String> search(String errorString,String json,String json2) throws IOException {
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
		
		
		
		a = new ArrayList<>(list.size());
		for (int j = 0; j < list.size()*2; j++) {
			a.add(null);
		}
		System.out.println("start searching");
		Stream<String> linesFromString = json.lines();
		linesFromString.forEach(l -> {
			i++;
			for (int j = 0; j < list.size(); j++) {
				if(l.contains(list.get(j))) {
					System.out.println(i);
					a.set(j,list.get(j)+" se trouve à la ligne : "+Integer.toString(i) +" dans le fichier : " + Main.pathNew);
					}; 
				}
			}
		
		);
		
		Stream<String> linesFromString2 = json2.lines();
		linesFromString2.forEach(l -> {
			i++;
			for (int j = 0; j < list.size(); j++) {
				if(l.contains(list.get(j))) {
					System.out.println(i);
					a.set(j+list.size(),list.get(j)+" se trouve à la ligne : "+Integer.toString(i) +" dans le fichier : " + Main.pathRef);
					}; 
				}
			}
		
		);
		return a;

	}
}



