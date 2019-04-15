package main.java.Builder;

/**
 * Defines an abstract class for cars to extend
 */
public class Car {
    public Model model;
    public Part part;
    int deliveryID;

    public Car(Model model,int id){
        this.deliveryID = id;
        this.model = model;
        if(model == Model.SPORT){
            this.part = Part.SPOILER;
        }else if(model == Model.HYBRID){
            this.part = Part.ELECTRIC_ENGINE;
        }else{
            this.part = Part.BED;
        }
    }
}
