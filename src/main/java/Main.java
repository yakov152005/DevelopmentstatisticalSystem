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
                    for (int i = 0; i < countryList.size(); i++) {
                        if (countryList.get(i).getName().equalsIgnoreCase(search)) {
                            System.out.println(countryList.get(i));
                        }
                    }
                    break;
                case LIST_COUNTRIES:
                    System.out.println("All country: ");
                    for (Country country1 : countryList) {
                        System.out.println(country1);
                    }
                    break;
                case SORT_COUNTRIES:
                    List<Country> filteredCountries = null;

                    System.out.println("Filter countries by continent\n" +
                            "Choose which continent you would like to filter by -- >");

                    int index = 1;
                    for (Enum e: Continent.values()){
                        System.out.println(index++ + " - " + e);
                    }
                    //AFRICA, ANTARCTICA, ASIA, EUROPE, NORTH_AMERICA, AUSTRALIA, SOUTH_AMERICA;

                    String selectStr = scanner.nextLine();
                    String land = "";
                    int select = Integer.parseInt(selectStr);
                    switch (select){
                        case 1:
                            land = "AFRICA";
                            filteredCountries =newFilterList(land,countryList);
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
                            System.out.println("Invalid number.");
                    }
                    assert filteredCountries != null;
                    if (!filteredCountries.isEmpty()) {
                        for (Country c : filteredCountries) {
                            System.out.println(c);
                        }
                    }else {
                        System.out.println("Filtering failed.");
                    }

                    break;
                case CONTINENT_FILTER:
                    menuForSwitchSorted();
                    int choice = scanner.nextInt();
                    switchSortedList(countryList,choice);
                    scanner.nextLine();//clean the buffer
                    break;
                case QUIT:
                    System.out.println("Exiting...");
                    break;
            }

        } while (option != MenuOption.QUIT);

        scanner.close();
    }
    public static void switchSortedList(LinkedList<Country> countryList, int choice){
        while (true){
            if (choice == 0){
                break;
            }
            switch (choice){
                case 1:
                    countryList.sort(new CompareCountryByName());
                    choice = 0;
                    break;
                case 2:
                    countryList.sort(new CompareCountryByPopulation());
                    choice = 0;
                    break;
                case 3:
                    countryList.sort(new CompareCountryByGdpLevel());
                    choice = 0;
                    break;
                case 4:
                    countryList.sort(new CompareCountryByMainland());
                    choice = 0;
                    break;
                case 5:
                    menuForSwitchedSortedByRating();
                    int select = s.nextInt();
                    switchSortedByRating(countryList,select);
                    choice = 0;
                    break;
                default:
                    System.out.println("You entered an incorrect number, try again");
                    break;
            }
        }
        System.out.println("the Sorted success.");

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
                    countryList.sort(new CompareCountryByRatings.byEconomicRating());
                    select = 0;
                    break;
                case 2:
                    countryList.sort(new CompareCountryByRatings.byPopulationRating());
                    select = 0;
                    break;
                case 3:
                    countryList.sort(new CompareCountryByRatings.byContinentRating());
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
    public static Scanner s = new Scanner(System.in);

}

