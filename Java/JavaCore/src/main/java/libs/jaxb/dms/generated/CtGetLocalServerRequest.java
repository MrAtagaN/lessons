
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Запрос на поиск ближайшего сервера DMS
 * 
 * <p>Java class for ct_GetLocalServerRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_GetLocalServerRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificators" type="{http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1}ct_Identificators"/>
 *         &lt;element name="userLocationInfo" type="{http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1}ct_UserLocationInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_GetLocalServerRequest", namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", propOrder = {
    "identificators",
    "userLocationInfo"
})
public class CtGetLocalServerRequest {

    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtIdentificators identificators;
    @XmlElement(namespace = "http://www.raiffeisen.ru/esb/cnr/RBP/Document/v1", required = true)
    protected CtUserLocationInfo userLocationInfo;

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
     * Gets the value of the userLocationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CtUserLocationInfo }
     *     
     */
    public CtUserLocationInfo getUserLocationInfo() {
        return userLocationInfo;
    }

    /**
     * Sets the value of the userLocationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtUserLocationInfo }
     *     
     */
    public void setUserLocationInfo(CtUserLocationInfo value) {
        this.userLocationInfo = value;
    }

}
