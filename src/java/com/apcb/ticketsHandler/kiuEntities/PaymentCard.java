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
public class PaymentCard {
    private String CardCode;

    public String getCardCode() {
        return CardCode;
    }
    @XmlAttribute(name = "CardCode")
    public void setCardCode(String CardCode) {
        this.CardCode = CardCode;
    }
    
    
}
