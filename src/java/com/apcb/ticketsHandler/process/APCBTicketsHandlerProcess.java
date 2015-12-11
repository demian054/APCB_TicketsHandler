/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.process;


import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirPriceRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirPriceRS;
import com.apcb.ticketsHandler.utils.KIUParserEntities;
import com.apcb.ticketsHandler.utils.KIU_Conection;
import com.apcb.ticketsHandler.utils.KUIXmlExamples;
import com.apcb.utils.conection.ServiceGenerator;
import com.apcb.utils.entities.Beam;
import com.apcb.utils.entities.Message;
import com.apcb.utils.utils.PropertiesReader;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.ticketsHandler.Enums.MessagesTypeEnum;
import com.apcb.utils.ticketsHandler.entities.Travel;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class APCBTicketsHandlerProcess {
    private Logger log = LogManager.getLogger(APCBTicketsHandlerProcess.class);
    Gson gson = new Gson();
            
    public Response ticketAirAvail(Request request) throws IOException, Exception {
        
        Response response = new Response();
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        Travel itinerary = gson.fromJson(request.getBeam().getObjectStr(), Travel.class);
        KIU_AirAvailRQ kIU_AirAvailRQ = KIUParserEntities.toAirAvailRequest(itinerary, propKiu);
        KIU_Conection kIU_Conection = new KIU_Conection();
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirAvailRS);
        KIU_AirAvailRS kIU_AirAvailRS;
        try {
             kIU_AirAvailRS = kIU_Conection.send(kIU_AirAvailRQ, propKiu, KIU_AirAvailRQ.class, KIU_AirAvailRS.class);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
            log.error(response.getMessage().getMsgDesc(), e);
            return response;
        }
        itinerary = KIUParserEntities.fromAirAvailResponse(itinerary, kIU_AirAvailRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setBeam(new Beam(gson.toJson(itinerary), Travel.class.getName()));
        response.setMessage(new Message(MessagesTypeEnum.Ok));
        return response;
    }
    
    public Response ticketAirPrice(Request request) throws IOException, Exception {
        
        Response response = new Response();
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        Travel itinerary = gson.fromJson(request.getBeam().getObjectStr(), Travel.class);
        KIU_AirPriceRQ kIU_AirPriceRQ = KIUParserEntities.toKIU_AirPriceRequest(itinerary, propKiu);
        KIU_Conection kIU_Conection = new KIU_Conection();
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirPriceRS);
        KIU_AirPriceRS kIU_AirPriceRS;
        try {
             kIU_AirPriceRS = kIU_Conection.send(kIU_AirPriceRQ, propKiu, KIU_AirPriceRQ.class, KIU_AirPriceRS.class);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
            log.error(response.getMessage().getMsgDesc(), e);
            return response;
        }
        itinerary = KIUParserEntities.fromAirPriceResponse(itinerary, kIU_AirPriceRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setBeam(new Beam(gson.toJson(itinerary), Travel.class.getName()));
        response.setMessage(new Message(MessagesTypeEnum.Ok));
        return response;
    }
    
}
