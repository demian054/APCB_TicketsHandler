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
public class Property {
    private String Code;
    private String Type;
    //no borrar lo necesita el parse a xml
    public Property() {}

    public Property(String Code, String Type) {
        this.Code = Code;
        this.Type = Type;
    }

    public Property(String Type) {
        this.Type = Type;
    }
    
    public String getCode() {
        return Code;
    }
    @XmlAttribute(name = "Code")
    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getType() {
        return Type;
    }
    @XmlAttribute(name = "Type")
    public void setType(String Type) {
        this.Type = Type;
    }
    
    
    
}
