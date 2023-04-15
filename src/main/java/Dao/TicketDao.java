package Dao;

import Models.Ticket;
import Utils.ConnectionManager;
import com.github.javafaker.shaded.snakeyaml.events.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    private final String CREATE_NEW_TICKET= "INSERT INTO ticket (passport_no, passenger_name,flight_id,seat_no,cost)" +
            "VALUES (?,?,?,?,?)";
    private final String READ_ALL_TICKET = "SELECT * FROM ticket";

    private final String UPDATE_TICKET_BY_ID = "UPDATE ticket SET passport_no=?, passenger_name=?,flight_id=?, " +
            "seat_no=?,cost=? " + "WHERE id=?";

    private final String DELETE_TICKET_BY_ID = "DELETE FROM ticket WHERE id=?";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public void addNewTicket(String passport_no, String passenger_name,
                             int flight_id, String seat_no, double cost) throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_TICKET);
            preparedStatement.setString(1,passport_no);
            preparedStatement.setString(2,passenger_name);
            preparedStatement.setInt(3,flight_id);
            preparedStatement.setString(4,seat_no);
            preparedStatement.setDouble(5,cost);
            preparedStatement.executeUpdate();
        }
    }

    public List<Ticket> readAllTickets () throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<>();
         try (Connection connection = getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_TICKET);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 int id = resultSet.getInt("id");
                 String passport_no = resultSet.getString("passport_no");
                 String passenger_name = resultSet.getString("passenger_name");
                 int flight_id = resultSet.getInt("flight_id");
                 String seat_no = resultSet.getString("seat_no");
                 double cost = resultSet.getDouble("cost");
                 tickets.add(new Ticket(id,passport_no,passenger_name,flight_id,seat_no,cost));
             } tickets.stream().forEach(x-> System.out.println(x.toString()));
             } return tickets;
         }

         public void updateTicketById(int id,String passport_no,String passenger_name,
                                      int flight_id, String seat_no, double cost) throws SQLException {
         try (Connection connection = getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKET_BY_ID);
             preparedStatement.setString(1,passport_no);
             preparedStatement.setString(2,passenger_name);
             preparedStatement.setInt(3,flight_id);
             preparedStatement.setString(4,seat_no);
             preparedStatement.setDouble(5, cost);
             preparedStatement.setInt(6, id);
             preparedStatement.executeUpdate();
         }
    }

    public void deleteFromTicketById(int id) throws SQLException{
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TICKET_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

}


