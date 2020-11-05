
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Описание документа
 * 
 * <p>Java class for ct_Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentProfile" type="{http://www.raiffeisen.ru/types/Document/v1}ct_DocumentProfile" minOccurs="0"/>
 *         &lt;element name="versions" type="{http://www.raiffeisen.ru/types/Document/v1}ct_DocumentVersionList" minOccurs="0"/>
 *         &lt;element name="relatedDocuments" type="{http://www.raiffeisen.ru/types/Document/v1}ct_RelatedDocumentList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_Document", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "documentProfile",
    "versions",
    "relatedDocuments"
})
public class CtDocument {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtDocumentProfile documentProfile;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtDocumentVersionList versions;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtRelatedDocumentList relatedDocuments;

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

    /**
     * Gets the value of the versions property.
     * 
     * @return
     *     possible object is
     *     {@link CtDocumentVersionList }
     *     
     */
    public CtDocumentVersionList getVersions() {
        return versions;
    }

    /**
     * Sets the value of the versions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDocumentVersionList }
     *     
     */
    public void setVersions(CtDocumentVersionList value) {
        this.versions = value;
    }

    /**
     * Gets the value of the relatedDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link CtRelatedDocumentList }
     *     
     */
    public CtRelatedDocumentList getRelatedDocuments() {
        return relatedDocuments;
    }

    /**
     * Sets the value of the relatedDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtRelatedDocumentList }
     *     
     */
    public void setRelatedDocuments(CtRelatedDocumentList value) {
        this.relatedDocuments = value;
    }

}
