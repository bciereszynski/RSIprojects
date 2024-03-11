package rsi.rmi.cw2.client;

import rsi.rmi.cw2.shared.IChatService;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            IChatService chatService = (IChatService) Naming.lookup("//localhost/server");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj swoje imie: ");
            String userName = scanner.nextLine();
            ChatClient chatClient = new ChatClient();
            chatClient.setName(userName);
            chatService.subscribe(chatClient);
            System.out.println("Connected :)");

            while (true) {
                String message = scanner.nextLine();
                chatService.sendMessage(userName, message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
