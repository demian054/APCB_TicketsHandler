/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.process;


import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
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
import com.apcb.utils.ticketsHandler.entities.Itinerary;
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

        Itinerary itinerary = gson.fromJson(request.getBeam().getObjectStr(), Itinerary.class);

        KIU_AirAvailRQ kIU_AirAvailRQ = KIUParserEntities.toAirAvailRQRequest(itinerary, propKiu);

        KIU_Conection kIU_Conection = new KIU_Conection();
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirAvailRS);
        KIU_AirAvailRS kIU_AirAvailRS;
        try {
             kIU_AirAvailRS = kIU_Conection.send(kIU_AirAvailRQ, propKiu);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
            return response;
        }
        itinerary = KIUParserEntities.fromAirAvailRQRequest(itinerary, kIU_AirAvailRS, propKiu);
        
        log.info(new Gson().toJson(itinerary));
        //response.setBeam(itinerary, Itinerary.class);
        response.setBeam(new Beam(gson.toJson(itinerary), Itinerary.class.getName()));
        response.setMessage(new Message(MessagesTypeEnum.Ok));
        return response;
    }
    
}