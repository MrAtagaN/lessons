
package libs.jaxb.dms.generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Идентификаторы местонахождения файла
 * 
 * <p>Java class for ct_MQFileReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_MQFileReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pageId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destination" type="{http://www.raiffeisen.ru/types/Document/v1}ct_MQDestination" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_MQFileReference", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "pageId",
    "extension",
    "messageId",
    "destination"
})
public class CtMQFileReference {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected BigInteger pageId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String extension;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected String messageId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtMQDestination destination;

    /**
     * Gets the value of the pageId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageId() {
        return pageId;
    }

    /**
     * Sets the value of the pageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageId(BigInteger value) {
        this.pageId = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link CtMQDestination }
     *     
     */
    public CtMQDestination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtMQDestination }
     *     
     */
    public void setDestination(CtMQDestination value) {
        this.destination = value;
    }

}
