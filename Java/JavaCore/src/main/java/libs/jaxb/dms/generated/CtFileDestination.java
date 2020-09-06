
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ct_FileDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_FileDestination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mqFileDestination" type="{http://www.raiffeisen.ru/types/Document/v1}ct_MQDestination" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_FileDestination", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "mqFileDestination"
})
public class CtFileDestination {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtMQDestination mqFileDestination;

    /**
     * Gets the value of the mqFileDestination property.
     * 
     * @return
     *     possible object is
     *     {@link CtMQDestination }
     *     
     */
    public CtMQDestination getMqFileDestination() {
        return mqFileDestination;
    }

    /**
     * Sets the value of the mqFileDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtMQDestination }
     *     
     */
    public void setMqFileDestination(CtMQDestination value) {
        this.mqFileDestination = value;
    }

}
