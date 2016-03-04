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
@XmlRootElement(name="ValueAddedTax")
public class ValueAddedTax {
    String VAT;

    public String getVAT() {
        return VAT;
    }
    @XmlAttribute(name="VAT")
    public void setVAT(String VAT) {
        this.VAT = VAT;
    }
    
    
}
