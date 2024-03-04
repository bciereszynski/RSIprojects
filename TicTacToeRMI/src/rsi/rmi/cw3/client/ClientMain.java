package rsi.rmi.cw3.client;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import rsi.rmi.cw3.shared.ITTTService;
import rsi.rmi.cw3.ssl.sockets.RMISSLClientSocketFactory;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    private static final int PORT = 2019;
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "policy");
            System.setSecurityManager(new SecurityManager());

            System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\bcier\\IdeaProjects\\RSIprojects\\TicTacToeRMI\\testkeys");
            System.setProperty("javax.net.ssl.trustStorePassword", "passphrase");

            // Make reference to SSL-based registry
            Registry registry = LocateRegistry.getRegistry(
                    InetAddress.getLocalHost().getHostName(), PORT,
                    new RMISSLClientSocketFactory());
            ITTTService itttService = (ITTTService) registry.lookup("server");

            //ITTTService itttService = (ITTTService) Naming.lookup("//localhost/server");
            Scanner scanner = new Scanner(System.in);
            TTTClient tttClient = new TTTClient();
            itttService.join(tttClient);

            while (true) {
                String coordinates = scanner.nextLine();
                try {
                    if(coordinates.length()!=3) {
                        throw new ValueException("Bad input!");
                    }
                    itttService.move(coordinates.charAt(0) - 48, coordinates.charAt(2) - 48, tttClient.getSymbol());
                }
                catch (RemoteException e){
                    throw e.getCause();
                }
                catch (ValueException e){
                    System.out.println(e.getMessage());
                    System.out.print("Insert coordinates(x,y):");
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
