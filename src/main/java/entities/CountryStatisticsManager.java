package entities;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CountryStatisticsManager {
private Country country;

    public void loadDataFromFile(LinkedList<Country>  countryList, String filename) {
        try (InputStream is = getClass().getResourceAsStream(filename)) {
            Scanner s = new Scanner(is);
            s.useDelimiter(",|\\n");

            while (s.hasNext()) {
                String line = s.nextLine();
                String[] parts = line.split(",");
                this.country = new Country(parts[0].trim(),parts[1].trim(),parts[2].trim()
                        ,parts[3].trim(),parts[4].trim(),parts[5].trim(),parts[6].trim());
                countryList.add(country);
                country.setCountryLinkedList(countryList);
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
