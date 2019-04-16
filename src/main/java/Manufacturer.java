package main.java;

import java.util.ArrayList;

import main.java.Mediator.Mediator;

/**
 * Defines the class which owns Factory and Dealerships
 */
public class Manufacturer {
    public int sales;
    public String name;
    public ArrayList<Factory> factories;
    public ArrayList<Dealership> dealers;
    public Mediator intermediary;
    public ArrayList<Car> stock;

    public Manufacturer(String name){
        this.name = name;
        this.sales = 0;
        this.factories = new ArrayList<>();
        this.dealers = new ArrayList<>();
        this.stock = new ArrayList<>();
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
    
    /**
     * Method for Mediator pattern, generates an order to buy
     * from another manufacturer
     * @param number is the number of cars requested
     * @param make is the make of car requested
     */
    public void buy(int number,Model make) {
        Car[] order = intermediary.receive(this,number, make); // place order through mediator
        for(int i = 0;i < order.length;i++) {
            this.stock.add(order[i]);
        }
    }
    
    /**
     * Method used in Mediator pattern, makes requested cars, then
     * will communicate with mediator to return them
     * @param number is the number of cars to make
     * @param make is the model of car
     */
    public Car[] sell(int number, Model make) {
        ArrayList<Car> sold = new ArrayList<>();
        int count = 0;
        for(int i = 0;i < this.stock.size();i++) {
            if(this.stock.get(i).model == make) { // check if they have the stock to sell
                count++; 
            }
        }
        if(count >= number) {
            for(int i = 0;i < this.stock.size();i++) {
                if(this.stock.get(i).model == make) {
                   if(sold.size() <= number) {
                       sold.add(this.stock.get(i)); // add to sold cars
                       this.stock.remove(i); // remove from the stock
                   }
                }
            }
        }else {
            int difference = number - count;
            // need to make the difference
            for(int j = 0;j < this.factories.size();j++) { // have the factory
                if(this.factories.get(j).model == make) {
                    this.factories.get(j).build(difference);
                    for(int k = 0;k < this.factories.get(j).stock.length;k++) {
                        this.stock.add(this.factories.get(j).stock[k]);
                    }
                    
                    // now we sell the cars
                    for(int h = 0;h < this.stock.size();h++) {
                        if(this.stock.get(h).model == make) {
                            if(sold.size() <= number) {
                                sold.add(this.stock.get(h));
                                this.stock.remove(h);
                            }
                        }
                    }
                }
            }
            this.buyFactory(make);
            for(int j = 0;j < this.factories.size();j++) {
                if(this.factories.get(j).model == make) {
                    this.factories.get(j).build(difference);
                    for(int k = 0;k < this.factories.get(j).stock.length;k++) {
                        this.stock.add(this.factories.get(j).stock[k]);
                    }
                    
                    // now we sell the cars
                    for(int h = 0;h < this.stock.size();h++) {
                        if(this.stock.get(h).model == make) {
                            if(sold.size() <= number) {
                                sold.add(this.stock.get(h));
                                this.stock.remove(h);
                            }
                        }
                    }
                }
            }
        }
        Car[] selling = new Car[sold.size()];
        for(int i = 0;i < selling.length;i++) {
            selling[i] = sold.get(i);
        }
        return selling;
    }
}
