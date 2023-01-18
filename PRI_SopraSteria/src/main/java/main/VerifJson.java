package main;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import config.Constants;

public class VerifJson {
	
	public static boolean verif(String newJson, String refJson) {
		
		boolean res = false; 
		String logPath = "src/main/resources/Log/log.txt";
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
					String[] listErrors = errors.split(";");
					ArrayList<String> lines = new ArrayList<String>(listErrors.length);
					for(int i =0;i<listErrors.length;i++) {
						lines.add(listErrors[i]+SearchJson.search(errors,newJson,refJson, Constants.PATHREF,Constants.PATHNEW)); 
						System.out.println(i);
					}
					
					LocalDateTime myDateObj = LocalDateTime.now();
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					String formattedDate = myDateObj.format(myFormatObj);
					
					Writer output;
					output = new BufferedWriter(new FileWriter(logPath, true));
					output.append("["+formattedDate+"]\n\n");
					for(int i=0;i<lines.size();i++) {
						System.out.println(lines.get(i));
						output.append(lines.get(i)+"\n");
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
