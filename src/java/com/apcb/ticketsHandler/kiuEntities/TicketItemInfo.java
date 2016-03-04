/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="TicketItemInfo")
public class TicketItemInfo {
    private String TicketNumber;
    private String Type;
    private String ItemNumber;
    private String TotalAmount;
    private String CommissionAmount;
    private String PaymentType;
    
    public String getTicketNumber() {
        return TicketNumber;
    }
    @XmlAttribute(name="TicketNumber")
    public void setTicketNumber(String TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    public String getType() {
        return Type;
    }
    @XmlAttribute(name="Type")
    public void setType(String Type) {
        this.Type = Type;
    }

    public String getItemNumber() {
        return ItemNumber;
    }
    @XmlAttribute(name="ItemNumber")
    public void setItemNumber(String ItemNumber) {
        this.ItemNumber = ItemNumber;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }
    @XmlAttribute(name="TotalAmount")
    public void setTotalAmount(String TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getCommissionAmount() {
        return CommissionAmount;
    }
    @XmlAttribute(name="CommissionAmount")
    public void setCommissionAmount(String CommissionAmount) {
        this.CommissionAmount = CommissionAmount;
    }

    public String getPaymentType() {
        return PaymentType;
    }
    @XmlAttribute(name="PaymentType")
    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }
 
    private PersonName PassengerName;

    public PersonName getPassengerName() {
        return PassengerName;
    }
    @XmlElement(name="PassengerName")
    public void setPassengerName(PersonName PassengerName) {
        this.PassengerName = PassengerName;
    }
    
    
    
}
