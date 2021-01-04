
package wsordprod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para orderedProductPK complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="orderedProductPK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerOrderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedProductPK", propOrder = {
    "customerOrderId",
    "productId"
})
public class OrderedProductPK {

    protected int customerOrderId;
    protected int productId;

    /**
     * Obtiene el valor de la propiedad customerOrderId.
     * 
     */
    public int getCustomerOrderId() {
        return customerOrderId;
    }

    /**
     * Define el valor de la propiedad customerOrderId.
     * 
     */
    public void setCustomerOrderId(int value) {
        this.customerOrderId = value;
    }

    /**
     * Obtiene el valor de la propiedad productId.
     * 
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Define el valor de la propiedad productId.
     * 
     */
    public void setProductId(int value) {
        this.productId = value;
    }

}
