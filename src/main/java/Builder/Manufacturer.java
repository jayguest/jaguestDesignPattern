package main.java.Builder;

import java.util.ArrayList;

/**
 * Defines the class which owns Factory and Dealerships
 */
public class Manufacturer {
    public int sales;
    public String name;
    public ArrayList<Factory> factories;

    public Manufacturer(String name){
        this.name = name;
        this.sales = 0;
        this.factories = new ArrayList<Factory>();
    }

    /**
     * Method to buy a factory
     * @param model is the model the factory will make
     */
    public void buyFactory(Model model){
        this.factories.add(new Factory(this,model));
    }
}
