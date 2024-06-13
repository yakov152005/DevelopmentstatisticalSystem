package utils;
import entities.Country;
import java.util.Comparator;

public class CompareCountryByGdpLevel implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2) {
        int gdpLevel1 = 0;
        int gdpLevel2 = 0;
        try {
            gdpLevel1 = Integer.parseInt(c1.getGDP());
            gdpLevel2 = Integer.parseInt(c2.getGDP());
        }catch (NumberFormatException e){}
        if (gdpLevel1 < gdpLevel2) return  -1;
        else if (gdpLevel1 > gdpLevel2 ) return 1;
        else return 0;
    }
}
