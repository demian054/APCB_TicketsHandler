/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "Tax")
public class Tax {
    String Amount;
    String TaxCode;
    String CurrencyCode;

    public String getAmount() {
        return Amount;
    }
    @XmlAttribute(name = "Amount")
    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getTaxCode() {
        return TaxCode;
    }
    @XmlAttribute(name = "TaxCode")
    public void setTaxCode(String TaxCode) {
        this.TaxCode = TaxCode;
    }
    
    public String getCurrencyCode() {
        return CurrencyCode;
    }
    @XmlAttribute(name = "CurrencyCode")
    public void setCurrencyCode(String CurrencyCode) {
        this.CurrencyCode = CurrencyCode;
    }
    

}
