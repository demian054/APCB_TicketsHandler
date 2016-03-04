/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apcb.ticketsHandler.utils;

import com.apcb.ticketsHandler.kiuEntities.*;
import com.apcb.ticketsHandler.kiuPrincipalEntities.*;
import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.utils.PropertiesReader;
import com.apcb.utils.ticketsHandler.enums.*;
import com.apcb.utils.ticketsHandler.entities.*;
import com.apcb.utils.utils.DateParser;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class KIUParserEntities {

    private final static Logger log = Logger.getLogger(KIUParserEntities.class);

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

                    itineraryOptions.add(itineraryOption);
                }
                itinerary.putItineraryOption((APCB_ItineraryOption[]) itineraryOptions.toArray(new APCB_ItineraryOption[itineraryOptions.size()]));
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
            for(APCB_ItineraryOption itineraryOption:itinerary.getItineraryOption()) {
                try {        

                    ItemFare itemFareTotal = kIU_AirPriceRS.getPricedItineraries().getPricedItinerary().getAirItineraryPricingInfo().getItinTotalFare();
                    itineraryOption.setTotalCost(new APCB_Cost());

                    itineraryOption.getTotalCost().setTotalAmount(new Double(itemFareTotal.getTotalFare().getAmount()));
                    itineraryOption.getTotalCost().setCurrencyCode(ISOCurrencyEnum.getDescriptionByCode(itemFareTotal.getTotalFare().getCurrencyCode()));
                    if (itemFareTotal.getTaxes()!=null && itemFareTotal.getTaxes().getTax()!=null){
                        List<APCB_Tax> totalTaxList = new ArrayList<>();
                        for(Tax tax:itemFareTotal.getTaxes().getTax()){
                            APCB_Tax aPCB_Tax = new APCB_Tax();
                            aPCB_Tax.setAmount(new Double(tax.getAmount()));
                            aPCB_Tax.setCode(tax.getTaxCode());
                            totalTaxList.add(aPCB_Tax);
                        }
                        itineraryOption.getTotalCost().setTaxes(totalTaxList);
                    }

                    List<PTC_FareBreakdown> pTC_FareBreakdownList = kIU_AirPriceRS.getPricedItineraries().getPricedItinerary().getAirItineraryPricingInfo().getPTC_FareBreakdowns().getPTC_FareBreakdown();

                    for (PTC_FareBreakdown pTC_FareBreakdown:pTC_FareBreakdownList){
                        ItemFare itemFareDetail = pTC_FareBreakdown.getPassengerFare();

                        for (APCB_Passenger passenger:travel.getPassangers()){
                            if (passenger.getPassangerType().getCode().equals(pTC_FareBreakdown.getPassengerTypeQuantity().getCode())){
                                passenger.setDetailCost(new APCB_Cost());
                                passenger.getDetailCost().setTotalAmount(new Double(itemFareDetail.getBaseFare().getAmount()));
                                passenger.getDetailCost().setCurrencyCode(ISOCurrencyEnum.getDescriptionByCode(itemFareDetail.getBaseFare().getCurrencyCode()));

                                if (itemFareDetail.getTaxes()!=null && itemFareDetail.getTaxes().getTax()!=null){
                                    List<APCB_Tax> detailTaxList = new ArrayList<>();
                                    for(Tax tax:itemFareDetail.getTaxes().getTax()){
                                        APCB_Tax aPCB_Tax = new APCB_Tax();
                                        aPCB_Tax.setAmount(new Double(tax.getAmount()));
                                        aPCB_Tax.setCode(tax.getTaxCode());
                                        detailTaxList.add(aPCB_Tax);
                                    }
                                    passenger.getDetailCost().setTaxes(detailTaxList); 
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    log.error("Error parse fromAirPriceResponse", e);
                }
            }
        }   
        return travel;
    }

    public static KIU_AirBookRQ toAirBookRequest(APCB_Travel travel, PropertiesReader prop) {
        KIU_AirBookRQ kIU_AirBookRQ = new KIU_AirBookRQ();

        kIU_AirBookRQ.setEchoToken(1);
        kIU_AirBookRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_AirBookRQ.setTarget(prop.getProperty("Target", false));
        kIU_AirBookRQ.setVersion(prop.getProperty("Version", false));
        kIU_AirBookRQ.setSequenceNmbr(travel.getTransactionId());
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

            for (APCB_Passenger passanger : travel.getPassangers()) {
                for (APCB_PassengerDetail passangerDetail : passanger.getPassengersDetail()) {
                    AirTraveler airTraveler = new AirTraveler();
                    airTraveler.setPassengerTypeCode(passanger.getPassangerType().getCode());
                    
                    PersonName personName = new PersonName();
                    personName.setGivenName(passangerDetail.getName());
                    personName.setSurname(passangerDetail.getSurname());
                    airTraveler.setPersonName(personName);
                    
                    if (passangerDetail.getTelephone()!= null && passangerDetail.getSurname().length()>3){
                        Telephone telephone = new Telephone();
                        telephone.setAreaCityCode(passangerDetail.getTelephone().substring(0, 3));
                        telephone.setPhoneNumber(passangerDetail.getTelephone().substring(4));
                        airTraveler.setTelephone(telephone);
                    }
                    
                    airTraveler.setEmail(passangerDetail.getEmail());
                    
                    Document document = new Document();
                    document.setDocType(passangerDetail.getDocumentType().getCode());
                    document.setDocID(passangerDetail.getDocumentID());
                    airTraveler.setDocument(document);
                    
                    CustoLoyalty custoLoyalty = new CustoLoyalty();
                    custoLoyalty.setMembershipID(passangerDetail.getCustLoyaltyMembershipID());
                    custoLoyalty.setProgramID(passangerDetail.getCustLoyaltyProgramID());
                    airTraveler.setCustoLoyalty(custoLoyalty);
                    
                    TravelerRefNumber travelerRefNumber = new TravelerRefNumber();
                    travelerRefNumber.setRPH(new Integer(passangerDetail.getDocumentID()));
                    
                    travelersInfo.add(airTraveler);
                }
            }
        }

        kIU_AirBookRQ.setTravelerInfo(travelersInfo);
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
        bookingReferenceID.setCompanyName(prop.getProperty("airlineCode", false));
        demandTicketDetail.setBookingReferenceID(bookingReferenceID);
        
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPaymentType(Integer.valueOf(payMainInfo.getPaymentType().getCode()));
            CreditCardInfo creditCardInfo = new CreditCardInfo();
            creditCardInfo.setCardType(Integer.BYTES);
            creditCardInfo.setCardCode(null);
            creditCardInfo.setCardNumber(payMainInfo.getCardNumber().toString());
            creditCardInfo.setSeriesCode(payMainInfo.getCVC());
            
            Calendar ExpirationDate = DateParser.fromDateSring(payMainInfo.getExpirationDate(), prop, "ExpirationDateCardFormatIN" );
            creditCardInfo.setExpireDate(DateParser.toDateSring(ExpirationDate, prop, "ExpirationDateCardFormatOUT"));
            
        paymentInfo.setCreditCardInfo(creditCardInfo);
        
            ValueAddedTax valueAddedTax = new ValueAddedTax();
            valueAddedTax.setVAT(payMainInfo.getTaxesAmount().toString());
        paymentInfo.setValueAddedTax(valueAddedTax);
        
        demandTicketDetail.setPaymentInfo(paymentInfo);
        kIU_AirDemandTicketRQ.setDemandTicketDetail(demandTicketDetail);

        return kIU_AirDemandTicketRQ;
    }

    public static APCB_Travel fromAirDemandTicketResponse(APCB_Travel travel, KIU_AirDemandTicketRS kIU_AirDemandTicketRS, PropertiesReader prop) {
        if (kIU_AirDemandTicketRS.getTicketItemInfo() != null) {
            travel.setTicketNumber(kIU_AirDemandTicketRS.getTicketItemInfo().getTicketNumber());
        }
        return travel;
    }

    public static KIU_CancelRQ toCancelRequest(APCB_Travel travel, PropertiesReader prop) {
        KIU_CancelRQ kIU_CancelRQ = new KIU_CancelRQ();
        kIU_CancelRQ.setEchoToken(1);
        kIU_CancelRQ.setTimeStamp(DateParser.toDateSring(Calendar.getInstance(), prop, "TimeStampFormatTZ"));
        kIU_CancelRQ.setTarget(prop.getProperty("Target", false));
        kIU_CancelRQ.setVersion(prop.getProperty("Version", false));
        kIU_CancelRQ.setSequenceNmbr(travel.getTransactionId());
        kIU_CancelRQ.setPrimaryLangID(prop.getProperty("PrimaryLang", false));

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
        kIU_CancelRQ.setPOS(pos);
        
        kIU_CancelRQ.setUniqueID(new ArrayList<UniqueId>());
        UniqueId bookingReference = new UniqueId();
        bookingReference.setType(UniqueIDTypeEnum.BookingReferenceID.getCode());
        bookingReference.setID(travel.getBookingReferenceID());
        kIU_CancelRQ.getUniqueID().add(bookingReference);
        
        if (travel.getTicketNumber()!=null && !travel.getTicketNumber().isEmpty()){
            UniqueId transaction = new UniqueId();
            transaction.setType(UniqueIDTypeEnum.TicketNumber.getCode());
            transaction.setID(travel.getTicketNumber());
            kIU_CancelRQ.getUniqueID().add(transaction);
            
            Ticketing ticketing = new Ticketing();
            ticketing.setTicketTimeLimit(Integer.valueOf(prop.getProperty("TicketTimeLimitBeforeCancel", false)));
        }
        return kIU_CancelRQ;
    }

    public static APCB_Travel fromCancelResponse(APCB_Travel travel, KIU_CancelRS kIU_CancelRS, PropertiesReader propKiu) {
        if (kIU_CancelRS.getTicketing()!= null){
            travel.setTicketTimeLimit(kIU_CancelRS.getTicketing().getTicketTimeLimit());
        }
        return travel;
    }

}
