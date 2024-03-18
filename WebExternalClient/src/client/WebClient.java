package client;

import com.lavasoft.GeoIPServiceSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL");
        QName qname = new QName("http://lavasoft.com/", "GeoIPService");

        Service service = Service.create(url, qname);
        GeoIPServiceSoap geo = service.getPort(GeoIPServiceSoap.class);

        System.out.println("Podaj ip:");
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String response = geo.getIpLocation(ip);

        System.out.println("Odpowiedź: " + response);
    }
}
