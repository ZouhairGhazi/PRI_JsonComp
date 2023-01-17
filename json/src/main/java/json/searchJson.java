package json;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class searchJson {
	static int i = 0 ;
	static int[] a = new int[5];
	static String errorString2 ="";
	static int inc = 0;
	
	public static String extractString(String patternStr, String input) {
	    Pattern pattern = Pattern.compile(patternStr);
	    Matcher matcher = pattern.matcher(input);
	    if (matcher.find()) {
	        return matcher.group(1);
	    }
	    return null;
	}
	
	public static int[] search(String errorString,String json) throws IOException {
		
		String[] list = new String[5];
		String idProposition = extractString("idProposition=([^\\]]+)", errorString);
		String dateHeureDebutReal = extractString("dateHeureDebutReal=([^\\]]+)", errorString);
		String idElementJournee = extractString("idElementJournee=([^\\]]+)", errorString);
		String codeCHRef = extractString("codeCHRef=([^\\]]+)", errorString);

		if (idProposition != null) {
			list[0]= ("\"idProposition\" : \"" + idProposition + "\"");
		}
		if (dateHeureDebutReal != null) {
			list[1]= ("\"dateHeureDebutReal\" : \"" + dateHeureDebutReal + "\"");
		}
		if (idElementJournee != null) {
			list[2]= ("\"idElementJournee\" : \"" + idElementJournee + "\"");
		}
		if (codeCHRef != null) {
			list[3]= ("\"codeCHRef\" : \"" + codeCHRef + "\"");
		}

		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		System.out.println(list[3]);
		System.out.println(list[4]);





		
		/*String findStr = "[";
		int lastIndex = 0;
		int countWord = 0;
		int pos = 0;
		while (lastIndex != -1) {
		    lastIndex = errorString.indexOf(findStr, lastIndex);
		    countWord++;
		    if (lastIndex != -1) {
		        pos=countWord-1;
		        System.out.println(pos);
		        lastIndex += findStr.length();
		    }
		}
		
		String findStr2 = "]";
		int lastIndex2 = 0;
		int countWord2 = 0;
		int pos2 = 0;
		while (lastIndex2 != -1) {
		    lastIndex2 = errorString.indexOf(findStr2, lastIndex2);
		    countWord2++;
		    if (lastIndex2 != -1) {
		        pos2=countWord2-1;
		        System.out.println(pos2);
		        lastIndex2 += findStr2.length();
		    }
		}
		
		errorString2=errorString.substring(pos+1,pos2);
		System.out.println(errorString2);*/
		System.out.println("start searching");
		Stream<String> linesFromString = json.lines();
		linesFromString.forEach(l -> {
			i++;
			for (int j = 0; j < 5; j++) {
				if(list[j]!=null && l.contains(list[j])) {
					System.out.println(i);
					a[inc] = i;
					inc++;}
				}
			}
		
		);
		inc = 0;
		return a;

	}
}



