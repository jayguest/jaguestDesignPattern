package main.java.Command;

import java.util.ArrayList;

import main.java.Car;

/**
 * Another class implementing command, this class
 * will go through the factories which processed an
 * order and return the cars made.
 * @author Jason Guest
 *
 */
public class Receive implements Command{

    public ArrayList<Car> order;
    
    public Receive() {
        this.order = new ArrayList<>();
    }
    
    @Override
    public void Execute() {
        System.out.println("\nCars delivered:");
        for(int i = 0;i < this.order.size();i++) {
            System.out.print(this.order.get(i).model + " ");
        }
    }

}
