package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Manufacturer;
import main.java.Model;
import main.java.Builder.Builder;
import main.java.Builder.Reader;

public class BuilderTest {

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
        Manufacturer owner = new Manufacturer("one");
        Builder test = new Builder(owner);
        assertNotNull(test);
        Reader read = new Reader();
        assertNotNull(read);
        owner.buyFactory(Model.SPORT);
        owner.createDealerships();
        assertTrue(owner.dealers.size() != 0);
    }
    
    @Test
    public void testConstructRequest() {
        Reader read = new Reader();
        Manufacturer owner = new Manufacturer("one");
        Builder test = new Builder(owner);
        read.builder = test;
        read.constructRequest(1, Model.SPORT);
        assertTrue(read.runResult.size() != 0);
        read.constructRequest(4, Model.TRUCK);
        assertTrue(read.runResult.size() >= 4);
    }

}
