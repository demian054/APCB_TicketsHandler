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
@XmlRootElement
public class Verification {
    String Email;
    String Telephone;

    public String getEmail() {
        return Email;
    }

    @XmlElement(name = "Email")
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    public String getTelephone() {
        return Telephone;
    }

    @XmlElement(name = "Telephone")
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }
    
    
    
}
