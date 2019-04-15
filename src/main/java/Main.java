package main.java;

import main.java.Builder.Builder;
import main.java.Builder.Reader;

/**
 * main.java.Main class
 */
public class Main {

    public static void main(String[] args){
        System.out.println("Jason Guest");
        System.out.println("Design Pattern Project");

        // Test vectors
        Car[] test = {new Sport(),new Truck(),new Sport(),new Hybrid(),new Sport()};

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
        System.out.println("Builder results:");
        for(int j = 0;j < reader.runResult.size();j++){
            System.out.print(reader.runResult.get(j) + " ");
        }



    }

}
