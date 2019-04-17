package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Manufacturer;
import main.java.Model;
import main.java.Mediator.Mediator;

public class MediatorTest {

    public Mediator test;
    
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
        Mediator test = new Mediator();
        assertNotNull(test);
    }
    
    @Test
    public void receiveTest() {
        Mediator test = new Mediator();
        Manufacturer buyer = new Manufacturer("one");
        Manufacturer seller = new Manufacturer("two");
        buyer.intermediary = test;
        test.buyer = buyer;
        test.seller = seller;
        buyer.buy(1,Model.SPORT);
        assertTrue(buyer.stock.size() != 0);
        //seller.buy(2, Model.HYBRID);
        buyer.buy(3, Model.TRUCK);
        
        seller.factories.get(0).build(2);
        buyer.buy(4,seller.factories.get(0).model);
    }

}
