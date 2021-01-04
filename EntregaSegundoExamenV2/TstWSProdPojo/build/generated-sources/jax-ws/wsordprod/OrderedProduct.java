
package wsordprod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para orderedProduct complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="orderedProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerOrder" type="{http://wsOrdProd/}customerOrder" minOccurs="0"/>
 *         &lt;element name="orderedProductPK" type="{http://wsOrdProd/}orderedProductPK" minOccurs="0"/>
 *         &lt;element name="product" type="{http://wsOrdProd/}product" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedProduct", propOrder = {
    "customerOrder",
    "orderedProductPK",
    "product",
    "quantity"
})
public class OrderedProduct {

    protected CustomerOrder customerOrder;
    protected OrderedProductPK orderedProductPK;
    protected Product product;
    protected short quantity;

    /**
     * Obtiene el valor de la propiedad customerOrder.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrder }
     *     
     */
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    /**
     * Define el valor de la propiedad customerOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrder }
     *     
     */
    public void setCustomerOrder(CustomerOrder value) {
        this.customerOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad orderedProductPK.
     * 
     * @return
     *     possible object is
     *     {@link OrderedProductPK }
     *     
     */
    public OrderedProductPK getOrderedProductPK() {
        return orderedProductPK;
    }

    /**
     * Define el valor de la propiedad orderedProductPK.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderedProductPK }
     *     
     */
    public void setOrderedProductPK(OrderedProductPK value) {
        this.orderedProductPK = value;
    }

    /**
     * Obtiene el valor de la propiedad product.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Define el valor de la propiedad product.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     */
    public short getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     */
    public void setQuantity(short value) {
        this.quantity = value;
    }

}
