/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import com.apcb.ticketsHandler.kiuEntities.AirTraveler;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="TravelerInfo")
public class TravelerInfo {
    List<AirTraveler> AirTraveler;

    public List<AirTraveler> getAirTraveler() {
        return AirTraveler;
    }
    @XmlElement(name = "AirTraveler")
    public void setAirTraveler(List<AirTraveler> AirTraveler) {
        this.AirTraveler = AirTraveler;
    }
    
    
    
}
