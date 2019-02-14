package flightservice.facade;

import flightservice.model.Flgt;
import flightservice.model.FlgtPK;
import flightservice.model.FlgtSgmt;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for the FlgtManager implementation
 */
public class FlgtManagerTest {
    private static final Logger LOG = Logger.getLogger(FlgtManagerTest.class.getName());
    private static EJBContainer ejbContainer;
    private static Context ctx;
    private static final String LOCAL_JNDI_NAME = "java:global/classes/FlgtManager!flightservice.facade.FlgtManagerLocal";

    public FlgtManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ejbContainer = EJBContainer.createEJBContainer();
        LOG.info("Starting the container");
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDownClass() {
        ejbContainer.close();
        LOG.info("Closing the container");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isArrival method, of class FlgtManager. The FlgtRoute is ordered by seqNo.
     *
     * @throws java.lang.Exception on any exception
     */
    @Test
    public void testIsArrival() throws Exception {
        LOG.info("isArrival");
        FlgtManagerLocal flgtManager = (FlgtManagerLocal) ctx.lookup(LOCAL_JNDI_NAME);
        FlgtSgmt sgmt;
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 85", "20190109")).get(1);
        assertEquals(true, flgtManager.isArrival(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 9994", "20190109")).get(1);
        assertEquals(true, flgtManager.isArrival(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("SN 467", "20190109")).get(1);
        assertEquals(true, flgtManager.isArrival(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("SN 467", "20190109")).get(2);
        assertEquals(true, flgtManager.isArrival(sgmt));

        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 85", "20190109")).get(0);
        assertEquals(false, flgtManager.isArrival(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 9994", "20190109")).get(0);
        assertEquals(false, flgtManager.isArrival(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("SN 467", "20190109")).get(0);
        assertEquals(false, flgtManager.isArrival(sgmt));
    }

    /**
     * Test of isDeparture method, of class FlgtManager. The FlgtRoute is ordered by seqNo.
     *
     * @throws java.lang.Exception on any exception
     */
    @Test
    public void testIsDeparture() throws Exception {
        LOG.info("isDeparture");
        FlgtManagerLocal flgtManager = (FlgtManagerLocal) ctx.lookup(LOCAL_JNDI_NAME);
        FlgtSgmt sgmt;
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 85", "20190109")).get(0);
        assertEquals(true, flgtManager.isDeparture(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 9994", "20190109")).get(0);
        assertEquals(true, flgtManager.isDeparture(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("SN 467", "20190109")).get(0);
        assertEquals(true, flgtManager.isDeparture(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("SN 467", "20190109")).get(1);
        assertEquals(true, flgtManager.isDeparture(sgmt));

        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 85", "20190109")).get(1);
        assertEquals(false, flgtManager.isDeparture(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 9994", "20190109")).get(1);
        assertEquals(false, flgtManager.isDeparture(sgmt));
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("SN 467", "20190109")).get(2);
        assertEquals(false, flgtManager.isDeparture(sgmt));
    }

    /**
     * Test of isPaxFlight method, of class FlgtManager.
     *
     * @throws java.lang.Exception on any exception
     */
    @Test
    public void testIsPaxFlight() throws Exception {
        LOG.info("isPaxFlight");
        FlgtManagerLocal flgtManager = (FlgtManagerLocal) ctx.lookup(LOCAL_JNDI_NAME);
        Flgt flgt;
        flgt = flgtManager.getById(new FlgtPK("EK 85", "20190109"));
        assertEquals(true, flgtManager.isPaxFlight(flgt));
        flgt = flgtManager.getById(new FlgtPK("SN 467", "20190109"));
        assertEquals(true, flgtManager.isPaxFlight(flgt));

        flgt = flgtManager.getById(new FlgtPK("EK 9994", "20190109"));
        assertEquals(false, flgtManager.isPaxFlight(flgt));
    }

    @Test
    public void testGetOriginForArrival() throws Exception {
        LOG.info("getOriginForArrival");
        FlgtManagerLocal flgtManager = (FlgtManagerLocal) ctx.lookup(LOCAL_JNDI_NAME);
        FlgtSgmt sgmt;
        sgmt = flgtManager.getFlgtRoute(new FlgtPK("EK 85", "20190109")).get(1);
        assertEquals("DXB", flgtManager.getOriginForArrival(sgmt));
    }
}
