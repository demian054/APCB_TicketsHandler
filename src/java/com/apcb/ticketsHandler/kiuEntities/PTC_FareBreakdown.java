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
@XmlRootElement(name = "PTC_FareBreakdown")
class PTC_FareBreakdown {
    
    PassengerTypeQuantity PassengerTypeQuantity;
    ItemFare PassengerFare;  

    public PassengerTypeQuantity getPassengerTypeQuantity() {
        return PassengerTypeQuantity;
    }
    @XmlElement(name = "PassengerTypeQuantity")
    public void setPassengerTypeQuantity(PassengerTypeQuantity PassengerTypeQuantity) {
        this.PassengerTypeQuantity = PassengerTypeQuantity;
    }

    public ItemFare getPassengerFare() {
        return PassengerFare;
    }
    @XmlElement(name = "PassengerFare")
    public void setPassengerFare(ItemFare PassengerFare) {
        this.PassengerFare = PassengerFare;
    }
    
}
