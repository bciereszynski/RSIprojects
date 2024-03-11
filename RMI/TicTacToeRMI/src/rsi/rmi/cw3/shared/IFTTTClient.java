package rsi.rmi.cw3.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFTTTClient extends Remote {
    void update(char[][] board) throws RemoteException;

    void setSymbol(char symbol) throws RemoteException;

    char getSymbol() throws RemoteException;
}
