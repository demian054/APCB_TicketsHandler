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
@XmlRootElement(name = "AirItineraryPricingInfo")
public class AirItineraryPricingInfo {
    
    ItemFare ItinTotalFare;
    PTC_FareBreakdowns PTC_FareBreakdowns;

    public ItemFare getItinTotalFare() {
        return ItinTotalFare;
    }
    @XmlElement(name = "ItinTotalFare")
    public void setItinTotalFare(ItemFare ItinTotalFare) {
        this.ItinTotalFare = ItinTotalFare;
    }

    public PTC_FareBreakdowns getPTC_FareBreakdowns() {
        return PTC_FareBreakdowns;
    }
    @XmlElement(name = "PTC_FareBreakdowns")
    public void setPTC_FareBreakdowns(PTC_FareBreakdowns PTC_FareBreakdowns) {
        this.PTC_FareBreakdowns = PTC_FareBreakdowns;
    }
    
    
    
    
}
