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
@XmlRootElement(name = "Customer")
public class Customer {
    private String PassengerTypeCode;
    private PersonName PersonName;
    private Document Document;
    private Verification ContactPerson;

    public String getPassengerTypeCode() {
        return PassengerTypeCode;
    }
    @XmlAttribute(name = "PassengerTypeCode")
    public void setPassengerTypeCode(String PassengerTypeCode) {
        this.PassengerTypeCode = PassengerTypeCode;
    }

    public PersonName getPersonName() {
        return PersonName;
    }
    @XmlElement(name = "PersonName")
    public void setPersonName(PersonName PersonName) {
        this.PersonName = PersonName;
    }

    public Document getDocument() {
        return Document;
    }
    @XmlElement(name = "PersonName")
    public void setDocument(Document Document) {
        this.Document = Document;
    }

    public Verification getContactPerson() {
        return ContactPerson;
    }
    @XmlElement(name = "PersonName")
    public void setContactPerson(Verification ContactPerson) {
        this.ContactPerson = ContactPerson;
    }
    
      
    
    
    
}
