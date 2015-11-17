/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuPrincipalEntities;

import com.apcb.ticketsHandler.kiuEntities.AirItinerary;
import com.apcb.ticketsHandler.kiuEntities.Pos;
import com.apcb.ticketsHandler.kiuEntities.SpecificFlightInfo;
import com.apcb.ticketsHandler.kiuEntities.TravelPreferences;
import com.apcb.ticketsHandler.kiuEntities.TravelerInfoSummary;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="KIU_AirAvailRQ")
public class KIU_AirAvailRQ {
    
/****************XmlAttribute*****************/
    private int EchoToken;
    private String TimeStamp;
    private String Target;
    private String Version; 
    private int SequenceNmbr; 
    private String PrimaryLangID;
    private boolean DirectFlightsOnly; 
    private int MaxResponses;

    public int getEchoToken() {
        return EchoToken;
    }
    @XmlAttribute(name = "EchoToken")
    public void setEchoToken(int EchoToken) {
        this.EchoToken = EchoToken;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }
    @XmlAttribute(name = "TimeStamp")
    public void setTimeStamp(String TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    public String getTarget() {
        return Target;
    }
    @XmlAttribute(name = "Target")
    public void setTarget(String Target) {
        this.Target = Target;
    }

    public String getVersion() {
        return Version;
    }
    @XmlAttribute(name = "Version")
    public void setVersion(String Version) {
        this.Version = Version;
    }

    public int getSequenceNmbr() {
        return SequenceNmbr;
    }
    @XmlAttribute(name = "SequenceNmbr")
    public void setSequenceNmbr(int SequenceNmbr) {
        this.SequenceNmbr = SequenceNmbr;
    }

    public String getPrimaryLangID() {
        return PrimaryLangID;
    }
    @XmlAttribute(name = "PrimaryLangID")
    public void setPrimaryLangID(String PrimaryLangID) {
        this.PrimaryLangID = PrimaryLangID;
    }

    public boolean getDirectFlightsOnly() {
        return DirectFlightsOnly;
    }
    @XmlAttribute(name = "DirectFlightsOnly")
    public void setDirectFlightsOnly(boolean DirectFlightsOnly) {
        this.DirectFlightsOnly = DirectFlightsOnly;
    }

    public int getMaxResponses() {
        return MaxResponses;
    }
    @XmlAttribute(name = "MaxResponses")
    public void setMaxResponses(int MaxResponses) {
        this.MaxResponses = MaxResponses;
    }
    
/****************XmlElements*****************/
    
    private Pos pos;
    private SpecificFlightInfo specificFlightInfo;
    private List<AirItinerary> originDestinationInformation;
    private TravelPreferences travelPreferences;
    private TravelerInfoSummary travelerInfoSummary;
    
    public Pos getPos() {
        return pos;
    }
    @XmlElement
    public void setPos(Pos pos) {
        this.pos = pos;
    }
    
    public SpecificFlightInfo getSpecificFlightInfo() {
        return specificFlightInfo;
    }
    @XmlElement
    public void setSpecificFlightInfo(SpecificFlightInfo specificFlightInfo) {
        this.specificFlightInfo = specificFlightInfo;
    }

    public List<AirItinerary> getOriginDestinationInformation() {
        return originDestinationInformation;
    }
    @XmlElement
    public void setOriginDestinationInformation(List<AirItinerary> originDestinationInformation) {
        this.originDestinationInformation = originDestinationInformation;
    }

    public TravelPreferences getTravelPreferences() {
        return travelPreferences;
    }
    @XmlElement
    public void setTravelPreferences(TravelPreferences travelPreferences) {
        this.travelPreferences = travelPreferences;
    }

    public TravelerInfoSummary getTravelerInfoSummary() {
        return travelerInfoSummary;
    }
    @XmlElement
    public void setTravelerInfoSummary(TravelerInfoSummary travelerInfoSummary) {
        this.travelerInfoSummary = travelerInfoSummary;
    }
    
    
    
    
   
  
    
}
