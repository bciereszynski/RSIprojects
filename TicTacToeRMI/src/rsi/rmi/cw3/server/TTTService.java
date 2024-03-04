package rsi.rmi.cw3.server;

import rsi.rmi.cw3.shared.IFTTTClient;
import rsi.rmi.cw3.shared.ITTTService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TTTService extends UnicastRemoteObject implements ITTTService {
    private final List<IFTTTClient> clients = new ArrayList<>();
    private final char[][] board = new char[3][3];
    private char currentSymbol = 'O';

    public TTTService() throws RemoteException {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                board[i][j] = '-';
            }
        }
    }

    @Override
    public void join(IFTTTClient client) throws RemoteException {
        if (clients.size() > 2) return;
        if (clients.isEmpty()) client.setSymbol('O');
        else client.setSymbol('X');
        clients.add(client);
        client.update(board);
    }

    @Override
    public void move(int x, int y, char symbol) throws RemoteException {
        if (symbol != currentSymbol) {
            System.out.println("Bad symbol:" + symbol + " " + currentSymbol);
            return;
        }
        if (board[x][y] != '-') {
            System.out.println("Box is occupied");
            return;
        }
        board[x][y] = currentSymbol;
        if (currentSymbol == 'O')
            currentSymbol = 'X';
        else
            currentSymbol = 'O';
        update();
    }

    private void update() {
        clients.forEach(c -> {
            try {
                c.update(board);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
