/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.services;

import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.ticketsHandler.utils.KIUParserEntities;
import com.apcb.ticketsHandler.utils.KIU_Conection;
import com.apcb.ticketsHandler.utils.KUIXmlExamples;
import com.apcb.utils.entities.Beam;
import com.apcb.utils.entities.Message;
import com.apcb.utils.entities.PropertiesReader;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import com.apcb.utils.ticketsHandler.Enums.MessagesTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.PassangerTypeEnum;
import com.apcb.utils.ticketsHandler.entities.Itinerary;
import com.apcb.utils.ticketsHandler.entities.Passanger;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
@WebService(serviceName = "TicketHandlerServices")
public class TicketHandlerServices {
    private final static Logger log = Logger.getLogger(KIU_Conection.class);
    private Gson gson = new Gson();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ticketAirAvail")
    public String ticketAirAvail(@WebParam(name = "request") String strRequest) {
        Response response = new Response();
        try {
            Request request = new Request(strRequest); 
            PropertiesReader prop = new PropertiesReader("KiuConnection");
            /*Itinerary itinerary = new Itinerary();

            itinerary.setCabin(CabinTypeEnum.Economy);

            itinerary.setDepartureDateTime(Calendar.getInstance());
            itinerary.setDestinationLocationCode(LocationEnum.CCS);
            itinerary.setDirectFlightsOnly(true);

            itinerary.setOriginLocationCode(LocationEnum.CCS);

            Passanger passanger = new Passanger();
            passanger.setPassangerType(PassangerTypeEnum.ADT);
            passanger.setPassangerQuantity(1);
            List<Passanger> passangers = new ArrayList<>();
            passangers.add(passanger);
            itinerary.setPassagers(passangers);
            */
            
            Itinerary itinerary = (Itinerary) request.getBeam().getObject();
            
            KIU_AirAvailRQ kIU_AirAvailRQ = KIUParserEntities.toAirAvailRQRequest(itinerary, prop);
            KIU_Conection kIU_Conection = new KIU_Conection();

            prop.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirAvailRS);
            KIU_AirAvailRS kIU_AirAvailRS = kIU_Conection.send(kIU_AirAvailRQ, prop);

            itinerary = KIUParserEntities.fromAirAvailRQRequest(itinerary, kIU_AirAvailRS, prop);
            
            log.info(new Gson().toJson(itinerary));
            response.setBeam(new Beam(itinerary, Itinerary.class));
            response.setMessage(new Message(MessagesTypeEnum.Ok));
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
}
