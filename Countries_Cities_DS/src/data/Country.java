package data;

public class Country {

    private String abbreviation;
    private String name;
    private String continent;

    public Country() {}

    public Country(String abbreviation, String name, String continent){
        this.abbreviation=abbreviation;
        this.name=name;
        this.continent=continent;

    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country name :" + name + ", Abbreviation :" + abbreviation +
                ", Continent :" + continent;
    }



}
