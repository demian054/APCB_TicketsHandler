/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Demian
 */
@XmlRootElement
public class Location {
    
    private String LocationCode;
    private String AltLocationCode;

    public String getLocationCode() {
        return LocationCode;
    }
    @XmlAttribute(name="LocationCode")
    public void setLocationCode(String locationCode) {
        this.LocationCode = locationCode;
    }
    
    
    public String getAltLocationCode() {
        return AltLocationCode;
    }
    @XmlValue
    public void setAltLocationCode(String AltLocationCode) {
        this.AltLocationCode = AltLocationCode;
    }
    
    
}
