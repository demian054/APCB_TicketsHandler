/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.process;


import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_CancelRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirPriceRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirPriceRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirBookRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirBookRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirDemandTicketRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirDemandTicketRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_CancelRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_TravelItineraryRS;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_TravelItineraryReadRQ;


import com.apcb.ticketsHandler.utils.KIUParserEntities;
import com.apcb.ticketsHandler.utils.KIU_Conection;
import com.apcb.ticketsHandler.utils.KUIXmlExamples;
import com.apcb.utils.entities.Message;
import com.apcb.utils.utils.PropertiesReader;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.RequestTicket;
import com.apcb.utils.entities.Response;
import com.apcb.utils.entities.ResponseTicket;
import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_Passenger;
import com.apcb.utils.ticketsHandler.entities.APCB_PassengerDetail;
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.apcb.utils.ticketsHandler.enums.PassangerTypeEnum;
import com.apcb.utils.utils.HtmlTemplateReader;
import com.apcb.utils.utils.PdfCreator;
import com.apcb.utils.utils.QRGenerator;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Demian
 */
public class APCBTicketsHandlerProcess {
    private Logger log = LogManager.getLogger(APCBTicketsHandlerProcess.class);
    Gson gson = new Gson();
            
    public Response ticketAirAvail(Request request) throws IOException, Exception {
        
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();
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
        log.info(new Gson().toJson(kIU_AirAvailRS));
        if (kIU_AirAvailRS.getError()!=null){
            response.setMessage(new Message(kIU_AirAvailRS.getError().getErrorCode(),kIU_AirAvailRS.getError().getErrorMsg()));
            log.error(response.getMessage().getMsgDesc());
            return response;
        }
        itinerary = KIUParserEntities.fromAirAvailResponse(itinerary, kIU_AirAvailRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response;
    }
    
    public Response ticketAirPrice(Request request) throws IOException, Exception {
        
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();
        KIU_AirPriceRQ kIU_AirPriceRQ = KIUParserEntities.toAirPriceRequest(itinerary, propKiu);
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
         if (kIU_AirPriceRS.getError()!=null){
            response.setMessage(new Message(kIU_AirPriceRS.getError().getErrorCode(),kIU_AirPriceRS.getError().getErrorMsg()));
            log.error(response.getMessage().getMsgDesc());
            return response;
        }
        itinerary = KIUParserEntities.fromAirPriceResponse(itinerary, kIU_AirPriceRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response;
    }
    
    public Response ticketAirReserv(Request request) throws IOException, Exception {
    
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();
        
        KIU_AirBookRQ kIU_AirBookRQ = KIUParserEntities.toAirBookRequest(itinerary, request.getPayMainInfo(), propKiu);
        KIU_Conection kIU_Conection = new KIU_Conection();
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirReservRS);
        KIU_AirBookRS kIU_AirBookRS;
        try {
             kIU_AirBookRS = kIU_Conection.send(kIU_AirBookRQ, propKiu, KIU_AirBookRQ.class, KIU_AirBookRS.class);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
            log.error(response.getMessage().getMsgDesc(), e);
            return response;
        }
         if (kIU_AirBookRS.getError()!=null){
            response.setMessage(new Message(kIU_AirBookRS.getError().getErrorCode(),kIU_AirBookRS.getError().getErrorMsg()));
            log.error(response.getMessage().getMsgDesc());
            return response;
        }
        itinerary = KIUParserEntities.fromAirBookResponse(itinerary, kIU_AirBookRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response;
    }
    
    public Response ticketAirDemand(Request request) throws IOException, Exception {
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();
        APCB_PayMain payMainInfo = request.getPayMainInfo();
        
        
        KIU_AirDemandTicketRQ kIU_AirDemandTicketRQ = KIUParserEntities.toAirDemandTicketRequest(itinerary, payMainInfo, propKiu);
        KIU_Conection kIU_Conection = new KIU_Conection();
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirDemandRS);
        KIU_AirDemandTicketRS kIU_AirDemandTicketRS;
        try {
             kIU_AirDemandTicketRS = kIU_Conection.send(kIU_AirDemandTicketRQ, propKiu, KIU_AirDemandTicketRQ.class, KIU_AirDemandTicketRS.class);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
            log.error(response.getMessage().getMsgDesc(), e);
            return response;
        }
         if (kIU_AirDemandTicketRS.getError()!=null){
            response.setMessage(new Message(kIU_AirDemandTicketRS.getError().getErrorCode(),kIU_AirDemandTicketRS.getError().getErrorMsg()));
            log.error(response.getMessage().getMsgDesc());
            return response;
        }
        itinerary = KIUParserEntities.fromAirDemandTicketResponse(itinerary, kIU_AirDemandTicketRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response;
    }

    public Response ticketAirCancel(Request request) throws IOException, Exception {
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();
        
        KIU_Conection kIU_Conection = new KIU_Conection();
        KIU_CancelRS kIU_CancelRS; 
        RequestTicket requestTicket = new RequestTicket(request);
        requestTicket.setBookingReferenceID(itinerary.getBookingReferenceID());
        KIU_CancelRQ kIU_CancelRQ = KIUParserEntities.toCancelRequest(requestTicket, propKiu);
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirCancelRS);
        
        try {
             kIU_CancelRS = kIU_Conection.send(kIU_CancelRQ, propKiu, KIU_CancelRQ.class, KIU_CancelRS.class);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
            log.error(response.getMessage().getMsgDesc(), e);
            return response;
        }
         if (kIU_CancelRS.getError()!=null){
            response.setMessage(new Message(kIU_CancelRS.getError().getErrorCode(),kIU_CancelRS.getError().getErrorMsg()));
            log.error(response.getMessage().getMsgDesc());
            return response;
        }
          
        for(APCB_Passenger passengerClass :itinerary.getPassangers()){
            for (APCB_PassengerDetail passengerDetail:passengerClass.getPassengersDetail()){
                if (passengerDetail.getTicketNumber()!=null && !passengerDetail.getTicketNumber().isEmpty()){
                    
                    requestTicket.setPassengerDetail(passengerDetail);
                    kIU_CancelRQ = KIUParserEntities.toCancelRequest(requestTicket, propKiu);
                    propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirCancelRS);

                    try {
                         kIU_CancelRS = kIU_Conection.send(kIU_CancelRQ, propKiu, KIU_CancelRQ.class, KIU_CancelRS.class);
                    } catch (Exception e) {
                        response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
                        log.error(response.getMessage().getMsgDesc(), e);
                        return response;
                    }
                     if (kIU_CancelRS.getError()!=null){
                        response.setMessage(new Message(kIU_CancelRS.getError().getErrorCode(),kIU_CancelRS.getError().getErrorMsg()));
                        log.error(response.getMessage().getMsgDesc());
                        return response;
                    }
                    itinerary = KIUParserEntities.fromCancelResponse(itinerary, kIU_CancelRS, propKiu);
                }    
            }
        } 
         
        log.info(new Gson().toJson(itinerary));
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response; 
    }
    
    
    public Response ticketAirConsultReserv(Request request) throws IOException, Exception {
        
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();

        KIU_Conection kIU_Conection = new KIU_Conection();
        
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirConsultbookingReferenceRS);
        KIU_TravelItineraryRS kIU_TravelItineraryRS;
        KIU_TravelItineraryReadRQ kIU_TravelItineraryReadRQ = KIUParserEntities.toConsultReservRequest(itinerary, propKiu);  
            
        try {
            kIU_TravelItineraryRS = kIU_Conection.send(kIU_TravelItineraryReadRQ, propKiu, KIU_TravelItineraryReadRQ.class, KIU_TravelItineraryRS.class);
        } catch (Exception e) {
           response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
           log.error(response.getMessage().getMsgDesc(), e);
           return response;
        }
        if (kIU_TravelItineraryRS.getError()!=null){
           response.setMessage(new Message(kIU_TravelItineraryRS.getError().getErrorCode(),kIU_TravelItineraryRS.getError().getErrorMsg()));
           log.error(response.getMessage().getMsgDesc());
           return response;
        }
        
        itinerary = KIUParserEntities.fromConsultReservResponse(itinerary, kIU_TravelItineraryRS, propKiu);
        log.info(new Gson().toJson(itinerary));
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response;       
    }
    
    public Response ticketAirConsultTickets(Request request) throws IOException, Exception {
        Response response = new Response(request.getSesionId());
        PropertiesReader propKiu = new PropertiesReader("KiuConnection");
        APCB_Travel itinerary = request.getTravelInfo();

        KIU_Conection kIU_Conection = new KIU_Conection();
        
        RequestTicket requestTicket = new RequestTicket(request);
        propKiu.setProperty("SimulateResponseMsg", KUIXmlExamples.strXmlAirConsultTicketRS);
        for(APCB_Passenger passengerClass :request.getTravelInfo().getPassangers()){
            for (APCB_PassengerDetail passengerDetail:passengerClass.getPassengersDetail()){
                requestTicket.setPassengerDetail(passengerDetail);
                KIU_TravelItineraryReadRQ kIU_TravelItineraryReadRQ = KIUParserEntities.toConsultTicketRequest(requestTicket, propKiu);
                KIU_TravelItineraryRS kIU_TravelItineraryRS;
                try {
                    kIU_TravelItineraryRS = kIU_Conection.send(kIU_TravelItineraryReadRQ, propKiu, KIU_TravelItineraryReadRQ.class, KIU_TravelItineraryRS.class);
                    // esto comprueba que el ticket se devuelva
                    log.info(kIU_TravelItineraryRS.getItineraryInfo().getTicketing().getTicketAdvisory());
                } catch (Exception e) {
                   response.setMessage(new Message(MessagesTypeEnum.ErrorAccessExt_Kiu));
                   log.error(response.getMessage().getMsgDesc(), e);
                   return response;
                }
                if (kIU_TravelItineraryRS.getError()!=null){
                   response.setMessage(new Message(kIU_TravelItineraryRS.getError().getErrorCode(),kIU_TravelItineraryRS.getError().getErrorMsg()));
                   log.error(response.getMessage().getMsgDesc());
                   return response;
                }

            } 
        }
        
        StringBuilder fileName = new StringBuilder();
        fileName.append(propKiu.getProperty("Target",false)).append("_");
        if (propKiu.getProperty("Simulate",false).equalsIgnoreCase("true")){
            fileName.append("Simulate_");
        }
        fileName.append(request.getSesionId()).append("_");
        fileName.append(request.getTravelInfo().getBookingReferenceID());
        
        
        String imagePathQR =  propKiu.getProperty("QRGeneratedPath",false)+fileName+".png";
        String filePathQR = propKiu.getProperty("ServerHTMLPath",false)+imagePathQR;
        String webPathPDF = propKiu.getProperty("WebServerHTMLPath",false)+
                propKiu.getProperty("TicketsPath",false)+fileName+".pdf";
        
        int QRSize = 60;
        if (propKiu.getProperty("QRSize",false)!=null){
            try {
                QRSize = Integer.valueOf(propKiu.getProperty("QRSize",false));
            } catch (Exception e) {
                log.error("Error to parse QRSize error in value "+propKiu.getProperty("QRSize",false),e);
            }
        }

        try {
            QRGenerator.generate(filePathQR, webPathPDF, QRSize);
            itinerary.setqRCode(imagePathQR);
        } catch(Exception e) {
            log.error("Cant Create Validation QRCode",e);
            throw new Exception("Cant Create Validation QRCode");
        } 

         try {
            itinerary.setPdfLink(webPathPDF);
            itinerary.setBooking(PdfCreator.createPdfTicket(request, propKiu, fileName.toString()));
        } catch(Exception e) {
            log.error("Cant write Voucher File",e);
            throw new Exception("Cant write Voucher File");
        }    
        response.setTravelInfo(itinerary);
        response.setPayMainInfo(request.getPayMainInfo());
        return response; 
    }

}
