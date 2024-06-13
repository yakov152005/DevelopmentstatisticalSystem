
package entities;

import java.util.LinkedList;

//Name,Population,GDP,enums.Continent,EconomicRating,PopulationRating,ContinentRating
public class Country implements  Cloneable,Comparable<Country> {
    private String name;
    private String population;
    private String GDP;
    private String enumsContinent;
    private String economicRating;
    private String populationRating;
    private String continentRating;
    private LinkedList<Country> countryLinkedList;

    public Country(String name,String population,String GDP,String enumsContinent,String economicRating,String populationRating,String continentRating){
        this.name = name;
        this.population = population;
        this.GDP = GDP;
        this.enumsContinent = enumsContinent;
        this.economicRating = economicRating;
        this.populationRating = populationRating;
        this.continentRating = continentRating;
        this.countryLinkedList = new LinkedList<>();
    }

    public LinkedList<Country> getCountryLinkedList() {
        return countryLinkedList;
    }

    public void setCountryLinkedList(LinkedList<Country> countryLinkedList) {
        this.countryLinkedList = countryLinkedList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public String getEnumsContinent() {
        return enumsContinent;
    }

    public void setEnumsContinent(String enumsContinent) {
        this.enumsContinent = enumsContinent;
    }

    public String getEconomicRating() {
        return economicRating;
    }

    public void setEconomicRating(String economicRating) {
        this.economicRating = economicRating;
    }

    public String getPopulationRating() {
        return populationRating;
    }

    public void setPopulationRating(String populationRating) {
        this.populationRating = populationRating;
    }

    public String getContinentRating() {
        return continentRating;
    }

    public void setContinentRating(String continentRating) {
        this.continentRating = continentRating;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Country{" +
                "Name='" + name + '\'' +
                ", Population='" + population + '\'' +
                ", GDP='" + GDP + '\'' +
                ", Continent='" + enumsContinent + '\'' +
                ", Economic Rating='" + economicRating + '\'' +
                ", Population Rating='" + populationRating + '\'' +
                ", Continent Rating='" + continentRating + '\'' +
                '}';
    }

    @Override
    public int compareTo(Country o) {
        return this.getName().compareTo(o.getName());
    }
}
