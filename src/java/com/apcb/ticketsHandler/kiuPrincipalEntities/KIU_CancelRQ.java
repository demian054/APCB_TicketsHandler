/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuPrincipalEntities;

import com.apcb.ticketsHandler.kiuEntities.DemandTicketDetail;
import com.apcb.ticketsHandler.kiuEntities.Pos;
import com.apcb.ticketsHandler.kiuEntities.Ticketing;
import com.apcb.ticketsHandler.kiuEntities.UniqueId;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="KIU_CancelRQ")
public class KIU_CancelRQ {
    private int EchoToken;
    private String TimeStamp;
    private String Target;
    private String Version; 
    private String SequenceNmbr; 
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

    public String getSequenceNmbr() {
        return SequenceNmbr;
    }
    @XmlAttribute(name = "SequenceNmbr")
    public void setSequenceNmbr(String sequenceNmbr) {
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
    
    private Pos POS;
    
    private List<UniqueId> UniqueID;
    
    private Ticketing Ticketing;
    
    
    public Pos getPOS() {
        return POS;
    }
    
    @XmlElement(name = "POS")
    public void setPOS(Pos POS) {
        this.POS = POS;
    }

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

    
    
   
    
}
