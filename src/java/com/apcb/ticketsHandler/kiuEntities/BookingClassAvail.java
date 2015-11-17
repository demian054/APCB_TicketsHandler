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
@XmlRootElement
public class BookingClassAvail {
    private String ResBookDesigCode;
    private String ResBookDesigQuantity;
    private String RPH;

    public String getResBookDesigCode() {
        return ResBookDesigCode;
    }
    @XmlAttribute(name="ResBookDesigCode")
    public void setResBookDesigCode(String resBookDesigCode) {
        this.ResBookDesigCode = resBookDesigCode;
    }

    public String getResBookDesigQuantity() {
        return ResBookDesigQuantity;
    }
    @XmlAttribute(name="ResBookDesigQuantity")
    public void setResBookDesigQuantity(String resBookDesigQuantity) {
        this.ResBookDesigQuantity = resBookDesigQuantity;
    }

    public String getRPH() {
        return RPH;
    }
    @XmlAttribute(name="RPH")
    public void setRPH(String rPH) {
        this.RPH = rPH;
    }
    
    
    
    
}
