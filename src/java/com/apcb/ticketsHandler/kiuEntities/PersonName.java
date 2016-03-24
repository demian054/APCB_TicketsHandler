/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "PersonName")
public class PersonName {
    private String NamePrefix;
    private String Surname;
    private String GivenName;
    private String MiddleName;

    public String getSurname() {
        return Surname;
    }
    @XmlElement(name = "Surname")
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getGivenName() {
        return GivenName;
    }
    @XmlElement(name = "GivenName")
    public void setGivenName(String GivenName) {
        this.GivenName = GivenName;
    }

    public String getNamePrefix() {
        return NamePrefix;
    }
    @XmlElement(name = "NamePrefix")
    public void setNamePrefix(String NamePrefix) {
        this.NamePrefix = NamePrefix;
    }

    public String getMiddleName() {
        return MiddleName;
    }
    @XmlElement(name = "MiddleName")
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }
    
}
