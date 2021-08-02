package com.example.wuzzuf;

import tech.tablesaw.api.Table;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/wuzzuf-jobs")
public class WuzzufResource {
    WuzzufDAOWeb wuzzufdata = new WuzzufDAOWeb();
    Table data = wuzzufdata.loadDataFromCSV(wuzzufdata.dataPath);

    @GET
    @Path("/structure")
    @Produces("text/plain")
    public String getDataInfoStructure() {
        return String.valueOf(wuzzufdata.getDataInfoStructure(data));
    }

    @GET
    @Path("/summary")
    @Produces("text/plain")
    public String getDataSummary() {
        return String.valueOf(wuzzufdata.getDataSummary(data));
    }

    @GET
    @Path("/jobs")
    @Produces("text/plain")
    public String getCountJobs() {
        return String.valueOf(wuzzufdata.count_jobs(data));
    }

    @GET
    @Path("/area")
    @Produces("text/plain")
    public String getCountAreas() {
        return String.valueOf(wuzzufdata.count_areas(data));
    }

    @GET
    @Path("/skills")
    @Produces("text/plain")
    public String getRequiredSkills() {
        return String.valueOf(wuzzufdata.get_required_skills(data));
    }


    @GET
    @Path("/years")
    @Produces("text/plain")
    public String getFactorizeYearsExp() {
        return String.valueOf(wuzzufdata.factorize_YearsExp(data));
    }

    @GET
    @Path("/jobs-pie-chart")
    @Produces("image/*")
    public Response getJobsPieChartImage() {
        File f = new File("src/main/resources/Data/PieChart.jpeg");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }
    @GET
    @Path("/title-chart")
    @Produces("image/*")
    public Response getTitleChartImage() {
        File f = new File("src/main/resources/Data/TitleGraph.jpeg");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }
    @GET
    @Path("/location-chart")
    @Produces("image/*")
    public Response getLocationGraphImage() {
        File f = new File("src/main/resources/Data/LocationGraph.jpeg");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }
}