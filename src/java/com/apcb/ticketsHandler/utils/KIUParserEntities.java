/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.utils;

import com.apcb.ticketsHandler.kiuEntities.AirTravelerAvail;
import com.apcb.ticketsHandler.kiuEntities.Airline;
import com.apcb.ticketsHandler.kiuEntities.CabinPref;
import com.apcb.ticketsHandler.kiuEntities.Location;
import com.apcb.ticketsHandler.kiuEntities.AirItinerary;
import com.apcb.ticketsHandler.kiuEntities.FlightSegment;
import com.apcb.ticketsHandler.kiuEntities.OriginDestinationOption;
import com.apcb.ticketsHandler.kiuEntities.PassengerTypeQuantity;
import com.apcb.ticketsHandler.kiuEntities.Pos;
import com.apcb.ticketsHandler.kiuEntities.Source;
import com.apcb.ticketsHandler.kiuEntities.SpecificFlightInfo;
import com.apcb.ticketsHandler.kiuEntities.TravelPreferences;
import com.apcb.ticketsHandler.kiuEntities.TravelerInfoSummary;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRQ;
import com.apcb.ticketsHandler.kiuPrincipalEntities.KIU_AirAvailRS;
import com.apcb.utils.utils.PropertiesReader;
import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import com.apcb.utils.ticketsHandler.Enums.MealCodeEnum;
import com.apcb.utils.ticketsHandler.Enums.PassangerTypeEnum;
import com.apcb.utils.ticketsHandler.entities.Itinerary;
import com.apcb.utils.ticketsHandler.entities.ItineraryOption;
import com.apcb.utils.ticketsHandler.entities.Passanger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class KIUParserEntities {
    private final static Logger log = Logger.getLogger(KIUParserEntities.class);
    
    public static String toDateSring(Calendar date, PropertiesReader prop, String Format){
        try {
            DateFormat df = new SimpleDateFormat(prop.getProperty(Format, false));
            return df.format(date.getTime());
        } catch (Exception e) {
            log.error("Error toDateString : "+Format, e);    
        }
        return "Error toDateString : "+Format;
    }
    
    public static Calendar fromDateSring(String strDate, PropertiesReader prop, String Format){
        Calendar date = new GregorianCalendar();
        if (!strDate.isEmpty()){
            try {
                DateFormat df = new SimpleDateFormat(prop.getProperty(Format, false)); 
                date.setTime(df.parse(strDate));
                return date;
            } catch (Exception e) {
                log.error("Error fromDateSring : "+Format, e);    
            }
        }
        return date;
    }
  
    public static KIU_AirAvailRQ toAirAvailRQRequest(Itinerary itinerary, PropertiesReader prop){
           
           KIU_AirAvailRQ avail = new KIU_AirAvailRQ();
                        
                        avail.setEchoToken(1);                        
                        avail.setTimeStamp(toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
                        avail.setTarget(prop.getProperty("Target", false));
                        avail.setVersion(prop.getProperty("Version", false));
                        avail.setSequenceNmbr(1);
                        avail.setPrimaryLangID(prop.getProperty("PrimaryLang", false));
                        avail.setDirectFlightsOnly(itinerary.isDirectFlightsOnly());
                        avail.setMaxResponses(Integer.parseInt(prop.getProperty("MaxResponses", false)));

                        Pos pos = new Pos();
                            Source source = new Source();
                            source.setAgentSine(prop.getProperty("AgentSine"));
                            source.setTerminalID(prop.getProperty("TerminalID"));
                            pos.setSource(source);
                    avail.setPos(pos);
                    
                        SpecificFlightInfo specificFlightInfo = new SpecificFlightInfo();
                            Airline airline = new Airline();
                            airline.setCode(prop.getProperty("airlineCode", false));
                            specificFlightInfo.setAirline(airline);
                    avail.setSpecificFlightInfo(specificFlightInfo);
                        AirItinerary origDesInfo = new AirItinerary();
                            origDesInfo.setDepartureDateTime(toDateSring(itinerary.getDepartureDateTime(), prop, "DateTimeFormat"));
                                Location origLocation = new Location();
                                origLocation.setLocationCode(itinerary.getOriginLocationCode().getCode());
                            origDesInfo.setOriginLocation(origLocation);
                                Location destLocation = new Location();
                                destLocation.setLocationCode(itinerary.getDestinationLocationCode().getCode());
                            origDesInfo.setDestinationLocation(destLocation);
                    avail.setOriginDestinationInformation(new ArrayList<>());        
                    avail.getOriginDestinationInformation().add(origDesInfo);
                    
                        TravelPreferences travelPreferences = new TravelPreferences();
                                CabinPref cabinPref = new CabinPref();
                                cabinPref.setCabin(itinerary.getCabin().getDescription());
                            travelPreferences.setCabinPref(cabinPref);
                    avail.setTravelPreferences(travelPreferences);
                    
                        TravelerInfoSummary travelerInfoSummary = new TravelerInfoSummary();
                                AirTravelerAvail airTravelerAvail = new AirTravelerAvail();
                                    airTravelerAvail.setPassengerTypeQuantity(new ArrayList<>());
                                            for (Passanger passanger : itinerary.getPassangers()){
                                               PassengerTypeQuantity passengerTypeQuantity = new PassengerTypeQuantity();
                                                passengerTypeQuantity.setCode(passanger.getPassangerType().getCode());
                                                passengerTypeQuantity.setQuantity(passanger.getPassangerQuantity());
                                                airTravelerAvail.getPassengerTypeQuantity().add(passengerTypeQuantity); 
                                            }
                                travelerInfoSummary.setAirTravelerAvail(airTravelerAvail);
                    avail.setTravelerInfoSummary(travelerInfoSummary);
        return avail;
    }
    
    public static Itinerary fromAirAvailRQRequest(Itinerary itinerary, KIU_AirAvailRS kIU_AirAvailRS, PropertiesReader prop){
        if (itinerary==null){
            itinerary = new Itinerary();
        }
        List<ItineraryOption> itineraryOptions = new ArrayList<>();
        
        for (AirItinerary airItinerary:kIU_AirAvailRS.getOriginDestinationInformation()){  
            if (airItinerary.getOriginDestinationOptions()!=null){
                for (OriginDestinationOption originDestinationOption:airItinerary.getOriginDestinationOptions().getOriginDestinationOption()){
                
                    ItineraryOption itineraryOption = new ItineraryOption();
                    FlightSegment flightSegment = originDestinationOption.getFlightSegment();
                    itineraryOption.setAirEquipType(flightSegment.getEquipment().getAirEquipType());
                    itineraryOption.setArrivalDateTime(fromDateSring(flightSegment.getArrivalDateTime(),prop,"TimeStampFormat"));
                    itineraryOption.setCabin(CabinTypeEnum.valueOf(flightSegment.getMarketingCabin().getCabinType()));
                    //TODO: hay una ambiguedad en la documentacion aparece como CompanyShortName en algunas partes
                    itineraryOption.setCompanyShortName(flightSegment.getMarketingAirline().getCode());
                    itineraryOption.setDepartureDateTime(fromDateSring(flightSegment.getDepartureDateTime(),prop,"TimeStampFormat"));
                    //TODO: hay una ambiguedad en la documentacion aparece como atrubuto y en algunas partes como elemento
                    try {
                      itineraryOption.setArrivalLocationCode(LocationEnum.valueOf(flightSegment.getArrivalAirport().getLocationCode()));
                    } catch (Exception e) {
                        log.error("Error ArrivalLocationCode ",e);
                    }
                    
                    itineraryOption.setFlightNumber(flightSegment.getFlightNumber());
                    itineraryOption.setJourneyDuration(flightSegment.getJourneyDuration());
                    
                    List<String> meals = new ArrayList<>();
                    for (Byte code : flightSegment.getMeal().getMealCode().getBytes()){
                        meals.add(MealCodeEnum.getDescriptionByCode(code.toString()));  
                    }
                    itineraryOption.setMealCode(meals.toArray(new String[meals.size()]));
                    itineraryOption.setMealServices(!(meals.isEmpty() || meals.contains(MealCodeEnum.NoMeals.getDescription())));
                    try {
                        itineraryOption.setDepartureLocationCode(LocationEnum.valueOf(flightSegment.getDepartureAirport().getLocationCode()));
                     } catch (Exception e) {
                        log.error("Error DepartureLocationCode ",e);
                    }
                    itineraryOption.setStopQuantity(Integer.parseInt(flightSegment.getStopQuantity()));
                    
                    itineraryOptions.add(itineraryOption);
                }
            }
        }
        itinerary.setDestinationOption((ItineraryOption[]) itineraryOptions.toArray(new ItineraryOption[itineraryOptions.size()]));
        return itinerary;
    }
    
    
   
    
}
