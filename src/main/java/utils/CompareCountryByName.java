package utils;

import entities.Country;

import java.util.Comparator;

public class CompareCountryByName implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o1.getName().compareTo(o2.getName());
    }
}