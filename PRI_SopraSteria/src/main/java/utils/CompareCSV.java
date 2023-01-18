package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class CompareCSV {
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        FileReader file1 = new FileReader(ClassLoader.getSystemResource("exemple_csv_1.csv").getPath());
        FileReader file2 = new FileReader(ClassLoader.getSystemResource("exemple_csv_2.csv").getPath());
        CSVParser parser1 = new CSVParser(file1, CSVFormat.DEFAULT);
        CSVParser parser2 = new CSVParser(file2, CSVFormat.DEFAULT);
        for (CSVRecord record1 : parser1) {
            CSVRecord record2 = parser2.iterator().next();
            for (int i = 0; i < record1.size(); i++) {
            	System.out.println("hi");
                if (!record1.get(i).equals(record2.get(i))) {
                    System.out.println("Difference found at index " + i + ": " + record1.get(i) + " vs " + record2.get(i));
                }
            }
        }
    }
}