package utils;
import entities.Country;
import java.util.Comparator;

public class CompareCountryByPopulation implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
        int population1 = 0;
        int population2 = 0;
        try {
            population1 = Integer.parseInt(c1.getPopulation());
            population2 = Integer.parseInt(c2.getPopulation());
        } catch (NumberFormatException e){}
        if (population1 < population2) return -1;
        else if (population1 > population2) return 1;
        else return 0;
    }
}
