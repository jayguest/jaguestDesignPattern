package main.java.Builder;

import java.util.ArrayList;

/**
 * Defines the class which owns Factory and Dealerships
 */
public class Manufacturer {
    public int sales;
    public String name;
    public ArrayList<Factory> factories;
    public ArrayList<Dealership> dealers;

    public Manufacturer(String name){
        this.name = name;
        this.sales = 0;
        this.factories = new ArrayList<>();
        this.dealers = new ArrayList<>();
    }

    /**
     * Method to buy a factory
     * @param model is the model the factory will make
     */
    public void buyFactory(Model model){
        this.factories.add(new Factory(this,model));
    }

    /**
     * Method to make dealerships once a dealer has factories
     */
    public void createDealerships(){
        for(int i = 0;i < this.factories.size();i++){
            this.dealers.add(new Dealership(this.factories.get(i)));
        }
    }
}
