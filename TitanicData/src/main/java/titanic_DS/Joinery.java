package titanic_DS;

import joinery.DataFrame;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Joinery {
    public static void main(String[] args){
        try {
            String path = "src/main/resources/titanic_train.csv";
            DataFrame<Object> df= loadDataFromCVS(path);
            DataFrame<Object> describe =getDataInfoStructure(df);
            System.out.println(describe.toString());

            System.out.println ("=========================================================================================");

            System.out.println(addDateColumnToData(df));
            System.out.println ("=========================================================================================");

            String path2 = "src/main/resources/titanic_test.csv";
            DataFrame<Object> df2= loadDataFromCVS(path2);

            DataFrame<Object> joined_data=JoinDataFrames(df,df2);
            System.out.println(joined_data);
            System.out.println ("=========================================================================================");

            DataFrame<Object> merged_data=MergeDataFrames(df,df2);
            System.out.println(merged_data);
            System.out.println ("=========================================================================================");


        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    ///  Load Data From CSV File
    public static DataFrame<Object> loadDataFromCVS(String path) throws IOException {
        DataFrame<Object> titanicData = DataFrame.readCsv (path);
        return titanicData;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// get the structure of the data
    public static DataFrame<Object> getDataInfoStructure(DataFrame<Object> data) {
        DataFrame<Object> dataStructure = data.describe ();
        return dataStructure ;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Adding Columns
    public static DataFrame<Object> addDateColumnToData(DataFrame<Object> data) {
        int rowCount = data.length ();
        List<LocalDate> dateList = new ArrayList<LocalDate>();
        for (int i = 0; i < rowCount; i++) {
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }
        //var fake_date = data.add("Fake Date", dateList);
        return data.add("Fake Date", dateList);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Join 2 DataFrames
    public static DataFrame<Object> JoinDataFrames (DataFrame<Object> data1, DataFrame<Object> data2){
        return data1.join(data2);
    }

    //Merge 2 DataFrames
    public static DataFrame<Object> MergeDataFrames (DataFrame<Object> data1, DataFrame<Object> data2){
        return data1.merge(data2);
    }

}
