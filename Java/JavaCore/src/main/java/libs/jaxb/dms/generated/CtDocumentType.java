
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Атрибуты типа документа
 * 
 * <p>Java class for ct_DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="docTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docTypeStorage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docTypeRetention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docTypeFullText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DocumentType", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "docTypeId",
    "docTypeStorage",
    "docTypeRetention",
    "docTypeFullText",
    "docTypeDescription"
})
public class CtDocumentType {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected String docTypeId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docTypeStorage;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docTypeRetention;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docTypeFullText;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docTypeDescription;

    /**
     * Gets the value of the docTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypeId() {
        return docTypeId;
    }

    /**
     * Sets the value of the docTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypeId(String value) {
        this.docTypeId = value;
    }

    /**
     * Gets the value of the docTypeStorage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypeStorage() {
        return docTypeStorage;
    }

    /**
     * Sets the value of the docTypeStorage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypeStorage(String value) {
        this.docTypeStorage = value;
    }

    /**
     * Gets the value of the docTypeRetention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypeRetention() {
        return docTypeRetention;
    }

    /**
     * Sets the value of the docTypeRetention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypeRetention(String value) {
        this.docTypeRetention = value;
    }

    /**
     * Gets the value of the docTypeFullText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypeFullText() {
        return docTypeFullText;
    }

    /**
     * Sets the value of the docTypeFullText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypeFullText(String value) {
        this.docTypeFullText = value;
    }

    /**
     * Gets the value of the docTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypeDescription() {
        return docTypeDescription;
    }

    /**
     * Sets the value of the docTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypeDescription(String value) {
        this.docTypeDescription = value;
    }

}
