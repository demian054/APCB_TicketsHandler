/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apcb.ticketsHandler.utils;

import com.apcb.utils.ticketsHandler.enums.NamePrefixTypeEnum;
import com.apcb.ticketsHandler.kiuEntities.*;
import com.apcb.ticketsHandler.kiuPrincipalEntities.*;
import com.apcb.utils.entities.RequestTicket;
import com.apcb.utils.entities.ResponseTicket;
import com.apcb.utils.enums.DocumentTypeEnum;
import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.utils.PropertiesReader;
import com.apcb.utils.ticketsHandler.enums.*;
import com.apcb.utils.ticketsHandler.entities.*;
import com.apcb.utils.utils.DateParser;
import com.apcb.utils.utils.StringUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Demian
 */
public class KIUParserEntities {

    private static Logger log = LogManager.getLogger(KIUParserEntities.class);

    public static KIU_AirAvailRQ toAirAvailRequest(APCB_Travel travel, PropertiesReader prop) {

        KIU_AirAvailRQ avail = new KIU_AirAvailRQ();

        avail.setEchoToken(1);
        avail.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        avail.setTarget(prop.getProperty("Target", false));
        avail.setVersion(prop.getProperty("Version", false));
        avail.setSequenceNmbr(travel.getTransactionId());
        avail.setPrimaryLangID(prop.getProperty("PrimaryLang", false));
        avail.setDirectFlightsOnly(travel.isDirectFlightsOnly());
        avail.setMaxResponses(Integer.parseInt(prop.getProperty("MaxResponses", false)));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(travel.getCurrency())) {
            source.setISOCurrency(travel.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        pos.setSource(source);
        avail.setPos(pos);

        SpecificFlightInfo specificFlightInfo = new SpecificFlightInfo();
        Airline airline = new Airline();
        airline.setCode(prop.getProperty("airlineCode", false));
        specificFlightInfo.setAirline(airline);
        avail.setSpecificFlightInfo(specificFlightInfo);
        AirItinerary origDesInfo = new AirItinerary();
        for (APCB_Itinerary itinerary : travel.getItinerary()) {
            origDesInfo.setDepartureDateTime(DateParser.toDateSring(itinerary.getDepartureDateTime(), prop, "DateTimeFormat"));
            Location origLocation = new Location();
            origLocation.setLocationCode(itinerary.getOriginLocationCode().getCode());
            origDesInfo.setOriginLocation(origLocation);
            Location destLocation = new Location();
            destLocation.setLocationCode(itinerary.getDestinationLocationCode().getCode());
            origDesInfo.setDestinationLocation(destLocation);
            avail.setOriginDestinationInformation(new ArrayList<>());
            avail.getOriginDestinationInformation().add(origDesInfo);
        }
        TravelPreferences travelPreferences = new TravelPreferences();
        CabinPref cabinPref = new CabinPref();
        cabinPref.setCabin(travel.getCabin().getDescription());
        travelPreferences.setCabinPref(cabinPref);
        avail.setTravelPreferences(travelPreferences);

        TravelerInfoSummary travelerInfoSummary = new TravelerInfoSummary();
        AirTravelerAvail airTravelerAvail = new AirTravelerAvail();
        airTravelerAvail.setPassengerTypeQuantity(new ArrayList<>());
        for (APCB_Passenger passanger : travel.getPassangers()) {
            PassengerTypeQuantity passengerTypeQuantity = new PassengerTypeQuantity();
            passengerTypeQuantity.setCode(passanger.getPassangerType().getCode());
            passengerTypeQuantity.setQuantity(passanger.getPassangerQuantity());
            airTravelerAvail.getPassengerTypeQuantity().add(passengerTypeQuantity);
        }
        travelerInfoSummary.setAirTravelerAvail(airTravelerAvail);
        avail.setTravelerInfoSummary(travelerInfoSummary);
        return avail;
    }

    public static APCB_Travel fromAirAvailResponse(APCB_Travel travel, KIU_AirAvailRS kIU_AirAvailRS, PropertiesReader prop) {
        log.info("Response from KIU :" + new Gson().toJson(kIU_AirAvailRS));
        // contamos los asientos qeue necesitamos solo niño y adulto, los infantes no ocupan.
        int passangerQuantitySeat = 0;
        for (APCB_Passenger passenger:travel.getPassangers()){
            if (passenger.getPassangerType().equals(PassangerTypeEnum.Adulto)
                    || passenger.getPassangerType().equals(PassangerTypeEnum.Niño)){
                passangerQuantitySeat += passenger.getPassangerQuantity();
            }

        }
        
        int itineraryNumber = 0;
        for (AirItinerary airItinerary : kIU_AirAvailRS.getOriginDestinationInformation()) {
            APCB_Itinerary itinerary = travel.getItinerary()[itineraryNumber++];
            List<APCB_ItineraryOption> itineraryOptions = new ArrayList<>();
            if (airItinerary.getOriginDestinationOptions() != null && airItinerary.getOriginDestinationOptions().getOriginDestinationOption() != null) {
                for (OriginDestinationOption originDestinationOption : airItinerary.getOriginDestinationOptions().getOriginDestinationOption()) {
                   
                    APCB_ItineraryOption itineraryOption = new APCB_ItineraryOption();
                    FlightSegment flightSegment = originDestinationOption.getFlightSegment();
                    itineraryOption.setAirEquipType(flightSegment.getEquipment().getAirEquipType());
                    itineraryOption.setArrivalDateTime(DateParser.fromDateSring(flightSegment.getArrivalDateTime(), prop, "TimeStampFormat"));
                    itineraryOption.setCabin(CabinTypeEnum.valueOf(flightSegment.getMarketingCabin().getCabinType()));
                    //TODO: hay una ambiguedad en la documentacion aparece como CompanyShortName en algunas partes
                    itineraryOption.setCompanyShortName(flightSegment.getMarketingAirline().getCode());
                    itineraryOption.setDepartureDateTime(DateParser.fromDateSring(flightSegment.getDepartureDateTime(), prop, "TimeStampFormat"));
                    //TODO: hay una ambiguedad en la documentacion aparece como atrubuto y en algunas partes como elemento
                    try {
                        itineraryOption.setArrivalLocationCode(LocationEnum.valueOf(flightSegment.getArrivalAirport().getLocationCode()));
                    } catch (Exception e) {
                        log.error("Error ArrivalLocationCode ", e);
                    }

                    itineraryOption.setFlightNumber(flightSegment.getFlightNumber());
                    itineraryOption.setJourneyDuration(flightSegment.getJourneyDuration());

                    List<String> meals = new ArrayList<>();
                    for (Byte code : flightSegment.getMeal().getMealCode().getBytes()) {
                        meals.add(MealCodeEnum.getDescriptionByCode(code.toString()));
                    }
                    itineraryOption.setMealCode(meals.toArray(new String[meals.size()]));
                    itineraryOption.setMealServices(!(meals.isEmpty() || meals.contains(MealCodeEnum.NoMeals.getDescription())));
                    try {
                        itineraryOption.setDepartureLocationCode(LocationEnum.valueOf(flightSegment.getDepartureAirport().getLocationCode()));
                    } catch (Exception e) {
                        log.error("Error DepartureLocationCode ", e);
                    }
                    itineraryOption.setStopQuantity(Integer.parseInt(flightSegment.getStopQuantity()));
                    
                    for (BookingClassAvail bookingClassAvail : flightSegment.getBookingClassAvail()) {
                        if (bookingClassAvail.getResBookDesigCode().equals(itineraryOption.getCabin().getBookingCode())){
                            // si esta en L es Lista de espera y si esta en R estan en Reservados por tanto no se agregan
                            log.info("bookingClassAvail.getResBookDesigQuantity()="+bookingClassAvail.getResBookDesigQuantity());
                            if (bookingClassAvail.getResBookDesigQuantity().equalsIgnoreCase("L") 
                                    || bookingClassAvail.getResBookDesigQuantity().equalsIgnoreCase("R")){
                                itineraryOption.setBookingAvail(0);
                            } else if (passangerQuantitySeat>Integer.valueOf(bookingClassAvail.getResBookDesigQuantity())){
                                itineraryOption.setBookingAvail(0);
                            }else {
                                itineraryOption.setBookingAvail(Integer.valueOf(bookingClassAvail.getResBookDesigQuantity()));
                            }
                            
                        }                        
                    }
                    if (itineraryOption.getBookingAvail()>0){
                        itineraryOptions.add(itineraryOption);
                    }
                    
                }
                     // si no hay opciones de itinerario que no agrege la lista (esto es posible ya que ignoramos los que esta en R y L)
                    if (itineraryOptions.size()>0){
                    itinerary.putItineraryOption((APCB_ItineraryOption[]) itineraryOptions.toArray(new APCB_ItineraryOption[itineraryOptions.size()]));
                    }
                }
            //travel.putItinerary(itinerary);  
            }
        //travel.setItinerary((ItineraryOption[]) itineraryOptions.toArray(new ItineraryOption[itineraryOptions.size()]));
        return travel;
    }

    public static KIU_AirPriceRQ toAirPriceRequest(APCB_Travel travel, PropertiesReader prop) {

        KIU_AirPriceRQ kIU_AirPriceRQ = new KIU_AirPriceRQ();

        kIU_AirPriceRQ.setEchoToken(1);
        kIU_AirPriceRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_AirPriceRQ.setTarget(prop.getProperty("Target", false));
        kIU_AirPriceRQ.setVersion(prop.getProperty("Version", false));
        kIU_AirPriceRQ.setSequenceNmbr(travel.getTransactionId());
        kIU_AirPriceRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setPseudoCityCode(prop.getProperty("PseudoCityCode", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(travel.getCurrency())) {
            source.setISOCurrency(travel.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        source.setRequestorID(new Property(prop.getProperty("RequestorIDType", false)));
        source.setBookingChannel(new Property(prop.getProperty("BookingChannelType", false)));
        pos.setSource(source);
        kIU_AirPriceRQ.setPOS(pos);

        List<AirItinerary> origDesInfos = new ArrayList<AirItinerary>();
        if (travel.getItinerary()!=null){
            for (APCB_Itinerary itinerary : travel.getItinerary()) {
               
                if (itinerary.getItineraryOption()!=null){
                    AirItinerary origDesInfo = new AirItinerary();
                    OriginDestinationOptions originDestinationOptions = new OriginDestinationOptions();
                    originDestinationOptions.setOriginDestinationOption(new ArrayList<OriginDestinationOption>());
                    // solo se agarra el primero para que kiu no devuelva el precio de todos sumados.
                    //APCB_ItineraryOption itineraryOption = itinerary.getItineraryOption()[0];
                    for (APCB_ItineraryOption itineraryOption : itinerary.getItineraryOption()) {
                        
                        OriginDestinationOption originDestinationOption = new OriginDestinationOption();

                        FlightSegment flightSegment = new FlightSegment();
                        flightSegment.setDepartureDateTime(DateParser.toDateSring(itineraryOption.getDepartureDateTime(), prop, "TimeStampFormat"));
                        flightSegment.setArrivalDateTime(DateParser.toDateSring(itineraryOption.getArrivalDateTime(), prop, "TimeStampFormat"));
                        flightSegment.setFlightNumber(itineraryOption.getFlightNumber());
                        flightSegment.setDepartureAirport(new Location(itineraryOption.getDepartureLocationCode().getCode()));
                        flightSegment.setResBookDesigCode(itineraryOption.getCabin().getBookingCode());
                        flightSegment.setArrivalAirport(new Location(itineraryOption.getArrivalLocationCode().getCode()));
                        flightSegment.setMarketingAirline(new Property(prop.getProperty("airlineCode", false), null));
                        originDestinationOption.setFlightSegment(flightSegment);
                        originDestinationOptions.getOriginDestinationOption().add(originDestinationOption);
                        

                    }
                    origDesInfo.setOriginDestinationOptions(originDestinationOptions);
                    origDesInfos.add(origDesInfo);
                }

            }
        }
        kIU_AirPriceRQ.setAirItinerary(origDesInfos);

        TravelerInfoSummary travelerInfoSummary = new TravelerInfoSummary();
        AirTravelerAvail airTravelerAvail = new AirTravelerAvail();
        if (travel.getPassangers() != null) {
            if (travel.getPassangers().length > 0) {
                airTravelerAvail.setPassengerTypeQuantity(new ArrayList<>());
            }
            for (APCB_Passenger passanger : travel.getPassangers()) {
                PassengerTypeQuantity passengerTypeQuantity = new PassengerTypeQuantity();
                passengerTypeQuantity.setCode(passanger.getPassangerType().getCode());
                passengerTypeQuantity.setQuantity(passanger.getPassangerQuantity());
                airTravelerAvail.getPassengerTypeQuantity().add(passengerTypeQuantity);
            }
        }
        travelerInfoSummary.setAirTravelerAvail(airTravelerAvail);
        kIU_AirPriceRQ.setTravelerInfoSummary(travelerInfoSummary);
        return kIU_AirPriceRQ;
    }

    public static APCB_Travel fromAirPriceResponse(APCB_Travel travel, KIU_AirPriceRS kIU_AirPriceRS, PropertiesReader prop) {
        
        for(APCB_Itinerary itinerary:travel.getItinerary()) {
            APCB_Cost totalCost = new APCB_Cost();
            
            ItemFare itemFareTotal = kIU_AirPriceRS.getPricedItineraries().getPricedItinerary().getAirItineraryPricingInfo().getItinTotalFare();
            
            totalCost.setBaseAmount(new Double(itemFareTotal.getBaseFare().getAmount()));
            totalCost.setTotalAmount(new Double(itemFareTotal.getTotalFare().getAmount()));
            totalCost.setCurrencyCode(ISOCurrencyEnum.getDescriptionByCode(itemFareTotal.getBaseFare().getCurrencyCode()));
            
            if (itemFareTotal.getTaxes()!=null && itemFareTotal.getTaxes().getTax()!=null){
                List<APCB_Tax> totalTaxList = new ArrayList<>();
                for(Tax tax:itemFareTotal.getTaxes().getTax()){
                    APCB_Tax aPCB_Tax = new APCB_Tax();
                    aPCB_Tax.setAmount(new Double(tax.getAmount()));
                    aPCB_Tax.setCode(tax.getTaxCode());
                    totalTaxList.add(aPCB_Tax);
                }
                totalCost.setTaxes(totalTaxList);
            }

            itinerary.setTotalCost(totalCost);
        }   
        return travel;
    }

    public static KIU_AirBookRQ toAirBookRequest(APCB_Travel travel, APCB_PayMain payMainInfo, PropertiesReader prop) {
        KIU_AirBookRQ kIU_AirBookRQ = new KIU_AirBookRQ();

        kIU_AirBookRQ.setEchoToken(1);
        kIU_AirBookRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_AirBookRQ.setTarget(prop.getProperty("Target", false));
        kIU_AirBookRQ.setVersion(prop.getProperty("Version", false));
        //kIU_AirBookRQ.setSequenceNmbr(travel.getTransactionId());
        kIU_AirBookRQ.setSequenceNmbr(1);
        kIU_AirBookRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setPseudoCityCode(prop.getProperty("PseudoCityCode", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(travel.getCurrency())) {
            source.setISOCurrency(travel.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        source.setRequestorID(new Property(prop.getProperty("RequestorIDType", false)));
        source.setBookingChannel(new Property(prop.getProperty("BookingChannelType", false)));
        pos.setSource(source);
        kIU_AirBookRQ.setPOS(pos);

        List<AirItinerary> origDesInfos = new ArrayList<AirItinerary>();
        if (travel.getItinerary()!=null){
            for (APCB_Itinerary itinerary : travel.getItinerary()) {
                AirItinerary origDesInfo = new AirItinerary();
                OriginDestinationOptions originDestinationOptions = new OriginDestinationOptions();
                originDestinationOptions.setOriginDestinationOption(new ArrayList<OriginDestinationOption>());
                if (itinerary.getItineraryOption()!=null){
                    for (APCB_ItineraryOption itineraryOption : itinerary.getItineraryOption()) {
                        OriginDestinationOption originDestinationOption = new OriginDestinationOption();

                        FlightSegment flightSegment = new FlightSegment();
                        flightSegment.setDepartureDateTime(DateParser.toDateSring(itineraryOption.getDepartureDateTime(), prop, "DateTimeFormat"));
                        flightSegment.setArrivalDateTime(DateParser.toDateSring(itineraryOption.getArrivalDateTime(), prop, "DateTimeFormat"));
                        flightSegment.setFlightNumber(itineraryOption.getFlightNumber());
                        flightSegment.setDepartureAirport(new Location(itineraryOption.getDepartureLocationCode().getCode()));
                        flightSegment.setResBookDesigCode(itineraryOption.getCabin().getBookingCode());
                        flightSegment.setArrivalAirport(new Location(itineraryOption.getArrivalLocationCode().getCode()));
                        flightSegment.setMarketingAirline(new Property(prop.getProperty("airlineCode", false), null));
                        originDestinationOption.setFlightSegment(flightSegment);
                        originDestinationOptions.getOriginDestinationOption().add(originDestinationOption);
                    }
                }
                origDesInfo.setOriginDestinationOptions(originDestinationOptions);
                origDesInfos.add(origDesInfo);
            }
        }
        kIU_AirBookRQ.setAirItinerary(origDesInfos);

        List<AirTraveler> travelersInfo = new ArrayList<>();

        if (travel.getPassangers() != null) {
            int RPH = 0;
            for (APCB_Passenger passanger : travel.getPassangers()) {
                for (APCB_PassengerDetail passangerDetail : passanger.getPassengersDetail()) {
                    AirTraveler airTraveler = new AirTraveler();
                    airTraveler.setPassengerTypeCode(passanger.getPassangerType().getCode());
                    
                    PersonName personName = new PersonName();
                    if (passangerDetail.getNamePrefix()!=null){
                        personName.setNamePrefix(passangerDetail.getNamePrefix().getCode());
                    }
                    passangerDetail.setName(StringUtils.removeSpecials(passangerDetail.getName()));
                    passangerDetail.setSurname(StringUtils.removeSpecials(passangerDetail.getSurname()));
                    
                    personName.setGivenName(passangerDetail.getName());
                    personName.setSurname(passangerDetail.getSurname());
                    if (passangerDetail.getMiddleName()!=null && !passangerDetail.getMiddleName().isEmpty()){
                        passangerDetail.setMiddleName(StringUtils.removeSpecials(passangerDetail.getMiddleName()));
                        personName.setMiddleName(passangerDetail.getMiddleName());
                    }

                    airTraveler.setPersonName(personName);
                    
                    if (passangerDetail.getTelephone()!= null && passangerDetail.getTelephone().length()>3){
                        Telephone telephone = new Telephone();
                        telephone.setAreaCityCode(passangerDetail.getTelephone().substring(0, 4));
                        telephone.setPhoneNumber(passangerDetail.getTelephone().substring(4));
                        airTraveler.setTelephone(telephone);
                    } else if (passangerDetail.getTelephoneHome()!= null && passangerDetail.getTelephoneHome().length()>3){
                        Telephone telephone = new Telephone();
                        telephone.setAreaCityCode(passangerDetail.getTelephoneHome().substring(0, 4));
                        telephone.setPhoneNumber(passangerDetail.getTelephoneHome().substring(4));
                        airTraveler.setTelephone(telephone);
                    }
                    
                    if (!passanger.getPassangerType().equals(PassangerTypeEnum.Adulto)){
                        passangerDetail.setDocumentType(DocumentTypeEnum.Cedula);
                        passangerDetail.setDocumentID(passangerDetail.getAge()+passangerDetail.getAgeType().getCode());
                        passangerDetail.setEmail(payMainInfo.getEmailPayer());
                    }
                    
                    Document document = new Document();                   
                    document.setDocType(passangerDetail.getDocumentType().getCode());
                    document.setDocID(passangerDetail.getDocumentID());
                    airTraveler.setDocument(document);
                    airTraveler.setEmail(passangerDetail.getEmail());
                    
                    CustoLoyalty custoLoyalty = new CustoLoyalty();
                    custoLoyalty.setMembershipID(passangerDetail.getCustLoyaltyMembershipID());
                    custoLoyalty.setProgramID(passangerDetail.getCustLoyaltyProgramID());
                    airTraveler.setCustoLoyalty(custoLoyalty);
                    
                    TravelerRefNumber travelerRefNumber = new TravelerRefNumber();
                    travelerRefNumber.setRPH(++RPH);
                    airTraveler.setTravelerRefNumber(travelerRefNumber);
                    
                    travelersInfo.add(airTraveler);
                }
            }
        }

        kIU_AirBookRQ.setTravelerInfo(new TravelerInfo());
        kIU_AirBookRQ.getTravelerInfo().setAirTraveler(travelersInfo);
        Ticketing ticketing = new Ticketing();
        ticketing.setTicketTimeLimit(new Integer(prop.getProperty("TicketTimeLimit", false)));
        kIU_AirBookRQ.setTicketing(ticketing);
        return kIU_AirBookRQ;
    }

    public static APCB_Travel fromAirBookResponse(APCB_Travel travel, KIU_AirBookRS kIU_AirBookRS, PropertiesReader prop) {
            if (kIU_AirBookRS.getBookingReferenceID() != null) {
                travel.setBookingReferenceID(kIU_AirBookRS.getBookingReferenceID().getID());
                travel.setTicketTimeLimit(new Integer(prop.getProperty("TicketTimeLimit", false)));
            }
            return travel;
    }

    public static KIU_AirDemandTicketRQ toAirDemandTicketRequest(APCB_Travel travel, APCB_PayMain payMainInfo, PropertiesReader prop) {
        KIU_AirDemandTicketRQ kIU_AirDemandTicketRQ = new KIU_AirDemandTicketRQ();
        kIU_AirDemandTicketRQ.setEchoToken(1);
        kIU_AirDemandTicketRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_AirDemandTicketRQ.setTarget(prop.getProperty("Target", false));
        kIU_AirDemandTicketRQ.setVersion(prop.getProperty("Version", false));
        kIU_AirDemandTicketRQ.setSequenceNmbr(travel.getTransactionId());
        kIU_AirDemandTicketRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setPseudoCityCode(prop.getProperty("PseudoCityCode", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(travel.getCurrency())) {
            source.setISOCurrency(travel.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        source.setRequestorID(new Property(prop.getProperty("RequestorIDType", false)));
        source.setBookingChannel(new Property(prop.getProperty("BookingChannelType", false)));
        pos.setSource(source);
        kIU_AirDemandTicketRQ.setPOS(pos);

        DemandTicketDetail demandTicketDetail = new DemandTicketDetail();
        
        UniqueId bookingReferenceID = new UniqueId();
        bookingReferenceID.setID(travel.getBookingReferenceID());
        Property companyName = new Property();
        companyName.setCode(prop.getProperty("airlineCode", false));
        bookingReferenceID.setCompanyName(companyName);
        demandTicketDetail.setBookingReferenceID(bookingReferenceID);
        
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPaymentType(Integer.valueOf(payMainInfo.getPaymentType().getCode()));
            CreditCardInfo creditCardInfo = new CreditCardInfo();
            creditCardInfo.setCardType(Integer.valueOf(payMainInfo.getPaymentType().getCodeAlternative()));
            creditCardInfo.setCardCode(payMainInfo.getCardEmisor().getCode());
            creditCardInfo.setCardNumber(payMainInfo.getCardNumber().toString());
            creditCardInfo.setSeriesCode(payMainInfo.getCVC());
            
            Calendar ExpirationDate = DateParser.fromDateSring(payMainInfo.getExpirationDate(), prop, "ExpirationDateCardFormatIN" );
            creditCardInfo.setExpireDate(DateParser.toDateSring(ExpirationDate, prop, "ExpirationDateCardFormatOUT"));
            
        paymentInfo.setCreditCardInfo(creditCardInfo);
        
           /* ValueAddedTax valueAddedTax = new ValueAddedTax();
            valueAddedTax.setVAT(payMainInfo.getTaxesAmount().toString());
        paymentInfo.setValueAddedTax(valueAddedTax);*/
        
        demandTicketDetail.setPaymentInfo(paymentInfo);
        kIU_AirDemandTicketRQ.setDemandTicketDetail(demandTicketDetail);

        return kIU_AirDemandTicketRQ;
    }

    public static APCB_Travel fromAirDemandTicketResponse(APCB_Travel travel, KIU_AirDemandTicketRS kIU_AirDemandTicketRS, PropertiesReader prop) throws Exception {
        if (kIU_AirDemandTicketRS.getTicketItemInfo() != null) {
           
            for (TicketItemInfo ticketItemInfo:kIU_AirDemandTicketRS.getTicketItemInfo()){
                APCB_PassengerDetail passengerTicketInfo = new APCB_PassengerDetail();
                String[] givenNames = ticketItemInfo.getPassengerName().getGivenName().split(" ");
                passengerTicketInfo.setName(givenNames[0]);
                if (givenNames.length==2){
                    if (NamePrefixTypeEnum.getByCode(givenNames[1]).equals(NamePrefixTypeEnum.KNOW)){
                        passengerTicketInfo.setMiddleName(givenNames[1]);
                    } else {
                        passengerTicketInfo.setNamePrefix(NamePrefixTypeEnum.getByCode(givenNames[1]));
                    }
                } else if (givenNames.length==3){
                    if (NamePrefixTypeEnum.getByCode(givenNames[1]).equals(NamePrefixTypeEnum.KNOW)){
                        passengerTicketInfo.setMiddleName(givenNames[1]);
                        passengerTicketInfo.setNamePrefix(NamePrefixTypeEnum.getByCode(givenNames[2]));
                    } else {
                        passengerTicketInfo.setMiddleName(givenNames[2]);
                        passengerTicketInfo.setNamePrefix(NamePrefixTypeEnum.getByCode(givenNames[1]));
                    }   
                }
                passengerTicketInfo.setSurname(ticketItemInfo.getPassengerName().getSurname());
                
                boolean asignedTicket = false;
                for(APCB_Passenger passengerClass :travel.getPassangers()){
                    for (APCB_PassengerDetail passengerDetail:passengerClass.getPassengersDetail()){
                        log.info(new Gson().toJson(passengerDetail));
                        if (passengerTicketInfo.equals(passengerDetail)){
                            passengerDetail.setTicketNumber(ticketItemInfo.getTicketNumber());
                            asignedTicket = true;
                        }
                    }
                }    
                if (!asignedTicket){
                    throw new Exception("Can´t asign ticket "+ticketItemInfo.getTicketNumber()+" from passenger "+ticketItemInfo.getPassengerName().getGivenName());
                }
            }
        }
        return travel;
    }

    public static KIU_CancelRQ toCancelRequest(RequestTicket requestTicket, PropertiesReader prop) {
        KIU_CancelRQ kIU_CancelRQ = new KIU_CancelRQ();
        kIU_CancelRQ.setEchoToken(1);
        kIU_CancelRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_CancelRQ.setTarget(prop.getProperty("Target", false));
        kIU_CancelRQ.setVersion(prop.getProperty("Version", false));
        kIU_CancelRQ.setSequenceNmbr(requestTicket.getSesionId());
        kIU_CancelRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setPseudoCityCode(prop.getProperty("PseudoCityCode", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(requestTicket.getCurrency())) {
            source.setISOCurrency(requestTicket.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        source.setRequestorID(new Property(prop.getProperty("RequestorIDType", false)));
        source.setBookingChannel(new Property(prop.getProperty("BookingChannelType", false)));
        pos.setSource(source);
        kIU_CancelRQ.setPOS(pos);
        kIU_CancelRQ.setUniqueID(new ArrayList<UniqueId>());
        
        log.info("Canceling Booking code "+requestTicket.getBookingReferenceID());
        
        if (requestTicket.getPassengerDetail()!=null){
            APCB_PassengerDetail passengerDetail = requestTicket.getPassengerDetail();
            if (passengerDetail.getTicketNumber()!=null && !passengerDetail.getTicketNumber().isEmpty()){
                 UniqueId transaction = new UniqueId();
                transaction.setType(UniqueIDTypeEnum.TicketNumber.getCode());
                transaction.setID(passengerDetail.getTicketNumber());
                kIU_CancelRQ.getUniqueID().add(transaction);
                Ticketing ticketing = new Ticketing();
                ticketing.setTicketTimeLimit(Integer.valueOf(prop.getProperty("TicketTimeLimitBeforeCancel", false)));
                kIU_CancelRQ.setTicketing(ticketing);
                log.info("Canceling Ticketing ID "+passengerDetail.getTicketNumber()+ " from pasanger "+passengerDetail.getDocumentID());
            }
        }
         
        UniqueId bookingReference = new UniqueId();
        bookingReference.setType(UniqueIDTypeEnum.BookingReferenceID.getCode());
        bookingReference.setID(requestTicket.getBookingReferenceID());
        kIU_CancelRQ.getUniqueID().add(bookingReference);
        
        return kIU_CancelRQ;
    }

    public static APCB_Travel fromCancelResponse(APCB_Travel travel, KIU_CancelRS kIU_CancelRS, PropertiesReader propKiu) {
        if (kIU_CancelRS.getTicketing()!= null){
            travel.setTicketTimeLimit(kIU_CancelRS.getTicketing().getTicketTimeLimit());
        }
        return travel;
    }
    
    public static KIU_TravelItineraryReadRQ toConsultReservRequest(APCB_Travel travel, PropertiesReader prop) {
           KIU_TravelItineraryReadRQ kIU_TravelItineraryReadRQ = new KIU_TravelItineraryReadRQ();
        kIU_TravelItineraryReadRQ.setEchoToken(1);
        kIU_TravelItineraryReadRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_TravelItineraryReadRQ.setTarget(prop.getProperty("Target", false));
        kIU_TravelItineraryReadRQ.setVersion(prop.getProperty("Version", false));
        kIU_TravelItineraryReadRQ.setSequenceNmbr(travel.getTransactionId());
        kIU_TravelItineraryReadRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setPseudoCityCode(prop.getProperty("PseudoCityCode", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(travel.getCurrency())) {
            source.setISOCurrency(travel.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        source.setRequestorID(new Property(prop.getProperty("RequestorIDType", false)));
        source.setBookingChannel(new Property(prop.getProperty("BookingChannelType", false)));
        pos.setSource(source);
        kIU_TravelItineraryReadRQ.setPOS(pos);
        
        kIU_TravelItineraryReadRQ.setUniqueID(new ArrayList<UniqueId>());
  
        UniqueId bookingReference = new UniqueId();
        bookingReference.setType(UniqueIDTypeEnum.BookingReferenceID.getCode());
        bookingReference.setID(travel.getBookingReferenceID());
        kIU_TravelItineraryReadRQ.getUniqueID().add(bookingReference);
        
        
         
        return kIU_TravelItineraryReadRQ;
    }

    public static KIU_TravelItineraryReadRQ toConsultTicketRequest(RequestTicket requestTicket, PropertiesReader prop) {
        KIU_TravelItineraryReadRQ kIU_TravelItineraryReadRQ = new KIU_TravelItineraryReadRQ();
        kIU_TravelItineraryReadRQ.setEchoToken(1);
        kIU_TravelItineraryReadRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_TravelItineraryReadRQ.setTarget(prop.getProperty("Target", false));
        kIU_TravelItineraryReadRQ.setVersion(prop.getProperty("Version", false));
        kIU_TravelItineraryReadRQ.setSequenceNmbr(requestTicket.getSesionId());
        kIU_TravelItineraryReadRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

        Pos pos = new Pos();
        Source source = new Source();
        source.setAgentSine(prop.getProperty("AgentSine", false));
        source.setTerminalID(prop.getProperty("TerminalID", false));
        source.setPseudoCityCode(prop.getProperty("PseudoCityCode", false));
        source.setISOCountry(ISOCountryEnum.getCodeByDescription(prop.getProperty("ISOCountry", false)));
        if (ISOCurrencyEnum.isValid(requestTicket.getCurrency())) {
            source.setISOCurrency(requestTicket.getCurrency().getCode());
        } else {
            source.setISOCurrency(ISOCurrencyEnum.getCodeByDescription(prop.getProperty("ISOCurrencyDefault", false)));
        }
        source.setRequestorID(new Property(prop.getProperty("RequestorIDType", false)));
        source.setBookingChannel(new Property(prop.getProperty("BookingChannelType", false)));
        pos.setSource(source);
        kIU_TravelItineraryReadRQ.setPOS(pos);
        
        kIU_TravelItineraryReadRQ.setUniqueID(new ArrayList<UniqueId>());
            
        UniqueId transaction = new UniqueId();
        transaction.setType(UniqueIDTypeEnum.TicketNumber.getCode());
        transaction.setID(requestTicket.getPassengerDetail().getTicketNumber());
        kIU_TravelItineraryReadRQ.getUniqueID().add(transaction);
         
        Verification verification = new Verification();
        verification.setEmail(requestTicket.getPassengerDetail().getEmail());
        kIU_TravelItineraryReadRQ.setVerification(verification);
        
        /*} else {
            
            UniqueId bookingReference = new UniqueId();
            bookingReference.setType(UniqueIDTypeEnum.BookingReferenceID.getCode());
            bookingReference.setID(travel.getBookingReferenceID());
            kIU_TravelItineraryReadRQ.getUniqueID().add(bookingReference);
        
        }*/
         
        return kIU_TravelItineraryReadRQ;
    }
    
    public static APCB_Travel fromConsultReservResponse(APCB_Travel travel, KIU_TravelItineraryRS kIU_TravelItineraryRS, PropertiesReader propKiu) {
           // COnsulta por Reserva
           travel.setBookingReferenceID(kIU_TravelItineraryRS.getTravelItinerary().getItineraryRef().getID());
           
           List<CustomerInfo> customerInfos = kIU_TravelItineraryRS.getTravelItinerary().getCustomerInfos().getCustomerInfo();
            
           List<APCB_PassengerDetail> passengerDetailADT = new ArrayList<APCB_PassengerDetail>();
           List<APCB_PassengerDetail> passengerDetailCNN = new ArrayList<APCB_PassengerDetail>();
           List<APCB_PassengerDetail> passengerDetailINF = new ArrayList<APCB_PassengerDetail>();
           for (CustomerInfo customerInfo : customerInfos) {
                Customer customer = customerInfo.getCustomer();
                APCB_PassengerDetail passengerDetail = new APCB_PassengerDetail();
                
                PersonName personName = customer.getPersonName(); 
                passengerDetail.setNamePrefix(NamePrefixTypeEnum.getByCode(personName.getNamePrefix()));
                passengerDetail.setName(personName.getGivenName());
                passengerDetail.setSurname(personName.getSurname());
                passengerDetail.setMiddleName(personName.getMiddleName());
                
                Document document = customer.getDocument();
                passengerDetail.setDocumentType(DocumentTypeEnum.getByCode(document.getDocType()));
                passengerDetail.setDocumentID(document.getDocID());
                
                Verification contactPerson = customer.getContactPerson();
                if (contactPerson!= null){
                    if (contactPerson.getTelephone()!=null){
                         passengerDetail.setTelephone(contactPerson.getTelephone());
                    }
                    if (contactPerson.getEmail()!=null){
                         passengerDetail.setEmail(contactPerson.getEmail());
                    }
                }
               
                switch (PassangerTypeEnum.getByCode(customer.getPassengerTypeCode())){
                    case Adulto:
                        passengerDetailADT.add(passengerDetail);
                        break;
                    case Niño:
                        passengerDetailCNN.add(passengerDetail);
                        break;  
                    case Infante:
                        passengerDetailINF.add(passengerDetail);
                        break;
                }   
           }
           if (!passengerDetailADT.isEmpty()){
               APCB_Passenger aPCB_Passenger = new APCB_Passenger();
               aPCB_Passenger.setPassangerQuantity(passengerDetailADT.size());
               aPCB_Passenger.setPassangerType(PassangerTypeEnum.Adulto);
               aPCB_Passenger.putPassengersDetail(passengerDetailADT.toArray(new APCB_PassengerDetail[passengerDetailADT.size()]));
           }
            if (!passengerDetailCNN.isEmpty()){
               APCB_Passenger aPCB_Passenger = new APCB_Passenger();
               aPCB_Passenger.setPassangerQuantity(passengerDetailCNN.size());
               aPCB_Passenger.setPassangerType(PassangerTypeEnum.Niño);
               aPCB_Passenger.putPassengersDetail(passengerDetailADT.toArray(new APCB_PassengerDetail[passengerDetailCNN.size()]));
           }
            if (!passengerDetailINF.isEmpty()){
               APCB_Passenger aPCB_Passenger = new APCB_Passenger();
               aPCB_Passenger.setPassangerQuantity(passengerDetailINF.size());
               aPCB_Passenger.setPassangerType(PassangerTypeEnum.Infante);
               aPCB_Passenger.putPassengersDetail(passengerDetailADT.toArray(new APCB_PassengerDetail[passengerDetailINF.size()]));
           }
        return travel;
    }
   
    public static APCB_PassengerDetail fromConsultTicketResponse(APCB_PassengerDetail passengerDetail , KIU_TravelItineraryRS kIU_TravelItineraryRS, PropertiesReader propKiu) {
        // nada que hacer aqui solo verfica que el ticket se devuelva
        kIU_TravelItineraryRS.getItineraryInfo().getTicketing().getTicketAdvisory();
        return passengerDetail;
    }

}
