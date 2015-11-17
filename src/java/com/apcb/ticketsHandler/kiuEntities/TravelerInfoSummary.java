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
public class TravelerInfoSummary {
    private AirTravelerAvail AirTravelerAvail;
    private PaymentDetail PaymentDetail;
    private PriceRequestInformation PriceRequestInformation;

    public AirTravelerAvail getAirTravelerAvail() {
        return AirTravelerAvail;
    }                  
    @XmlElement(name = "AirTravelerAvail")
    public void setAirTravelerAvail(AirTravelerAvail airTravelerAvail) {
        this.AirTravelerAvail = airTravelerAvail;
    }

    public PaymentDetail getPaymentDetail() {
        return PaymentDetail;
    }
    @XmlElement(name = "PaymentDetail")
    public void setPaymentDetail(PaymentDetail PaymentDetail) {
        this.PaymentDetail = PaymentDetail;
    }

    public PriceRequestInformation getPriceRequestInformation() {
        return PriceRequestInformation;
    }
    @XmlElement(name = "PriceRequestInformation")
    public void setPriceRequestInformation(PriceRequestInformation PriceRequestInformation) {
        this.PriceRequestInformation = PriceRequestInformation;
    }
    
    
    
    
    
    
    
}
