package main.java.Command;

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

    private int number; // number of cars
    private Model model; // make of cars
    
    @Override
    public void Execute() {
        
    }

}
