package Wuzzuf;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static tech.tablesaw.aggregate.AggregateFunctions.count;
import static tech.tablesaw.aggregate.AggregateFunctions.mean;

public class WuzzufDAO {
    Table wuzzufData;
    String dataPath = "src/main/resources/data/Wuzzuf_Jobs.csv";

    public WuzzufDAO() {
    }

    ///  Load Data From CSV File
    public Table loadDataFromCVS(String path) throws IOException {
        //Table wuzzufData = Table.read ().csv (path);
        Table wuzzufData = Table.read().usingOptions(CsvReadOptions
                .builder(path)
                .missingValueIndicator("-"));
        return wuzzufData;
    }
    ///////////////////////////////////////////////////////////////////////////////////////
    // get the structure of the data
    public String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure ();
        return dataStructure.toString ();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //get Data Summary
    public String getDataSummary(Table data) {
        Table summary = data.summary ();
        return summary.toString ();
    }

    public Table distinctData(Table data) {
        Table distinctData = (Table) data.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctData;

    }

    public Table count_company_jobs(Table table) {
        //Table new_table = table.summarize("Title", count).by("Company");
        Table new_table = table.summarize("Title", count).by("Company");
        return new_table.sortOn("-Count [Title]");
    }

    public  Table count_jobs(Table table) {
        Table counted_jobs = table.countBy(table.categoricalColumn("Title"))
                .sortOn("-Count");
                //.first(20);
        return counted_jobs;
    }

    public  Table count_areas(Table table) {
        Table counted_areas = table.countBy(table.categoricalColumn("Location"))
                .sortOn("-Count");
        //.first(20);
        return counted_areas;
    }

    public Table get_required_skills(Table table) {
        List<String> skills = new ArrayList<>();

        for (Object colName : table.column("Skills")) {
            String[] Temp =String.valueOf(colName).split(",");
            Collections.addAll(skills, Temp);
        }
        Table allSkills = Table.create("table", StringColumn.create("skills", skills));
        Table required_skills = allSkills.countBy(allSkills.categoricalColumn("skills"))
                .sortOn("-Count");
        return required_skills;
    }

    public List<Number> factorize_YearsExp(Table table){
        //NumberColumn min_ExpYears = null;
        StringColumn years = (StringColumn) table.column ("YearsExp");
        //System.out.println(years.size());
        List<Number> mapped_ExpYears = new ArrayList<Number> ();
        for (String year : years){
            String[] n = year.split("");
            StringBuffer f = new StringBuffer();

            for (String s : n) {
                if (s.matches("[0-9]+")) {
                    f.append(s);
                } else {
                    break;
                }
                if (f.length()!= 0) {
                    mapped_ExpYears.add(Integer.parseInt(String.valueOf(f)));
                    //f.setLength(0);
                } else {
                    mapped_ExpYears.add(Integer.parseInt("0"));
                }
            }
        }
        //NumberColumn min_ExpYears = DoubleColumn.create ("min_ExpYears", mapped_ExpYears);
        //table.addColumns (min_ExpYears);
        return mapped_ExpYears;//table;
    }



}




