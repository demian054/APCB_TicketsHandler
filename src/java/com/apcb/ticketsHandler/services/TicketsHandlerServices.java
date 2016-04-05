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
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;
import com.google.gson.Gson;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Demian
 */
@WebService(serviceName = "TicketsHandlerServices")
public class TicketsHandlerServices {
    private Logger log = LogManager.getLogger(TicketsHandlerServices.class);
    private Gson gson = new Gson();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ticketAirAvail")
    public String ticketAirAvail(@WebParam(name = "request") String strRequest) {
        Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirAvail(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
    @WebMethod(operationName = "ticketAirPrice")
    public String ticketAirPrice(@WebParam(name = "request") String strRequest) {
              Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirPrice(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
    @WebMethod(operationName = "ticketAirReserv")
    public String ticketAirReserv(@WebParam(name = "request") String strRequest) {
              Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirReserv(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
   @WebMethod(operationName = "ticketAirDemand")
    public String ticketAirDemand(@WebParam(name = "request") String strRequest) {
        Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirDemand(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
    @WebMethod(operationName = "ticketAirCancel")
    public String ticketAirCancel(@WebParam(name = "request") String strRequest) {
        Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirCancel(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
    @WebMethod(operationName = "ticketAirConsultTickets")
    public String ticketAirConsultTickets(@WebParam(name = "request") String strRequest) {
        Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirConsultTickets(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
    @WebMethod(operationName = "ticketAirConsultReserv")
    public String ticketAirConsultReserv(@WebParam(name = "request") String strRequest) {
        Request request = new Request(strRequest); 
        Response response;
        try {
            APCBTicketsHandlerProcess process = new APCBTicketsHandlerProcess();
            response = process.ticketAirConsultReserv(request);
            
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
    
}
