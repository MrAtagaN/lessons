
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Документы, соответствующие параметрам поиска
 * 
 * <p>Java class for ct_SearchDocumentsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_SearchDocumentsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documents" type="{http://www.raiffeisen.ru/types/Document/v1}ct_DocumentList"/>
 *         &lt;element name="searchOverLimit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_SearchDocumentsResponse", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "documents",
    "searchOverLimit"
})
public class CtSearchDocumentsResponse {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtDocumentList documents;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1")
    protected Boolean searchOverLimit;

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link CtDocumentList }
     *     
     */
    public CtDocumentList getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDocumentList }
     *     
     */
    public void setDocuments(CtDocumentList value) {
        this.documents = value;
    }

    /**
     * Gets the value of the searchOverLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchOverLimit() {
        return searchOverLimit;
    }

    /**
     * Sets the value of the searchOverLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchOverLimit(Boolean value) {
        this.searchOverLimit = value;
    }

}
