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
@XmlRootElement(name = "CustomerInfo")
public class CustomerInfo {
    private int RPHM;
    private Customer Customer;

    public int getRPHM() {
        return RPHM;
    }
    @XmlAttribute(name = "CustomerInfo")
    public void setRPHM(int RPHM) {
        this.RPHM = RPHM;
    }

    public Customer getCustomer() {
        return Customer;
    }
    @XmlElement(name = "CustomerInfo")
    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }
    
    
    
    
    
     
}
