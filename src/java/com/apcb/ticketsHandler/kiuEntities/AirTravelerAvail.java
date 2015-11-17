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
@XmlRootElement
public class AirTravelerAvail {
    
    private List<PassengerTypeQuantity> PassengerTypeQuantity;

    public List<PassengerTypeQuantity> getPassengerTypeQuantity() {
        return PassengerTypeQuantity;
    }
    @XmlElement(name="PassengerTypeQuantity")
    public void setPassengerTypeQuantity(List<PassengerTypeQuantity> passengerTypeQuantity) {
        this.PassengerTypeQuantity = passengerTypeQuantity;
    }
  
}
