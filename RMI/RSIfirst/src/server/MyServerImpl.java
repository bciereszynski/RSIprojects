/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import common.MyServerInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    int i = 0;
    protected MyServerImpl() throws RemoteException {
        super();
    }
   @Override
   public String getDescription(String text) throws RemoteException {
       i++;
        System.out.println("MyServerImpl.getDescription: " + text + " " + i);
       return "getDescription: " + text + " " + i;
   }
    @Override
    public int add(int a, int b) throws RemoteException{
        return a+b;
        }
    @Override
    public int subtract(int a, int b) throws RemoteException{
        return a-b;
    }
    @Override
    public int multiply(int a, int b) throws RemoteException{
        return a*b*1000;
    }
    @Override
    public int divide(int a, int b) throws RemoteException{
        return a/b;
    }
}