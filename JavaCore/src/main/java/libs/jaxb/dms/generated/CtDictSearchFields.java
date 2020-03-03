
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Поля для определения записи в справочнике
 * 
 * <p>Java class for ct_DictSearchFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DictSearchFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dictFields" type="{http://www.raiffeisen.ru/types/CustomField/v1}ct_CustomFieldList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DictSearchFields", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "defaultForm",
    "dictFields"
})
public class CtDictSearchFields {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1")
    protected String defaultForm;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtCustomFieldList dictFields;

    /**
     * Gets the value of the defaultForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultForm() {
        return defaultForm;
    }

    /**
     * Sets the value of the defaultForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultForm(String value) {
        this.defaultForm = value;
    }

    /**
     * Gets the value of the dictFields property.
     * 
     * @return
     *     possible object is
     *     {@link CtCustomFieldList }
     *     
     */
    public CtCustomFieldList getDictFields() {
        return dictFields;
    }

    /**
     * Sets the value of the dictFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtCustomFieldList }
     *     
     */
    public void setDictFields(CtCustomFieldList value) {
        this.dictFields = value;
    }

}
