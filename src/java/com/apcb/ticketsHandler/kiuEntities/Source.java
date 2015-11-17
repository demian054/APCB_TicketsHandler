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
@XmlRootElement
public class Source {
    private String AgentSine;
    private String TerminalID;
    private String PseudoCityCode;
    private String ISOCountry;
    private String ISOCurrency;
    private Property RequestorID;
    private Property BookingChannel;
    
    
    public String getAgentSine() {
        return AgentSine;
    }
    @XmlAttribute(name = "AgentSine")
    public void setAgentSine(String AgentSine) {
        this.AgentSine = AgentSine;
    }

    public String getTerminalID() {
        return TerminalID;
    }
    @XmlAttribute(name = "TerminalID")
    public void setTerminalID(String TerminalID) {
        this.TerminalID = TerminalID;
    }

    public String getPseudoCityCode() {
        return PseudoCityCode;
    }
    @XmlAttribute(name = "PseudoCityCode")
    public void setPseudoCityCode(String PseudoCityCode) {
        this.PseudoCityCode = PseudoCityCode;
    }

    public String getISOCountry() {
        return ISOCountry;
    }
    @XmlAttribute(name = "ISOCountry")
    public void setISOCountry(String ISOCountry) {
        this.ISOCountry = ISOCountry;
    }

    public String getISOCurrency() {
        return ISOCurrency;
    }
    @XmlAttribute(name = "ISOCurrency")
    public void setISOCurrency(String ISOCurrency) {
        this.ISOCurrency = ISOCurrency;
    }

    public Property getRequestorID() {
        return RequestorID;
    }
    @XmlElement(name = "RequestorID")
    public void setRequestorID(Property RequestorID) {
        this.RequestorID = RequestorID;
    }

    public Property getBookingChannel() {
        return BookingChannel;
    }
    @XmlElement(name = "BookingChannel")
    public void setBookingChannel(Property BookingChannel) {
        this.BookingChannel = BookingChannel;
    }
    
    
    
}
