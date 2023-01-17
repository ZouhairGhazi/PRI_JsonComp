package utils;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class FileTransformer {
	
	public static void main(String[] args) throws Exception {
		File input = new File(ClassLoader.getSystemResource("example.csv").getPath());
        File output = new File("output.json");

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        // Read data from CSV file
        List<Object> data = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();


        ObjectMapper mapper = new ObjectMapper();

        // Write JSON formated data to output.json file
        mapper.writeValue(output, data);
        System.out.println(data);
    } 

}
