package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Facade.Facade;

public class FacadeTest {

    @Test
    public void testConstructor() {
        Facade test = new Facade();
        assertNotNull(test);
        
    }

}
