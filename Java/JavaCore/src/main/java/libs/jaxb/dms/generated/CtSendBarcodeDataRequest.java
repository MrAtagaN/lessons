
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Отправка данных ШК
 * 
 * <p>Java class for ct_SendBarcodeDataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_SendBarcodeDataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificators" type="{http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1}ct_Identificators"/>
 *         &lt;element name="barcodeData" type="{http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1}ct_BarcodeData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_SendBarcodeDataRequest", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "identificators",
    "barcodeData"
})
public class CtSendBarcodeDataRequest {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtIdentificators identificators;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtBarcodeData barcodeData;

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
     * Gets the value of the barcodeData property.
     * 
     * @return
     *     possible object is
     *     {@link CtBarcodeData }
     *     
     */
    public CtBarcodeData getBarcodeData() {
        return barcodeData;
    }

    /**
     * Sets the value of the barcodeData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtBarcodeData }
     *     
     */
    public void setBarcodeData(CtBarcodeData value) {
        this.barcodeData = value;
    }

}
