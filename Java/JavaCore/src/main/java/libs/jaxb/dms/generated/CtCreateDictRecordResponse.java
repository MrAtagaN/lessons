
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Результат создания записи в справочнике
 * 
 * <p>Java class for ct_CreateDictRecordResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_CreateDictRecordResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dictFilelds" type="{http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1}ct_DictSearchFields"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_CreateDictRecordResponse", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "dictFilelds",
    "status"
})
public class CtCreateDictRecordResponse {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtDictSearchFields dictFilelds;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected String status;

    /**
     * Gets the value of the dictFilelds property.
     * 
     * @return
     *     possible object is
     *     {@link CtDictSearchFields }
     *     
     */
    public CtDictSearchFields getDictFilelds() {
        return dictFilelds;
    }

    /**
     * Sets the value of the dictFilelds property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDictSearchFields }
     *     
     */
    public void setDictFilelds(CtDictSearchFields value) {
        this.dictFilelds = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
