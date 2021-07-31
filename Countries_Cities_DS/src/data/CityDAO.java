package data;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CityDAO {

    public List<City> readCityFromCSV(String filePath) {
        List<City> cityData = new ArrayList<>();

        File dataFile2 = new File(filePath);
        List<String> cityInfo = new ArrayList<String>();
        try {
            cityInfo = Files.readAllLines(dataFile2.toPath());
        } catch (Exception e) {
            System.out.println("An error has been happened during reading city dataset file");
        }

        for (int lineIdx = 1; lineIdx < cityInfo.size(); lineIdx++) {
            String line = cityInfo.get(lineIdx);
            String[] fields2 = line.split(",");
            cityData.add(createCity(fields2));
        }

        return cityData;
    }

    public City createCity(String[] metadata)
    {
        //if (metadata[8] == ""){
        //    metadata[8]="minor";
        //}
        City city = new City(metadata[0].trim(), metadata[4].trim(), metadata[8].trim(),
                metadata[9].trim(),metadata[10].trim());

        return city;

    }

    public Map<String , City> HighestPopulationCityOFCountry (List<City> cities) {
        Map<String, City> HighestPopulationCityOFCountry = new HashMap<>();
        cities.stream()
                .collect(groupingBy(City::getCountry, Collectors.maxBy(Comparator.comparing(City::getPopulation))))
                .forEach((k, v) -> HighestPopulationCityOFCountry.put(k, v.orElse(null)));

        return HighestPopulationCityOFCountry;
    }

    //public Map<String , City> HighestPopulationCityOFContinent (List<City> cities,List<Country> countries){
    //    Map<String, City> HighestPopulationCityOFContinent = new HashMap<>();
    //    cities.stream()
    //            .filter(city -> countries.stream().collect(groupingBy((),(Country::getContinent))
    //                    .anyMatch(c -> c==city.getCountry()))
    //            .max(Comparator.comparing(City::getPopulation))
    //            .forEach((k, v) -> HighestPopulationCityOFContinent.put(k, v.orElse(null)));
    //    //cities.stream()
    //    //        .collect(groupingBy(countries.stream()
    //    //                .collect(Country::getContinent)), Collectors.maxBy(Comparator.comparing(City::getPopulation)))
    //    //        .forEach((k, v) -> HighestPopulationCityOFContinent.put(k, v.orElse(null)));
    //}

    public Optional<City> HighestPopulationCapital (List<City> cities) {
       Optional<City> HighestPopCapital = cities.stream()
               .filter(c -> c.getCapital() == "primary")
               .max(Comparator.comparing(City::getPopulation));
        return HighestPopCapital;
    }


    public String getMedianQuartile (List<City> cities){
    List <City> sortedCities =  cities.stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList());
    int mid =sortedCities.size()/2;
      return "Median quartile City Name: "+sortedCities.get(mid).getName()+
              " ,with population: "+ sortedCities.get(mid).getPopulation();
    }


    public String getLowerQuartile (List<City> cities) {
        List<City> sortedCities = cities.stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList());
        int lower = sortedCities.size() / 4;
        return "lower quartile City Name: " + sortedCities.get(lower).getName()+
        " with population : " + sortedCities.get(lower).getPopulation();
    }

    public String getUpperQuartile (List<City> cities) {
        List<City> sortedCities = cities.stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList());
        int upper = (3 * sortedCities.size()) / 4;
        return "upper quartile City Name: " + sortedCities.get(upper).getName() +
                " with population: " + sortedCities.get(upper).getPopulation();
    }

    public List<City> getInterQuartileRange (List<City> cities) {
        List<City> sortedCities = cities.stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList());
        int lower = sortedCities.size() / 4;
        int upper = (3 * sortedCities.size()) / 4;
        return new ArrayList<>(sortedCities).subList(lower, upper);
    }

}
