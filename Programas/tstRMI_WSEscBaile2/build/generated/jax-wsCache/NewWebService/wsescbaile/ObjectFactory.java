
package wsescbaile;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsescbaile package. 
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

    private final static QName _HelloResponse_QNAME = new QName("http://wsEscBaile/", "helloResponse");
    private final static QName _AltaAlumno_QNAME = new QName("http://wsEscBaile/", "altaAlumno");
    private final static QName _ModificaAlumno_QNAME = new QName("http://wsEscBaile/", "modificaAlumno");
    private final static QName _ModificaAlumnoResponse_QNAME = new QName("http://wsEscBaile/", "modificaAlumnoResponse");
    private final static QName _AltaAlumnoResponse_QNAME = new QName("http://wsEscBaile/", "altaAlumnoResponse");
    private final static QName _BorraAlumnoResponse_QNAME = new QName("http://wsEscBaile/", "borraAlumnoResponse");
    private final static QName _BorraAlumno_QNAME = new QName("http://wsEscBaile/", "borraAlumno");
    private final static QName _Hello_QNAME = new QName("http://wsEscBaile/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsescbaile
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AltaAlumnoResponse }
     * 
     */
    public AltaAlumnoResponse createAltaAlumnoResponse() {
        return new AltaAlumnoResponse();
    }

    /**
     * Create an instance of {@link BorraAlumnoResponse }
     * 
     */
    public BorraAlumnoResponse createBorraAlumnoResponse() {
        return new BorraAlumnoResponse();
    }

    /**
     * Create an instance of {@link ModificaAlumno }
     * 
     */
    public ModificaAlumno createModificaAlumno() {
        return new ModificaAlumno();
    }

    /**
     * Create an instance of {@link ModificaAlumnoResponse }
     * 
     */
    public ModificaAlumnoResponse createModificaAlumnoResponse() {
        return new ModificaAlumnoResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link AltaAlumno }
     * 
     */
    public AltaAlumno createAltaAlumno() {
        return new AltaAlumno();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link BorraAlumno }
     * 
     */
    public BorraAlumno createBorraAlumno() {
        return new BorraAlumno();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaAlumno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "altaAlumno")
    public JAXBElement<AltaAlumno> createAltaAlumno(AltaAlumno value) {
        return new JAXBElement<AltaAlumno>(_AltaAlumno_QNAME, AltaAlumno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificaAlumno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "modificaAlumno")
    public JAXBElement<ModificaAlumno> createModificaAlumno(ModificaAlumno value) {
        return new JAXBElement<ModificaAlumno>(_ModificaAlumno_QNAME, ModificaAlumno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificaAlumnoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "modificaAlumnoResponse")
    public JAXBElement<ModificaAlumnoResponse> createModificaAlumnoResponse(ModificaAlumnoResponse value) {
        return new JAXBElement<ModificaAlumnoResponse>(_ModificaAlumnoResponse_QNAME, ModificaAlumnoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaAlumnoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "altaAlumnoResponse")
    public JAXBElement<AltaAlumnoResponse> createAltaAlumnoResponse(AltaAlumnoResponse value) {
        return new JAXBElement<AltaAlumnoResponse>(_AltaAlumnoResponse_QNAME, AltaAlumnoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorraAlumnoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "borraAlumnoResponse")
    public JAXBElement<BorraAlumnoResponse> createBorraAlumnoResponse(BorraAlumnoResponse value) {
        return new JAXBElement<BorraAlumnoResponse>(_BorraAlumnoResponse_QNAME, BorraAlumnoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorraAlumno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "borraAlumno")
    public JAXBElement<BorraAlumno> createBorraAlumno(BorraAlumno value) {
        return new JAXBElement<BorraAlumno>(_BorraAlumno_QNAME, BorraAlumno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsEscBaile/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}
