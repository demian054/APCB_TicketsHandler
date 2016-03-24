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
@XmlRootElement(name="Ticketing")
public class Ticketing {
    Integer TicketTimeLimit;
    String TicketAdvisory;

    public Integer getTicketTimeLimit() {
        return TicketTimeLimit;
    }
    @XmlAttribute(name = "TicketTimeLimit")
    public void setTicketTimeLimit(Integer TicketTimeLimit) {
        this.TicketTimeLimit = TicketTimeLimit;
    }

    public String getTicketAdvisory() {
        return TicketAdvisory;
    }

    @XmlElement(name = "TicketAdvisory")
    public void setTicketAdvisory(String TicketAdvisory) {
        this.TicketAdvisory = TicketAdvisory;
    }
    
    
    
}
