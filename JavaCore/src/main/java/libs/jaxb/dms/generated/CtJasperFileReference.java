
package libs.jaxb.dms.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ct_JasperFileReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ct_JasperFileReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outputFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parameters" type="{http://www.raiffeisen.ru/types/Document/v1}ct_JasperParameterList"/>
 *         &lt;element name="jasperVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ct_JasperFileReference", namespace = "http://www.raiffeisen.ru/types/Document/v1", propOrder = {
    "reportPath",
    "outputFormat",
    "parameters",
    "jasperVersion"
})
public class CtJasperFileReference {

    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected String reportPath;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected String outputFormat;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1", required = true)
    protected CtJasperParameterList parameters;
    @XmlElement(namespace = "http://www.raiffeisen.ru/types/Document/v1")
    protected String jasperVersion;

    /**
     * Gets the value of the reportPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPath() {
        return reportPath;
    }

    /**
     * Sets the value of the reportPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPath(String value) {
        this.reportPath = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link CtJasperParameterList }
     *     
     */
    public CtJasperParameterList getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtJasperParameterList }
     *     
     */
    public void setParameters(CtJasperParameterList value) {
        this.parameters = value;
    }

    /**
     * Gets the value of the jasperVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJasperVersion() {
        return jasperVersion;
    }

    /**
     * Sets the value of the jasperVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJasperVersion(String value) {
        this.jasperVersion = value;
    }

}
