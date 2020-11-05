
package libs.jaxb.dms.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ct_RelatedDocumentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_RelatedDocumentList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="relatedDocument" type="{http://www.raiffeisen.ru/types/Document/v1}ct_RelatedDocument" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_RelatedDocumentList", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "relatedDocument"
})
public class CtRelatedDocumentList {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected List<CtRelatedDocument> relatedDocument;

    /**
     * Gets the value of the relatedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CtRelatedDocument }
     * 
     * 
     */
    public List<CtRelatedDocument> getRelatedDocument() {
        if (relatedDocument == null) {
            relatedDocument = new ArrayList<CtRelatedDocument>();
        }
        return this.relatedDocument;
    }

}
