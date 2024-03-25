package com.rsi.ws;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService

@HandlerChain(file= "com/handler-chain.xml")
public class ServerInfo{

    @WebMethod
    public String getServerName() {
        return "Test server (with MAC check)";
    }

}