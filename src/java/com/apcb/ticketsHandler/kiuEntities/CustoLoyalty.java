/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="CustoLoyalty")
public class CustoLoyalty {
    private String ProgramID;
    private String MembershipID;

    public String getProgramID() {
        return ProgramID;
    }
    @XmlAttribute(name = "ProgramID")
    public void setProgramID(String ProgramID) {
        this.ProgramID = ProgramID;
    }

    public String getMembershipID() {
        return MembershipID;
    }
    @XmlAttribute(name = "MembershipID")
    public void setMembershipID(String MembershipID) {
        this.MembershipID = MembershipID;
    }

}
