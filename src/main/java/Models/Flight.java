package Models;


import java.sql.Date;

public class Flight {
    int id;
    String flight_no;
    Date departure_date;
    String departure_airport_code;
    Date arrival_date;
    String arrival_airport_code;
    int aircraft_id;
    String status;

    public Flight(int id, String flight_no, Date departure_date, String departure_airport_code, Date arrival_date, String arrival_airport_code, int aircraft_id, String status) {
        this.id = id;
        this.flight_no = flight_no;
        this.departure_date = departure_date;
        this.departure_airport_code = departure_airport_code;
        this.arrival_date = arrival_date;
        this.arrival_airport_code = arrival_airport_code;
        this.aircraft_id = aircraft_id;
        this.status = status;
    }

    public Flight(String flight_no, Date departure_date, String departure_airport_code, Date arrival_date, String arrival_airport_code, int aircraft_id, String status) {
        this.flight_no = flight_no;
        this.departure_date = departure_date;
        this.departure_airport_code = departure_airport_code;
        this.arrival_date = arrival_date;
        this.arrival_airport_code = arrival_airport_code;
        this.aircraft_id = aircraft_id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flight_no='" + flight_no + '\'' +
                ", departure_date=" + departure_date +
                ", departure_airport_code='" + departure_airport_code + '\'' +
                ", arrival_date=" + arrival_date +
                ", arrival_airport_code='" + arrival_airport_code + '\'' +
                ", aircraft_id=" + aircraft_id +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_airport_code() {
        return departure_airport_code;
    }

    public void setDeparture_airport_code(String departure_airport_code) {
        this.departure_airport_code = departure_airport_code;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getArrival_airport_code() {
        return arrival_airport_code;
    }

    public void setArrival_airport_code(String arrival_airport_code) {
        this.arrival_airport_code = arrival_airport_code;
    }

    public int getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(int aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
