
package wsmessageclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para creaMensaje complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="creaMensaje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strMensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creaMensaje", propOrder = {
    "strMensaje"
})
public class CreaMensaje {

    protected String strMensaje;

    /**
     * Obtiene el valor de la propiedad strMensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrMensaje() {
        return strMensaje;
    }

    /**
     * Define el valor de la propiedad strMensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrMensaje(String value) {
        this.strMensaje = value;
    }

}
