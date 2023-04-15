package Dao;
import Models.Aircraft;
import Utils.ConnectionManager;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDao {

    private final String CREATE_NEW_AIRCRAFT= "INSERT INTO aircraft (model)" +
            "VALUES (?)";
    private final String READ_ALL_AIRCRAFT = "SELECT * FROM aircraft";

    private final String UPDATE_AIRCRAFT_BY_ID = "UPDATE aircraft SET id=?, model=? WHERE id=?";

    private final String DELETE_AIRCRAFT_BY_ID = "DELETE FROM aircraft WHERE id=?";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public void addNewAircraft (String model) throws SQLException  {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_AIRCRAFT);
            preparedStatement.setString(1, model);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aircraft> readAllAircraftList() throws SQLException {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_AIRCRAFT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              int id = resultSet.getInt("id");
              String model = resultSet.getString("model");
              aircrafts.add(new Aircraft(id,model));
            }
            aircrafts.stream().forEach(x->x.toString());
        }
        return aircrafts;
    }

    public void updateAircraftEntity (int id, Aircraft aircraft) throws SQLException, PSQLException {
        try (Connection  connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AIRCRAFT_BY_ID);
            preparedStatement.setInt(1, aircraft.getId());
            preparedStatement.setString(2, aircraft.getModel());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteAircraftById (int id) throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AIRCRAFT_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }


}
