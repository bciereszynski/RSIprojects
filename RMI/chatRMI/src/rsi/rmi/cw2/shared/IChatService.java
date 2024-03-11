package rsi.rmi.cw2.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatService extends Remote {
    void subscribe(IChatClient iChatClient) throws RemoteException;
    void sendMessage(String name, String message) throws RemoteException;
}
