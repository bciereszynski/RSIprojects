package rsi.rmi.cw3.client;

import rsi.rmi.cw3.shared.ITTTService;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            ITTTService itttService = (ITTTService) Naming.lookup("//localhost/server");
            Scanner scanner = new Scanner(System.in);
            TTTClient tttClient = new TTTClient();
            itttService.join(tttClient);

            while (true) {
                String coordinates = scanner.nextLine();
                itttService.move(coordinates.charAt(0) - 48, coordinates.charAt(2) - 48, tttClient.getSymbol());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
