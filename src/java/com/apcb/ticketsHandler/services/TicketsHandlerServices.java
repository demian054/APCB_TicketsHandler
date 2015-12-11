/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.services;

import com.apcb.ticketsHandler.process.APCBTicketsHandlerProcess;
import com.apcb.utils.entities.Message;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.ticketsHandler.Enums.MessagesTypeEnum;
import com.google.gson.Gson;
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
    
    @WebMethod(operationName = "ticketAirPrice")
    public String ticketAirPrice(@WebParam(name = "request") String strRequest) {
        Response response = new Response();
        try {
            Request request = new Request(strRequest); 
            
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirPrice(request);
            
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
}
