package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import config.Constants;

public class CompareCSV {
    public static void main(String[] args) throws Exception {
    	
    	InputStream is = ClassLoader.getSystemResourceAsStream("CSV_file.csv");
    	BufferedReader br = new BufferedReader(new InputStreamReader(is));

    	String line;
    	while ((line = br.readLine()) != null) {
    	   System.out.println(line);
    	}

    	br.close();
    	
        /*String file1 = Constants.PATHNEW_CSV;
        String file2 = Constants.PATHREF_CSV;

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        

        // read file1 and store its contents in set1
        try (CSVParser parser = new CSVParser(new FileReader(file1), CSVFormat.DEFAULT.withDelimiter('|').withRecordSeparator("\n"))) {
            for (CSVRecord record : parser) {
                set1.add(record.toString());
            }
        }

        // read file2 and store its contents in set2
        try (CSVParser parser = new CSVParser(new FileReader(file2), CSVFormat.DEFAULT.withDelimiter('|').withRecordSeparator("\n"))) {
            for (CSVRecord record : parser) {
                set2.add(record.toString());
            }
        }

        // Find rows that are in file1 but not in file2
        Set<String> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);

        // Find rows that are in file2 but not in file1
        Set<String> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);

        // Find rows that are in both files
        Set<String> common = new HashSet<>(set1);
        common.retainAll(set2);
        
        System.out.println(common);*/
    }
}