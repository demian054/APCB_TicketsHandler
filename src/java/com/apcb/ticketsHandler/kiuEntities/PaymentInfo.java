/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="PaymentInfo")
public class PaymentInfo {
    private Integer PaymentType;

    public Integer getPaymentType() {
        return PaymentType;
    }
    @XmlAttribute(name="PaymentType")
    public void setPaymentType(Integer PaymentType) {
        this.PaymentType = PaymentType;
    }
 
    private CreditCardInfo CreditCardInfo;
    private ValueAddedTax ValueAddedTax;
    
    public CreditCardInfo getCreditCardInfo() {
        return CreditCardInfo;
    }
    @XmlElement(name = "CreditCardInfo")
    public void setCreditCardInfo(CreditCardInfo CreditCardInfo) {
        this.CreditCardInfo = CreditCardInfo;
    }

    public ValueAddedTax getValueAddedTax() {
        return ValueAddedTax;
    }
    @XmlElement(name = "ValueAddedTax")
    public void setValueAddedTax(ValueAddedTax ValueAddedTax) {
        this.ValueAddedTax = ValueAddedTax;
    }
    
    
    
    
}
