
package libs.jaxb.dms.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Идентификаторы местонахождения файлов
 * 
 * <p>Java class for ct_mqPagesReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_mqPagesReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mqPageReference" type="{http://www.raiffeisen.ru/types/Document/v1}ct_MQFileReference" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_mqPagesReference", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "mqPageReference"
})
public class CtMqPagesReference {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected List<CtMQFileReference> mqPageReference;

    /**
     * Gets the value of the mqPageReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mqPageReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMqPageReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CtMQFileReference }
     * 
     * 
     */
    public List<CtMQFileReference> getMqPageReference() {
        if (mqPageReference == null) {
            mqPageReference = new ArrayList<CtMQFileReference>();
        }
        return this.mqPageReference;
    }

}
