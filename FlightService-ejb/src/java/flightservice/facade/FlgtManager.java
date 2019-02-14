package flightservice.facade;

import com.home.flightservice.boundary.ArrivalVO;
import com.home.flightservice.boundary.DepartureVO;
import flightservice.boundary.FlgtManagerRemote;
import flightservice.model.Flgt;
import flightservice.model.FlgtPK;
import flightservice.model.FlgtSgmt;
import flightservice.model.FlgtSgmtSchedule;
import flightservice.model.FlgtStatus;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementation of flight master data operations.
 */
@Stateless
public class FlgtManager implements FlgtManagerLocal, FlgtManagerRemote {
    private static final Logger LOG = Logger.getLogger(FlgtManager.class.getName());

    @Resource
    SessionContext ctx;

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Flgt> getFlgts() {
        LOG.finer("Get all flights");
        List<Flgt> flgtList = em.createQuery("select f FROM FLGT f").getResultList();
        LOG.log(Level.FINER, "Return [{0}] flight(s)", flgtList.size());

        return flgtList;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Flgt getById(FlgtPK id) {
        if (id == null || id.getFlgtNo().isEmpty() || id.getSchedFlgtDt().isEmpty()) {
            throw new IllegalArgumentException("id is invalid");
        }
        LOG.log(Level.FINER, "Search for {0}", id.toString());

        Flgt flgt = em.find(Flgt.class, id);

        if (flgt != null) {
            LOG.log(Level.FINER, "Return {0}", flgt.toString());
        }
        else {
            LOG.log(Level.FINER, "Return [null]");
        }

        return flgt;
    }

    @Override
    public boolean exists(FlgtPK id) {
        if (id == null || id.getFlgtNo().isEmpty() || id.getSchedFlgtDt().isEmpty()) {
            throw new IllegalArgumentException("id is invalid");
        }
        LOG.log(Level.FINER, "Search for {0}", id.toString());

        if (em.find(Flgt.class, id) != null) {
            LOG.log(Level.FINER, "Return [true]");
            return true;
        }
        else {
            LOG.log(Level.FINER, "Return [false]");
            return false;
        }
    }

    @Override
    public long countFlights() {
        Query query;

        query = em.createQuery("SELECT count(f) FROM FLGT f");
        long count = (long) query.getSingleResult();
        LOG.log(Level.FINER, "Return [{0}]", count);

        return count;
    }

    @Override
    public List<FlgtSgmt> getFlgtRoute(FlgtPK id) {
        List<FlgtSgmt> route = new ArrayList<>();

        LOG.log(Level.FINER, "Search for {0}", id.toString());
        if (exists(id)) {
            route = em.createQuery("select r FROM FLGTSGMT r WHERE r.flgtSgmtPK.flgtPK = :id ORDER BY r.seqNo")
                    .setParameter("id", id)
                    .getResultList();
        }
        LOG.log(Level.FINER, "Return [{0}] route(s)", route.size());

        return route;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Flgt> getFlightContent() {
        List<Flgt> flgtList = getFlgts();

        return flgtList;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Flgt> getFlightContent(int offset, int count) {
        if (offset < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (count < 1) {
            throw new IllegalArgumentException("count < 1");
        }

        LOG.log(Level.FINER, "Offset=[{0}] count=[{1}]", new Object[]{offset, count});

        Query query = em.createQuery("select f FROM FLGT f ORDER BY f.flgtPK.schedFlgtDt");
        query.setFirstResult(offset);
        query.setMaxResults(count);

        List<Flgt> flgtList = query.getResultList();
        LOG.log(Level.FINER, "Return [{0}] flight(s)", flgtList.size());

        return flgtList;
    }

    @Override
    public Flgt getByFlightSchedule(FlgtPK id) {
        Flgt flgt = getById(id);

        return flgt;
    }

    @Override
    public List<ArrivalVO> getPaxFlightArrivals(String arpo, Timestamp startEat, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count < 1");
        }

        LOG.log(Level.FINER, "Search max [{0}] PAX ARRIVALS for [{1}] [{2}]", new Object[]{count, arpo, startEat});

        Query query = em.createQuery("select s FROM FLGTSGMTSCHEDULE s WHERE s.flgtSgmtPK.arpo = :arpo and s.eat >= :startEat ORDER BY s.eat");
        query.setParameter("arpo", arpo).setParameter("startEat", startEat);
        query.setMaxResults(count);
        List<FlgtSgmtSchedule> sgmtScheduleList = query.getResultList();

        LOG.log(Level.FINER, "Found [{0}] sgmt schedule(s)", sgmtScheduleList.size());

        List<ArrivalVO> arrivalList = new ArrayList<>();
        for (FlgtSgmtSchedule sgmtSchedule : sgmtScheduleList) {
            if (isArrival(sgmtSchedule.getFlgtSgmt()) && isPaxFlight(sgmtSchedule.getFlgtSgmt().getFlgt())) {
                ArrivalVO arrival = buildArrivalVO(sgmtSchedule);

                arrivalList.add(arrival);
                LOG.finer(arrival.toString());
            }
        }

        return arrivalList;
    }

    @Override
    public List<DepartureVO> getPaxFlightDepartures(String arpo, Timestamp startEdt, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count < 1");
        }

        LOG.log(Level.FINER, "Search max [{0}] PAX DEPARTURES for [{1}] [{2}]", new Object[]{count, arpo, startEdt});

        Query query = em.createQuery("select s FROM FLGTSGMTSCHEDULE s WHERE s.flgtSgmtPK.arpo = :arpo and s.eat >= :startEdt ORDER BY s.eat");
        query.setParameter("arpo", arpo).setParameter("startEdt", startEdt);
        query.setMaxResults(count);
        List<FlgtSgmtSchedule> sgmtScheduleList = query.getResultList();

        LOG.log(Level.FINER, "Found [{0}] sgmt schedule(s)", sgmtScheduleList.size());

        List<DepartureVO> departureList = new ArrayList<>();
        for (FlgtSgmtSchedule sgmtSchedule : sgmtScheduleList) {
            if (isDeparture(sgmtSchedule.getFlgtSgmt()) && isPaxFlight(sgmtSchedule.getFlgtSgmt().getFlgt())) {
                DepartureVO departure = buildDepartureVO(sgmtSchedule);

                departureList.add(departure);
                LOG.finer(departure.toString());
            }
        }

        return departureList;
    }

    @Override
    public List<ArrivalVO> getArrivals(String arpo, Timestamp startEat, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count < 1");
        }

        LOG.log(Level.FINER, "Search max [{0}] ARRIVALS for [{1}] [{2}]", new Object[]{count, arpo, startEat});

        Query query = em.createQuery("select s FROM FLGTSGMTSCHEDULE s WHERE s.flgtSgmtPK.arpo = :arpo and s.eat >= :startEat ORDER BY s.eat");
        query.setParameter("arpo", arpo).setParameter("startEat", startEat);
        query.setMaxResults(count);
        List<FlgtSgmtSchedule> sgmtScheduleList = query.getResultList();

        LOG.log(Level.FINER, "Found [{0}] sgmt schedule(s)", sgmtScheduleList.size());

        List<ArrivalVO> arrivalList = new ArrayList<>();
        for (FlgtSgmtSchedule sgmtSchedule : sgmtScheduleList) {
            if (isArrival(sgmtSchedule.getFlgtSgmt())) {
                ArrivalVO arrival = buildArrivalVO(sgmtSchedule);

                arrivalList.add(arrival);
                LOG.finer(arrival.toString());
            }
        }

        return arrivalList;
    }

    @Override
    public List<DepartureVO> getDepartures(String arpo, Timestamp startEdt, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count < 1");
        }

        LOG.log(Level.FINER, "Search max [{0}] DEPARTURES for [{1}] [{2}]", new Object[]{count, arpo, startEdt});

        Query query = em.createQuery("select s FROM FLGTSGMTSCHEDULE s WHERE s.flgtSgmtPK.arpo = :arpo and s.eat >= :startEdt ORDER BY s.eat");
        query.setParameter("arpo", arpo).setParameter("startEdt", startEdt);
        query.setMaxResults(count);
        List<FlgtSgmtSchedule> sgmtScheduleList = query.getResultList();

        LOG.log(Level.FINER, "Found [{0}] sgmt schedule(s)", sgmtScheduleList.size());

        List<DepartureVO> departureList = new ArrayList<>();
        for (FlgtSgmtSchedule sgmtSchedule : sgmtScheduleList) {
            if (isDeparture(sgmtSchedule.getFlgtSgmt())) {
                DepartureVO departure = buildDepartureVO(sgmtSchedule);

                departureList.add(departure);
                LOG.finer(departure.toString());
            }
        }

        return departureList;
    }

    @Override
    public boolean isArrival(FlgtSgmt sgmt) {
        if (sgmt == null) {
            throw new IllegalArgumentException("sgmt == null");
        }

        boolean ret = true;

        LOG.log(Level.FINER, "Find sgmt for flgt {0} with seqNo < {1}", new Object[]{sgmt.getFlgtSgmtPK().getFlgtPK().toString(), sgmt.getSeqNo()});

        // Fetch the segments for this flight with a lesser seqNo
        Query query = em.createQuery("select s.seqNo FROM FLGTSGMT s WHERE s.flgtSgmtPK.flgtPK = :flgtPK and s.seqNo < :seqNo");
        query.setParameter("flgtPK", sgmt.getFlgtSgmtPK().getFlgtPK()).setParameter("seqNo", sgmt.getSeqNo());
        // Check the fetched list
        if (query.getResultList().isEmpty()) {
            // The list is empty, no segment with a lesser seqNo --> there is no lesser segment in the route, this sgmt is a departure
            ret = false;
        }

        return ret;
    }

    @Override
    public boolean isDeparture(FlgtSgmt sgmt) {
        if (sgmt == null) {
            throw new IllegalArgumentException("sgmt == null");
        }

        boolean ret = true;

        LOG.log(Level.FINER, "Find sgmt for flgt {0} with seqNo > {1}", new Object[]{sgmt.getFlgtSgmtPK().getFlgtPK().toString(), sgmt.getSeqNo()});

        // Fetch the segments for this flight with a greater seqNo
        Query query = em.createQuery("select s.seqNo FROM FLGTSGMT s WHERE s.flgtSgmtPK.flgtPK = :flgtPK and s.seqNo > :seqNo");
        query.setParameter("flgtPK", sgmt.getFlgtSgmtPK().getFlgtPK()).setParameter("seqNo", sgmt.getSeqNo());
        // Check the fetched list
        if (query.getResultList().isEmpty()) {
            // The list is empty, no segment with a greater seqNo --> there is no greater segment in the route, this sgmt is an arrival
            ret = false;
        }

        return ret;
    }

    @Override
    public boolean isPaxFlight(Flgt flgt) {
        if (flgt == null) {
            throw new IllegalArgumentException("flgt == null");

        }
        if (flgt.getFlgtType() == null) {
            throw new IllegalArgumentException("flgtType == null");

        }
        return flgt.getFlgtType().equals("PAX");
    }

    /**
     * Build the ArrivalVO
     *
     * @param sgmtSchedule the base value to build the ArrivalVO from
     *
     * @return the ArrivalVO
     */
    private ArrivalVO buildArrivalVO(FlgtSgmtSchedule sgmtSchedule) {
        ArrivalVO arrival = new ArrivalVO();

        arrival.setFlgtNo(sgmtSchedule.getFlgtSgmtPK().getFlgtPK().getFlgtNo());
        arrival.setArpo(sgmtSchedule.getFlgtSgmtPK().getArpo());
        arrival.setSchedFlgtDt(convert2String(sgmtSchedule.getSat(), "HH:mm:ss"));

        if (sgmtSchedule.getFlgtSgmt().getFlgtStatus() == FlgtStatus.Arrived) {
            // Set the touchdown time
            arrival.setExpected(convert2String(sgmtSchedule.getTdt(), "HH:mm:ss"));
        }
        else {
            // Set the estimated arrival time
            arrival.setExpected(convert2String(sgmtSchedule.getEat(), "HH:mm:ss"));
        }

        arrival.setComments(buildComments(sgmtSchedule));
        arrival.setUpdated(convert2String(new Timestamp(System.currentTimeMillis()), "yyyyMMddHHmmssS"));

        arrival.setOriginArpo(getOriginForArrival(sgmtSchedule.getFlgtSgmt()));
        arrival.setPaxExit(sgmtSchedule.getFlgtSgmt().getPaxExit());

        return arrival;
    }

    /**
     * Build the DepartureVO
     *
     * @param sgmtSchedule the base value to build the DepartureVO from
     *
     * @return the DepartureVO
     */
    private DepartureVO buildDepartureVO(FlgtSgmtSchedule sgmtSchedule) {
        DepartureVO departure = new DepartureVO();

        departure.setFlgtNo(sgmtSchedule.getFlgtSgmtPK().getFlgtPK().getFlgtNo());
        departure.setArpo(sgmtSchedule.getFlgtSgmtPK().getArpo());
        departure.setSchedFlgtDt(convert2String(sgmtSchedule.getSat(), "HH:mm:ss"));
        departure.setExpected(convert2String(sgmtSchedule.getEdt(), "HH:mm:ss"));
        departure.setComments(buildComments(sgmtSchedule));
        departure.setUpdated(convert2String(new Timestamp(System.currentTimeMillis()), "yyyyMMddHHmmssS"));

        departure.setGate(sgmtSchedule.getFlgtSgmt().getGate());

        departure.setCheckinCounter(sgmtSchedule.getFlgtSgmt().getCheckinCounter());

        return departure;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String getOriginForArrival(FlgtSgmt sgmt) {
        if (sgmt == null) {
            throw new IllegalArgumentException("sgmt == null");
        }

        LOG.log(Level.FINER, "Find sgmt for flgt {0} with seqNo < {1}", new Object[]{sgmt.getFlgtSgmtPK().getFlgtPK().toString(), sgmt.getSeqNo()});

        String ret = "Unknown";

        // Fetch the segments for this flight with a lesser seqNo
        Query query = em.createQuery("select s.flgtSgmtPK.arpo FROM FLGTSGMT s WHERE s.flgtSgmtPK.flgtPK = :flgtPK and s.seqNo < :seqNo ORDER BY s.seqNo DESC");
        query.setParameter("flgtPK", sgmt.getFlgtSgmtPK().getFlgtPK()).setParameter("seqNo", sgmt.getSeqNo());
        // Check the fetched list
        List<String> originList = query.getResultList();
        for (String origin : originList) {
            ret = origin;
            break;
        }

        return ret;
    }

    /**
     * Build the commments for arrivals and departures
     *
     * @param sgmtSchedule the base value to build the comments from
     *
     * @return the comments
     */
    private String buildComments(FlgtSgmtSchedule sgmtSchedule) {
        String ret = sgmtSchedule.getFlgtSgmt().getFlgtStatus().toString();

        return ret;
    }

    /**
     * Convert a Timestamp to a String using the given format.
     *
     * @param ts  the timestamp
     * @param fmt the format to use for conversion
     *
     * @return the resulting string
     */
    private String convert2String(Timestamp ts, String fmt) {
        Date date = new Date();
        date.setTime(ts.getTime());
        String formattedDate = new SimpleDateFormat(fmt).format(date);

        return formattedDate;
    }
}
