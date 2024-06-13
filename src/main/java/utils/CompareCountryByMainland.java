package utils;

import entities.Country;

import java.util.Comparator;

public class CompareCountryByMainland implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2) {
        return c1.getEnumsContinent().compareTo(c2.getEnumsContinent());
    }
}
