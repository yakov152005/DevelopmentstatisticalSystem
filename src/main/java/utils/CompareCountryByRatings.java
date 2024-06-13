package utils;
import entities.Country;
import java.util.Comparator;

public class CompareCountryByRatings {
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


