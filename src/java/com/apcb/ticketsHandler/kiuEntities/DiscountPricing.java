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
public class DiscountPricing {
    String TicketDesignatorCode;

    public String getTicketDesignatorCode() {
        return TicketDesignatorCode;
    }
    @XmlAttribute(name = "TicketDesignatorCode")
    public void setTicketDesignatorCode(String TicketDesignatorCode) {
        this.TicketDesignatorCode = TicketDesignatorCode;
    }
    
    
    
            
    
}
