
package wsescbaile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificaAlumno complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificaAlumno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cveAlumnoV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreAlumnoV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apPaternoAlumnoV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apMaternoAlumnoV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cveAlumnoN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreAlumnoN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apPaternoAlumnoN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apMaternoAlumnoN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificaAlumno", propOrder = {
    "cveAlumnoV",
    "nombreAlumnoV",
    "apPaternoAlumnoV",
    "apMaternoAlumnoV",
    "cveAlumnoN",
    "nombreAlumnoN",
    "apPaternoAlumnoN",
    "apMaternoAlumnoN"
})
public class ModificaAlumno {

    protected String cveAlumnoV;
    protected String nombreAlumnoV;
    protected String apPaternoAlumnoV;
    protected String apMaternoAlumnoV;
    protected String cveAlumnoN;
    protected String nombreAlumnoN;
    protected String apPaternoAlumnoN;
    protected String apMaternoAlumnoN;

    /**
     * Obtiene el valor de la propiedad cveAlumnoV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveAlumnoV() {
        return cveAlumnoV;
    }

    /**
     * Define el valor de la propiedad cveAlumnoV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveAlumnoV(String value) {
        this.cveAlumnoV = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAlumnoV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAlumnoV() {
        return nombreAlumnoV;
    }

    /**
     * Define el valor de la propiedad nombreAlumnoV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAlumnoV(String value) {
        this.nombreAlumnoV = value;
    }

    /**
     * Obtiene el valor de la propiedad apPaternoAlumnoV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApPaternoAlumnoV() {
        return apPaternoAlumnoV;
    }

    /**
     * Define el valor de la propiedad apPaternoAlumnoV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApPaternoAlumnoV(String value) {
        this.apPaternoAlumnoV = value;
    }

    /**
     * Obtiene el valor de la propiedad apMaternoAlumnoV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApMaternoAlumnoV() {
        return apMaternoAlumnoV;
    }

    /**
     * Define el valor de la propiedad apMaternoAlumnoV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApMaternoAlumnoV(String value) {
        this.apMaternoAlumnoV = value;
    }

    /**
     * Obtiene el valor de la propiedad cveAlumnoN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveAlumnoN() {
        return cveAlumnoN;
    }

    /**
     * Define el valor de la propiedad cveAlumnoN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveAlumnoN(String value) {
        this.cveAlumnoN = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAlumnoN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAlumnoN() {
        return nombreAlumnoN;
    }

    /**
     * Define el valor de la propiedad nombreAlumnoN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAlumnoN(String value) {
        this.nombreAlumnoN = value;
    }

    /**
     * Obtiene el valor de la propiedad apPaternoAlumnoN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApPaternoAlumnoN() {
        return apPaternoAlumnoN;
    }

    /**
     * Define el valor de la propiedad apPaternoAlumnoN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApPaternoAlumnoN(String value) {
        this.apPaternoAlumnoN = value;
    }

    /**
     * Obtiene el valor de la propiedad apMaternoAlumnoN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApMaternoAlumnoN() {
        return apMaternoAlumnoN;
    }

    /**
     * Define el valor de la propiedad apMaternoAlumnoN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApMaternoAlumnoN(String value) {
        this.apMaternoAlumnoN = value;
    }

}
