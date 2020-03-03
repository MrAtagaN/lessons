
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Описание версии документа
 * 
 * <p>Java class for ct_DocumentVersion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DocumentVersion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="docNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subversionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versionLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastEditTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typistId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typistName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forceVersionRo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileReference" type="{http://www.raiffeisen.ru/types/Document/v1}ct_FileReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DocumentVersion", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "docNumber",
    "versionId",
    "versionNumber",
    "subversionNumber",
    "versionLabel",
    "status",
    "lastEditTime",
    "comment",
    "authorId",
    "authorName",
    "typistId",
    "typistName",
    "forceVersionRo",
    "fileReference"
})
public class CtDocumentVersion {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docNumber;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String versionId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String versionNumber;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String subversionNumber;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String versionLabel;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String status;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String lastEditTime;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String comment;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String authorId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String authorName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String typistId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String typistName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String forceVersionRo;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtFileReference fileReference;

    /**
     * Gets the value of the docNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * Sets the value of the docNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNumber(String value) {
        this.docNumber = value;
    }

    /**
     * Gets the value of the versionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionId(String value) {
        this.versionId = value;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionNumber(String value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the subversionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubversionNumber() {
        return subversionNumber;
    }

    /**
     * Sets the value of the subversionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubversionNumber(String value) {
        this.subversionNumber = value;
    }

    /**
     * Gets the value of the versionLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionLabel() {
        return versionLabel;
    }

    /**
     * Sets the value of the versionLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionLabel(String value) {
        this.versionLabel = value;
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

    /**
     * Gets the value of the lastEditTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastEditTime() {
        return lastEditTime;
    }

    /**
     * Sets the value of the lastEditTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastEditTime(String value) {
        this.lastEditTime = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the authorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * Sets the value of the authorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorId(String value) {
        this.authorId = value;
    }

    /**
     * Gets the value of the authorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Sets the value of the authorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorName(String value) {
        this.authorName = value;
    }

    /**
     * Gets the value of the typistId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypistId() {
        return typistId;
    }

    /**
     * Sets the value of the typistId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypistId(String value) {
        this.typistId = value;
    }

    /**
     * Gets the value of the typistName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypistName() {
        return typistName;
    }

    /**
     * Sets the value of the typistName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypistName(String value) {
        this.typistName = value;
    }

    /**
     * Gets the value of the forceVersionRo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForceVersionRo() {
        return forceVersionRo;
    }

    /**
     * Sets the value of the forceVersionRo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForceVersionRo(String value) {
        this.forceVersionRo = value;
    }

    /**
     * Gets the value of the fileReference property.
     * 
     * @return
     *     possible object is
     *     {@link CtFileReference }
     *     
     */
    public CtFileReference getFileReference() {
        return fileReference;
    }

    /**
     * Sets the value of the fileReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtFileReference }
     *     
     */
    public void setFileReference(CtFileReference value) {
        this.fileReference = value;
    }

}
