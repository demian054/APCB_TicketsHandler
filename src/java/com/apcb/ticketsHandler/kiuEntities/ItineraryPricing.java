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
@XmlRootElement(name = "ItineraryPricing")
public class ItineraryPricing {
    private String ItemRPHList;
    private Cost Cost;
    private Taxes Taxes;

    public String getItemRPHList() {
        return ItemRPHList;
    }
    @XmlElement(name = "ItemRPHList")
    public void setItemRPHList(String ItemRPHList) {
        this.ItemRPHList = ItemRPHList;
    }

    public Cost getCost() {
        return Cost;
    }
    @XmlElement(name = "Cost")
    public void setCost(Cost Cost) {
        this.Cost = Cost;
    }

    public Taxes getTaxes() {
        return Taxes;
    }
    @XmlElement(name = "Taxes")
    public void setTaxes(Taxes Taxes) {
        this.Taxes = Taxes;
    }
    
    
    
    
    
    
}
