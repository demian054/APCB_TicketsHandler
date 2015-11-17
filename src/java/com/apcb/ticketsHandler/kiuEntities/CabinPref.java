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
public class CabinPref {
    private String Cabin;

    public String getCabin() {
        return Cabin;
    }
    @XmlAttribute(name="Cabin")
    public void setCabin(String cabin) {
        this.Cabin = cabin;
    }
    
    
    
}
