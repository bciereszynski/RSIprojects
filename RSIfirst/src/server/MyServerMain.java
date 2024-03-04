/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class MyServerMain{
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            //System.setProperty("java.rmi.server.hostname", "192.168.0.110");
            //System.setProperty("java.rmi.server.codebase","file:C:\\Users\\bcier\\IdeaProjects\\RSI1\\out\\production\\RSI1");
            //System.setProperty("java.rmi.server.codebase", "http://192.168.0.110/smth/");
            LocateRegistry.createRegistry(1099);
            MyServerImpl obj1 = new MyServerImpl();
            Naming.rebind("//localhost/smth", obj1);
            System.out.println("Serwer oczekuje ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
