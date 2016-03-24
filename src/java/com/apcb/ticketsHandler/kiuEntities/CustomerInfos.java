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
@XmlRootElement(name = "CustomerInfos")
public class CustomerInfos {
    private List<CustomerInfo> CustomerInfo;

    public List<CustomerInfo> getCustomerInfo() {
        return CustomerInfo;
    }
    @XmlElement(name = "CustomerInfo")
    public void setCustomerInfo(List<CustomerInfo> CustomerInfo) {
        this.CustomerInfo = CustomerInfo;
    }
    
    
}
