
package wsjsonPersonaClte;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsjsonPersonaClte package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hello_QNAME = new QName("http://wsjsonpersona/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://wsjsonpersona/", "helloResponse");
    private final static QName _ObtenPersona_QNAME = new QName("http://wsjsonpersona/", "obtenPersona");
    private final static QName _ObtenPersonaResponse_QNAME = new QName("http://wsjsonpersona/", "obtenPersonaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsjsonPersonaClte
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenPersona }
     * 
     */
    public ObtenPersona createObtenPersona() {
        return new ObtenPersona();
    }

    /**
     * Create an instance of {@link ObtenPersonaResponse }
     * 
     */
    public ObtenPersonaResponse createObtenPersonaResponse() {
        return new ObtenPersonaResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsjsonpersona/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsjsonpersona/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsjsonpersona/", name = "obtenPersona")
    public JAXBElement<ObtenPersona> createObtenPersona(ObtenPersona value) {
        return new JAXBElement<ObtenPersona>(_ObtenPersona_QNAME, ObtenPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsjsonpersona/", name = "obtenPersonaResponse")
    public JAXBElement<ObtenPersonaResponse> createObtenPersonaResponse(ObtenPersonaResponse value) {
        return new JAXBElement<ObtenPersonaResponse>(_ObtenPersonaResponse_QNAME, ObtenPersonaResponse.class, null, value);
    }

}
