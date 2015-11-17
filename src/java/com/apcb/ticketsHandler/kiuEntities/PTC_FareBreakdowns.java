/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name = "PTC_FareBreakdowns")
public class PTC_FareBreakdowns {
    List<PTC_FareBreakdown> PTC_FareBreakdown;

    public List<PTC_FareBreakdown> getPTC_FareBreakdown() {
        return PTC_FareBreakdown;
    }
    @XmlElement(name = "PTC_FareBreakdown")
    public void setPTC_FareBreakdown(List<PTC_FareBreakdown> PTC_FareBreakdown) {
        this.PTC_FareBreakdown = PTC_FareBreakdown;
    }
   
    
   
    
}
