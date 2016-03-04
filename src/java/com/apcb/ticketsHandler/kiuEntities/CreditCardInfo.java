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
@XmlRootElement(name="CreditCardInfo")
public class CreditCardInfo {
    Integer CardType;
    String CardCode;
    String CardNumber;
    Integer SeriesCode;
    String ExpireDate;

    public Integer getCardType() {
        return CardType;
    }
    @XmlAttribute(name="CardType")
    public void setCardType(Integer CardType) {
        this.CardType = CardType;
    }

    public String getCardCode() {
        return CardCode;
    }
    @XmlAttribute(name="CardCode")
    public void setCardCode(String CardCode) {
        this.CardCode = CardCode;
    }

    public String getCardNumber() {
        return CardNumber;
    }
    @XmlAttribute(name="CardNumber")
    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public Integer getSeriesCode() {
        return SeriesCode;
    }
    @XmlAttribute(name="SeriesCode")
    public void setSeriesCode(Integer SeriesCode) {
        this.SeriesCode = SeriesCode;
    }

    public String getExpireDate() {
        return ExpireDate;
    }
    @XmlAttribute(name="ExpireDate")
    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

}
