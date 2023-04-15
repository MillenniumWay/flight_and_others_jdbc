package Dao;
import Models.Airport;
import Models.Flight;
import Utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDao {
    private final String CREATE_NEW_FLIGHT= "INSERT INTO flight (id,flight_no,departure_date," +
            "departure_airport_code,arrival_date,arrival_airport_code,aircraft_id,status)" +
            "VALUES (?,?,?,?,?,?,?,?)";
    private final String READ_ALL_FLIGHT = "SELECT * FROM flight";

    private final String UPDATE_FLIGHT_BY_ID = "UPDATE flight SET id=?, flight_no=?, departure_date=?," +
            "departure_airport_code=?,arrival_date=?,arrival_airport_code=?,aircraft_id=?," +
            "status=? WHERE id=?";

    private final String DELETE_FLIGHT_BY_ID = "DELETE FROM flight WHERE id=?";


    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public void addNewFlight ( int id, String flight_no,  Date departure_date,  String departure_airport_code,
    Date arrival_date, String arrival_airport_code, int aircraft_id, String status) throws SQLException, IllegalArgumentException {
         try (Connection connection = getConnection()) {
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_FLIGHT);
             preparedStatement.setInt(1, id);
             preparedStatement.setString(2, flight_no);
             preparedStatement.setDate(3, departure_date);
             preparedStatement.setString(4, departure_airport_code);
             preparedStatement.setDate(5, arrival_date);
             preparedStatement.setString(6, arrival_airport_code);
             preparedStatement.setInt(7, aircraft_id);
             preparedStatement.setString(8, status);
             preparedStatement.executeUpdate();
         }   catch (Exception e) {
                 throw e;
             }
    }

    public List<Flight> readAllFromFlight() throws SQLException {
        ArrayList <Flight> flights = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(READ_ALL_FLIGHT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String flight_no = resultSet.getString("flight_no");
                Date departure_date = resultSet.getDate("departure_date");
                String departure_airport_code = resultSet.getString("departure_airport_code");
                Date arrival_date = resultSet.getDate("arrival_date");
                String arrival_airport_code = resultSet.getString("arrival_airport_code");
                int aircraft_id = resultSet.getInt("aircraft_id");
                String status = resultSet.getString("status");
                flights.add(new Flight(id,flight_no,departure_date,departure_airport_code,arrival_date,
                        arrival_airport_code,aircraft_id,status));
            } flights.stream().forEach(x->x.toString());
        } return flights;
    }

    public void updateFlightsEntity (int id, Flight flight)
            throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FLIGHT_BY_ID);
            preparedStatement.setInt(1,flight.getId());
            preparedStatement.setString(2,flight.getFlight_no());
            preparedStatement.setDate(3,flight.getDeparture_date());
            preparedStatement.setString(4,flight.getDeparture_airport_code());
            preparedStatement.setDate(5,flight.getArrival_date());
            preparedStatement.setString(6,flight.getArrival_airport_code());
            preparedStatement.setInt(7,flight.getAircraft_id());
            preparedStatement.setString(8,flight.getStatus());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
        }

    }

    public void deleteFromFlightById(int id) throws SQLException{
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FLIGHT_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

}
