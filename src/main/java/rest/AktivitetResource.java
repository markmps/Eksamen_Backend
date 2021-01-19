package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dto.WeatherDTO;
import facades.UserFacade;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;
import utils.HttpUtils;

@Path("aktivitet")
public class AktivitetResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final UserFacade USERFACADE =  UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;
    
    Gson gson = new Gson();

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        
        return "test";
    }
    
    @Path("/aktiviteter")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAktiviteter() throws IOException {
     
 
        return Response.ok().entity(GSON.toJson(USERFACADE.getAktiviteter())).build();
    
        
       }

    @Path("/weatherapi")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeatherAPI() throws IOException {
        
        String chuck = HttpUtils.fetchData("https://vejr.eu/api.php?location=Roskilde&degree=C");
        
        WeatherDTO wdto = gson.fromJson(chuck, WeatherDTO.class);
        
        String combinedJSON = gson.toJson(wdto);
        return combinedJSON;
        
       }
   
}