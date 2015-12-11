/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.utils;

import com.apcb.utils.conection.ConectionHttpsURL;
import com.apcb.utils.utils.PropertiesReader;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIUMainRequest;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.entities.Travel;
import com.apcb.utils.xml.XmlParser;
import org.apache.log4j.Logger;


public class KIU_Conection {
    private final static Logger log = Logger.getLogger(KIU_Conection.class);
    
    public <T> T send(Object avail, PropertiesReader prop, Class inObjClass, Class<T> outObjClass) throws Exception{
        
        KIUMainRequest request = new KIUMainRequest(inObjClass);        
        request.setUser(prop.getProperty("User"));
        request.setPassword(prop.getProperty("Password"));
        request.setRequest(avail);
        //TestConection http = new TestConection();
        log.info(request.toString());
        ConectionHttpsURL con = new ConectionHttpsURL(prop);
        String KIUresp = con.sendPost(request.toString());
                
        log.info("KUI literal response: "+KIUresp); 
        return (T) XmlParser.fromXML(KIUresp, outObjClass);    
    }
    
    public static void main(String[] args) throws Exception {
        PropertiesReader prop = new PropertiesReader("KiuConnection");
        Travel itinerary = new Travel();
        
        itinerary.setCabin(CabinTypeEnum.Economy);
        
        /*itinerary.setDepartureDateTime(Calendar.getInstance());
        itinerary.setDestinationLocationCode(LocationEnum.CCS);
        itinerary.setDirectFlightsOnly(true);
        
        itinerary.setOriginLocationCode(LocationEnum.CCS);
        
        Passanger passanger = new Passanger();
        passanger.setPassangerType(PassangerTypeEnum.ADT);
        passanger.setPassangerQuantity(1);

        itinerary.putPassangers(passanger);
                                
        KIU_AirAvailRQ avail = KIUParserEntities.toAirAvailRQRequest(itinerary, prop);
        KIU_Conection kIU_Conection = new KIU_Conection();
        
        prop.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirAvailRS);
        KIU_AirAvailRS kIU_AirAvailRS = kIU_Conection.send(avail, prop);
        
        itinerary = KIUParserEntities.fromAirAvailRQRequest(itinerary, kIU_AirAvailRS, prop);
        
        log.info(new Gson().toJson(itinerary));*/
    }
}
