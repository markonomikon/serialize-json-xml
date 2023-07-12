package ua.markonomikon.service.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ua.markonomikon.model.pojo.Person;

import static ua.markonomikon.management.AppConstants.PERSON_PATH;

@Path(PERSON_PATH)
public class PersonServiceResource {
    @Inject
    ObjectMapper objectMapper;
    @Inject
    Jsonb jsonb;
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
