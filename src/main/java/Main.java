import entities.Country;
import entities.CountryStatisticsManager;
import enums.Continent;
import enums.MenuOption;
import utils.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        CountryStatisticsManager csm = new CountryStatisticsManager();
        LinkedList<Country> countryList = new LinkedList<>();
        csm.loadDataFromFile(countryList, "/data.csv");

        Scanner scanner = new Scanner(System.in);
        MenuOption option;
        do {
            System.out.println("Enter option: (A)dd country, (F)ind country, (L)ist countries, (S)ort countries, (C)ontinent filter, (Q)uit");
            String userInput = scanner.nextLine();
            option = MenuOption.fromCode(userInput);

            if (option == null) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

//Name,Population,GDP,enums.Continent,EconomicRating,PopulationRating,ContinentRating
            switch (option) {

                case ADD_COUNTRY:
                    System.out.println("Enter Name of country: ");
                    String name = scanner.nextLine();
                    System.out.println("Population: ");
                    String population = scanner.nextLine();
                    System.out.println("GDP: ");
                    String gdp = scanner.nextLine();
                    System.out.println("enums.Continent: ");
                    String enumC = scanner.nextLine();
                    System.out.println("EconomicRating: ");
                    String economic = scanner.nextLine();
                    System.out.println("Population Rating: ");
                    String populationR = scanner.nextLine();
                    System.out.println("Continent Rating: ");
                    String continentR = scanner.nextLine();

                    Country country = new Country(name, population, gdp, enumC, economic, populationR, continentR);
                    countryList.add(country);
                    country.setCountryLinkedList(countryList);
                    System.out.println("Add success. ");
                    break;

                case FIND_COUNTRY:
                    System.out.println("Search country: ");
                    String search = scanner.nextLine();
                    findCountry(search,countryList);
                    break;

                case LIST_COUNTRIES:
                    System.out.println("All country: ");
                    for (Country country1 : countryList) {
                        System.out.println(country1);
                    }
                    break;

                case SORT_COUNTRIES:
                    System.out.println("Filter countries by continent\n" +
                            "Choose which continent you would like to filter by -- >");
                    int index = 1;
                    for (Enum e: Continent.values()){
                        System.out.println(index++ + " - " + e);
                    }
                    
                    //AFRICA, ANTARCTICA, ASIA, EUROPE, NORTH_AMERICA, AUSTRALIA, SOUTH_AMERICA;
                    String selectStr = scanner.nextLine();
                    sortedCountryByMainLand(selectStr,countryList);
                    
                    break;

                case CONTINENT_FILTER:
                    menuForSwitchSorted();
                    String choiceRes = scanner.nextLine();
                    int choice = Integer.parseInt(choiceRes);
                    switchSortedList(countryList,choice);
                    break;

                case QUIT:
                    System.out.println("Exiting...");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }

        } while (option != MenuOption.QUIT);

        scanner.close();
    }

    public static void switchSortedList(LinkedList<Country> countryList, int choice){
        if (choice ==0){
            System.out.println("Back to the menu...");
        }
        while (choice != 0) {
            switch (choice) {
                case 1:
                    countryList.sort(new Comparators.CompareCountryByName());
                    choice = 0;
                    System.out.println("the Sorted success.");
                    break;
                case 2:
                    countryList.sort(new Comparators.CompareCountryByPopulation());
                    choice = 0;
                    System.out.println("the Sorted success.");
                    break;
                case 3:
                    countryList.sort(new Comparators.CompareCountryByGdpLevel());
                    choice = 0;
                    System.out.println("the Sorted success.");
                    break;
                case 4:
                    countryList.sort(new Comparators.CompareCountryByMainland());
                    choice = 0;
                    System.out.println("the Sorted success.");
                    break;
                case 5:
                    menuForSwitchedSortedByRating();
                    int select = s.nextInt();
                    switchSortedByRating(countryList, select);
                    System.out.println("the Sorted success.");
                    choice = 0;
                    break;
                default:
                    System.out.println("You entered an incorrect number, try again");
                    switchSortedList(countryList, s.nextInt());
                    return;
            }
        }


    }
    public static void menuForSwitchSorted(){
        System.out.println("Choose the way you want to sort the list -- >");
        System.out.println("""
                1 - By name.
                2 - Population size.
                3 - GDP.
                4 - Mainland.
                5 - Ratings.
                0 - to return back.\s""");

    }
    public static void menuForSwitchedSortedByRating(){
        System.out.println("Choose the way you want to sort the list By Rating -- >");
        System.out.println("""
                1 - Economic.
                2 - Population.
                3 - Continent.
                0 - to return back.\s""");
    }
    public static void switchSortedByRating(LinkedList<Country> countryList, int select){
        while (true){
            if (select == 0){
                break;
            }
            switch (select){
                case 1:
                    countryList.sort(new Comparators.CompareCountryByRatings.byEconomicRating());
                    select = 0;
                    break;
                case 2:
                    countryList.sort(new Comparators.CompareCountryByRatings.byPopulationRating());
                    select = 0;
                    break;
                case 3:
                    countryList.sort(new Comparators.CompareCountryByRatings.byContinentRating());
                    select = 0;
                    break;
                default:
                    System.out.println("You entered an incorrect number, try again");
                    break;
            }
        }
    }
    public static List<Country> newFilterList(String land,LinkedList<Country> countryList){
        List<Country> filteredCountries = new ArrayList<>();
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getEnumsContinent().equalsIgnoreCase(land)){
                filteredCountries.add(countryList.get(i));
            }
        }
        return filteredCountries;
    }

    public static void findCountry(String search,LinkedList<Country> countryList){
        search = search.toUpperCase();

        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getName().equalsIgnoreCase(search)) {
                System.out.println(countryList.get(i));
            } else if (countryList.get(i).getName().length() > search.length()) {
                if (countryList.get(i).getName().charAt(0) == search.charAt(0)){
                    System.out.println(countryList.get(i));
                }
            }
        }
    }
    public static void sortedCountryByMainLand(String selectStr, LinkedList<Country> countryList){
        List<Country> filteredCountries = null;

        String land = "";
        int select = 0;
        try {
            select = Integer.parseInt(selectStr);
        } catch (NumberFormatException e) {

        }
        switch (select){
            case 1:
                land = "AFRICA";
                filteredCountries = newFilterList(land,countryList);
                break;
            case 2:
                land = "ANTARCTICA";
                filteredCountries =newFilterList(land,countryList);
                break;
            case 3:
                land = "ASIA";
                filteredCountries =newFilterList(land,countryList);
                break;
            case 4:
                land = "EUROPE";
                filteredCountries =newFilterList(land,countryList);
                break;
            case 5:
                land = "NORTH_AMERICA";
                filteredCountries =newFilterList(land,countryList);
                break;
            case 6:
                land = "AUSTRALIA";
                filteredCountries =newFilterList(land,countryList);
                break;
            case 7:
                land = "SOUTH_AMERICA";
                filteredCountries =newFilterList(land,countryList);
                break;
            default:
                System.out.println("Invalid Input.");
        }
        try {
            assert filteredCountries != null;
            if (!filteredCountries.isEmpty()) {
                for (Country c : filteredCountries) {
                    System.out.println(c);
                }
            }else {
                System.out.println("Filtering failed.");
            }
        } catch (Exception e) {
        }
    }

    public static Scanner s = new Scanner(System.in);
}

