package Q1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 * @author there
 */
public class PasswordGenIT {
    
    public PasswordGenIT() {
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
     * Test of clear method, of class PasswordGen.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        PasswordGen instance = new PasswordGen();
        instance.clear();
        assertEquals(0, instance.fails[0]);
    }

    /**
     * Test of hasNewLine method, of class PasswordGen.
     */
    @Test
    public void testHasNewLine() {
        System.out.println("hasNewLine");
        String word = "test\n";
        PasswordGen instance = new PasswordGen();
        boolean expResult = true;
        boolean result = instance.hasNewLine(word);
        assertEquals(expResult, result);
    }

    /**
     * Test of isSingleCharacter method, of class PasswordGen.
     */
    @Test
    public void testIsSingleCharacter() {
        System.out.println("isSingleCharacter");
        String word = "test";
        PasswordGen instance = new PasswordGen();
        boolean expResult = false;
        boolean result = instance.isSingleCharacter(word);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEqual method, of class PasswordGen.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        String password = "the";
        String word = "The";
        PasswordGen instance = new PasswordGen();
        boolean expResult = false;
        boolean result = instance.isEqual(password, word);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCorrectLength method, of class PasswordGen.
     */
    @Test
    public void testIsCorrectLength() {
        System.out.println("isCorrectLength");
        String tempPass = "Gerardth";
        PasswordGen instance = new PasswordGen();
        boolean expResult = true;
        boolean result = instance.isCorrectLength(tempPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasUpperCase method, of class PasswordGen.
     */
    @Test
    public void testHasUpperCase() {
        System.out.println("hasUpperCase");
        String tempPass = "lemmy";
        PasswordGen instance = new PasswordGen();
        boolean expResult = false;
        boolean result = instance.hasUpperCase(tempPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasLowerCase method, of class PasswordGen.
     */
    @Test
    public void testHasLowerCase() {
        System.out.println("hasLowerCase");
        String tempPass = "LeMMY";
        PasswordGen instance = new PasswordGen();
        boolean expResult = true;
        boolean result = instance.hasLowerCase(tempPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSingleSpecialCase method, of class PasswordGen.
     */
    @Test
    public void testHasSingleSpecialCase() {
        System.out.println("hasSingleSpecialCase");
        String tempPass = "Gerar!d";
        PasswordGen instance = new PasswordGen();
        boolean expResult = true;
        boolean result = instance.hasSingleSpecialCase(tempPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of pipeline method, of class PasswordGen.
     */
    @Test
    public void testPipeline() {
        System.out.println("pipeline");
        String password = "theMounta!nwalk";
        PasswordGen instance = new PasswordGen();
        instance.pipeline(password);
        int expResult = 1;
        int result = instance.generated;
        assertEquals(expResult, result);
    }
    
}
