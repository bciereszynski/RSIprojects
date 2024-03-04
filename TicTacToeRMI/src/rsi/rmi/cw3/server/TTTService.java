package rsi.rmi.cw3.server;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import rsi.rmi.cw3.shared.IFTTTClient;
import rsi.rmi.cw3.shared.ITTTService;
import rsi.rmi.cw3.shared.RMISSLServerSocketFactory;
import rsi.rmi.cw3.ssl.sockets.RMISSLClientSocketFactory;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TTTService extends UnicastRemoteObject implements ITTTService {
    private static final int PORT = 2019;
    private final List<IFTTTClient> clients = new ArrayList<>();
    private final char[][] board = new char[3][3];
    private char currentSymbol = 'O';
    private boolean end = false;

    public TTTService() throws Exception {
        super(PORT,
                new RMISSLClientSocketFactory(),
                new RMISSLServerSocketFactory());
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
    public void move(int x, int y, char symbol) throws Exception {
        if(end)
            throw new Exception("Game is ended!");
        if (symbol != currentSymbol) {
            System.out.println("Bad symbol:" + symbol + " " + currentSymbol);
            throw new Exception("Its your opponent turn!");
        }
        if (x>2 || y>2){
            throw new ValueException("Invalid coordinates!");
        }
        if (board[x][y] != '-') {
            throw new ValueException("This field is already occupied!");
        }
        board[x][y] = currentSymbol;
        end = checkWin(x, y, symbol);
        if (currentSymbol == 'O')
            currentSymbol = 'X';
        else
            currentSymbol = 'O';
        update();
    }

    private boolean checkWin(int x, int y, char symbol){
        //column
        for (int i = 0; i<3; i++){
            if(board[x][i] != symbol)
                break;
            if (i == 2)
                return true;
        }
        //row
        for (int i = 0; i<3; i++){
            if(board[i][y] != symbol)
                break;
            if (i == 2)
                return true;
        }
        //diagonal \
        for (int i = 0; i<3; i++){
            if(board[i][i] != symbol)
                break;
            if (i == 2)
                return true;
        }
        //diagonal /
        for (int i = 0; i<3; i++){
            if(board[i][2-i] != symbol)
                break;
            if (i == 2)
                return true;
        }
        return false;
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
