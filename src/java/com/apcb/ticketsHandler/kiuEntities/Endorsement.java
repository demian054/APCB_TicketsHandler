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
@XmlRootElement(name="Endorsement")
public class Endorsement {
    private String Info;

    public String getInfo() {
        return Info;
    }
    @XmlAttribute(name="Info")
    public void setInfo(String Info) {
        this.Info = Info;
    }
    
    
}
