package main.java;

/**
 * Defines the model which will instantiated for specific car types
 */
public class Factory {
    public Model model;
    public Manufacturer owner;
    public Car[] stock;

    public Factory(Manufacturer owner,Model model){
        this.model = model;
        this.owner = owner;
    }

    /**
     * Builds a set of Cars by request from dealership
     * @param request is the number of cars to build
     */
    public void build(int request){
        Car[] delivery = new Car[request];

        for(int i = 0;i < request;i++){
            if(this.model == Model.HYBRID){
                delivery[i] = new Hybrid();
            }else if(this.model == Model.SPORT){
                delivery[i] = new Sport();
            }else{
                delivery[i] = new Truck();
            }
        }

        this.stock = delivery;
    }

    public void resetStock(){
        this.stock = null;
    }

}
