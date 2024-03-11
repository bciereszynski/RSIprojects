package rsi.rmi.cw3.client;

import rsi.rmi.cw3.shared.IFTTTClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TTTClient extends UnicastRemoteObject implements IFTTTClient {
    private char symbol;

    protected TTTClient() throws RemoteException {
    }

    @Override
    public void setSymbol(char symbol) throws RemoteException {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() throws RemoteException {
        return this.symbol;
    }

    @Override
    public void update(char[][] board) throws RemoteException {
        System.out.println("\nJesteś " + symbol);
        System.out.print(buildBoard(board));
        System.out.print("Podaj wpółrzędne(x,y):");
    }

    private String buildBoard(char[][] board) {
        StringBuilder builder = new StringBuilder();
        builder.append("     |     |     \n");
        builder.append("  ").append(board[0][0]).append("  |  ").append(board[0][1]).append("  |  ").append(board[0][2]).append("  \n");
        builder.append("     |     |     \n");
        builder.append("-----------------\n");
        builder.append("     |     |     \n");
        builder.append("  ").append(board[1][0]).append("  |  ").append(board[1][1]).append("  |  ").append(board[1][2]).append("  \n");
        builder.append("     |     |     \n");
        builder.append("-----------------\n");
        builder.append("     |     |     \n");
        builder.append("  ").append(board[2][0]).append("  |  ").append(board[2][1]).append("  |  ").append(board[2][2]).append("  \n");
        builder.append("     |     |     \n");
        return builder.toString();
    }
}
