<%-- 
    Document   : index
    Created on : Nov 9, 2015, 10:45:26 PM
    Author     : Demian
--%>

<%@page import="com.apcb.utils.entities.PropertiesReader"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.PassengerTypeQuantity"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.AirTravelerAvail"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.TravelerInfoSummary"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.CabinPref"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.TravelPreferences"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.Location"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.Location"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.AirItinerary"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.Airline"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.SpecificFlightInfo"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.Source"%>
<%@page import="com.apcb.ticketsHandler.kiuEntities.Pos"%>
<%@page import="com.apcb.utils.xml.XmlParser"%>
<%@page import="com.apcb.ticketsHandler.utils.KIUParserEntities"%>
<%@page import="com.apcb.ticketsHandler.kiuPrincipalEntities.KIUMainRequest"%>
<%@page import="com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS"%>
<%@page import="com.apcb.utils.conection.ConectionHttpsURL"%>
<%@page import="com.apcb.ticketsHandler.utils.TestConection"%>
<%@page import="com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ"%>
<%
        
         KIU_AirAvailRQ avail = new KIU_AirAvailRQ();
                        avail.setMaxResponses(10);
                        avail.setEchoToken(1);
                        avail.setTimeStamp("2012-04-20T15:45:07-03:00");
                        avail.setTarget("Testing");
                        //avail.setTarget("Production");
                        avail.setVersion("3.0");
                        avail.setSequenceNmbr(1);
                        avail.setPrimaryLangID("en-us");
                        avail.setDirectFlightsOnly(false);
                        avail.setMaxResponses(5);

                        Pos pos = new Pos();
                            Source source = new Source();
                            source.setAgentSine("NET00VHWW");
                            source.setTerminalID("NET00VH000");
                            pos.setSource(source);
                    avail.setPos(pos);
                    
                        SpecificFlightInfo specificFlightInfo = new SpecificFlightInfo();
                            Airline airline = new Airline();
                            airline.setCode("XX");
                            specificFlightInfo.setAirline(airline);
                    avail.setSpecificFlightInfo(specificFlightInfo);
                        AirItinerary origDesInfo = new AirItinerary();
                            origDesInfo.setDepartureDateTime("2015-11-12");
                                Location origLocation = new Location();
                                origLocation.setLocationCode("CCS");
                            origDesInfo.setOriginLocation(origLocation);
                                Location destLocation = new Location();
                                destLocation.setLocationCode("CUM");
                            origDesInfo.setDestinationLocation(destLocation);
                    avail.setOriginDestinationInformation(new ArrayList<AirItinerary>());        
                    avail.getOriginDestinationInformation().add(origDesInfo);
                    
                        TravelPreferences travelPreferences = new TravelPreferences();
                                CabinPref cabinPref = new CabinPref();
                                cabinPref.setCabin("Economy");
                            travelPreferences.setCabinPref(cabinPref);
                    avail.setTravelPreferences(travelPreferences);
                    
                        TravelerInfoSummary travelerInfoSummary = new TravelerInfoSummary();
                                AirTravelerAvail airTravelerAvail = new AirTravelerAvail();
                                    airTravelerAvail.setPassengerTypeQuantity(new ArrayList<PassengerTypeQuantity>());
                                            PassengerTypeQuantity passengerTypeQuantity_1 = new PassengerTypeQuantity();
                                                passengerTypeQuantity_1.setCode("ADT");
                                                passengerTypeQuantity_1.setQuantity(1);
                                        airTravelerAvail.getPassengerTypeQuantity().add(passengerTypeQuantity_1);
                                            PassengerTypeQuantity passengerTypeQuantity_2 = new PassengerTypeQuantity();
                                                passengerTypeQuantity_2.setCode("CNN");
                                                passengerTypeQuantity_2.setQuantity(0);
                                        airTravelerAvail.getPassengerTypeQuantity().add(passengerTypeQuantity_2);
                                            PassengerTypeQuantity passengerTypeQuantity_3 = new PassengerTypeQuantity();
                                                passengerTypeQuantity_3.setCode("INF");
                                                passengerTypeQuantity_3.setQuantity(0);
                                        airTravelerAvail.getPassengerTypeQuantity().add(passengerTypeQuantity_3);
                                travelerInfoSummary.setAirTravelerAvail(airTravelerAvail);
                    avail.setTravelerInfoSummary(travelerInfoSummary);

        TestConection testConection = new TestConection();
       
        PropertiesReader prop = new PropertiesReader();
        prop.setTarget("Testing.");
             
        prop.setProperty("Testing.Server","https://ssl00.kiusys.com/ws3/");
        prop.setProperty("Testing.User","VH");
        prop.setProperty("Testing.Password","RJH80MP3Q1K3");
        prop.setProperty("Testing.airlineCode","XX");
        prop.setProperty("Testing.AgentSine","NET00VHWW");
        prop.setProperty("Testing.TerminalID","NET00VH000");       
        
         try {            
          //PropertiesReader prop = new PropertiesReader("KiuConnection", "C:\\Users\\Demian\\Documents\\NetBeansProjects\\Aeropostal\\APCB_TicketsHandler2\\src\\java\\");
          testConection.play(avail, prop);
	} catch (Exception ex) {
        }
         
        try {            
          //testConection.play(avail);
	} catch (Exception ex) {
        }
        
        

    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
