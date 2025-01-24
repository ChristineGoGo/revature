package application.Service;

import java.util.List;

import application.DAO.FlightDAO;
import application.Model.Flight;

public class FlightService {
    FlightDAO flightDAO;

    /**
     * No-args constructor for a flightService that instantiates a plain flightDAO
     */
    public FlightService() {
        flightDAO = new FlightDAO();
    }

    /**
     * Constructor for a flightService when a flightDAO is provided
     * This is used for when a mock flightDAO that exhibits mock behavior is used in the test cases.
     * This would allow for testing of FlightService independently of FlightDAO
     * @param flightDAO
     */
    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    /**
     * Using the flightDAO to add a new flight to the database
     * @param flight
     * @return newly added flight
     */
    public Flight addFlight(Flight flight) {
        Flight newFlight = new Flight();
        newFlight = flightDAO.insertFlight(flight);
        Integer generatedFlightId = newFlight.getFlight_id();

        if (generatedFlightId > 0) {
            return newFlight;
        }

        return null;
    }

    /**
     * Use the flightDAO to update a flight in the database
     * @param flight_id
     * @param flight object
     * @return newly updated flight
     */
    public Flight updateFlight(int flight_id, Flight flight) {
        Flight matchedFlight = flightDAO.getFlightById(flight_id);
        if (!(matchedFlight == null)) {
            flightDAO.updateFlight(flight_id, flight);
            return flightDAO.getFlightById(flight_id);
        }
        return null;
    }

    /**
     * Use the FlightDAO to retrieve a List containing all flights
     * @return all flights in the database
     */
    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    /**
     * Use the flightDAO to retrieve a LIST containing all flights departing from a certain city
     * and arriving at another city
     * @param departure_city
     * @param arrival_city
     * @return list of flights
     */
    public List<Flight> getAllFlightsFromCityToCity(String departure_city, String arrival_city) {
        return flightDAO.getAllFlightsFromCityToCity(departure_city, arrival_city);

    }


}
