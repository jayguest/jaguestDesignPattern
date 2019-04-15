package main.java.Facade;

import main.java.Car;
import main.java.Manufacturer;
import main.java.Model;

import java.util.ArrayList;

/**
 * This class provides a simple interface to the more complex system.
 * Essentially, we want it so that the client needs only provide small
 * amounts of information to the facade interface to get the entirety
 * of the construction, communication, and retrieval of builds handled
 * behind the scenes where the client doesn't see.
 */
public class Facade {
    public Manufacturer owner; // manufacturer the facade interfaces for
    public ArrayList<Car> cart; // keeps track of cars ordered through facade

    public Facade(){
        this.owner = new Manufacturer("Maker");
        cart = new ArrayList<>();
    }

    /**
     * A simple order interface, the user need only ask for how many
     * and what make they want.
     * @param num is how many cars of the specified make wanted
     * @param make is the make of car wanted
     */
    public void Order(int num, Model make) {
        System.out.println("Ordered " + num + " " + make + "(s).");
        if (owner.factories.size() == 0) {
            owner.buyFactory(make);
            owner.factories.get(0).build(num);
            for(int k = 0;k < owner.factories.get(0).stock.length;k++){
                cart.add(owner.factories.get(0).stock[k]); // add the ordered cars to cart
            }
            owner.factories.get(0).resetStock();
        } else {
            for (int i = 0; i < owner.factories.size(); i++) {
                if (owner.factories.get(i).model == make) { // factory for the make exists
                    owner.factories.get(i).build(num);
                    for(int k = 0;k < owner.factories.get(i).stock.length;k++){
                        cart.add(owner.factories.get(i).stock[k]); // add the ordered cars to cart
                    }
                    owner.factories.get(i).resetStock();
                    return; // done once ordered
                }
            }
            // if no factory for the make exists yet:
            owner.buyFactory(make); // make a factory for it
            for (int j = 0; j < owner.factories.size(); j++) {
                if (owner.factories.get(j).model == make) {
                    owner.factories.get(j).build(num);
                    for(int l = 0;l < owner.factories.get(j).stock.length;l++){
                        cart.add(owner.factories.get(j).stock[l]); // add the ordered cars to cart
                    }
                    owner.factories.get(j).resetStock();
                    return; // done once ordered
                }
            }
        }
    }


    public Car[] Checkout(){
        Car[] cars = new Car[cart.size()];
        for(int i = 0;i < cart.size();i++){
            cars[i] = cart.get(i);
        }
        cart.clear(); // empty the cart between orders
        System.out.println("Order complete, checkout:");
        return cars;
    }
}
