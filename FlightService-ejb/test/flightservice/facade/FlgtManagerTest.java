package flightservice.facade;

import flightservice.model.Flgt;
import flightservice.model.FlgtPK;
import flightservice.model.FlgtSgmt;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for the FlgtManager implementation
 */
public class FlgtManagerTest {

    public FlgtManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isArrival method, of class FlgtManager.
     */
    @Test
    public void testIsArrival() throws Exception {
        System.out.println("isArrival");
        FlgtSgmt sgmt = null;
        FlgtManager instance = new FlgtManager();
        boolean expResult = false;
        boolean result = instance.isArrival(sgmt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDeparture method, of class FlgtManager.
     */
    @Test
    public void testIsDeparture() throws Exception {
        System.out.println("isDeparture");
        FlgtSgmt sgmt = null;
        FlgtManager instance = new FlgtManager();
        boolean expResult = false;
        boolean result = instance.isDeparture(sgmt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPaxFlight method, of class FlgtManager.
     */
    @Test
    public void testIsPaxFlight() throws Exception {
        System.out.println("isPaxFlight");
        Flgt flgt = null;
        FlgtManager instance = new FlgtManager();
        flgt = instance.getById(new FlgtPK("EK 85", "20190109"));
        boolean expResult = true;
        boolean result = instance.isPaxFlight(flgt);
        assertEquals(expResult, result);
    }
}
