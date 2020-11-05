
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ссылка на файл - скан документа
 * 
 * <p>Java class for ct_FileReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_FileReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mqReference" type="{http://www.raiffeisen.ru/types/Document/v1}ct_MQFileReference" minOccurs="0"/>
 *         &lt;element name="jasperReference" type="{http://www.raiffeisen.ru/types/Document/v1}ct_JasperFileReference" minOccurs="0"/>
 *         &lt;element name="rollbackInError" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mqPagesReference" type="{http://www.raiffeisen.ru/types/Document/v1}ct_mqPagesReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_FileReference", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "type",
    "extension",
    "mqReference",
    "jasperReference",
    "rollbackInError",
    "mqPagesReference"
})
public class CtFileReference {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected String type;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String extension;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtMQFileReference mqReference;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtJasperFileReference jasperReference;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected Boolean rollbackInError;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected CtMqPagesReference mqPagesReference;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Gets the value of the mqReference property.
     * 
     * @return
     *     possible object is
     *     {@link CtMQFileReference }
     *     
     */
    public CtMQFileReference getMqReference() {
        return mqReference;
    }

    /**
     * Sets the value of the mqReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtMQFileReference }
     *     
     */
    public void setMqReference(CtMQFileReference value) {
        this.mqReference = value;
    }

    /**
     * Gets the value of the jasperReference property.
     * 
     * @return
     *     possible object is
     *     {@link CtJasperFileReference }
     *     
     */
    public CtJasperFileReference getJasperReference() {
        return jasperReference;
    }

    /**
     * Sets the value of the jasperReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtJasperFileReference }
     *     
     */
    public void setJasperReference(CtJasperFileReference value) {
        this.jasperReference = value;
    }

    /**
     * Gets the value of the rollbackInError property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRollbackInError() {
        return rollbackInError;
    }

    /**
     * Sets the value of the rollbackInError property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRollbackInError(Boolean value) {
        this.rollbackInError = value;
    }

    /**
     * Gets the value of the mqPagesReference property.
     * 
     * @return
     *     possible object is
     *     {@link CtMqPagesReference }
     *     
     */
    public CtMqPagesReference getMqPagesReference() {
        return mqPagesReference;
    }

    /**
     * Sets the value of the mqPagesReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtMqPagesReference }
     *     
     */
    public void setMqPagesReference(CtMqPagesReference value) {
        this.mqPagesReference = value;
    }

}
