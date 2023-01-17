package json;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class verifJson {
	
	public static boolean verif(String newJson, String refJson) {
		boolean res=false; 
		String logPath= System.getProperty("user.home") + "/Desktop/log.txt";
		try {
				JSONAssert.assertEquals(newJson, refJson, JSONCompareMode.LENIENT);
				res=true;
				System.out.println("done");
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (AssertionError erreurs) {
				erreurs.printStackTrace();
				File file = new File(logPath);
				
				try {
					file.createNewFile();
					String errors=erreurs.toString();
					int[] line = searchJson.search(errors,newJson); 
					
					LocalDateTime myDateObj = LocalDateTime.now();
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					String formattedDate = myDateObj.format(myFormatObj);
					
					Writer output;
					output = new BufferedWriter(new FileWriter(logPath, true));
					output.append("["+formattedDate+"]\n\n"+
							errors+"\n");
					for(int i=0;i<4;i++) {
						System.out.println(line[i]);
						if(line[i]!=0) {
							output.append("line : "+line[i]+"\n");
							
						}
					}
					output.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} 
				
			}
		 return res;
	}
}
