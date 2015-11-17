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
@XmlRootElement(name = "AirItinerary")
public class AirItinerary {
    private String DepartureDateTime;
    private Location OriginLocation;
    private Location DestinationLocation;
    private OriginDestinationOptions OriginDestinationOptions; 

    public String getDepartureDateTime() {
        return DepartureDateTime;
    }
    @XmlElement(name="DepartureDateTime")
    public void setDepartureDateTime(String departureDateTime) {
        this.DepartureDateTime = departureDateTime;
    }
    
    public Location getOriginLocation() {
        return OriginLocation;
    }
    @XmlElement(name = "OriginLocation")
    public void setOriginLocation(Location originLocation) {
        this.OriginLocation = originLocation;
    }

    public Location getDestinationLocation() {
        return DestinationLocation;
    }
    @XmlElement(name = "DestinationLocation")
    public void setDestinationLocation(Location destinationLocation) {
        this.DestinationLocation = destinationLocation;
    }

    public OriginDestinationOptions getOriginDestinationOptions() {
        return OriginDestinationOptions;
    }
    @XmlElement(name = "OriginDestinationOptions")
    public void setOriginDestinationOptions(OriginDestinationOptions originDestinationOptions) {
        this.OriginDestinationOptions = originDestinationOptions;
    }
    
    
    
}
