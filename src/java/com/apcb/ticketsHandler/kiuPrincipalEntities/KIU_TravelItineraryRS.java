/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuPrincipalEntities;

import com.apcb.ticketsHandler.kiuEntities.TravelItinerary;
import com.apcb.ticketsHandler.kiuEntities.AirItinerary;
import com.apcb.ticketsHandler.kiuEntities.Error;
import com.apcb.ticketsHandler.kiuEntities.ItineraryInfo;
import com.apcb.ticketsHandler.kiuEntities.Pos;
import com.apcb.ticketsHandler.kiuEntities.TravelerInfoSummary;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="KIU_TravelItineraryRS") // incompleto
public class KIU_TravelItineraryRS {
    private int EchoToken;
    private String TimeStamp;
    private String Target;
    private String Version; 
    private int SequenceNmbr; 
    private String PrimaryLangID;
    
    
    public int getEchoToken() {
        return EchoToken;
    }
    @XmlAttribute(name = "EchoToken")
    public void setEchoToken(int echoToken) {
        this.EchoToken = echoToken;
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
    public void setTarget(String target) {
        this.Target = target;
    }

    public String getVersion() {
        return Version;
    }
    @XmlAttribute(name = "Version")
    public void setVersion(String version) {
        this.Version = version;
    }

    public int getSequenceNmbr() {
        return SequenceNmbr;
    }
    @XmlAttribute(name = "SequenceNmbr")
    public void setSequenceNmbr(int sequenceNmbr) {
        this.SequenceNmbr = sequenceNmbr;
    }

    public String getPrimaryLangID() {
        return PrimaryLangID;
    }
    @XmlAttribute(name = "PrimaryLangID")
    public void setPrimaryLangID(String primaryLangID) {
        this.PrimaryLangID = primaryLangID;
    }
    
    /****************XmlElements*****************/
    
    private String Success;
    private Error Error;
    
    private TravelItinerary TravelItinerary;
    private ItineraryInfo ItineraryInfo;

    public String getSuccess() {
        return Success;
    }
    @XmlElement(name = "Success")
    public void setSuccess(String Success) {
        this.Success = Success;
    }

    public Error getError() {
        return Error;
    }
    @XmlElement(name = "Error")
    public void setError(Error Error) {
        this.Error = Error;
    }

    public TravelItinerary getTravelItinerary() {
        return TravelItinerary;
    }
    @XmlElement(name = "TravelItinerary")
    public void setTravelItinerary(TravelItinerary TravelItinerary) {
        this.TravelItinerary = TravelItinerary;
    }

    public ItineraryInfo getItineraryInfo() {
        return ItineraryInfo;
    }
    
    @XmlElement(name = "ItineraryInfo")
    public void setItineraryInfo(ItineraryInfo ItineraryInfo) {
        this.ItineraryInfo = ItineraryInfo;
    }
    
    
    
    

   
}
