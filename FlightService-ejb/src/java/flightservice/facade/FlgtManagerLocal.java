package flightservice.facade;

import flightservice.model.Flgt;
import flightservice.model.FlgtPK;
import flightservice.model.FlgtSgmt;
import java.util.List;
import javax.ejb.Local;

/**
 * Local flight services.
 */
@Local
public interface FlgtManagerLocal {
    /**
     * Get all flights.
     *
     * @return a list of all flights
     */
    public List<Flgt> getFlgts();

    /**
     * Get a flight by its id.
     *
     * @param id the flights id
     *
     * @return the requested flight
     */
    public Flgt getById(final FlgtPK id);

    /**
     * Get the route of a flight by the flights by its id.
     *
     * @param id the flights id
     *
     * @return the requested flight route
     */
    public List<FlgtSgmt> getFlgtRoute(FlgtPK id);

    /**
     * Check if a flight segment is an arrival segment
     *
     * @param sgmt the flight segment
     *
     * @return true if the flight segment is an arrival else false
     */
    public boolean isArrival(FlgtSgmt sgmt);

    /**
     * Check if a flight segment is a departure segment
     *
     * @param sgmt the flight segment
     *
     * @return true if the flight segment is a departure else false
     */
    public boolean isDeparture(FlgtSgmt sgmt);

    /**
     * Check if a flight is a passenger flight
     *
     * @param flgt the flight to check
     *
     * @return true in case of a passenger flight, else false
     */
    public boolean isPaxFlight(Flgt flgt);
}
