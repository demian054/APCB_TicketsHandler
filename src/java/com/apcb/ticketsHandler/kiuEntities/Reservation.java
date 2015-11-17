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
@XmlRootElement(name = "Reservation")
public class Reservation {
    private String DepartureDateTime;
    private int FlightNumber;
    private String ResBookDesigCode;
    
    private Location DepartureAirport;
    private Location ArrivalAirport;
    private String MarketingAirline;
    
    public String getDepartureDateTime() {
        return DepartureDateTime;
    }
    @XmlAttribute(name = "DepartureDateTime")
    public void setDepartureDateTime(String DepartureDateTime) {
        this.DepartureDateTime = DepartureDateTime;
    }

    public int getFlightNumber() {
        return FlightNumber;
    }
    @XmlAttribute(name = "FlightNumber")
    public void setFlightNumber(int FlightNumber) {
        this.FlightNumber = FlightNumber;
    }

    public String getResBookDesigCode() {
        return ResBookDesigCode;
    }
    @XmlAttribute(name = "ResBookDesigCode")
    public void setResBookDesigCode(String ResBookDesigCode) {
        this.ResBookDesigCode = ResBookDesigCode;
    }

    public Location getDepartureAirport() {
        return DepartureAirport;
    }
    @XmlElement(name = "DepartureAirport")
    public void setDepartureAirport(Location DepartureAirport) {
        this.DepartureAirport = DepartureAirport;
    }

    public Location getArrivalAirport() {
        return ArrivalAirport;
    }
    @XmlElement(name = "ArrivalAirport")
    public void setArrivalAirport(Location ArrivalAirport) {
        this.ArrivalAirport = ArrivalAirport;
    }

    public String getMarketingAirline() {
        return MarketingAirline;
    }
    @XmlElement(name = "MarketingAirline")
    public void setMarketingAirline(String MarketingAirline) {
        this.MarketingAirline = MarketingAirline;
    }
    
    
    
}
