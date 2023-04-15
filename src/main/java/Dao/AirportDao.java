package Dao;

import Models.Airport;
import Utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {

    private final String CREATE_NEW_AIRPORT= "INSERT INTO airport (code,country,city)" +
            "VALUES (?,?,?)";
    private final String READ_ALL_AIRPORT = "SELECT * FROM airport";

    private final String UPDATE_AIRPORT_BY_CODE = "UPDATE airport SET code=?, country=?, city=? WHERE code=?";

    private final String DELETE_AIRPORT_BY_CODE = "DELETE FROM airport WHERE code=?";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public void addNewAirport (String code, String country,String city) throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_AIRPORT);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, country);
            preparedStatement.setString(3,city);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Airport> readAllAirports()throws SQLException {
        ArrayList<Airport> airports = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_AIRPORT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                airports.add(new Airport(code,country,city));
            }
            airports.stream().forEach(x->x.toString());
        }
        return airports;
    }

    public void updateAirportEntityByCode (String code, Airport airport) throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AIRPORT_BY_CODE);
            preparedStatement.setString(1, airport.getCode());
            preparedStatement.setString(2, airport.getCountry());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.setString(4,code);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteAirportByCode (String code) throws SQLException{
        try (Connection connection =getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AIRPORT_BY_CODE);
            preparedStatement.setString(1,code);
            preparedStatement.executeUpdate();
        }
    }

}
