/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.utils;

import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirPriceRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirPriceRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_TravelItineraryReadRQ;
import com.apcb.utils.xml.XmlParser;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class TestMaping {
    private final static Logger log = Logger.getLogger(TestMaping.class);
    public static void main(String[] args) throws Exception {
   
    log.debug("KIU_AirAvail RQ/RS ");
        
        KIU_AirAvailRQ kIU_AirAvailRQ = (KIU_AirAvailRQ) XmlParser.fromXML(KUIXmlExamples.strXmlAirAvailRQ, KIU_AirAvailRQ.class);
        log.debug(XmlParser.toXML(kIU_AirAvailRQ, KIU_AirAvailRQ.class));
        
        KIU_AirAvailRS kIU_AirAvailRS = (KIU_AirAvailRS) XmlParser.fromXML(KUIXmlExamples.strXmlAirAvailRS, KIU_AirAvailRS.class);
        log.debug(XmlParser.toXML(kIU_AirAvailRS, KIU_AirAvailRS.class));
        
    log.debug("KIU_AirPrice RQ/RS ");
        
        KIU_AirPriceRQ kIU_AirPriceRQ = (KIU_AirPriceRQ) XmlParser.fromXML(KUIXmlExamples.strXmlAirPriceRQ, KIU_AirPriceRQ.class);
        log.debug(XmlParser.toXML(kIU_AirPriceRQ, KIU_AirPriceRQ.class));
        
        KIU_AirPriceRS kIU_AirPriceRS = (KIU_AirPriceRS) XmlParser.fromXML(KUIXmlExamples.strXmlAirPriceRS, KIU_AirPriceRS.class);
        log.debug(XmlParser.toXML(kIU_AirPriceRS, KIU_AirPriceRS.class));
                          
     log.debug("KIU_TravelItineraryRead RQ/RS"); 
        
        KIU_TravelItineraryReadRQ kIU_TravelItineraryReadRQ = (KIU_TravelItineraryReadRQ) XmlParser.fromXML(KUIXmlExamples.strXmlTravelItineraryReadRQTicketConMail, KIU_TravelItineraryReadRQ.class);
        log.debug(XmlParser.toXML(kIU_TravelItineraryReadRQ, KIU_TravelItineraryReadRQ.class));
     
        
        
    }

    
}
