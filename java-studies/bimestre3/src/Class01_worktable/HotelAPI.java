package Class01_worktable;

public class HotelAPI {

    private final String checkIn;
    private final String checkOut;
    private final String city;

    public HotelAPI() {
        this.checkIn = "20/10/2021";
        this.checkOut = "20/10/2100";
        this.city = "Londres";
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getCity() {
        return city;
    }
}


