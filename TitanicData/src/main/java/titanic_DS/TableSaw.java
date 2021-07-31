package titanic_DS;

import joinery.DataFrame;
import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tech.tablesaw.joining.DataFrameJoiner;


public class TableSaw {

    public static void main(String[] args){
        try {
            String path = "src/main/resources/titanic_train.csv";
            Table df= loadDataFromCVS(path);
            String describe =getDataSummary(df);
            System.out.println(describe);

            System.out.println ("=========================================================================================");

            System.out.println(addDateColumnToData(df));
            System.out.println ("=========================================================================================");

            String path2 = "src/main/resources/titanic_test.csv";
            Table df2= loadDataFromCVS(path2);

            //Table joined_data=JoinDataFrames(df,df2);
            //System.out.println(joined_data);
            //System.out.println ("=========================================================================================");

            Table merged_data=MergeDataFrames(df,df2);
            System.out.println(merged_data);
            System.out.println ("=========================================================================================");


        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    ///  Load Data From CSV File
    public static Table loadDataFromCVS(String path) throws IOException {
        final var csv = Table.read().csv(path);
        return csv;
    }

    /// get the summary of the data
    public static String getDataSummary(Table data) {
        Table dataSummary = data.summary ();
        return dataSummary.toString ();
    }

    //Adding Columns
    public static Table addDateColumnToData(Table data) {
        int rowCount = data.rowCount ();
        List<LocalDate> dateList = new ArrayList<LocalDate>();
        for (int i = 0; i < rowCount; i++) {
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }
        DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }

    //Join DataFrames
    public static Table JoinDataFrames (Table data1, Table data2){
        DataFrameJoiner joiner = new DataFrameJoiner(data1);
        return joiner.inner(data2);
    }

    //Merge DataFrames
    public static Table MergeDataFrames (Table data1,Table data2){
        return data1.concat(data2);
    }
}

