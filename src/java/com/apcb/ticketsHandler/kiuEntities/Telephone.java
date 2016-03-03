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
@XmlRootElement(name = "Telephone")
public class Telephone {
    private String AreaCityCode;
    private String PhoneNumber;
    
    public String getAreaCityCode() {
        return AreaCityCode;
    }
    
    @XmlAttribute(name = "AreaCityCode")
    public void setAreaCityCode(String AreaCityCode) {
        this.AreaCityCode = AreaCityCode;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    
    @XmlAttribute(name = "PhoneNumber")
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
        
}
