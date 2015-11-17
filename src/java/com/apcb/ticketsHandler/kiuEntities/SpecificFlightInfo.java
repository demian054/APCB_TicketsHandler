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
public class SpecificFlightInfo {
    private Airline Airline;

    public Airline getAirline() {
        return Airline;
    }
    @XmlElement(name = "Airline")
    public void setAirline(Airline airline) {
        this.Airline = airline;
    }
    
    
    
}
