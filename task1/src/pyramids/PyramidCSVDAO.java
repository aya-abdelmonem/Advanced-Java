package pyramids;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO {

    public List<Pyramid> readPyramidsFromCSV(String fileName) {
        List<Pyramid> pyramids = new ArrayList<>();

        File dataFile = new File(fileName);
        List<String> pyramidInfo = new ArrayList<String>();
        try {
            pyramidInfo = Files.readAllLines(dataFile.toPath());
        } catch (Exception e) {
            System.out.println("An error has been happened during reading pyramids dataset file");
        }

        for (int lineIdx = 1; lineIdx < pyramidInfo.size(); lineIdx++) {
            String line = pyramidInfo.get(lineIdx);
            String[] fields = line.split(",");
            pyramids.add(createPyramid(fields));
        }

        return pyramids;
    }

    public Pyramid createPyramid(String[] metadata)
    {
        try {
            Pyramid aPyramid = new Pyramid(metadata[0].trim(), metadata[2].trim(),
                    metadata[4].trim(), Double.parseDouble(metadata[7].trim()));
            return aPyramid;
        } catch (Exception e) {
            Pyramid aPyramid = new Pyramid(metadata[0].trim(), metadata[2].trim(),
                    metadata[4].trim(), null);
            return aPyramid;
        }


    }
}
