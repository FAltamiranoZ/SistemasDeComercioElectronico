
package wscustord;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para edit complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="edit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{http://wsCustOrd/}customerOrder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edit", propOrder = {
    "entity"
})
public class Edit {

    protected CustomerOrder entity;

    /**
     * Obtiene el valor de la propiedad entity.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrder }
     *     
     */
    public CustomerOrder getEntity() {
        return entity;
    }

    /**
     * Define el valor de la propiedad entity.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrder }
     *     
     */
    public void setEntity(CustomerOrder value) {
        this.entity = value;
    }

}
