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
@XmlRootElement(name = "ItineraryInfo")
public class ItineraryInfo {
    private ReservationItems ReservationItems;
    private ItineraryPricing ItineraryPricing;
    private Ticketing Ticketing;
    
    

    public ReservationItems getReservationItems() {
        return ReservationItems;
    }
    @XmlElement(name = "ItineraryInfo")
    public void setReservationItems(ReservationItems ReservationItems) {
        this.ReservationItems = ReservationItems;
    }

    public ItineraryPricing getItineraryPricing() {
        return ItineraryPricing;
    }
    @XmlElement(name = "ItineraryPricing")
    public void setItineraryPricing(ItineraryPricing ItineraryPricing) {
        this.ItineraryPricing = ItineraryPricing;
    }

    public Ticketing getTicketing() {
        return Ticketing;
    }
    @XmlElement(name = "Ticketing")
    public void setTicketing(Ticketing Ticketing) {
        this.Ticketing = Ticketing;
    }
    
    
    
    
}
