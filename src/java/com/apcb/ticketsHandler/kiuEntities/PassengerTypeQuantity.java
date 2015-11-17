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
@XmlRootElement
public class PassengerTypeQuantity {
    private String Code;
    private int Quantity;

    public String getCode() {
        return Code;
    }
    @XmlAttribute(name = "Code")
    public void setCode(String code) {
        this.Code = code;
    }

    public int getQuantity() {
        return Quantity;
    }
    @XmlAttribute(name = "Quantity")
    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
    
    
    
}
