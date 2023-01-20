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
		String logPath = "src/main/resources/Log/log.txt"; // On défini le chemin correspondant au fichier de log
		try {
				JSONAssert.assertEquals(newJson, refJson, JSONCompareMode.LENIENT); // En utilisant JSONAssert on compare les 2 JSON dans un ordre non-strict
				res = true;
				System.out.println("done");
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (AssertionError erreurs) { // Si les 2 fichiers ne sont pas identiques
				erreurs.printStackTrace();
				File file = new File(logPath); // On créé un File avec le chemin d'accès au log
				
				try {
					file.createNewFile(); // On essaye de créer le fichier log (Si il existe le code continue)
					String errors = erreurs.toString(); // On stocke les différences détectées dans un String
					String[] listErrors = errors.split(";"); // On split à chaque ";""
					ArrayList<String> lines = new ArrayList<String>(listErrors.length); 
					for(int i =0;i<listErrors.length;i++) {
						lines.add(listErrors[i]+SearchJson.search(errors,newJson,refJson, Constants.PATHREF,Constants.PATHNEW)); 
						System.out.println(i);
					}
					
					LocalDateTime myDateObj = LocalDateTime.now(); // On récupère la date et heure actuelle
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // On lui indique le format d'affichage que l'on souhaite
					String formattedDate = myDateObj.format(myFormatObj); // Puis on récupère le tout dans un String
					
					Writer output;
					output = new BufferedWriter(new FileWriter(logPath, true)); // On créé un buffer pour pouvoir écrire dans notre fichier log
					output.append("["+formattedDate+"]\n\n"); // Dans un premier temps on écrit la date et l'heure
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
