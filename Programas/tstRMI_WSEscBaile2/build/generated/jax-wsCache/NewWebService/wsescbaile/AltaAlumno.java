
package wsescbaile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para altaAlumno complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="altaAlumno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cveAlumno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreAlumno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apPaternoAlumno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apMaternoAlumno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "altaAlumno", propOrder = {
    "cveAlumno",
    "nombreAlumno",
    "apPaternoAlumno",
    "apMaternoAlumno"
})
public class AltaAlumno {

    protected String cveAlumno;
    protected String nombreAlumno;
    protected String apPaternoAlumno;
    protected String apMaternoAlumno;

    /**
     * Obtiene el valor de la propiedad cveAlumno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveAlumno() {
        return cveAlumno;
    }

    /**
     * Define el valor de la propiedad cveAlumno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveAlumno(String value) {
        this.cveAlumno = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAlumno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * Define el valor de la propiedad nombreAlumno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAlumno(String value) {
        this.nombreAlumno = value;
    }

    /**
     * Obtiene el valor de la propiedad apPaternoAlumno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApPaternoAlumno() {
        return apPaternoAlumno;
    }

    /**
     * Define el valor de la propiedad apPaternoAlumno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApPaternoAlumno(String value) {
        this.apPaternoAlumno = value;
    }

    /**
     * Obtiene el valor de la propiedad apMaternoAlumno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApMaternoAlumno() {
        return apMaternoAlumno;
    }

    /**
     * Define el valor de la propiedad apMaternoAlumno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApMaternoAlumno(String value) {
        this.apMaternoAlumno = value;
    }

}
