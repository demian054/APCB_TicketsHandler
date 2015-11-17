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
@XmlRootElement(name = "Air")
public class Air {
    private Reservation Reservation;

    public Reservation getReservation() {
        return Reservation;
    }
    @XmlElement(name = "Reservation")
    public void setReservation(Reservation Reservation) {
        this.Reservation = Reservation;
    }
    
    
}
