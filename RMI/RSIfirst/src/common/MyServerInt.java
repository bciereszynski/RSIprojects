package common;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MyServerInt extends Remote{
String getDescription(String text) throws RemoteException;

int add(int a, int b) throws RemoteException;
int subtract(int a, int b) throws RemoteException;
int multiply(int a, int b) throws RemoteException;
int divide(int a, int b) throws RemoteException;
}