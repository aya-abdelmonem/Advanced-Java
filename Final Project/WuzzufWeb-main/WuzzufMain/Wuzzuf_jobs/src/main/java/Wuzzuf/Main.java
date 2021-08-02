package Wuzzuf;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.IOException;
import java.util.List;

public class Main {
    //Table wuzzufData;
    //String dataPath = "src/main/resources/data/Wuzzuf_Jobs.csv";

    //public WuzzufDataAnalysis() {}
    public static void main(String[] args) {
        WuzzufDAO data = new WuzzufDAO ();
        try {

            //read Dataset
            data.wuzzufData= data.loadDataFromCVS (data.dataPath);

            //getting the Structure of the data
            String structure = data.getDataInfoStructure (data.wuzzufData);
            System.out.println (structure);
            System.out.println ("=====================================================================================");
            System.in.read ();

            //getting Data summery
            String summary = data.getDataSummary (data.wuzzufData);
            System.out.println (summary);
            System.out.println ("=====================================================================================");
            System.in.read ();

            Table company_jobs = data.count_company_jobs(data.wuzzufData);
            System.out.println (company_jobs);
            System.out.println ("=====================================================================================");
           // System.in.read ();
           
            dataRepresentation.graphjobs(data.wuzzufData);
            
            //the most popular job titles
            Table job_freq = data.count_jobs(data.wuzzufData);
            System.out.println (job_freq);
            System.out.println ("=====================================================================================");
            //System.in.read ();

          dataRepresentation.graphTitlejob(data.wuzzufData);  
            
           

            //the most popular areas
            Table area_freq = data.count_areas(data.wuzzufData);
            System.out.println (area_freq);
            System.out.println ("=====================================================================================");
            System.in.read ();
            
            
          dataRepresentation.graphLocation(data.wuzzufData);

            //the most important required skills
            Table required_skills = data.get_required_skills(data.wuzzufData);
            System.out.println (required_skills);
           // System.out.println (required_skills.size());
            System.out.println ("=====================================================================================");
            System.in.read ();

            //factorize the YearsExp feature and convert it to numbers in new col
            Table new_table = data.factorize_YearsExp(data.wuzzufData);
            System.out.println (new_table.first(20));
            System.out.println ("=====================================================================================");
            System.in.read ();

            //Apply K-means for job title and companies



        } catch (IOException e) {
            e.printStackTrace ();
        }

    }


}
