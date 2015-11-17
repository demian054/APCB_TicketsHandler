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
@XmlRootElement(name = "Item")
public class Item {
    private int ItinSeqNumber;
    private Air Air;

    public int getItinSeqNumber() {
        return ItinSeqNumber;
    }
    @XmlAttribute(name = "ItinSeqNumber")
    public void setItinSeqNumber(int ItinSeqNumber) {
        this.ItinSeqNumber = ItinSeqNumber;
    }

    public Air getAir() {
        return Air;
    }
    @XmlElement(name = "Air")
    public void setAir(Air Air) {
        this.Air = Air;
    }
    
    
    
}
