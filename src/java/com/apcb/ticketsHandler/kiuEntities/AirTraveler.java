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
@XmlRootElement(name="AirTraveler")
public class AirTraveler {
    private String PassengerTypeCode;  
    private String BirthDate;

    public String getPassengerTypeCode() {
        return PassengerTypeCode;
    }
    
    @XmlAttribute(name = "PassengerTypeCode")
    public void setPassengerTypeCode(String PassengerTypeCode) {
        this.PassengerTypeCode = PassengerTypeCode;
    }

    public String getBirthDate() {
        return BirthDate;
    }
    
    @XmlAttribute(name = "BirthDate")
    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }
      
    private PersonName PersonName;
    
    private Telephone Telephone;
   
    private String Email;   
    
    private Document Document;
    
    private CustoLoyalty CustoLoyalty;
    
    private TravelerRefNumber TravelerRefNumber;

    public PersonName getPersonName() {
        return PersonName;
    }
    @XmlElement(name = "PersonName")
    public void setPersonName(PersonName PersonName) {
        this.PersonName = PersonName;
    }

    public Telephone getTelephone() {
        return Telephone;
    }
    @XmlElement(name = "Telephone")
    public void setTelephone(Telephone Telephone) {
        this.Telephone = Telephone;
    }

    public String getEmail() {
        return Email;
    }
    @XmlElement(name = "Email")
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Document getDocument() {
        return Document;
    }
    @XmlElement(name = "Document")
    public void setDocument(Document Document) {
        this.Document = Document;
    }

    public CustoLoyalty getCustoLoyalty() {
        return CustoLoyalty;
    }
    @XmlElement(name = "CustoLoyalty")
    public void setCustoLoyalty(CustoLoyalty CustoLoyalty) {
        this.CustoLoyalty = CustoLoyalty;
    }

    public TravelerRefNumber getTravelerRefNumber() {
        return TravelerRefNumber;
    }
    @XmlElement(name = "TravelerRefNumber")
    public void setTravelerRefNumber(TravelerRefNumber TravelerRefNumber) {
        this.TravelerRefNumber = TravelerRefNumber;
    }
    
    
    
    
}
