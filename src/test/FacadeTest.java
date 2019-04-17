package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Car;
import main.java.Manufacturer;
import main.java.Model;
import main.java.Facade.Facade;

public class FacadeTest {

    public Facade test;
    public Facade test2;
    public Manufacturer owner;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        
    }
    
    @Test
    public void testConstructor() {
        test = new Facade();
        assertNotNull(test);
    }
    
    @Test
    public void OrderTest() {
        test2 = new Facade();
        owner = new Manufacturer("Test");
        test2.owner = owner;
        assertNotNull(owner);
        test2.Order(1, Model.SPORT);
        assertTrue(test2.cart.size() != 0);
    }
    
    @Test
    public void checkoutTest() {
        Facade test = new Facade();
        owner = new Manufacturer("Test");
        test.owner = owner;
        test.Order(1, Model.HYBRID);
        Car[] newCar = test.Checkout();
        assertNotNull(newCar);
        assertTrue(newCar.length != 0);
        
        test.Order(3, Model.SPORT);
        test.Order(3, Model.TRUCK);
    }

}
