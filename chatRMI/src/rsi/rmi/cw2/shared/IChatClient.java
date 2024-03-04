package rsi.rmi.cw2.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatClient extends Remote {
    void update(String name, String message) throws RemoteException;
}
