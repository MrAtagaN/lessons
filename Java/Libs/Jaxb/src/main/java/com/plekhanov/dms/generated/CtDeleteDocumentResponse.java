
package com.plekhanov.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Результат удаления документа (номер удаленного документа)
 * 
 * <p>Java class for ct_DeleteDocumentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_DeleteDocumentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="document" type="{http://www.raiffeisen.ru/types/Document/v1}ct_Document" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_DeleteDocumentResponse", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "document"
})
public class CtDeleteDocumentResponse {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1")
    protected CtDocument document;

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
