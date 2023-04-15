import Dao.*;
import Models.Aircraft;
import Models.Airport;
import Models.Flight;
import Models.Seat;
import Utils.ConnectionManager;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        AircraftDao aircraftDao = new AircraftDao();
        AirportDao airportDao = new AirportDao();
        FlightDao flightDao = new FlightDao();
        SeatDao seatDao = new SeatDao();
        TicketDao ticketDao = new TicketDao();
    }
}
