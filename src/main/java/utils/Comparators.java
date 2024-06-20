package utils;
import entities.Country;
import java.util.Comparator;

public class Comparators {
    public static class CompareCountryByGdpLevel implements Comparator<Country> {
        @Override
        public int compare(Country c1, Country c2) {
            int gdpLevel1 = 0;
            int gdpLevel2 = 0;
            try {
                gdpLevel1 = Integer.parseInt(c1.getGDP());
                gdpLevel2 = Integer.parseInt(c2.getGDP());
            } catch (NumberFormatException e) {
            }
            if (gdpLevel1 < gdpLevel2) return -1;
            else if (gdpLevel1 > gdpLevel2) return 1;
            else return 0;
        }
    }
    public static class CompareCountryByMainland implements Comparator<Country> {
        @Override
        public int compare(Country c1, Country c2) {
            return c1.getEnumsContinent().compareTo(c2.getEnumsContinent());
        }
    }

    public static class CompareCountryByName implements Comparator<Country> {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class CompareCountryByPopulation implements Comparator<Country> {
        @Override
        public int compare(Country c1, Country c2) {
            int population1 = 0;
            int population2 = 0;
            try {
                population1 = Integer.parseInt(c1.getPopulation());
                population2 = Integer.parseInt(c2.getPopulation());
            } catch (NumberFormatException e) {
            }
            if (population1 < population2) return -1;
            else if (population1 > population2) return 1;
            else return 0;
        }
    }

    public static class CompareCountryByRatings {
        public static class byEconomicRating implements Comparator<Country>{
            public int compare(Country c1, Country c2){
                double rate1 = 0;
                double rate2 = 0;
                try {
                    rate1 = Double.parseDouble(c1.getEconomicRating());
                    rate2 = Double.parseDouble(c2.getEconomicRating());
                }catch (NumberFormatException e){
                    System.out.println("Invalid number format: " + rate1 +" " + rate2);
                }
                if (rate1 < rate2) return -1;
                else if (rate1 > rate2) return 1;
                else return 0;
            }
        }

        public static class byPopulationRating implements Comparator<Country> {
            public int compare(Country c1, Country c2) {
                double rate1 = parsePopulationRating(c1.getPopulationRating());
                double rate2 = parsePopulationRating(c2.getPopulationRating());
                return Double.compare(rate1, rate2);
            }

            private double parsePopulationRating(String rating) {
                try {
                    return Double.parseDouble(rating);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + rating);
                    return 0.0;
                }
            }
        }

        public static class byContinentRating implements Comparator<Country>{
            public int compare(Country c1, Country c2){
                double rate1 = 0;
                double rate2 = 0;
                try {
                    rate1 = Double.parseDouble(c1.getContinentRating());
                    rate2 = Double.parseDouble(c2.getContinentRating());
                }catch (NumberFormatException e){
                    System.out.println("Invalid number format: " + rate1 +" " + rate2);
                }
                if (rate1 < rate2) return -1;
                else if (rate1 > rate2) return 1;
                else return 0;
            }
        }
    }
}

