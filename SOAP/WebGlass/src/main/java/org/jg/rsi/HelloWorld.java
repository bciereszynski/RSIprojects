package org.jg.rsi;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import java.util.List;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL) //optional
public interface HelloWorld {
    @WebMethod
    //@WebMethod(operationName = "getName")
    String getHelloWorldAsString(String name);

    //@WebMethod(action = "POST")
    @WebMethod
    public List<Product> getProducts();
}