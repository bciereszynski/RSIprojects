package Server;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import database.Product;
import database.ProductDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    private ProductDatabase database = new ProductDatabase();
    protected MyServerImpl() throws RemoteException {
        super();
    }
   @Override
   public List<Product> getProducts() throws RemoteException {
        return database.getAll();
   }

   public Product getProduct(int id) throws RemoteException {
       return database.get(id);
   }
}