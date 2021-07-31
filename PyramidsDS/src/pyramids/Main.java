package pyramids;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        PyramidCSVDAO pyramidDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pyramidDAO.readPyramidsFromCSV("D:\\pyramids.csv");

        for(Pyramid p: pyramids)
        {
            System.out.println(p);
        }
    }
}
