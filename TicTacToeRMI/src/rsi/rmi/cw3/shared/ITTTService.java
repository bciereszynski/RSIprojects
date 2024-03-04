package rsi.rmi.cw3.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITTTService extends Remote {
    void join(IFTTTClient iChatClient) throws RemoteException;
    void move(int x, int y, char symbol) throws Exception;
}
