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
public class OriginDestinationOption {
    private FlightSegment FlightSegment;

    public FlightSegment getFlightSegment() {
        return FlightSegment;
    }
    @XmlElement(name = "FlightSegment")
    public void setFlightSegment(FlightSegment flightSegment) {
        this.FlightSegment = flightSegment;
    }
    
 
}
