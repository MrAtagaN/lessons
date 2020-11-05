
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Запрос на Создание документа
 * 
 * <p>Java class for ct_CreateDocumentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_CreateDocumentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificators" type="{http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1}ct_Identificators"/>
 *         &lt;element name="document" type="{http://www.raiffeisen.ru/types/Document/v1}ct_Document"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_CreateDocumentRequest", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "identificators",
    "document"
})
public class CtCreateDocumentRequest {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtIdentificators identificators;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtDocument document;

    /**
     * Gets the value of the identificators property.
     * 
     * @return
     *     possible object is
     *     {@link CtIdentificators }
     *     
     */
    public CtIdentificators getIdentificators() {
        return identificators;
    }

    /**
     * Sets the value of the identificators property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtIdentificators }
     *     
     */
    public void setIdentificators(CtIdentificators value) {
        this.identificators = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link CtDocument }
     *     
     */
    public CtDocument getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtDocument }
     *     
     */
    public void setDocument(CtDocument value) {
        this.document = value;
    }

}
