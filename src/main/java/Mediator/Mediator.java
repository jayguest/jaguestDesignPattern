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
    
    public Car[] receive(Manufacturer buyer,int num,Model make) {
        if(buyer.equals(this.seller)) { // ensure we don't get someone buying from themselves
            Manufacturer temp = this.buyer;
            this.buyer = buyer;
            this.seller = temp;
        }
        
        Car[] order;
        order = seller.sell(num, make); // call the seller to make the cars requested
        // swap positions
        Manufacturer temp = buyer;
        this.buyer = seller;
        this.seller = temp;
        return order;
    }

}
