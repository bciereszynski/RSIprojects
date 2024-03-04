package client;

import Server.MyServerInt;
import database.Product;

import java.rmi.Naming;
import java.util.List;

public class MyClientMain {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");
        System.setSecurityManager(new SecurityManager());
        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//localhost/srv");

            System.out.println("Get all:" );
            List<Product> result = myRemoteObject.getProducts();
            for(Product p: result){
                System.out.println("Product: " + p.id + " Name: " + p.name + " Value: " + p.value );
            }
            System.out.println("Get #2");
            Product p = myRemoteObject.getProduct(2);
            System.out.println("Product: " + p.id + " Name: " + p.name + " Value: " + p.value );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

