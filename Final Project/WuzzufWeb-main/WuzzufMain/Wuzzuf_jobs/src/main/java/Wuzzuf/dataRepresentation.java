package Wuzzuf;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import tech.tablesaw.api.Table;
import java.awt.Color;
import java.util.List;
//import java.util.Map;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;
import static tech.tablesaw.aggregate.AggregateFunctions.count;
import tech.tablesaw.api.Table;

/**
 *
 * @author rawan
 */
public class dataRepresentation {
    

    
    
     public static void graphjobs(Table table) {
     
        table =  table.countBy("Company").sortDescendingOn("Count").first(10) ;
        System.out.println(table);
        List<String> Company = table.stringColumn("Category").asList();
        List<Integer> Title = table.intColumn("Count").asList();
        PieChart chart = new PieChartBuilder().width(1000).height(600).title("Pie Chart").build();

        for (int i = 0; i < Company.size(); i++) {
            chart.addSeries(Company.get(i), Title.get(i));
        }

        new SwingWrapper(chart).displayChart();
    }
    /**
     *
     * @param table
     */
     public static void graphTitlejob(Table table) {
         
        table =  table.countBy("Title").sortDescendingOn("Count").first(10) ;
        System.out.println(table);
        List<String> Title = table.stringColumn("Category").asList();
        List<Integer> Count = table.intColumn("Count").asList();
        

        CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Title Histogram").xAxisTitle ("Title").yAxisTitle ("-Count").build ();

        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);  
        chart.addSeries ("Title graph",Title, (List<? extends Number>) Count);
            
//        for (int i = 0; i < Title.size(); i++) {
//                
//            chart.addSeries(Title.get(i),Count.get(i));
//            
//            }
            
        new SwingWrapper (chart).displayChart ();
    }
      
      
      public static void graphLocation(Table table) {
          
          
          
        table =  table.countBy("Location").sortDescendingOn("Count").first(10) ;
        System.out.println(table);
        List<String> Location = table.stringColumn("Category").asList();
        List<Integer> Count = table.intColumn("Count").asList();
        
        CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Title Histogram").xAxisTitle ("Location").yAxisTitle ("-Count").build ();
       
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);  
        chart.addSeries ("Location graph",Location, (List<? extends Number>) Count);
         
//        for (int i = 0; i < Location.size(); i++) {
//                
//            chart.addSeries(Location.get(i),Count.get(i));
//            
//            }
//            
        new SwingWrapper (chart).displayChart ();
    }
}
