package com.rsi.client;


import com.rsi.ws.ServerInfo;
import com.rsi.ws.ServerInfoService;

public class WsClient{

    public static void main(String[] args) throws Exception {

        ServerInfoService sis = new ServerInfoService();
        ServerInfo si = sis.getServerInfoPort();

        System.out.println(si.getServerName());

    }

}