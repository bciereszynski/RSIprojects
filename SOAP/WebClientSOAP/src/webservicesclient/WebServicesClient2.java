package webservicesclient;
import org.jg.rsi.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class WebServicesClient2 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://rsi.jg.org/", "HelloWorldImplService");

        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        String request = "To ja - KLIENT 2";
        String response = hello.getHelloWorldAsString(request);

        System.out.println("Klient wysłał: " + request);
        System.out.println("Klient otrzymał: " + response);
    }
}
