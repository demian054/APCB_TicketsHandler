/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.services;

import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.ticketsHandler.process.APCBTicketsHandlerProcess;
import com.apcb.ticketsHandler.utils.KIUParserEntities;
import com.apcb.ticketsHandler.utils.KIU_Conection;
import com.apcb.ticketsHandler.utils.KUIXmlExamples;
import com.apcb.utils.entities.Beam;
import com.apcb.utils.entities.Message;
import com.apcb.utils.utils.PropertiesReader;
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
@WebService(serviceName = "TicketsHandlerServices")
public class TicketsHandlerServices {
    private Logger log = Logger.getLogger(TicketsHandlerServices.class);
    private Gson gson = new Gson();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ticketAirAvail")
    public String ticketAirAvail(@WebParam(name = "request") String strRequest) {
        Response response = new Response();
        try {
            Request request = new Request(strRequest); 
            
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirAvail(request);
            
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
}
