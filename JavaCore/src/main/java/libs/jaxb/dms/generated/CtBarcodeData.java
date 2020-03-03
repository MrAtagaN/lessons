
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация о ШК
 * 
 * <p>Java class for ct_BarcodeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_BarcodeData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barcodeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="packageContextId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="documentProfile" type="{http://www.raiffeisen.ru/types/Document/v1}ct_DocumentProfile"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_BarcodeData", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "barcodeValue",
    "title",
    "packageContextId",
    "documentProfile"
})
public class CtBarcodeData {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected String barcodeValue;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1")
    protected boolean title;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected String packageContextId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtDocumentProfile documentProfile;

    /**
     * Gets the value of the barcodeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcodeValue() {
        return barcodeValue;
    }

    /**
     * Sets the value of the barcodeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcodeValue(String value) {
        this.barcodeValue = value;
    }

    /**
     * Gets the value of the title property.
     * 
     */
    public boolean isTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     */
    public void setTitle(boolean value) {
        this.title = value;
    }

    /**
     * Gets the value of the packageContextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageContextId() {
        return packageContextId;
    }

    /**
     * Sets the value of the packageContextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageContextId(String value) {
        this.packageContextId = value;
    }

    /**
     * Gets the value of the documentProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CtDocumentProfile }
     *     
     */
    public CtDocumentProfile getDocumentProfile() {
        return documentProfile;
    }

    /**
     * Sets the value of the documentProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDocumentProfile }
     *     
     */
    public void setDocumentProfile(CtDocumentProfile value) {
        this.documentProfile = value;
    }

}
