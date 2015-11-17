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
@XmlRootElement
public class FlightSegment {
    private String DepartureDateTime;
    private String ArrivalDateTime;
    private String StopQuantity;
    private String FlightNumber;
    private String JourneyDuration;
    private String ResBookDesigCode;
    /***Elements**/
    private Location DepartureAirport;
    private Location ArrivalAirport;
    private Equipment Equipment;
    private Property MarketingAirline;
    private Meal Meal;
    private MarketingCabin MarketingCabin;
    private List<BookingClassAvail> BookingClassAvail;
    
    public String getDepartureDateTime() {
        return DepartureDateTime;
    }
    @XmlAttribute(name="DepartureDateTime")
    public void setDepartureDateTime(String departureDateTime) {
        this.DepartureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return ArrivalDateTime;
    }
    @XmlAttribute(name="ArrivalDateTime")
    public void setArrivalDateTime(String ArrivalDateTime) {
        this.ArrivalDateTime = ArrivalDateTime;
    }

    public String getStopQuantity() {
        return StopQuantity;
    }
    @XmlAttribute(name="StopQuantity")
    public void setStopQuantity(String stopQuantity) {
        this.StopQuantity = stopQuantity;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }
    @XmlAttribute(name="FlightNumber")
    public void setFlightNumber(String flightNumber) {
        this.FlightNumber = flightNumber;
    }

    public String getJourneyDuration() {
        return JourneyDuration;
    }
    @XmlAttribute(name="JourneyDuration")
    public void setJourneyDuration(String journeyDuration) {
        this.JourneyDuration = journeyDuration;
    }
    
    public String getResBookDesigCode() {
        return ResBookDesigCode;
    }
    @XmlAttribute(name="ResBookDesigCode")
    public void setResBookDesigCode(String ResBookDesigCode) {
        this.ResBookDesigCode = ResBookDesigCode;
    }

    public Location getDepartureAirport() {
        return DepartureAirport;
    }
    
    @XmlElement(name="DepartureAirport")
    public void setDepartureAirport(Location departureAirport) {
        this.DepartureAirport = departureAirport;
    }
      

    public Location getArrivalAirport() {
        return ArrivalAirport;
    }
    @XmlElement(name="ArrivalAirport")
    public void setArrivalAirport(Location arrivalAirport) {
        this.ArrivalAirport = arrivalAirport;
    }

    public Equipment getEquipment() {
        return Equipment;
    }
    @XmlElement(name="Equipment")
    public void setEquipment(Equipment equipment) {
        this.Equipment = equipment;
    }

    public Property getMarketingAirline() {
        return MarketingAirline;
    } 
    @XmlElement(name="MarketingAirline")
    public void setMarketingAirline(Property marketingAirline) {
        this.MarketingAirline = marketingAirline;
    }

    public MarketingCabin getMarketingCabin() {
        return MarketingCabin;
    }
    @XmlElement(name="MarketingCabin")
    public void setMarketingCabin(MarketingCabin marketingCabin) {
        this.MarketingCabin = marketingCabin;
    }

    public Meal getMeal() {
        return Meal;
    }
    @XmlElement(name="Meal")
    public void setMeal(Meal meal) {
        this.Meal = meal;
    }

    public List<BookingClassAvail> getBookingClassAvail() {
        return BookingClassAvail;
    }
    @XmlElement(name="BookingClassAvail")
    public void setBookingClassAvail(List<BookingClassAvail> BookingClassAvail) {
        this.BookingClassAvail = BookingClassAvail;
    }
    
    
    
}
