package client;

import com.lavasoft.GeoIPServiceSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class WebClient {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL");
        QName qname = new QName("http://lavasoft.com/", "GeoIPService");

        Service service = Service.create(url, qname);
        GeoIPServiceSoap geo = service.getPort(GeoIPServiceSoap.class);

        String response = geo.getLocation();

        System.out.println("Klient otrzymał: " + response);
    }
}
