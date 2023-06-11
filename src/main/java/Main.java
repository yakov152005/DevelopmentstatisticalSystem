import entities.CountryStatisticsManager;
import enums.MenuOption;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CountryStatisticsManager csm = new CountryStatisticsManager();
        csm.loadDataFromFile("/data.csv");

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

            switch (option) {
                case ADD_COUNTRY:
                    // Logic to add country
                    break;
                case FIND_COUNTRY:
                    // Logic to find and display country
                    break;
                case LIST_COUNTRIES:
                    // Logic to list all countries
                    break;
                case SORT_COUNTRIES:
                    // Logic to sort countries
                    break;
                case CONTINENT_FILTER:
                    // Logic to filter countries by continent
                    break;
                case QUIT:
                    System.out.println("Exiting...");
                    break;
            }

        } while (option != MenuOption.QUIT);

        scanner.close();
    }
}