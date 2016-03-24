/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "CustomerInfo")
public class CustomerInfo {
    private int RPH;
    private Customer Customer;

    public int getRPH() {
        return RPH;
    }
    @XmlAttribute(name = "RPH")
    public void setRPHM(int RPH) {
        this.RPH = RPH;
    }

    public Customer getCustomer() {
        return Customer;
    }
    @XmlElement(name = "Customer")
    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }
    
    
    
    
    
     
}
