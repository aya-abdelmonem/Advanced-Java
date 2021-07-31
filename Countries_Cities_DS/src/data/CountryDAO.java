package data;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    public List<Country> readCountryFromCSV(String filePath) {
        List<Country> data = new ArrayList<>();

        File dataFile = new File(filePath);
        List<String> info = new ArrayList<String>();
        try {
            info = Files.readAllLines(dataFile.toPath());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        for (int lineIdx = 1; lineIdx < info.size(); lineIdx++) {
            String line = info.get(lineIdx);
            String[] fields = line.split(",");
            data.add(createCountry(fields));
        }

        return data;
    }

    public Country createCountry(String[] metadata)
    {
            Country country = new Country(metadata[0].trim(), metadata[1].trim(),
                    metadata[2].trim());
            return country;

    }


}
