
package com.easyway.covid19.model;

import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Message"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Error" type="{}Error" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
    "error",
    "timestamp"
})
@XmlSeeAlso({
    Response.StatusMessage.class
})
public abstract class Message
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "Error")
    protected List<Error> error;
    @XmlElement(name = "Timestamp")
    protected Long timestamp;

    /**
     * Gets the value of the error property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the error property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Error }
     * 
     * 
     */
    public List<Error> getError() {
        if (error == null) {
            error = new ArrayList<Error>();
        }
        return this.error;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            List<Error> theError;
            theError = (((this.error!= null)&&(!this.error.isEmpty()))?this.getError():null);
            strategy.appendField(locator, this, "error", buffer, theError);
        }
        {
            Long theTimestamp;
            theTimestamp = this.getTimestamp();
            strategy.appendField(locator, this, "timestamp", buffer, theTimestamp);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Message)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Message that = ((Message) object);
        {
            List<Error> lhsError;
            lhsError = (((this.error!= null)&&(!this.error.isEmpty()))?this.getError():null);
            List<Error> rhsError;
            rhsError = (((that.error!= null)&&(!that.error.isEmpty()))?that.getError():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "error", lhsError), LocatorUtils.property(thatLocator, "error", rhsError), lhsError, rhsError)) {
                return false;
            }
        }
        {
            Long lhsTimestamp;
            lhsTimestamp = this.getTimestamp();
            Long rhsTimestamp;
            rhsTimestamp = that.getTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timestamp", lhsTimestamp), LocatorUtils.property(thatLocator, "timestamp", rhsTimestamp), lhsTimestamp, rhsTimestamp)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<Error> theError;
            theError = (((this.error!= null)&&(!this.error.isEmpty()))?this.getError():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "error", theError), currentHashCode, theError);
        }
        {
            Long theTimestamp;
            theTimestamp = this.getTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timestamp", theTimestamp), currentHashCode, theTimestamp);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        if (null == target) {
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");
        }
        if (target instanceof Message) {
            final Message copy = ((Message) target);
            if ((this.error!= null)&&(!this.error.isEmpty())) {
                List<Error> sourceError;
                sourceError = (((this.error!= null)&&(!this.error.isEmpty()))?this.getError():null);
                @SuppressWarnings("unchecked")
                List<Error> copyError = ((List<Error> ) strategy.copy(LocatorUtils.property(locator, "error", sourceError), sourceError));
                copy.error = null;
                if (copyError!= null) {
                    List<Error> uniqueErrorl = copy.getError();
                    uniqueErrorl.addAll(copyError);
                }
            } else {
                copy.error = null;
            }
            if (this.timestamp!= null) {
                Long sourceTimestamp;
                sourceTimestamp = this.getTimestamp();
                Long copyTimestamp = ((Long) strategy.copy(LocatorUtils.property(locator, "timestamp", sourceTimestamp), sourceTimestamp));
                copy.setTimestamp(copyTimestamp);
            } else {
                copy.timestamp = null;
            }
        }
        return target;
    }

    public void setError(List<Error> value) {
        this.error = null;
        List<Error> draftl = this.getError();
        draftl.addAll(value);
    }

}
