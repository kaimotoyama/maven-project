import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.apache.commons.csv.*;


public class CSVReaderTest {
    private static final String fileName = "src/main/resources/test.csv";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord csvRecord : csvParser) {
            int value1 = Integer.valueOf(csvRecord.get(0));
            int value2 = Integer.valueOf(csvRecord.get(1));
            int add = value1 + value2;
            String sum = Integer.toString(add);

            try {
                Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/result.csv"));
                CSVPrinter printer = CSVFormat.DEFAULT.print(writer);
                printer.printRecord(value1, value2, sum);

                    writer.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }


            System.out.println("Value 1: " + csvRecord.get(0));
            System.out.println("Value 2: " + csvRecord.get(1));
            System.out.println("Sum: " + sum);
        }
    }
	}


