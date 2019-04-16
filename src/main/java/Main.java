package main.java;

import main.java.Builder.Builder;
import main.java.Builder.Reader;
import main.java.Facade.Facade;
import main.java.Mediator.Mediator;

/**
 * main.java.Main class
 */
public class Main {

    public static void main(String[] args){
        System.out.println("Jason Guest");
        System.out.println("Design Pattern Project");
        System.out.println();

        // Test vectors
        Car[] test = {new Sport(),new Truck(),new Sport(),new Hybrid(),new Sport(),new Truck(), new Hybrid(),new Hybrid()};
        System.out.println("The test vector being used: ");
        for(int t = 0;t < test.length;t++){
            System.out.print(test[t].model + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Pattern: Builder");
        // builder pattern setup
        Reader reader = new Reader();
        Manufacturer buildMan = new Manufacturer("build");
        Builder builder = new Builder(buildMan);
        reader.builder = builder;
        // run it
        for(int i = 0;i < test.length;i++){
            reader.constructRequest(1,test[i].model);
        }
        System.out.println("Builder results: (will return what the factories made)");
        for(int j = 0;j < reader.runResult.size();j++){
            System.out.print(reader.runResult.get(j).model + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Pattern: Facade");
        // Wanted interface: Order(), Checkout(), that's all the user wants to have to do
        // simple way to order car(s) and then request them to be sent to client
        // without the confusion of going through dealer->factory->manufacturer

        Facade salesman = new Facade();

        salesman.Order(2,Model.HYBRID);
        salesman.Order(4,Model.TRUCK);
        Car[] order1 = salesman.Checkout();
        for(int o = 0;o < order1.length;o++){
            System.out.print(order1[o].model + " ");
        }
        System.out.println();

        System.out.println();
        salesman.Order(3,Model.SPORT);
        salesman.Order(5,Model.HYBRID);
        Car[] order2 = salesman.Checkout();
        for(int p = 0;p < order2.length;p++){
            System.out.print(order2[p].model + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Pattern: Command");
        ArrayList<Order> orders = new ArrayList<>();
        Manufacturer tesla = new Manufacturer("Tesla");
        
        // orders queued up
        orders.add(new Order(2,Model.HYBRID,tesla));
        orders.add(new Order(3,Model.TRUCK,tesla));
        orders.add(new Order(1,Model.SPORT,tesla));
        
        System.out.println("Orders generated: ");
        for(int i = 0;i < orders.size();i++) {
            System.out.print(orders.get(i).number + " " + orders.get(i).model + "  ");
        }System.out.println();
        
        // execute orders
        for(int order = 0;order < orders.size();order++) {
            orders.get(order).Execute();
        }
        System.out.println();
        
        System.out.println();
        System.out.println("Pattern: Mediator");
        // Begin with a manufacturer
        Manufacturer business = new Manufacturer("Business");
        // for this last design pattern, I'll get a little bit of variation from the rest
        // The manufacturer will do business with another
        Manufacturer other = new Manufacturer("Other");
        
        Mediator intermediary = new Mediator();
        // set beginning state
        intermediary.buyer = business;
        intermediary.seller = other;
        
        business.intermediary = intermediary;
        other.intermediary = intermediary;
        
        business.buy(4, Model.SPORT);
        other.buy(3, Model.TRUCK);
        other.buy(5, Model.HYBRID);
        
        System.out.println("Initial buyer stock: ");
        for(int i = 0;i < business.stock.size();i++) {
            System.out.print(business.stock.get(i).model + " ");
        }
        
        System.out.println("\nInitial seller stock: ");
        for(int i = 0;i < other.stock.size();i++) {
            System.out.print(other.stock.get(i).model + " ");
        }
    }

}
