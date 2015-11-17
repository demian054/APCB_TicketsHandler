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
@XmlRootElement
public class TravelPreferences {
    private String MaxStopsQuantity;
    private CabinPref CabinPref;

    public String getMaxStopsQuantity() {
        return MaxStopsQuantity;
    }
    @XmlAttribute(name = "MaxStopsQuantity")
    public void setMaxStopsQuantity(String maxStopsQuantity) {
        this.MaxStopsQuantity = maxStopsQuantity;
    }
    
    public CabinPref getCabinPref() {
        return CabinPref;
    }
    @XmlElement(name = "CabinPref")
    public void setCabinPref(CabinPref cabinPref) {
        this.CabinPref = cabinPref;
    }
    
    
    
}
