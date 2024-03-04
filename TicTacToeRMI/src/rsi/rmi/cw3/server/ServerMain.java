package rsi.rmi.cw3.server;

import rsi.rmi.cw3.shared.RMISSLServerSocketFactory;
import rsi.rmi.cw3.ssl.sockets.RMISSLClientSocketFactory;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    private static final int PORT = 2019;
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            Registry registry = LocateRegistry.createRegistry(PORT,
                    new RMISSLClientSocketFactory(),
                    new RMISSLServerSocketFactory());
            //LocateRegistry.createRegistry(1099);
            TTTService server = new TTTService();
            registry.bind("server", server);
            //Naming.rebind("//localhost/server", server);
            System.out.println("Server online ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}