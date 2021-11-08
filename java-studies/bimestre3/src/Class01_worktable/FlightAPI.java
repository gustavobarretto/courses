package Class01_worktable;

public class FlightAPI {
    private final String origin;
    private final String destiny;
    private final String departureDate;
    private final String arrivalDate;

    public FlightAPI() {
        this.origin = "Salvador";
        this.destiny = "Londres";
        this.departureDate = "20/10/2021";
        this.arrivalDate = "20/10/2100";
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
