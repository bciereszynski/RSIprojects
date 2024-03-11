package Server;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class MyServerMain{
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            LocateRegistry.createRegistry(1099);
            MyServerImpl server = new MyServerImpl();
            Naming.rebind("//localhost/srv", server);
            System.out.println("Serwer oczekuje ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
