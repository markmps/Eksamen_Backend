package rest;

import com.google.gson.Gson;

import dto.WeatherDTO;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

@Path("weather")
public class JokeResource {

    @Context
    private UriInfo context;
    
    Gson gson = new Gson();

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        
        return "test";
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        
        String weather = HttpUtils.fetchData("https://vejr.eu/api.php?location=Roskilde&degree=C");
        WeatherDTO wdto = gson.fromJson(weather, WeatherDTO.class);
        
        String combinedJSON = gson.toJson(wdto);
        return combinedJSON;
        
       }

   
}