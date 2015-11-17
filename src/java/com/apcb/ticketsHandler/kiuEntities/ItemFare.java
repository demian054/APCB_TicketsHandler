/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement
public class ItemFare {
    Fare BaseFare;
    Taxes Taxes;
    Fare TotalFare;

    public Fare getBaseFare() {
        return BaseFare;
    }
    @XmlElement(name = "BaseFare")
    public void setBaseFare(Fare BaseFare) {
        this.BaseFare = BaseFare;
    }

    public Taxes getTaxes() {
        return Taxes;
    }
    @XmlElement(name = "Taxes")
    public void setTaxes(Taxes Taxes) {
        this.Taxes = Taxes;
    }
    
    
    public Fare getTotalFare() {
        return TotalFare;
    }
    @XmlElement(name = "TotalFare")
    public void setTotalFare(Fare TotalFare) {
        this.TotalFare = TotalFare;
    }
    
    
    
}
