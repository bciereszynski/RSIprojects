package org.jg.rsi;
//Service Implementation
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.jg.rsi.HelloWorld", name="HelloWorldName", portName = "HelloWorldPortName",
        serviceName = "HelloWorldImplService", targetNamespace = "http://rsi.jg.org/")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }
    @Override
    public List<Product> getProducts(){
        Product p1 = new Product("nazwa1", "desc", 12);
        Product p2 = new Product("nazwa2", "desc2", 21);
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        return list;
    }
}