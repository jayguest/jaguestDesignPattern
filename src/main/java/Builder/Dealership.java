package main.java.Builder;

/**
 * Defines the class which generates orders for cars from Factory
 */
public class Dealership {
    private Model model;
    private Factory provider;
    private Manufacturer owner;

    public Dealership(Factory provider){
        this.provider = provider;
        this.owner = provider.owner;
        this.model = provider.model; // can only sell what factory makes
    }

    /**
     * Method to send a build request to the factory provider
     * @param request is the number of cars requested
     */
    public Car[] request(int request){
        this.owner.sales += request; // keep track of sales
        return provider.build(request);
    }
}
