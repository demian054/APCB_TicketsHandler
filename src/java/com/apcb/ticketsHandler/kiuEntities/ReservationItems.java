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
@XmlRootElement(name = "ReservationItems")
public class ReservationItems {
    private List<Item> Item;

    public List<Item> getItem() {
        return Item;
    }
    @XmlElement(name = "ReservationItems")
    public void setItem(List<Item> Item) {
        this.Item = Item;
    }
    
    
    
}
