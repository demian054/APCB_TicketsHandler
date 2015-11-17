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
public class Airline {
    private String Code;

    public String getCode() {
        return Code;
    }
    @XmlAttribute(name="Code") 
    public void setCode(String Code) {
        this.Code = Code;
    }
 
}
