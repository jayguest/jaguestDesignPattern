package main.java.Builder;

/**
 * Defines the model which will instantiated for specific car types
 */
public class Factory {
    public Model model;
    public Manufacturer owner;

    public Factory(Manufacturer owner,Model model){
        this.model = model;
        this.owner = owner;
    }

    /**
     * Builds a set of Cars by request from dealership
     * @param request is the number of cars to build
     * @return the delivery of cars
     */
    Car[] build(int request){
        Car[] delivery = new Car[request];

        for(int i = 0;i < request;i++){
            delivery[i] = new Car(this.model,request);
        }

        return delivery;
    }

}
