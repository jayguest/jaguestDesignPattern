package main.java.Builder;

import java.util.ArrayList;
import main.java.Car;
import main.java.Model;

/**
 * The reader class specified by builder design pattern, receives the
 * order from client to construct, passes the build request to the builder.
 * The client will just be the main method passing info to reader.
 */
public class Reader {

    public ArrayList<Car> runResult;

    public Builder builder;


    public Reader() {
        this.runResult = new ArrayList<>();
    }

    // will receive orders for car objects (sport, truck or hybrid)
    // but all will be car, which is the common case

    /**.
     * Method used to construct a request
     * @param num is the number of cars
     * @param make is the car model
     */
    public void constructRequest(int num, Model make) {
        this.builder.buildRequest(num,make);
        System.out.print("car requested ");
        requestResult(make);
        System.out.println("car received ");
    }

    /**.
     * Once request filled, we ask for the result
     * @param make is the model
     */
    public void requestResult(Model make) {
        Car[] temp = this.builder.returnResult(make);
        
        for (int i = 0;i < temp.length;i++) {
            this.runResult.add(temp[i]);
        }

    }

}
