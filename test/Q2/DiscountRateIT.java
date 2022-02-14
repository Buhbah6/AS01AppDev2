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
public class DiscountRateIT {
    
    public DiscountRateIT() {
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
    
    @Test
    public void testGetServiceDiscountRate() {
        System.out.println("getServiceDiscountRate");
        String type = "Premium";
        double expResult = 0.2;
        double result = DiscountRate.getServiceDiscountRate(type);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getProductDiscountRate method, of class DiscountRate.
     */
    @Test
    public void testGetProductDiscountRate() {
        System.out.println("getProductDiscountRate");
        String type = "Gold";
        double expResult = 0.1;
        double result = DiscountRate.getProductDiscountRate(type);
        assertEquals(expResult, result, 0.0);
    }   
}
