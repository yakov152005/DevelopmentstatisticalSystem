package entities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class CountryStatisticsManager {

    public void loadDataFromFile(String filename) {
        try (InputStream is = getClass().getResourceAsStream(filename)) {
            Scanner scanner = new Scanner(is);
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                //Fill in the blanks
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
