package rsi.rmi.cw2.server;

import rsi.rmi.cw2.shared.IChatClient;
import rsi.rmi.cw2.shared.IChatService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatService extends UnicastRemoteObject implements IChatService {
    private final List<IChatClient> clients = new ArrayList<>();

    public ChatService() throws RemoteException {
    }


    @Override
    public void subscribe(IChatClient chatClient) throws RemoteException {
        clients.add(chatClient);
    }

    @Override
    public void sendMessage(String name, String message) throws RemoteException {
        clients.forEach(c -> {
            try {
                c.update(name, message);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
