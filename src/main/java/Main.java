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



    }

}
