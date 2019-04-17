package main.java.Mediator;

import main.java.Car;
import main.java.Manufacturer;
import main.java.Model;

/**
 * No more explicit calling between objects, use this class to have
 * class communication.
 * @author Jason Guest
 *
 */
public class Mediator {
    
    public Manufacturer buyer;
    public Manufacturer seller;
    
    /**.
     * Method to ask for cars, build them, and then send them back to the asker
     * @param buyer is the asker
     * @param num is the number of cars
     * @param make is the model
     * @return the cars
     */
    public Car[] receive(Manufacturer buyer,int num,Model make) {
        
        Car[] order;
        order = seller.sell(num, make); // call the seller to make the cars requested
        // swap positions
        Manufacturer temp = buyer;
        this.buyer = seller;
        this.seller = temp;
        return order;
    }

}
