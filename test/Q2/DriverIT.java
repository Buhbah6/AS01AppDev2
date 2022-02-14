package Q2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author there
 */
public class DriverIT {
    
    public DriverIT() {
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
     * Test of calcServiceRebate method, of class Driver.
     */
    @Test
    public void testCalcServiceRebate() {
        System.out.println("calcServiceRebate");
        Visit vis = new Visit(new Customer("Leonard", true, "Premium"), 74.99, 372.9);
        double expResult = 14.998;
        double result = Driver.calcServiceRebate(vis);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcProductRebate method, of class Driver.
     */
    @Test
    public void testCalcProductRebate() {
        System.out.println("calcProductRebate");
        Visit vis = new Visit(new Customer("Leonard", true, "Premium"), 74.99, 372.9);
        double expResult = 37.29;
        double result = Driver.calcProductRebate(vis);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcFinalCost method, of class Driver.
     */
    @Test
    public void testCalcFinalCost() {
        System.out.println("calcFinalCost");
        Visit vis = new Visit(new Customer("Leonard", true, "Premium"), 74.99, 372.9);
        double expResult = 395.602;
        double result = Driver.calcFinalCost(vis);
        assertEquals(expResult, result, 0.0);
    }
    
}
