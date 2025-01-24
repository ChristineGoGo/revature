package application.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Model.Flight;
import application.Util.ConnectionUtil;

public class FlightDAO {
    /**
     * retrieve all flights from the flight table
     * 
     * @return all flights
     */

     public List<Flight> getAllFlights() {
        Connection conn = ConnectionUtil.getConnection();
        List<Flight> flights = new ArrayList();

        try {
            String sql = "SELECT * FROM flight";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlight_id(rs.getInt("flight_id"));
                flight.setArrival_city(rs.getString("arrival_city"));
                flight.setDeparture_city(rs.getString("departure_city"));
                flights.add(flight);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return flights;
     }
     /**
      * retrieve a flight by its id
      * @param flight_id
      * @return flight
      */
      public Flight getFlightById(int flight_id) {
        Connection conn = ConnectionUtil.getConnection();
        Flight flight = new Flight();

        try {
            String sql = "SELECT * FROM flight WHERE flight_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, flight_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                flight.setFlight_id(rs.getInt("flight_id"));
                flight.setDeparture_city(rs.getString("departure_city"));
                flight.setArrival_city(rs.getString("arrival_city"));
            }
            return flight;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to find the id!");
        }
        return null;
      }
      /**
       * Add a flight into the flight table. flight_id is auto generated
       * @param flight
       */
      public Flight insertFlight(Flight flight) {
        Connection conn = ConnectionUtil.getConnection();
        Flight newFlight = new Flight();

        try {
            String sql = "INSERT INTO flight (departure_city, arrival_city) VALUES ( ?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, flight.getDeparture_city());
            pst.setString(2, flight.getArrival_city());

            pst.executeUpdate();

            ResultSet pKeyResultSet = pst.getGeneratedKeys();
            if (pKeyResultSet.next()) {
                int generated_flight_id = (int) pKeyResultSet.getLong(1);
                newFlight.setFlight_id(generated_flight_id);
                newFlight.setDeparture_city(flight.getDeparture_city());
                newFlight.setArrival_city(flight.getArrival_city());
                return newFlight;
            }



        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
      }

      /**
       * update a flight identified by the flight id
       * @param flight_id
       * @param flight
       */
      public void updateFlight(int flight_id, Flight flight) {
        Connection conn = ConnectionUtil.getConnection();

        try {
            String sql = "UPDATE flight SET departure_city = ?, arrival_city = ? WHERE flight_id = ?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, flight.getDeparture_city());
            pst.setString(2, flight.getArrival_city());
            pst.setInt(3, flight_id);

            pst.executeUpdate();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
      }

      /**
       * query database of flights from certain cities
       * @param departure_city
       * @param arrival_city
       * @return flight objects
       */

       public List<Flight> getAllFlightsFromCityToCity(String departure_city, String arrival_city) {
            Connection conn = ConnectionUtil.getConnection();
            List<Flight> flights = new ArrayList<>();

            try {
                String sql = "SELECT * FROM flight WHERE departure_city = ? AND arrival_city = ?;";
                
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, departure_city);
                pst.setString(2, arrival_city);

                ResultSet result = pst.executeQuery();

                while(result.next()) {
                    Flight flight = new Flight();
                    flight.setFlight_id(result.getInt("flight_id"));
                    flight.setDeparture_city(result.getString("departure_city"));
                    flight.setArrival_city(result.getString("arrival_city"));

                    flights.add(flight);
                }
                return flights;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            return null;
       }

}
