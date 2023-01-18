package main;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class VerifJson {
	
	public static boolean verif(String newJson, String refJson) {
		
		boolean res = false; 
		String logPath = System.getProperty("user.home") + "/Desktop/log.txt";
		try {
				JSONAssert.assertEquals(newJson, refJson, JSONCompareMode.LENIENT);
				res = true;
				System.out.println("done");
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (AssertionError erreurs) {
				erreurs.printStackTrace();
				File file = new File(logPath);
				
				try {
					file.createNewFile();
					String errors = erreurs.toString();
					ArrayList<String> line = SearchJson.search(errors,newJson,refJson); 
					
					LocalDateTime myDateObj = LocalDateTime.now();
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					String formattedDate = myDateObj.format(myFormatObj);
					
					Writer output;
					output = new BufferedWriter(new FileWriter(logPath, true));
					output.append("["+formattedDate+"]\n\n"+
							errors+"\n");
					for(int i=0;i<line.size();i++) {
						System.out.println(line.get(i));
						output.append(line.get(i)+"\n");
					}
					output.write(System.lineSeparator());
					output.append("------------------------------------------------------------------------------------------------------------------------------------------------");
					output.write(System.lineSeparator());
					output.write(System.lineSeparator());
					output.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} 
				
			}
		 return res;
	}

}
