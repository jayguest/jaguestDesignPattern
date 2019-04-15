package main.java.Command;

import main.java.Manufacturer;
import main.java.Model;

/**
 * Class implementing the command interface. As defined
 * by Command design pattern, this is the object which the 
 * requests are encapsulated as objects.
 * The requests in this situation are car orders.
 * @author Jason Guest
 *
 */
public class Order implements Command{

    public Manufacturer owner;
    public int number; // number of cars
    public Model model; // make of cars
    
    public Order(int number,Model make, Manufacturer owner) {
        this.number = number;
        this.model = make;
        this.owner = owner;
    }
    
    @Override
    public void Execute() {
        owner.processOrder(this);
    }

}
