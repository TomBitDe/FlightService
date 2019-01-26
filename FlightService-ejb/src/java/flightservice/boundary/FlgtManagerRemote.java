package flightservice.boundary;

import flightservice.model.Flgt;
import flightservice.model.FlgtPK;
import flightservice.model.PassengerFlgt;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Remote;

/**
 * Remote flight services.
 */
@Remote
public interface FlgtManagerRemote {
    /**
     * Get the content of flgt entity (all flights in DB table).
     *
     * @return a list of all flights
     */
    public List<Flgt> getFlightContent();

    /**
     * Get the content of flgt entity starting at row offset fetching count rows.
     *
     * @param offset the offset to start fetching
     * @param count  the number of rows to fetch
     *
     * @return a list of flights
     */
    public List<Flgt> getFlightContent(int offset, int count);

    /**
     * Get a flight by its Primary Key (flight no. and schedule).
     *
     * @param id the Primary Key (id) of the flight
     *
     * @return the matching flight
     */
    public Flgt getByFlightSchedule(FlgtPK id);

    /**
     * Get the passenger flight arrivals.
     *
     * @param arpo     the airport to arrive to
     * @param startEat the starting estimated arrival timestamp
     * @param count    the maximum number of arrivals to return
     *
     * @return the passanger flight arrival list
     */
    public List<PassengerFlgt> getPaxFlightArrivals(String arpo, Timestamp startEat, int count);

    /**
     * Get the passenger flight departures.
     *
     * @param arpo     the airport to depart from
     * @param startEdt the starting estimated departure timestamp
     * @param count    the maximum number of departures to return
     *
     * @return the passanger flight departures list
     */
    public List<PassengerFlgt> getPaxFlightDepartures(String arpo, Timestamp startEdt, int count);

    /**
     * Get all arrivals PAX, FTR and TRC.
     *
     * @param arpo     the airport to arrive to
     * @param startEat the starting estimated arrival timestamp
     * @param count    the maximum number of arrivals to return
     *
     * @return the arrival flight list
     */
    public List<ArrivalVO> getArrivals(String arpo, Timestamp startEat, int count);

    /**
     * Get all departures PAX, FTR and TRC.
     *
     * @param arpo     the airport to depart from
     * @param startEdt the starting estimated departure timestamp
     * @param count    the maximum number of departures to return
     *
     * @return the departure flight list
     */
    public List<DepartureVO> getDepartures(String arpo, Timestamp startEdt, int count);

    /**
     * Check if a given flight exists by its id.
     *
     * @param id the flights id
     *
     * @return true if the flight exists else false
     */
    boolean exists(final FlgtPK id);

    /**
     * Get the number of flights.
     *
     * @return the number of flights
     */
    long countFlights();
}
