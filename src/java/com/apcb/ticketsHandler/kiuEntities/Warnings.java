/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "Warnings")
public class Warnings {
    
    List<Warning> Warning;

    public List<Warning> getWarning() {
        return Warning;
    }
    @XmlElement(name = "Warning")
    public void setWarning(List<Warning> Warning) {
        this.Warning = Warning;
    }
    
    
    
    
}
