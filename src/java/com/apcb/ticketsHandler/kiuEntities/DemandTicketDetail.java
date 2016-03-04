/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="DemandTicketDetail")
public class DemandTicketDetail {
    private String TourCode;
    
    public String getTourCode() {
        return TourCode;
    }
    @XmlAttribute(name="EchoToken")
    public void setTourCode(String TourCode) {
        this.TourCode = TourCode;
    }
    
    private UniqueId BookingReferenceID;    
    private PaymentInfo PaymentInfo;
    private Endorsement Endorsement;


    public UniqueId getBookingReferenceID() {
        return BookingReferenceID;
    }
    @XmlElement(name = "BookingReferenceID")
    public void setBookingReferenceID(UniqueId BookingReferenceID) {
        this.BookingReferenceID = BookingReferenceID;
    }

    public PaymentInfo getPaymentInfo() {
        return PaymentInfo;
    }
    @XmlElement(name = "PaymentInfo")
    public void setPaymentInfo(PaymentInfo PaymentInfo) {
        this.PaymentInfo = PaymentInfo;
    }

    public Endorsement getEndorsement() {
        return Endorsement;
    }
    @XmlElement(name = "Endorsement")
    public void setEndorsement(Endorsement Endorsement) {
        this.Endorsement = Endorsement;
    }

}
