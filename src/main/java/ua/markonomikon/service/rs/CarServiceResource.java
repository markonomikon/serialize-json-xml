package ua.markonomikon.service.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ua.markonomikon.model.pojo.Car;
import ua.markonomikon.model.pojo.Component;
import ua.markonomikon.model.record.Engine;
import ua.markonomikon.model.record.Wheels;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;

import static ua.markonomikon.management.AppConstants.CAR_PATH;

@Path(CAR_PATH)
public class CarServiceResource {
    @Inject
    ObjectMapper objectMapper;
    @Inject
    Jsonb jsonb;

    @GET
    @Path("/jackson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonWayOne() throws JsonProcessingException {
        Car car = new Car();
        car.brand = "Ford";
        car.model = "Focus";
        car.components = new ArrayList<>();

        Component component = new Component();
        component.engine = new Engine("1.9 TDI", 140);
        component.tire = new Wheels("Bridgestone", 17);

        car.components.add(component);

        return objectMapper.writeValueAsString(car);
    }
    @GET
    @Path("/jsonb")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonWayTwo() throws JsonProcessingException {
        Car car = new Car();
        car.brand = "Toyota";
        car.model = "Supra";
        car.components = new ArrayList<>();

        Component component = new Component();
        component.engine = new Engine("V8", 500);
        component.tire = new Wheels("TOYO", 20);

        car.components.add(component);

        return jsonb.toJson(car);
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() throws JsonProcessingException {
        Car car = new Car();
        car.brand = "Toyota";
        car.model = "Supra";
        car.components = new ArrayList<>();

        Component component = new Component();
        component.engine = new Engine("V8", 500);
        component.tire = new Wheels("TOYO", 20);

        car.components.add(component);

        XmlMapper xmlMapper = new XmlMapper();

        return xmlMapper.writeValueAsString(car);
    }
}
