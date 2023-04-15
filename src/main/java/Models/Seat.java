package Models;

public class Seat {
    int aircraft_id;
    String seat_no;

    @Override
    public String toString() {
        return "Seat{" +
                "aircraft_id=" + aircraft_id +
                ", seat_no='" + seat_no + '\'' +
                '}';
    }

    public Seat(int aircraft_id, String seat_no) {
        this.aircraft_id = aircraft_id;
        this.seat_no = seat_no;
    }

    public int getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(int aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }
}
