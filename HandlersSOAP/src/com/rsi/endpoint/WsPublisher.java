package com.rsi.endpoint;

import javax.xml.ws.Endpoint;
import com.rsi.ws.ServerInfo;

//Endpoint publisher
public class WsPublisher{

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ws/server", new ServerInfo());

        System.out.println("Service is published!");
    }

}