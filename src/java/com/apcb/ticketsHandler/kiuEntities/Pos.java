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
@XmlRootElement(name="POS")
public class Pos {
    private Source Source;

    public Source getSource() {
        return Source;
    }
    @XmlElement(name = "Source")
    public void setSource(Source source) {
        this.Source = source;
    }
    
    
    
}
