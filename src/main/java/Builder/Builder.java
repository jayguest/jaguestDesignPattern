package main.java.Builder;

import main.java.Car;
import main.java.Manufacturer;
import main.java.Model;

/**
 * Receives build commands from the reader, runs the construction chain
 */
public class Builder {

    public Manufacturer owner;

    public Builder(Manufacturer owner){
        this.owner = owner;
    }

    public void buildRequest(int num, Model make){
        if(this.owner.factories.size() == 0){ // owner has no factories yet
            this.owner.buyFactory(make);
            this.owner.factories.get(0).build(num);
        }else{ // owner has factories, check if they are right kind
            for(int i = 0;i < this.owner.factories.size();i++){
                if(this.owner.factories.get(i).model == make){
                    this.owner.factories.get(i).build(num);
                }else{
                    this.owner.buyFactory(make);
                    for(int j = 0;j < this.owner.factories.size();j++){
                        if(this.owner.factories.get(j).model == make){
                            this.owner.factories.get(j).build(num);
                        }
                    }
                }
            }
        }
    }

    public Car[] returnResult(Model make){
        Car[] send = new Car[this.owner.factories.size()];
        for(int i = 0;i < this.owner.factories.size();i++){
            if(this.owner.factories.get(i).model == make){
                send = this.owner.factories.get(i).stock; // receive built cars
                // now we empty the stock to reflect the delivery
                this.owner.factories.get(i).resetStock();
            }
        }
        return send; // send over the built cars
    }

}
