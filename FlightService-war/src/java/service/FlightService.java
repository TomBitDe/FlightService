package service;

import flightservice.boundary.FlgtListVO;
import flightservice.boundary.FlgtManagerRemote;
import flightservice.boundary.FlgtVO;
import flightservice.model.Flgt;
import flightservice.model.FlgtPK;
import com.home.flightservice.boundary.ArrivalVO;
import com.home.flightservice.boundary.DepartureVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * RESTful Flight Service.
 */
@Path("/FlightService")
@Stateless
public class FlightService {
    @EJB
    FlgtManagerRemote flightMangerRemote;

    /**
     * Get a list of all flights.
     *
     * @param offset the position to start fetching
     * @param count  the number of fetches to do
     *
     * @return the flight list based on offset and count
     */
    @PermitAll
    @GET
    @Path("/flights/{offset}/{count}")
    @Produces({MediaType.APPLICATION_XML})
    public Response getAll(@PathParam("offset") String offset, @PathParam("count") String count) {
        int intOffset = Integer.valueOf(offset);
        int intCount = Integer.valueOf(count);

        List<Flgt> flightList = flightMangerRemote.getFlightContent(intOffset, intCount);

        FlgtListVO flightListVO = null;
        Response response;

        if (flightList != null) {
            List<FlgtVO> flights = new ArrayList();
            flightListVO = new FlgtListVO();

            for (Flgt flight : flightList) {
                FlgtVO flgtVO = new FlgtVO(flight.getFlgtPK().getFlgtNo(), flight.getFlgtPK().getSchedFlgtDt(),
                                           flight.getFlgtType(), flight.getAcType(),
                                           flight.getUpdated(), flight.getUpdtuser());
                flights.add(flgtVO);
            }
            flightListVO.setFlightList(flights);
        }

        response = Response.ok().entity(flightListVO).build();

        return response;
    }

    /**
     * Get a flight by its flight number and scheduled date.
     *
     * @param flgtNo    the flight number of the flight
     * @param scheduled the scheduled date of the flight
     *
     * @return the matching flight
     */
    @PermitAll
    @GET
    @Path("/flight/{flight}/{scheduled}")
    @Produces({MediaType.APPLICATION_XML})
    public Response getById(@PathParam("flight") String flgtNo, @PathParam("scheduled") String scheduled) {
        Flgt flight = flightMangerRemote.getByFlightSchedule(new FlgtPK(flgtNo, scheduled));

        FlgtVO flgtVO = null;
        Response response;

        if (flight != null) {
            flgtVO = new FlgtVO(flight.getFlgtPK().getFlgtNo(), flight.getFlgtPK().getSchedFlgtDt(),
                                flight.getFlgtType(), flight.getAcType(),
                                flight.getUpdated(), flight.getUpdtuser());
        }
        response = Response.ok().entity(flgtVO).build();

        return response;
    }

    /**
     * Check if an flight exists by its id (flight number and scheduled date).
     *
     * @param flgtNo    the flight number of the flight
     * @param scheduled the scheduled date of the flight
     *
     * @return true if the flight exists otherwise false
     */
    @PermitAll
    @GET
    @Path("/exists/{flight}/{scheduled}")
    @Produces({MediaType.APPLICATION_XML})
    public Response exists(@PathParam("flight") String flgtNo, @PathParam("scheduled") String scheduled) {
        Flgt flight = flightMangerRemote.getByFlightSchedule(new FlgtPK(flgtNo, scheduled));

        if (flight != null) {
            return Response.ok().entity("true").build();
        }
        return Response.ok().entity("false").build();

    }

    /**
     * Count the flights.
     *
     * @return the number of flights
     */
    @PermitAll
    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_XML})
    public Response count() {
        long val = flightMangerRemote.countFlights();

        Response response;

        response = Response.ok().entity(String.valueOf(val)).build();

        return response;
    }

    /**
     * A list of all passenger arrival flights.
     *
     * @param arpo     the airport to show passenger arrival flights for
     * @param startEat the timestamp to start with
     * @param count    the maximum arrivals to fetch
     *
     * @return the matching passenger arrival flights
     */
    @PermitAll
    @GET
    @Path("/pax_arrivals/{arpo}/{startEat}/{count}")
    @Produces({MediaType.APPLICATION_XML})
    public Response paxArrivals(@PathParam("arpo") String arpo, @PathParam("startEat") String startEat, @PathParam("count") String count) {
        int intCount = Integer.valueOf(count);
        Timestamp tsStartEat = Timestamp.valueOf(startEat);

        // Get the ArrivalVOs from the remote call as a List
        List<ArrivalVO> paxArrivalList = flightMangerRemote.getPaxFlightArrivals(arpo, tsStartEat, intCount);

        GenericEntity<List<ArrivalVO>> entity
                = new GenericEntity<List<ArrivalVO>>(new ArrayList(paxArrivalList)) {
        };

        Response response = Response.ok(entity).build();

        return response;
    }

    /**
     * A list of all passenger departure flights.
     *
     * @param arpo     the airport to show passenger departure flights for
     * @param startEdt the timestamp to start with
     * @param count    the maximum departures to fetch
     *
     * @return the matching passenger departure flights
     */
    @PermitAll
    @GET
    @Path("/pax_departures/{arpo}/{startEdt}/{count}")
    @Produces({MediaType.APPLICATION_XML})
    public Response paxDepartures(@PathParam("arpo") String arpo, @PathParam("startEdt") String startEdt, @PathParam("count") String count) {
        int intCount = Integer.valueOf(count);
        Timestamp tsStartEdt = Timestamp.valueOf(startEdt);

        // Get the DepartureVOs from the remote call as a List
        List<DepartureVO> paxDepartureList = flightMangerRemote.getPaxFlightDepartures(arpo, tsStartEdt, intCount);

        GenericEntity<List<DepartureVO>> entity
                = new GenericEntity<List<DepartureVO>>(new ArrayList(paxDepartureList)) {
        };

        Response response = Response.ok(entity).build();

        return response;
    }

    /**
     * A list of all arrival flights.
     *
     * @param arpo     the airport to show arrival flights for
     * @param startEat the timestamp to start with
     * @param count    the maximum arrivals to fetch
     *
     * @return the matching arrival flights
     */
    @PermitAll
    @GET
    @Path("/arrivals/{arpo}/{startEat}/{count}")
    @Produces({MediaType.APPLICATION_XML})
    public Response arrivals(@PathParam("arpo") String arpo, @PathParam("startEat") String startEat, @PathParam("count") String count) {
        int intCount = Integer.valueOf(count);
        Timestamp tsStartEat = Timestamp.valueOf(startEat);

        // Get the ArrivalVOs from the remote call as a List
        List<ArrivalVO> arrivalList = flightMangerRemote.getArrivals(arpo, tsStartEat, intCount);

        GenericEntity<List<ArrivalVO>> entity
                = new GenericEntity<List<ArrivalVO>>(new ArrayList(arrivalList)) {
        };

        Response response = Response.ok(entity).build();

        return response;
    }

    /**
     * A list of all departure flights.
     *
     * @param arpo     the airport to show departure flights for
     * @param startEdt the timestamp to start with
     * @param count    the maximum departures to fetch
     *
     * @return the matching departure flights
     */
    @PermitAll
    @GET
    @Path("/departures/{arpo}/{startEdt}/{count}")
    @Produces({MediaType.APPLICATION_XML})
    public Response departures(@PathParam("arpo") String arpo, @PathParam("startEdt") String startEdt, @PathParam("count") String count) {
        int intCount = Integer.valueOf(count);
        Timestamp tsStartEdt = Timestamp.valueOf(startEdt);

        // Get the DepartureVOs from the remote call as a List
        List<DepartureVO> departureList = flightMangerRemote.getDepartures(arpo, tsStartEdt, intCount);

        GenericEntity<List<DepartureVO>> entity
                = new GenericEntity<List<DepartureVO>>(new ArrayList(departureList)) {
        };

        Response response = Response.ok(entity).build();

        return response;
    }

    /**
     * Give a list of all supported service operations.
     *
     * @return a list of service operations
     */
    @OPTIONS
    @Produces({MediaType.TEXT_PLAIN})
    public String getSupportedOperations() {
        return "GET, DELETE, PUT, POST";
    }
}
