package data;

public class City {
    private String name;
    private String country;
    private String capital;
    private String population;
    private String id;

    public City() {
    }


    public City(String name, String country, String capital, String population, String id) {
        this.name = name;
        this.country = country;
        this.capital = capital;
        this.population = population;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "City name :" + name + ", Population :" + population + ", ID :" + id;
    }
}
