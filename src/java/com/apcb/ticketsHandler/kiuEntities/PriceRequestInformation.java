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
@XmlRootElement
public class PriceRequestInformation {
    List<DiscountPricing> DiscountPricing;
    List<Tax> Tax;

    public List<DiscountPricing> getDiscountPricing() {
        return DiscountPricing;
    }
    @XmlElement(name = "DiscountPricing")
    public void setDiscountPricing(List<DiscountPricing> DiscountPricing) {
        this.DiscountPricing = DiscountPricing;
    }

    public List<Tax> getTax() {
        return Tax;
    }
    @XmlElement(name = "Tax")
    public void setTax(List<Tax> Tax) {
        this.Tax = Tax;
    }

}
