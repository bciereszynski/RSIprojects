package Server;

import database.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyServerInt extends Remote{

public List<Product> getProducts() throws RemoteException;
public Product getProduct(int id) throws RemoteException;
}