package Models;

public class Ticket {
    int id;
    String passport_no;
    String passenger_name;
    int flight_id;
    String seat_no;
    double cost;

    public Ticket(String passport_no, String passenger_name, int flight_id, String seat_no) {
        this.passport_no = passport_no;
        this.passenger_name = passenger_name;
        this.flight_id = flight_id;
        this.seat_no = seat_no;
    }

    public Ticket(int id, String passport_no, String passenger_name, int flight_id, String seat_no) {
        this.id = id;
        this.passport_no = passport_no;
        this.passenger_name = passenger_name;
        this.flight_id = flight_id;
        this.seat_no = seat_no;


    }

    public Ticket(int id, String passport_no, String passenger_name, int flight_id, String seat_no, double cost) {
        this.id = id;
        this.passport_no = passport_no;
        this.passenger_name = passenger_name;
        this.flight_id = flight_id;
        this.seat_no = seat_no;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", passport_no='" + passport_no + '\'' +
                ", passenger_name='" + passenger_name + '\'' +
                ", flight_id=" + flight_id +
                ", seat_no='" + seat_no + '\'' +
                ", cost=" + cost +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
