/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "Warning")
public class Warning {
    String Type;
    String Message;

    public String getType() {
        return Type;
    }
    @XmlAttribute(name = "Type")
    public void setType(String Type) {
        this.Type = Type;
    }

    public String getMessage() {
        return Message;
    }
    @XmlValue
    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    
    
    
    
}
