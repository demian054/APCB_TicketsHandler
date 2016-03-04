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
public class UniqueId {
    private String Type;
    private String ID;
    private String CompanyName;

    public String getType() {
        return Type;
    }
    @XmlAttribute(name="Type")
    public void setType(String Type) {
        this.Type = Type;
    }

    public String getID() {
        return ID;
    }
    @XmlAttribute(name="ID")
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCompanyName() {
        return CompanyName;
    }
    
    @XmlAttribute(name="CompanyName")
    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

}
