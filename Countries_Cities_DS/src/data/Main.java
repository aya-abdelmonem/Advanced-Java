package data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountryDAO countryCsvDAO = new CountryDAO();
        CityDAO cityCsvDAO = new CityDAO();
       List<Country> countries = countryCsvDAO.readCountryFromCSV("D:\\ITI-AI\\advancedJava\\countries.csv");

        for(Country c: countries)
        {
            System.out.println(c);
        }
        System.out.println("=============================================================================================================");
        System.out.println("=============================================================================================================");

        List<City> cities = cityCsvDAO.readCityFromCSV("D:\\ITI-AI\\advancedJava\\cities.csv");

        for(City i: cities)
        {
           System.out.println(i);
        }
        //System.out.println(cities.size());
        System.out.println("=============================================================================================================");
        System.out.println("=============================================================================================================");


        Map<String, City> HighestPopCityOFCountry= cityCsvDAO.HighestPopulationCityOFCountry(cities);
        System.out.println("Highest Population City OF each Country: "+HighestPopCityOFCountry);
        //System.out.println(HighestPopCityOFCountry.size());
        System.out.println("=============================================================================================================");
        System.out.println("=============================================================================================================");

        System.out.println("Highest Population Capital: "+cityCsvDAO.HighestPopulationCapital(cities));
        System.out.println("=============================================================================================================");
        System.out.println("=============================================================================================================");


        System.out.println(cityCsvDAO.getMedianQuartile (cities));

        System.out.println(cityCsvDAO.getLowerQuartile (cities));

        System.out.println(cityCsvDAO.getUpperQuartile (cities));

        System.out.println("=============================================================================================================");
        System.out.println(cityCsvDAO.getInterQuartileRange (cities));


    }

}
