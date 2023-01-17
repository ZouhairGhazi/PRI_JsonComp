package json;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class VerifJson {
	
	public static boolean verif(String newJson, String refJson) {
		boolean res=false; 
		String logPath= System.getProperty("user.home") + "/Desktop/log.txt";
		try {
				JSONAssert.assertEquals(newJson, refJson, JSONCompareMode.LENIENT);
				res=true;
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (AssertionError erreurs) {
				erreurs.printStackTrace();
				File file = new File(logPath);
				
				try {
					file.createNewFile();
					String errors=erreurs.toString();
					System.out.println(errors);
					
					errors = errors.substring(errors.indexOf("[") + 1);
					errors = errors.replace(";", "");
					
					LocalDateTime myDateObj = LocalDateTime.now();
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					String formattedDate = myDateObj.format(myFormatObj);
					
					Writer output;
					output = new BufferedWriter(new FileWriter(logPath, true));
					output.append("["+formattedDate+"]\n\n"+
							errors+"\n");
					output.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} 
				
			}
		 return res;
	}
}
