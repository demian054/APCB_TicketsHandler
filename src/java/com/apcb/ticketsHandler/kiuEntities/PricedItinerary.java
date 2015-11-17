/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "PricedItinerary")
public class PricedItinerary {
    String SequenceNumber;
    AirItinerary AirItinerary;
    AirItineraryPricingInfo AirItineraryPricingInfo;

    public String getSequenceNumber() {
        return SequenceNumber;
    }
    @XmlAttribute(name = "SequenceNumber")
    public void setSequenceNumber(String SequenceNumber) {
        this.SequenceNumber = SequenceNumber;
    }

    public AirItinerary getAirItinerary() {
        return AirItinerary;
    }
    @XmlElement(name = "AirItinerary")
    public void setAirItinerary(AirItinerary AirItinerary) {
        this.AirItinerary = AirItinerary;
    }
    
    public AirItineraryPricingInfo getAirItineraryPricingInfo() {
        return AirItineraryPricingInfo;
    }
    @XmlElement(name = "AirItineraryPricingInfo")
    public void setAirItineraryPricingInfo(AirItineraryPricingInfo AirItineraryPricingInfo) {
        this.AirItineraryPricingInfo = AirItineraryPricingInfo;
    }
    
    
    
    
}
