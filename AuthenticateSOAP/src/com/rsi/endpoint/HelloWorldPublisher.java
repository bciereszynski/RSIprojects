package com.rsi.endpoint;
 
import javax.xml.ws.Endpoint;
import com.rsi.ws.HelloWorldImpl;
 
//Endpoint publisher
public class HelloWorldPublisher{
 
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/hello", new HelloWorldImpl());

		System.out.println("Server is online...");
    }
 
}