package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Manufacturer;
import main.java.Model;
import main.java.Command.Order;
import main.java.Command.Receive;

public class CommandTest {

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
    public void constructorTest() {
        int num = 1;
        Manufacturer test = new Manufacturer("one");
        Order order = new Order(num,Model.SPORT,test);
        Receive rec = new Receive();
        assertNotNull(order);
        assertNotNull(rec);
    }
    
    @Test
    public void ExecuteTest() {
        int num = 1;
        Manufacturer test = new Manufacturer("one");
        Order order = new Order(num,Model.SPORT,test);
        Receive rec = new Receive();
        order.Execute();
        Order next = new Order(4,Model.TRUCK,test);
        next.Execute();
    }

}
