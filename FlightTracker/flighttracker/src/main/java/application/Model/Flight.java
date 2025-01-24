package application.Model;

import java.util.Objects;

public class Flight {
    public int flight_id;
    public String departure_city;
    public String arrival_city;

    /**
     * A default, no-args constructor is REQUIRED for Jackson ObjectMApper
     * to work
     */

    public Flight(){

    }

    /**
     * A constructor without a flight_id for when persisting a flight to the database
     * where the flight_id has not been created yet
     * @param departure_city
     * @param arrival_city
     */

     public Flight(String departure_city, String arrival_city) {
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;

     }

    /** an all args constructor for use when retrieving a flight from the database*
     * @param flight_id
     * @param departure_city
     * @param arrival_city
     */
     public Flight(int flight_id, String departure_city, String arrival_city) {
        this.flight_id = flight_id;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
     }

    /**
     * Generate getters and setters from the IDE - Source Control VSCode
     * They are required to correctly parse to/from JSON using Jackson ObjectMapper
     * @return flight_id
     */
    public int getFlight_id() {
        return flight_id;
    }
    
    /**
     * Generate getter and setters from the IDE - Source Control VSCode
     * They are required to correctly parse to/from JSON using Jackson ObjectMapper
     * @param flight_id
     */
    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    /**
     * Generate getter and setters from the IDE - Source Control VSCode
     * They are required to correctly parse to/from JSON using Jackson ObjectMapper
     * @return departure_city
     */

    public String getDeparture_city() {
        return departure_city;
    }

    /**
     * Generate getter and setters from the IDE - Source Control VSCode
     * They are required to correctly parse to/from JSON using Jackson ObjectMapper
     * @param departure_city
     */

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    /**
     * Generate getter and setters from the IDE - Source Control VSCode
     * They are required to correctly parse to/from JSON using Jackson ObjectMapper
     * @return arrival_city
     */

    public String getArrival_city() {
        return arrival_city;
    }

    /**
     * Generate getter and setters from the IDE - Source Control VSCode
     * They are required to correctly parse to/from JSON using Jackson ObjectMapper
     * @param arrival_city
     */

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }
    /**
     * a toString method in the event that you want to test your method using System.out.print
     * ln
     * @return a string representation of this flight
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flight{");
        sb.append("flight_id=").append(flight_id);
        sb.append(", departure_city=").append(departure_city);
        sb.append(", arrival_city=").append(arrival_city);
        sb.append('}');
        return sb.toString();
    }

    /**
     * An equals method that determines if another flight is equal to this one
     * @param o some other object (such as Flight)
     * @return true if this flight is equivalent to o, false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Flight flight = (Flight) o;
        return this.flight_id == flight.flight_id && Objects.equals(departure_city, flight.departure_city) && Objects.equals(arrival_city, flight.arrival_city);
    }

}
