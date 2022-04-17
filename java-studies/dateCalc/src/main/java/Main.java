import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      Reservation reservation1 =
              new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));
        Reservation reservation2 =
                new Reservation(LocalDate.of(2022, 03, 10), LocalDate.of(2022, 03, 15));
        Reservation reservation3 =
                new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));
        Reservation reservation4 =
                new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));
        Reservation reservation5 =
                new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));
        Reservation reservation6 =
                new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));
        Reservation reservation7 =
                new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));
        Reservation reservation8 =
                new Reservation(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05));

        List<Reservation> reservationList = List.of(reservation1, reservation2);

        Reservation newReservation = new Reservation(LocalDate.of(2022, 3, 6), LocalDate.of(2022, 3, 9));

        reservationList.stream().filter(reservation -> {
            return checkingData(newReservation, reservation);
        });

    }

    public static Boolean checkingData(Reservation r, Reservation rAlreadyInUse) {
        if(r.getCheckIn().isAfter(rAlreadyInUse.getCheckIn()) && r.getCheckIn().isBefore(rAlreadyInUse.getCheckOut())) {
            return true;
        } else if(r.getCheckOut().isAfter(rAlreadyInUse.getCheckIn()) && r.getCheckOut().isBefore(rAlreadyInUse.getCheckOut())) {
            return true;
        }
        return false;
    }
}
