package client;

import common.MyServerInt;

import java.rmi.Naming;
public class MyClientMain {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");
        System.setSecurityManager(new SecurityManager());
        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//localhost/smth");
            String text = "Hallo :-)";
            String result = myRemoteObject.getDescription(text);
            System.out.println("Wysłano do servera: " + text);
            System.out.println("Otrzymana z serwera odpowiedź: " + result);
            int resultAdd = myRemoteObject.add(2, 2);
            System.out.println("Otrzymana z serwera odpowiedź: " + resultAdd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

