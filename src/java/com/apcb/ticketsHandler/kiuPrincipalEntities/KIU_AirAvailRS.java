/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuPrincipalEntities;

import com.apcb.ticketsHandler.kiuEntities.Error;
import com.apcb.ticketsHandler.kiuEntities.AirItinerary;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */    
@XmlRootElement(name="Root")
public class KIU_AirAvailRS {
    
/****************XmlAttribute*****************/
    private int EchoToken;
    private String TimeStamp;
    private String Target;
    private String Version; 
    private int SequenceNmbr; 

    public int getEchoToken() {
        return EchoToken;
    }
    @XmlAttribute(name="EchoToken")
    public void setEchoToken(int echoToken) {
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

    public int getSequenceNmbr() {
        return SequenceNmbr;
    }
    @XmlAttribute(name="SequenceNmbr")
    public void setSequenceNmbr(int sequenceNmbr) {
        this.SequenceNmbr = sequenceNmbr;
    }

    
/****************XmlElements*****************/
    
    private String Success;
    private Error Error;
    private List<AirItinerary> OriginDestinationInformation;

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
    
    public List<AirItinerary> getOriginDestinationInformation() {
        return OriginDestinationInformation;
    }
    @XmlElement(name="OriginDestinationInformation")
    public void setOriginDestinationInformation(List<AirItinerary> originDestinationInformation) {
        this.OriginDestinationInformation = originDestinationInformation;
    }

}
