
package libs.jaxb.dms.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Список версий
 * 
 * <p>Java class for ct_DocumentVersionList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DocumentVersionList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.raiffeisen.ru/types/Document/v1}ct_DocumentVersion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DocumentVersionList", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "version"
})
public class CtDocumentVersionList {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected List<CtDocumentVersion> version;

    /**
     * Gets the value of the version property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the version property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CtDocumentVersion }
     * 
     * 
     */
    public List<CtDocumentVersion> getVersion() {
        if (version == null) {
            version = new ArrayList<CtDocumentVersion>();
        }
        return this.version;
    }

}
