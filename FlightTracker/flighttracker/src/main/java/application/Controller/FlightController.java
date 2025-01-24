package application.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.Model.Flight;
import application.Service.FlightService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class FlightController {
    FlightService flightService;

    /**
     * inittialize the controller using the service
     */
    public FlightController() {
        flightService = new FlightService();
    }

    /**
     * Define the structure of the Javalin API using methods
     */
    public Javalin startAPI () {
        Javalin app = Javalin.create();
        app.post("/flights", this::postFlightHandler);
        app.get("/flights", this::getAllFlightsHandler);
        app.put("/flights/{flight_id}", this::updateFlightHandler);
        app.get("/flights/departing/{departure_city}/arriving/{arrival_city}", this::getAllFlightsDepartingFromCityArrivingToCityHandler);
        return app;
    }

    /**
     * handler to receive all flights
     * @param ctx 
     */
    private void getAllFlightsHandler(Context ctx) {
        ctx.json(flightService.getAllFlights());
    }

    /**
     * add a new flight
     * @param ctx
     * @throws JsonProcessingException will be thrown if there is an issue converting JSON into
     * an object
     */
    private void postFlightHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Flight flight = mapper.readValue(context.body(), Flight.class);
        Flight addedFlight = flightService.addFlight(flight);
        if (addedFlight == null) {
            context.status(400);
        } else {
            context.json(mapper.writeValueAsString(addedFlight));
        }
    }

    /**
     * update a flight using the flight's id
     * @param context
     * @throws JsonProcessingException
     */
    private void updateFlightHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Flight flight = mapper.readValue(context.body(), Flight.class);
        int flight_id = Integer.parseInt(context.pathParam("flight_id"));
        Flight flightToUpdate = flightService.updateFlight(flight_id, flight);
        System.out.println(flightToUpdate);

        if (flightToUpdate == null) {
            context.status(400);
        } else {
            context.json(mapper.writeValueAsString(flightToUpdate));
        }
    }

    /**
     * handler to display the departing from and arrival to flights
     * @param context
     * @throws JsonProcessingException
     */
    private void getAllFlightsDepartingFromCityArrivingToCityHandler(Context context) throws JsonProcessingException {
        String departure_city = context.pathParam("departure_city");
        String arrival_city = context.pathParam("arrival_city");
        context.json(flightService.getAllFlightsFromCityToCity(departure_city, arrival_city));
    }
}
