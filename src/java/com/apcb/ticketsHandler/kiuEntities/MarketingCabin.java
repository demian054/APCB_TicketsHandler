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
public class MarketingCabin {
    private String CabinType;
    private String RPH;

    public String getCabinType() {
        return CabinType;
    }
    @XmlAttribute(name="CabinType")
    public void setCabinType(String cabinType) {
        this.CabinType = cabinType;
    }

    public String getRPH() {
        return RPH;
    }
    @XmlAttribute(name="RPH")
    public void setRPH(String rPH) {
        this.RPH = rPH;
    }
    
    
    
}
