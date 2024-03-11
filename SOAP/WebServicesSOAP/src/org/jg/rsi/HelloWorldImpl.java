package org.jg.rsi;
//Service Implementation
import javax.jws.WebService;
@WebService(endpointInterface = "org.jg.rsi.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }
}