
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Атрибуты профайла документа
 * 
 * <p>Java class for ct_DocumentProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DocumentProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="docNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastEditTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastAccessTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="authorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typistId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typistName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastEditUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastEditUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastAccessUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastAccessUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="abstract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentType" type="{http://www.raiffeisen.ru/types/Document/v1}ct_DocumentType" minOccurs="0"/>
 *         &lt;element name="customFields" type="{http://www.raiffeisen.ru/types/CustomField/v1}ct_CustomFieldList" minOccurs="0"/>
 *         &lt;element name="isCertified" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DocumentProfile", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "docNumber",
    "docName",
    "createTime",
    "lastEditTime",
    "lastAccessTime",
    "authorId",
    "authorName",
    "authorFullName",
    "typistId",
    "typistName",
    "lastEditUserId",
    "lastEditUserName",
    "lastAccessUserId",
    "lastAccessUserName",
    "appId",
    "appExtension",
    "retention",
    "status",
    "defaultForm",
    "_abstract",
    "storage",
    "documentType",
    "customFields",
    "isCertified"
})
public class CtDocumentProfile {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docNumber;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String docName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastEditTime;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastAccessTime;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String authorId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String authorName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String authorFullName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String typistId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String typistName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String lastEditUserId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String lastEditUserName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String lastAccessUserId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String lastAccessUserName;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String appId;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String appExtension;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String retention;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String status;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String defaultForm;
    @XmlElement(name = "abstract", namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String _abstract;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String storage;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtDocumentType documentType;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtCustomFieldList customFields;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected Boolean isCertified;

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
     * Gets the value of the docName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocName() {
        return docName;
    }

    /**
     * Sets the value of the docName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocName(String value) {
        this.docName = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the lastEditTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastEditTime() {
        return lastEditTime;
    }

    /**
     * Sets the value of the lastEditTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastEditTime(XMLGregorianCalendar value) {
        this.lastEditTime = value;
    }

    /**
     * Gets the value of the lastAccessTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * Sets the value of the lastAccessTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastAccessTime(XMLGregorianCalendar value) {
        this.lastAccessTime = value;
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
     * Gets the value of the authorFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorFullName() {
        return authorFullName;
    }

    /**
     * Sets the value of the authorFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorFullName(String value) {
        this.authorFullName = value;
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
     * Gets the value of the lastEditUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastEditUserId() {
        return lastEditUserId;
    }

    /**
     * Sets the value of the lastEditUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastEditUserId(String value) {
        this.lastEditUserId = value;
    }

    /**
     * Gets the value of the lastEditUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastEditUserName() {
        return lastEditUserName;
    }

    /**
     * Sets the value of the lastEditUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastEditUserName(String value) {
        this.lastEditUserName = value;
    }

    /**
     * Gets the value of the lastAccessUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastAccessUserId() {
        return lastAccessUserId;
    }

    /**
     * Sets the value of the lastAccessUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastAccessUserId(String value) {
        this.lastAccessUserId = value;
    }

    /**
     * Gets the value of the lastAccessUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastAccessUserName() {
        return lastAccessUserName;
    }

    /**
     * Sets the value of the lastAccessUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastAccessUserName(String value) {
        this.lastAccessUserName = value;
    }

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the value of the appExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppExtension() {
        return appExtension;
    }

    /**
     * Sets the value of the appExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppExtension(String value) {
        this.appExtension = value;
    }

    /**
     * Gets the value of the retention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetention() {
        return retention;
    }

    /**
     * Sets the value of the retention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetention(String value) {
        this.retention = value;
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
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbstract(String value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the storage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorage(String value) {
        this.storage = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link CtDocumentType }
     *     
     */
    public CtDocumentType getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDocumentType }
     *     
     */
    public void setDocumentType(CtDocumentType value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the customFields property.
     * 
     * @return
     *     possible object is
     *     {@link CtCustomFieldList }
     *     
     */
    public CtCustomFieldList getCustomFields() {
        return customFields;
    }

    /**
     * Sets the value of the customFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtCustomFieldList }
     *     
     */
    public void setCustomFields(CtCustomFieldList value) {
        this.customFields = value;
    }

    /**
     * Gets the value of the isCertified property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCertified() {
        return isCertified;
    }

    /**
     * Sets the value of the isCertified property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCertified(Boolean value) {
        this.isCertified = value;
    }

}
