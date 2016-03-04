/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuPrincipalEntities;

import com.apcb.ticketsHandler.kiuEntities.TicketItemInfo;
import com.apcb.ticketsHandler.kiuEntities.AirItinerary;
import com.apcb.ticketsHandler.kiuEntities.AirTraveler;
import com.apcb.ticketsHandler.kiuEntities.Error;
import com.apcb.ticketsHandler.kiuEntities.Pos;
import com.apcb.ticketsHandler.kiuEntities.PricedItineraries;
import com.apcb.ticketsHandler.kiuEntities.Ticketing;
import com.apcb.ticketsHandler.kiuEntities.UniqueId;
import com.apcb.ticketsHandler.kiuEntities.Warnings;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */    
@XmlRootElement(name="KIU_AirDemandTicketRS")
public class KIU_CancelRS {
    
/****************XmlAttribute*****************/
    private String EchoToken;
    private String TimeStamp;
    private String Target;
    private String Version; 
    private String SequenceNmbr; 

    public String getEchoToken() {
        return EchoToken;
    }
    @XmlAttribute(name="EchoToken")
    public void setEchoToken(String echoToken) {
        this.EchoToken = echoToken;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }
    @XmlAttribute(name="TimeStamp")
    public void setTimeStamp(String timeStamp) {
        this.TimeStamp = timeStamp;
    }

    public String getTarget() {
        return Target;
    }
    @XmlAttribute(name="Target")
    public void setTarget(String target) {
        this.Target = target;
    }

    public String getVersion() {
        return Version;
    }
    @XmlAttribute(name="Version")
    public void setVersion(String version) {
        this.Version = version;
    }

    public String getSequenceNmbr() {
        return SequenceNmbr;
    }
    @XmlAttribute(name="SequenceNmbr")
    public void setSequenceNmbr(String sequenceNmbr) {
        this.SequenceNmbr = sequenceNmbr;
    }

    
/****************XmlElements*****************/
    
    private String Success;
    private Error Error;

    private List<UniqueId> UniqueID;
    private Ticketing Ticketing;
    

    public List<UniqueId> getUniqueID() {
        return UniqueID;
    }
    @XmlElement(name = "UniqueID")
    public void setUniqueID(List<UniqueId> UniqueID) {
        this.UniqueID = UniqueID;
    }

    public Ticketing getTicketing() {
        return Ticketing;
    }
    @XmlElement(name = "Ticketing")
    public void setTicketing(Ticketing Ticketing) {
        this.Ticketing = Ticketing;
    }
 
    public Error getError() {
        return Error;
    }
    @XmlElement(name="Error")
    public void setError(Error error) {
        this.Error = error;
    }     
    
    public String getSuccess() {
        return Success;
    }
    @XmlElement(name="Success")
    public void setSuccess(String success) {
        this.Success = success;
    }

}
