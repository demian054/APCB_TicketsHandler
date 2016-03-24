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
@XmlRootElement(name = "Document")
public class Document {
    
    private String DocType;
    private String DocID;

    public String getDocType() {
        return DocType;
    }
    @XmlAttribute(name = "DocType")
    public void setDocType(String DocType) {
        this.DocType = DocType;
    }

    public String getDocID() {
        return DocID;
    }
    @XmlAttribute(name = "DocID")
    public void setDocID(String DocID) {
        this.DocID = DocID;
    }
 
}
