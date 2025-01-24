package application;

import application.Controller.FlightController;
import io.javalin.Javalin;


public class App 
{
    public static void main( String[] args )
    {
        // Connection conn = ConnectionUtil.getConnection();
        // FlightService service = new FlightService();
        // FlightDAO dao = new FlightDAO();
        // Flight flight = new Flight("Nairobi", "Mombasa");
        // System.out.println(dao.getAllFlights());
        FlightController flightController = new FlightController();
        Javalin app = flightController.startAPI();
        app.start(7070);

    }
}
