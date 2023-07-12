package ua.markonomikon.serialize.service.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ua.markonomikon.serialize.model.pojo.Person;
import ua.markonomikon.serialize.management.AppConstants;

/**
 * SERVICE: class for Person object
 */

@Path(AppConstants.PERSON_PATH)
public class PersonServiceResource {
    @Inject
    ObjectMapper objectMapper;
    @Inject
    Jsonb jsonb;

    /**
     * JSON: simple GET where we create a Person pojo and map it to json using jackson's ObjectMapper.
     */
    @GET
    @Path("/jackson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonWayOne() throws JsonProcessingException {
        Person person = new Person();
        person.name= "Timon";
        person.surname= "Pumba";
        person.age= 99;

        return objectMapper.writeValueAsString(person);
    }

    /**
     * JSON: simple GET where we create a Person pojo and map it to json using Jsonb.
     */
    @GET
    @Path("/jsonb")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonWayTwo() throws JsonProcessingException {
        Person person = new Person();
        person.name= "Timon";
        person.surname= "Pumba";
        person.age= 99;

        return jsonb.toJson(person);
    }

    /**
     * XML: simple GET where we create a Person pojo and map it to xml using XmlMapper.
     */
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() throws JsonProcessingException {
        Person person = new Person();
        person.name= "Timon";
        person.surname= "Pumba";
        person.age= 99;

        XmlMapper xmlMapper = new XmlMapper();

        return xmlMapper.writeValueAsString(person);
    }
}






/*
 * Created by markonomikon.
 */