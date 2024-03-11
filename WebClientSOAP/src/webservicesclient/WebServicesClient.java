package webservicesclient;

import org.jg.rsi.HelloWorld;
import org.jg.rsi.HelloWorldImplService;

public class WebServicesClient {
    public static void main(String[] args) {
        HelloWorldImplService helloService = new HelloWorldImplService();
        HelloWorld hello = helloService.getHelloWorldImplPort();

        String request = "To ja - KLIENT";
        String response = hello.getHelloWorldAsString(request);

        System.out.println("Klient wysłał: " + request);
        System.out.println("Klient otrzymał: " + response);
    }
}
