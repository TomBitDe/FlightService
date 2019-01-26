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
}
