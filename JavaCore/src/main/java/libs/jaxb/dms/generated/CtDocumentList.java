
package libs.jaxb.dms.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Список документов
 * 
 * <p>Java class for ct_DocumentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DocumentList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documents" type="{http://www.raiffeisen.ru/types/Document/v1}ct_Document" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DocumentList", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "documents"
})
public class CtDocumentList {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected List<CtDocument> documents;

    /**
     * Gets the value of the documents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CtDocument }
     * 
     * 
     */
    public List<CtDocument> getDocuments() {
        if (documents == null) {
            documents = new ArrayList<CtDocument>();
        }
        return this.documents;
    }

}
