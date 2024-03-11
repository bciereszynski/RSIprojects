package rsi.rmi.cw2.client;

import rsi.rmi.cw2.shared.IChatClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class ChatClient extends UnicastRemoteObject implements IChatClient {
    private String name;

    protected ChatClient() throws RemoteException {
    }

    @Override
    public void update(String name, String message) throws RemoteException {
        if(Objects.equals(name, this.name))
            return;
        System.out.println("["+name+"]: "+message);
    }

    public void setName(String name) {
        this.name = name;
    }

}
