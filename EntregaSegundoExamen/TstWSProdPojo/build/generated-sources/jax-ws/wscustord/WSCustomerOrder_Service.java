
package wscustord;

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
@WebServiceClient(name = "WSCustomerOrder", targetNamespace = "http://wsCustOrd/", wsdlLocation = "http://localhost:8080/AffableBeanCorregido/WSCustomerOrder?WSDL")
public class WSCustomerOrder_Service
    extends Service
{

    private final static URL WSCUSTOMERORDER_WSDL_LOCATION;
    private final static WebServiceException WSCUSTOMERORDER_EXCEPTION;
    private final static QName WSCUSTOMERORDER_QNAME = new QName("http://wsCustOrd/", "WSCustomerOrder");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/AffableBeanCorregido/WSCustomerOrder?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCUSTOMERORDER_WSDL_LOCATION = url;
        WSCUSTOMERORDER_EXCEPTION = e;
    }

    public WSCustomerOrder_Service() {
        super(__getWsdlLocation(), WSCUSTOMERORDER_QNAME);
    }

    public WSCustomerOrder_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCUSTOMERORDER_QNAME, features);
    }

    public WSCustomerOrder_Service(URL wsdlLocation) {
        super(wsdlLocation, WSCUSTOMERORDER_QNAME);
    }

    public WSCustomerOrder_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCUSTOMERORDER_QNAME, features);
    }

    public WSCustomerOrder_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSCustomerOrder_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSCustomerOrder
     */
    @WebEndpoint(name = "WSCustomerOrderPort")
    public WSCustomerOrder getWSCustomerOrderPort() {
        return super.getPort(new QName("http://wsCustOrd/", "WSCustomerOrderPort"), WSCustomerOrder.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSCustomerOrder
     */
    @WebEndpoint(name = "WSCustomerOrderPort")
    public WSCustomerOrder getWSCustomerOrderPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsCustOrd/", "WSCustomerOrderPort"), WSCustomerOrder.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCUSTOMERORDER_EXCEPTION!= null) {
            throw WSCUSTOMERORDER_EXCEPTION;
        }
        return WSCUSTOMERORDER_WSDL_LOCATION;
    }

}
