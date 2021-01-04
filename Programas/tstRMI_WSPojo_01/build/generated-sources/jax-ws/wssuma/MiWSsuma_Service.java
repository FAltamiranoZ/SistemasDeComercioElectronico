
package wssuma;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "miWSsuma", targetNamespace = "http://wssuma/", wsdlLocation = "http://192.168.15.4:8080/proyT01_163314_JFAZ/miWSsuma?WSDL")
public class MiWSsuma_Service
    extends Service
{

    private final static URL MIWSSUMA_WSDL_LOCATION;
    private final static WebServiceException MIWSSUMA_EXCEPTION;
    private final static QName MIWSSUMA_QNAME = new QName("http://wssuma/", "miWSsuma");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.15.4:8080/proyT01_163314_JFAZ/miWSsuma?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MIWSSUMA_WSDL_LOCATION = url;
        MIWSSUMA_EXCEPTION = e;
    }

    public MiWSsuma_Service() {
        super(__getWsdlLocation(), MIWSSUMA_QNAME);
    }

    public MiWSsuma_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MIWSSUMA_QNAME, features);
    }

    public MiWSsuma_Service(URL wsdlLocation) {
        super(wsdlLocation, MIWSSUMA_QNAME);
    }

    public MiWSsuma_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MIWSSUMA_QNAME, features);
    }

    public MiWSsuma_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MiWSsuma_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MiWSsuma
     */
    @WebEndpoint(name = "miWSsumaPort")
    public MiWSsuma getMiWSsumaPort() {
        return super.getPort(new QName("http://wssuma/", "miWSsumaPort"), MiWSsuma.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MiWSsuma
     */
    @WebEndpoint(name = "miWSsumaPort")
    public MiWSsuma getMiWSsumaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wssuma/", "miWSsumaPort"), MiWSsuma.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MIWSSUMA_EXCEPTION!= null) {
            throw MIWSSUMA_EXCEPTION;
        }
        return MIWSSUMA_WSDL_LOCATION;
    }

}
