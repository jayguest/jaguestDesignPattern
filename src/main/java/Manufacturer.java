package main.java;

import java.util.ArrayList;

import main.java.Command.Order;
import main.java.Command.Receive;

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
    
    public void addDealership(Factory provider) {
        this.dealers.add(new Dealership(provider));
    }
    
    /**
     * Method used for Command Design Pattern to utilize and pass on
     * the Order objects.
     * @param order is the Order object to process
     */
    public void processOrder(Order order) {
        if(this.factories.size() == 0) { // no factories yet
            this.buyFactory(order.model);
            this.addDealership(this.factories.get(0));
            this.factories.get(0).build(order.number);
            Receive process = new Receive();
            for(int i = 0;i < this.factories.get(0).stock.length;i++) {
                process.order.add(this.factories.get(0).stock[i]);
            }
            // pass the order on
            this.dealers.get(0).processReceive(process);
            return;
        }else {
            for(int j = 0;j < this.factories.size();j++) { // find the factory
                if(this.factories.get(j).model == order.model) {
                    this.factories.get(j).build(order.number);
                    Receive process = new Receive();
                    for(int h = 0;h < this.factories.get(j).stock.length;h++) {
                        process.order.add(this.factories.get(j).stock[h]);
                    }
                    // pass the order on
                    for(int d = 0;d < this.dealers.size();d++) {
                        if(this.dealers.get(d).provider == this.factories.get(j)) {
                            this.dealers.get(d).processReceive(process);
                            return;
                        }
                    }
                }
                // if factory not found
                this.buyFactory(order.model);
                this.addDealership(this.factories.get(this.factories.size()-1));
                for(int k = 0;k < this.factories.size();k++) {
                    if(this.factories.get(k).model == order.model) {
                        this.factories.get(k).build(order.number);
                        Receive process = new Receive();
                        for(int l = 0;l < this.factories.get(k).stock.length;l++) {
                            process.order.add(this.factories.get(k).stock[l]);
                        }
                        // pass the order on
                     // pass the order on
                        for(int d = 0;d < this.dealers.size();d++) {
                            if(this.dealers.get(d).provider == this.factories.get(j)) {
                                this.dealers.get(d).processReceive(process);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
