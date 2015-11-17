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
@XmlRootElement(name = "PricedItineraries")
public class PricedItineraries {
    private PricedItinerary PricedItinerary;

    
    public PricedItinerary getPricedItinerary() {
        return PricedItinerary;
    }
    @XmlElement(name = "PricedItinerary")
    public void setPricedItinerary(PricedItinerary PricedItinerary) {
        this.PricedItinerary = PricedItinerary;
    }
    
    
    
}
