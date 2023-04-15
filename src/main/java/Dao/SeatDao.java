package Dao;

import Models.Seat;
import Utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDao {

    private final String CREATE_NEW_SEAT= "INSERT INTO seat (aircraft_id, seat_no)" +
            "VALUES (?,?)";
    private final String READ_ALL_SEAT = "SELECT * FROM seat";

    private final String UPDATE_SEAT_BY_ID = "UPDATE seat SET aircraft_id=?, seat_no=? WHERE  aircraft_id=? AND seat_no=?";

    private final String DELETE_SEAT_BY_ID = "DELETE FROM seat WHERE aircraft_id=? AND seat_no=?";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public void addNewSEAT(int aircraft_id, String seat_no) throws SQLException{
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_SEAT);
            preparedStatement.setInt(1,aircraft_id);
            preparedStatement.setString(2,seat_no);
            preparedStatement.executeUpdate();
        }
    }

    public List<Seat> readAllSeats () throws SQLException {
        ArrayList<Seat> seats = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_SEAT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int aircraft_id = resultSet.getInt("aircraft_id");
                String seat_no = resultSet.getString("seat_no");
                seats.add(new Seat(aircraft_id,seat_no));
            } seats.stream().forEach(x->x.toString());
        }
        return seats;
    }

    public void updateSeatById (int id_art, String id_seat, Seat seat) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEAT_BY_ID);
            preparedStatement.setInt(1,seat.getAircraft_id());
            preparedStatement.setString(2,seat.getSeat_no());
            preparedStatement.setInt(3,id_art);
            preparedStatement.setString(4, id_seat);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteSeatById (int id_art, String id_seat)throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SEAT_BY_ID);
            preparedStatement.setInt(1,id_art);
            preparedStatement.setString(2,id_seat);
            preparedStatement.executeUpdate();
        }
    }

}
