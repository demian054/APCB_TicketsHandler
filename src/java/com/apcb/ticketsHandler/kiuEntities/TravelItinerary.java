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
@XmlRootElement(name = "TravelItinerary")
public class TravelItinerary {
    UniqueId ItineraryRef;
    CustomerInfos CustomerInfos;
    ItineraryInfo ItineraryInfo;

    public UniqueId getItineraryRef() {
        return ItineraryRef;
    }
    @XmlElement(name = "ItineraryRef")
    public void setItineraryRef(UniqueId ItineraryRef) {
        this.ItineraryRef = ItineraryRef;
    }

    public CustomerInfos getCustomerInfos() {
        return CustomerInfos;
    }
    @XmlElement(name = "CustomerInfos")
    public void setCustomerInfos(CustomerInfos CustomerInfos) {
        this.CustomerInfos = CustomerInfos;
    }
    
    
    
    
    
    
}
