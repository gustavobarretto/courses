package Class01_worktable;

public class Booking implements IBooking {

    private final FlightAPI flight;
    private final HotelAPI hotel;

    public Booking() {
        this.flight = new FlightAPI();
        this.hotel = new HotelAPI();
    }

    @Override
    public void searchTicketAndHotel(String departureDate, String arrivalDate, String city) {
        if(flight.getDepartureDate().equals(departureDate) &&
           hotel.getCheckIn().equals(departureDate) &&
           flight.getArrivalDate().equals(arrivalDate) &&
           hotel.getCheckOut().equals(arrivalDate) &&
           flight.getDestiny().equals(city) &&
           hotel.getCity().equals(city)) {
            System.out.println("A sua busca encontrou uma viagem!" +
                    " Você poderá partir no dia " + flight.getDepartureDate() +
                    " e retornar no dia " + flight.getArrivalDate() +
                    " da cidade de " + flight.getDestiny() + ".");
        } else {
            System.out.println("Não foi encontrada nenhuma viagem com esses dados.");
        }

    }
}
