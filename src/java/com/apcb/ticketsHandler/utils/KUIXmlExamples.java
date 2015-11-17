/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.utils;

/**
 *
 * @author Demian
 */
public class KUIXmlExamples {
    

    public static String strXmlAirAvailRQ = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirAvailRQ EchoToken=\"1\" TimeStamp=\"2012-04-20T15:45:07-03:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\" " +
        "DirectFlightsOnly=\"false\" MaxResponses=\"5\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\"> " +
        "</Source> " +
        "</POS> " +
        "<SpecificFlightInfo> " +
        "<Airline Code=\"XX\"/> " +
        "</SpecificFlightInfo> " +
        "<OriginDestinationInformation> " +
        "<DepartureDateTime>2015-03-09</DepartureDateTime> " +
        "<OriginLocation LocationCode=\"AEP\"/> " +
        "<DestinationLocation LocationCode=\"COR\"/> " +
        "</OriginDestinationInformation> " +
        "<OriginDestinationInformation> " +
        "<DepartureDateTime>2015-03-12</DepartureDateTime> " +
        "<OriginLocation LocationCode=\"COR\"/> " +
        "<DestinationLocation LocationCode=\"AEP\"/> " +
        "</OriginDestinationInformation> " +
        "<TravelPreferences > "+ 
        "<CabinPref Cabin=\"Economy\"/> " +
        "</TravelPreferences> " +
        "<TravelerInfoSummary> " +
        "<AirTravelerAvail> " +
        "<PassengerTypeQuantity Code=\"ADT\" Quantity=\"1\"/> " +
        "</AirTravelerAvail> " +
        "</TravelerInfoSummary> " +
        "</KIU_AirAvailRQ>";
    

    public static String strXmlAirAvailRS = "<?xml version=\"1.0\" encoding=\"UTF-8\"  standalone=\"yes\" ?> " +
        "<Root EchoToken=\"1\" TimeStamp=\"2015-03-06T17:38:05+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<OriginDestinationInformation> " +
        "<DepartureDateTime>2015-03-09</DepartureDateTime> " +
        "<OriginLocation>AEP</OriginLocation><DestinationLocation>COR</DestinationLocation> " +
        "<OriginDestinationOptions> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-09 08:00:00\" " +
        "ArrivalDateTime=\"2015-03-09 10:55:00\" StopQuantity=\"1\" FlightNumber=\"3130\" " +
        "JourneyDuration=\"02:55:00\"> " +
        "<DepartureAirport LocationCode=\"CCS\"/> " +
        "<ArrivalAirport LocationCode=\"CUM\"/> " +
        "<Equipment AirEquipType=\"SF3\" /> " +
        "<MarketingAirline CompanyShortName=\"XX\"/> " +
        "<Meal MealCode=\"S\"/> " +
        "<MarketingCabin CabinType=\"Economy\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"Y\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"M\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"L\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-09 09:00:00\" " +
        "ArrivalDateTime=\"2015-03-09 12:59:00\" StopQuantity=\"1\" FlightNumber=\"1000\" " +
        "JourneyDuration=\"03:59:00\"> " +
        "<DepartureAirport LocationCode=\"CCS\"/> " +
        "<ArrivalAirport LocationCode=\"CUM\"/> " +
        "<Equipment AirEquipType=\"DC9\" /> " +
        "<MarketingAirline CompanyShortName=\"XX\"/> " +
        "<Meal MealCode=\"S\"/> " +
        "<MarketingCabin CabinType=\"Economy\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"Y\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"B\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"K\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"L\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "</OriginDestinationOptions> " +
        "</OriginDestinationInformation> " +
        "<OriginDestinationInformation> " +
        "<DepartureDateTime>2015-03-12</DepartureDateTime> " +
        "<OriginLocation>COR</OriginLocation> " +
        "<DestinationLocation>AEP</DestinationLocation> " +
        "<OriginDestinationOptions> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-12 10:00:00\" " +
        "ArrivalDateTime=\"2015-03-12 11:00:00\" StopQuantity=\"0\" FlightNumber=\"455\" " +
        "JourneyDuration=\"01:00:00\"> " +
        "<DepartureAirport LocationCode=\"CCS\"/> " +
        "<ArrivalAirport LocationCode=\"CUM\"/> " +
        "<Equipment AirEquipType=\"SF3\" /> " +
        "<MarketingAirline CompanyShortName=\"XX\"/> " +
        "<Meal MealCode=\"-\"/> " +
        "<MarketingCabin CabinType=\"Economy\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"Y\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"B\" ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"H\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "<BookingClassAvail ResBookDesigCode=\"N\" " +
        "ResBookDesigQuantity=\"9\" RPH=\"1\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "</OriginDestinationOptions> " +
        "</OriginDestinationInformation> " +
        "</Root>";
    
    public static String strXmlAirPriceRQ = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirPriceRQ EchoToken=\"1\" TimeStamp=\"2015-03-09T16:49:52+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS>" +
        "<Source AgentSine=\"NET00XXWW\" PseudoCityCode=\"NET\" ISOCountry=\"AR\" " +
        "ISOCurrency=\"USD\" TerminalID=\"NET00XX000\"> " +
        "<RequestorID Type=\"5\"/> " +
        "<BookingChannel Type=\"1\"/> " +
        "</Source> " +
        "</POS> " +
        "<AirItinerary> " +
        "<OriginDestinationOptions> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-09 12:00:00\" " +
        "ArrivalDateTime=\"2015-03-09 14:00:00\" FlightNumber=\"1\" ResBookDesigCode=\"B\" > " +
        "<DepartureAirport LocationCode=\"AEP\"/> " +
        "<ArrivalAirport LocationCode=\"COR\"/> " +
        "<MarketingAirline Code=\"XX\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-11 10:00:00\" " +
        "ArrivalDateTime=\"2015-03-11 11:00:00\" FlightNumber=\"455\" ResBookDesigCode=\"B\" > " +
        "<DepartureAirport LocationCode=\"COR\"/> " +
        "<ArrivalAirport LocationCode=\"AEP\"/> " +
        "<MarketingAirline Code=\"XX\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "</OriginDestinationOptions> " +
        "</AirItinerary> " +
        "<TravelerInfoSummary> " +
        "<AirTravelerAvail> " +
        "<PassengerTypeQuantity Code=\"ADT\" Quantity=\"1\"/> " +
        "<PassengerTypeQuantity Code=\"CNN\" Quantity=\"1\"/> " +
        "<PassengerTypeQuantity Code=\"INF\" Quantity=\"1\"/> " +
        "</AirTravelerAvail> " +
        "<PaymentDetail> " +
        "<PaymentCard CardCode=\"VI\"/> " +
        "</PaymentDetail> " +
        "<PriceRequestInformation> " +
        "<DiscountPricing TicketDesignatorCode=\"SD\" /> " +
        "<DiscountPricing TicketDesignatorCode=\"DC\" /> " +
        "<Tax Amount=\"20.99\" TaxCode=\"PP\" /> " +
        "<Tax Amount=\"15\" TaxCode=\"PW\" /> " +
        "</PriceRequestInformation> " +
        "</TravelerInfoSummary> " +
        "</KIU_AirPriceRQ>";
    
    
    public static String strXmlAirPriceRS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirPriceRS EchoToken=\"1\" TimeStamp=\"2015-03-09T16:49:52+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<PricedItineraries> " +
        "<PricedItinerary SequenceNumber=\"1\"> " +
        "<AirItinerary> " +
        "<OriginDestinationOptions> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-09 " +
        "12:00:00\" ArrivalDateTime=\"2015-03-09 14:00:00\" FlightNumber=\"1\" " +
        "ResBookDesigCode=\"B\"> " +
        "<DepartureAirport LocationCode=\"AEP\"/> " +
        "<ArrivalAirport LocationCode=\"COR\"/> " +
        "<MarketingAirline Code=\"XX\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-11 " +
        "10:00:00\" ArrivalDateTime=\"2015-03-11 11:00:00\" FlightNumber=\"455\" " +
        "ResBookDesigCode=\"B\"> " +
        "<DepartureAirport LocationCode=\"COR\"/> " +
        "<ArrivalAirport LocationCode=\"AEP\"/> " +
        "<MarketingAirline Code=\"XX\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "</OriginDestinationOptions> " +
        "</AirItinerary> " +
        "<AirItineraryPricingInfo> " +
        "<ItinTotalFare> " +
        "<BaseFare Amount=\"34.68\" CurrencyCode=\"USD\"/> " +
        "<Taxes> " +
        "<Tax TaxCode=\"DL\" Amount=\"3.76\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Tax TaxCode=\"PP\" Amount=\"62.97\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Tax TaxCode=\"PW\" Amount=\"45\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Tax TaxCode=\"QN\" Amount=\"1.57\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Tax TaxCode=\"TQ\" Amount=\"4.56\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Tax TaxCode=\"XR\" Amount=\"12.66\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Tax TaxCode=\"YR\" Amount=\"23.97\" " +
        "CurrencyCode=\"USD\"/> " +
        "</Taxes> " +
        "<TotalFare Amount=\"189.17\" CurrencyCode=\"USD\"/> " +
        "</ItinTotalFare> " +
        "<PTC_FareBreakdowns> " +
        "<PTC_FareBreakdown> " +
        "<PassengerTypeQuantity Quantity=\"1\" " +
        "Code=\"ADT\" /> " +
        "<PassengerFare> " +
        "<BaseFare Amount=\"21.68\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Taxes> " +
        "<Tax TaxCode=\"DL\" Amount=\"2.35\" " +
        "CurrencyCode=\"USD\" /> "+ 
        "<Tax TaxCode=\"PP\" Amount=\"20.99\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"PW\" Amount=\"15\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"QN\" Amount=\"0.98\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"TQ\" Amount=\"2.28\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"XR\" Amount=\"6.33\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"YR\" Amount=\"7.99\" " +
        "CurrencyCode=\"USD\" /> " +
        "</Taxes> " +
        "</PassengerFare> " +
        "</PTC_FareBreakdown> " +
        "<PTC_FareBreakdown> " +
        "<PassengerTypeQuantity Quantity=\"1\" " +
        "Code=\"CNN\" /> " +
        "<PassengerFare> " +
        "<BaseFare Amount=\"10.84\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Taxes> " +
        "<Tax TaxCode=\"DL\" Amount=\"1.18\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"PP\" Amount=\"20.99\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"PW\" Amount=\"15\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"QN\" Amount=\"0.49\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"TQ\" Amount=\"2.28\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"XR\" Amount=\"6.33\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"YR\" Amount=\"7.99\" " +
        "CurrencyCode=\"USD\" /> " +
        "</Taxes> " +
        "</PassengerFare> " +
        "</PTC_FareBreakdown> " +
        "<PTC_FareBreakdown> " +
        "<PassengerTypeQuantity Quantity=\"1\" " +
        "Code=\"INF\" /> " +
        "<PassengerFare> " +
        "<BaseFare Amount=\"2.16\" " +
        "CurrencyCode=\"USD\"/> " +
        "<Taxes> " +
        "<Tax TaxCode=\"DL\" Amount=\"0.23\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"PP\" Amount=\"20.99\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"PW\" Amount=\"15\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"QN\" Amount=\"0.1\" " +
        "CurrencyCode=\"USD\" /> " +
        "<Tax TaxCode=\"YR\" Amount=\"7.99\" " +
        "CurrencyCode=\"USD\" /> " +
        "</Taxes> " +
        "</PassengerFare> " +
        "</PTC_FareBreakdown> " +
        "</PTC_FareBreakdowns> " + 
        "</AirItineraryPricingInfo> " +
        "</PricedItinerary> " +
        "</PricedItineraries> " +
        "<Warnings> " +
        "<Warning Type=\"13\">PRICE DISCREPANCIES</Warning> " +
        "</Warnings> " +
        "</KIU_AirPriceRS>";      
      
    
    public static String strXmlAirBookRQ = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirBookRQ EchoToken=\"1\" TimeStamp=\"2015-03-30T19:07:51+00:00\" " +
        "Target=\"Production\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" PseudoCityCode=\"NET\" ISOCountry=\"AR\" " +
        "ISOCurrency=\"USD\" TerminalID=\"NET00XX000\"> " +
        "<RequestorID Type=\"5\"/> " +
        "<BookingChannel Type=\"1\"/> " +
        "</Source> " +
        "</POS> " +
        "<PriceInfo> " +
        "<FareInfos> " +
        "<FareInfo> " +
        "<DiscountPricing TicketDesignatorCode=\"DC\" /> " +
        "<DiscountPricing TicketDesignatorCode=\"F1\" /> " +
        "</FareInfo> " +
        "</FareInfos> " +
        "<PriceRequestInformation> " +
        "<TPA_Extensions> " +
        "<Tax Amount=\"20.99\" TaxCode=\"PP\" /> " +
        "<Tax Amount=\"15\" TaxCode=\"PW\" /> " +
        "</TPA_Extensions> " +
        "</PriceRequestInformation> " +
        "</PriceInfo> " +
        "<AirItinerary> " +
        "<OriginDestinationOptions> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-31 09:40:00\" " +
        "ArrivalDateTime=\"2015-03-31 10:40:00\" FlightNumber=\"103\" ResBookDesigCode=\"Y\" > " +
        "<DepartureAirport LocationCode=\"AEP\"/> " +
        "<ArrivalAirport LocationCode=\"COR\"/> " +
        "<MarketingAirline Code=\"XX\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "</OriginDestinationOptions> " +
        "</AirItinerary> " +
        "<TravelerInfo> " +
        "<AirTraveler PassengerTypeCode=\"ADT\" BirthDate=\"1980-12-07\"> " +
        "<PersonName> " +
        "<NamePrefix>MR</NamePrefix> " +
        "<GivenName>JUAN</GivenName> " +
        "<MiddleName>CARLOS</MiddleName> " +
        "<Surname>PEREZ</Surname> " +
        "</PersonName> " +
        "<Telephone AreaCityCode=\"011\" PhoneNumber=\"123456789\"/> " +
        "<Address> " +
        "<AddressLine>CALLE 34 N 11</AddressLine> " +
        "<CityName>BUENOS AIRES</CityName> " +
        "<PostalCode>C1407AXA</PostalCode> " +
        "<StateProv>CAPITAL FEDERAL</StateProv> " +
        "<CountryName>ARGENTINA</CountryName> " + 
        "</Address> " +
        "<Email>JUAN@PEREZ.COM</Email> " +
        "<Document DocID=\"123456789\" DocType=\"NI\"></Document> " +
        "<CustoLoyalty ProgramID=\"XX\" MembershipID=\"12346789\" /> " +
        "<TSAInfo> " +
        "<BirthDate>1980-12-07</BirthDate> " +
        "<Gender>M</Gender> " +
        "<DocExpireDate>2017-01-20</DocExpireDate> " +
        "<DocIssueCountry>AR</DocIssueCountry> " +
        "<BirthCountry>AR</BirthCountry> " +
        "<TSADocType>P</TSADocType> " +
        "<TSADocID>123456789</TSADocID> " +
        "</TSAInfo> " +
        "<TravelerRefNumber RPH=\"01\"/> " +
        "</AirTraveler> " +
        "<SpecialReqDetails> " +
        "<Remarks> " +
        "<Remark>PASAJERO NECESITA SILLA DE RUEDAS</Remark> " +
        "</Remarks> " +
        "<SpecialServiceRequests> " +
        "<SpecialServiceRequest ServiceQuantity=\"1\" " +
        "SSRCode=\"CKIN\" Status=\"HK\" TravelerRefNumberRPHList=\"01\"> " +
        "<Text>PEREZ/JUAN.NI123456789</Text> " +
        "<Airline Code=\"XX\" /> " +
        "<FlightLeg Date=\"2015-03-31\" FlightNumber=\"103\" " +
        "ResBookDesigCode=\"Y\"> " +
        "<DepartureAirport LocationCode=\"AEP\" /> " +
        "<ArrivalAirport LocationCode=\"COR\" /> " +
        "</FlightLeg> " +
        "</SpecialServiceRequest> " +
        "<SpecialServiceRequest ServiceQuantity=\"1\" " +
        "SSRCode=\"WCHR\" Status=\"NN\" TravelerRefNumberRPHList=\"01\"> " +
        "<Text>PASAJERO NECESITA SILLA DE RUEDAS</Text> " +
        "<Airline Code=\"XX\" /> " +
        "<FlightLeg Date=\"2015-03-31\" FlightNumber=\"103\" " +
        "ResBookDesigCode=\"Y\"> " +
        "<DepartureAirport LocationCode=\"AEP\" /> " +
        "<ArrivalAirport LocationCode=\"COR\" /> " +
        "</FlightLeg> " +
        "</SpecialServiceRequest> " +
        "</SpecialServiceRequests> " +
        "</SpecialReqDetails> " +
        "</TravelerInfo> " +
        "<Ticketing TicketTimeLimit=\"3\" /> " +
        "</KIU_AirBookRQ>";
    
    public static String strXmlAirBookRS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirBookRS EchoToken=\"1\" TimeStamp=\"2015-03-30T19:07:51+00:00\" " +
        "Target=\"Production\" Version=\"3.0\" SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<AirItinerary> " +
        "<OriginDestinationOptions> " +
        "<OriginDestinationOption> " +
        "<FlightSegment DepartureDateTime=\"2015-03-31 09:40:00\" " +
        "ArrivalDateTime=\"2015-03-31 10:40:00\" FlightNumber=\"103\" ResBookDesigCode=\"Y\"> " +
        "<DepartureAirport LocationCode=\"AEP\"/> " +
        "<ArrivalAirport LocationCode=\"COR\"/> " +
        "<MarketingAirline Code=\"XX\"/> " +
        "</FlightSegment> " +
        "</OriginDestinationOption> " +
        "</OriginDestinationOptions> " +
        "</AirItinerary> " +
        "<TravelerInfo> " +
        "<AirTraveler PassengerTypeCode=\"ADT\" BirthDate=\"1980-12-07\"> " +
        "<PersonName> " +
        "<NamePrefix>MR</NamePrefix> " +
        "<GivenName>JUAN</GivenName> " +
        "<MiddleName>CARLOS</MiddleName> " +
        "<Surname>PEREZ</Surname> " +
        "</PersonName> " +
        "<Telephone AreaCityCode=\"011\" PhoneNumber=\"123456789\"/> " +
        "<Address> " +
        "<AddressLine>CALLE 34 N 11</AddressLine> " +
        "<CityName>BUENOS AIRES</CityName> " +
        "<PostalCode>C1407AXA</PostalCode> " +
        "<StateProv>CAPITAL FEDERAL</StateProv> " +
        "<CountryName>ARGENTINA</CountryName> " +
        "</Address> " +
        "<Email>JUAN@PEREZ.COM</Email> " +
        "<Document DocID=\"123456789\" DocType=\"NI\"/> " +
        "<CustoLoyalty ProgramID=\"XX\" MembershipID=\"12346789\"/> " +
        "<TSAInfo> " +
        "<BirthDate>1980-12-07</BirthDate> " +
        "<Gender>M</Gender> " +
        "<DocExpireDate>2017-01-20</DocExpireDate> " +
        "<DocIssueCountry>AR</DocIssueCountry> " +
        "<BirthCountry>AR</BirthCountry> " +
        "<TSADocType>P</TSADocType> " +
        "<TSADocID>123456789</TSADocID> " +
        "</TSAInfo> " +
        "<TravelerRefNumber RPH=\"01\"/> " +
        "</AirTraveler> " +
        "<SpecialReqDetails> " +
        "<Remarks> " +
        "<Remark>PASAJERO NECESITA SILLA DE RUEDAS</Remark> " +
        "</Remarks> " +
        "<SpecialServiceRequests> " +
        "<SpecialServiceRequest Airline=\"XX\" Code=\"CKIN\" " +
        "Status=\"UC\" DepartureAirport=\"AEP\" ArrivalAirport=\"COR\" FlightNumber=\"103\" " +
        "RecordBookDesignator=\"Y\" Date=\"2015-03-31\" NumberOfServices=\"1\" " +
        "PassengerNames=\"-1PEREZ/JUAN CARLOS\" Text=\"FREE TEXT IS MANDATORY\" " +
        "PassengerAssociationIds=\"P1\"/> " +
        "<SpecialServiceRequest Airline=\"XX\" Code=\"WCHR\" " +
        "Status=\"UC\" DepartureAirport=\"AEP\" ArrivalAirport=\"COR\" FlightNumber=\"103\" " +
        "RecordBookDesignator=\"Y\" Date=\"2015-03-31\" NumberOfServices=\"1\" " +
        "PassengerNames=\"-1PEREZ/JUAN CARLOS\" Text=\"ONLY STATUS NN IS PERMITTED\" " +
        "PassengerAssociationIds=\"P1\"/> " +
        "</SpecialServiceRequests> " +
        "</SpecialReqDetails> " +
        "</TravelerInfo> " +
        "<BookingReferenceID Type=\"1\" ID=\"OOJPDB\"/> " +
        "</KIU_AirBookRS>";
    
    public static String strXmlAirDemandTicketRQCredito = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirDemandTicketRQ EchoToken=\"1\" TimeStamp=\"2012-04-25T12:45:57-03:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" " +
        "ISOCountry=\"AR\" ISOCurrency=\"ARS\"> " +
        "<RequestorID Type=\"5\"/> " +
        "<BookingChannel Type=\"1\"/> " +
        "</Source> " +
        "</POS> " +
        "<DemandTicketDetail TourCode=\"\"> " +
        "<BookingReferenceID ID=\"EKVXLW\"> " +
        "<CompanyName Code=\"XX\"/> " +
        "</BookingReferenceID> " +
        "<Commission Percent=\"5.5\" CapAmount=\"20\"/> " +
        "<PaymentInfo PaymentType=\"5\"> " +
        "<CreditCardInfo CardType=\"1\" CardCode=\"IK\" " +
        "CardNumber=\"0123456789012345\" SeriesCode=\"123\" ExpireDate=\"1212\"/> " +
        "<ValueAddedTax VAT=\"\"/> " +
        "</PaymentInfo> " +
        "<Endorsement Info=\"THIS TICKET IS NONREFUNDABLE\"/> " +
        "</DemandTicketDetail> " +
        "</KIU_AirDemandTicketRQ>";
    
    public static String strXmlAirDemandTicketRQCorporativa = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirDemandTicketRQ EchoToken=\"1\" TimeStamp=\"2012-04-25T12:45:57-03:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" " +
        "ISOCountry=\"AR\" ISOCurrency=\"ARS\"> " +
        "<RequestorID Type=\"5\"/> " +
        "<BookingChannel Type=\"1\"/> " +
        "</Source> " +
        "</POS> " +
        "<DemandTicketDetail TourCode=\"\"> " +
        "<BookingReferenceID ID=\"EKVXLW\"> " +
        "<CompanyName Code=\"XX\"/> " +
        "</BookingReferenceID> " +
        "<PaymentInfo PaymentType=\"34\" InvoiceCode=\"ACME\"> " +
        "<ValueAddedTax VAT=\"\"/> " +
        "</PaymentInfo> " +
        "<Endorsement Info=\"THIS TICKET IS NONREFUNDABLE\"/> " +
        "</DemandTicketDetail> " +
        "</KIU_AirDemandTicketRQ>";
    
    public static String strXmlAirDemandTicketRQMiscelaneo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirDemandTicketRQ EchoToken=\"1\" TimeStamp=\"2012-04-25T12:45:57-03:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" " +
        "ISOCountry=\"AR\" ISOCurrency=\"ARS\"> " +
        "<RequestorID Type=\"5\"/> " +
        "<BookingChannel Type=\"1\"/> " +
        "</Source> " +
        "</POS> " +
        "<DemandTicketDetail TourCode=\"\"> " +
        "<BookingReferenceID ID=\"EKVXLW\"> " +
        "<CompanyName Code=\"XX\"/> " +
        "</BookingReferenceID> " +
        "<PaymentInfo PaymentType=\"37\" MiscellaneousCode=\"PP\" Text=\"PAGO CON " +
        "PAYPAL\"> " +
        "<ValueAddedTax VAT=\"\"/> " +
        "</PaymentInfo> " +
        "<Endorsement Info=\"THIS TICKET IS NONREFUNDABLE\"/> " +
        "</DemandTicketDetail> " +
        "</KIU_AirDemandTicketRQ>";
    
    public static String strXmlAirDemandTicketRS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_AirDemandTicketRS EchoToken=\"1\" TimeStamp=\"2012-04-25T15:45:57+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\"><Success/> " +
        "<BookingReferenceID ID=\"EKVXLW\"> " +
        "<CompanyName Code=\"XX\" /> " +
        "</BookingReferenceID> " +
        "<TicketItemInfo TicketNumber=\"9992200029590\" Type=\"eTicket\" ItemNumber=\"1\" " +
        "TotalAmount=\"300.37\" CommissionAmount=\"0.00\" PaymentType=\"5\"> " +
        "<PassengerName> " +
        "<GivenName>JUAN</GivenName> " +
        "<Surname>PEREZ</Surname> " +
        "</PassengerName> " +
        "</TicketItemInfo> " +
        "</KIU_AirDemandTicketRS>";
    

    public static String strXmlCancelRQReserva = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_CancelRQ EchoToken=\"1\" TimeStamp=\"2015-03-12T17:17:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" /> " +
        "</POS> " +
        "<UniqueID Type=\"14\" ID=\"UNSXXM\" /> " +
        "</KIU_CancelRQ>";
    
    public static String strXmlCancelRSReserva = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_CancelRS EchoToken=\"1\" TimeStamp=\"2015-03-12T17:17:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<UniqueID Type=\"14\" ID=\"UNSXXM\" /> " +
        "</KIU_CancelRS>";
    
    public static String strXmlCancelRQTicket = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_CancelRQ EchoToken=\"1\" TimeStamp=\"2015-03-12T17:17:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" /> " +
        "</POS> " +
        "<UniqueID Type=\"14\" ID=\"UNSXXM\" /> " +
        "<UniqueID Type=\"30\" ID=\"0123456789012\" /> " +
        "<Ticketing TicketTimeLimit=\"2\" /> " +
        "</KIU_CancelRQ>";
    
    public static String strXmlCancelRSTicket = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_CancelRS EchoToken=\"1\" TimeStamp=\"2015-03-12T17:17:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<UniqueID Type=\"14\" ID=\"UNSXXM\" /> " +
        "<Ticketing TicketTimeLimit=\"2\" /> " +
        "</KIU_CancelRS>";
    
    
    public static String strXmlTravelItineraryReadRQPNR = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_TravelItineraryReadRQ EchoToken=\"1\" TimeStamp=\"2015-03-12T19:33:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" /> " +
        "</POS> " +
        "<UniqueID Type=\"14\" ID=\"IKEIKZ\" /> " +
        "</KIU_TravelItineraryReadRQ>";
    
    public static String strXmlTravelItineraryReadRQTicket = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_TravelItineraryReadRQ EchoToken=\"1\" TimeStamp=\"2015-03-12T19:33:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" /> " +
        "</POS> " +
        "<UniqueID Type=\"30\" ID=\"9992200038032\" /> " +
        "</KIU_TravelItineraryReadRQ>";
    
    public static String strXmlTravelItineraryReadRQTicketConMail = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_TravelItineraryReadRQ EchoToken=\"1\" TimeStamp=\"2015-03-12T19:33:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\" PrimaryLangID=\"en-us\"> " +
        "<POS> " +
        "<Source AgentSine=\"NET00XXWW\" TerminalID=\"NET00XX000\" /> " +
        "</POS> " +
        "<UniqueID Type=\"30\" ID=\"9992200038032\" /> " +
        "<Verification> " +
        "<Email>JUAN@PEREZ.COM</Email> " +
        "</Verification> " +
        "</KIU_TravelItineraryReadRQ>";
    
    
    public static String strXmlTravelItineraryRSPNR = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
        "<KIU_TravelItineraryRS EchoToken=\"1\" TimeStamp=\"2015-03-12T19:33:36+00:00\" " +
        "Target=\"Testing\" Version=\"3.0\" SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<TravelItinerary> " +
        "<ItineraryRef Type=\"14\" ID=\"IKEIKZ\"/> " +
        "<CustomerInfos> " +
        "<CustomerInfo RPH=\"1\"> " +
        "<Customer PassengerTypeCode=\"ADT\"> " +
        "<PersonName> " +
        "<Surname>PEREZ</Surname> " +
        "<GivenName>JUAN</GivenName> " +
        "</PersonName> " +
        "<Document DocType=\"NI\" DocID=\"123456789\" /> " +
        "<ContactPerson> " +
        "<Telephone>123456798</Telephone> " +
        "<Email>JUAN@PEREZ.COM</Email> " +
        "</ContactPerson> " +
        "</Customer> " +
        "</CustomerInfo> " +
        "</CustomerInfos> " +
        "<ItineraryInfo> " +
        "<ReservationItems> " +
        "<Item ItinSeqNumber=\"1\"> " +
        "<Air> " +
        "<Reservation DepartureDateTime=\"2012-11-13T12:00:00\" " +
        "FlightNumber=\"4540\" ResBookDesigCode=\"J\"> " +
        "<DepartureAirport LocationCode=\"AEP\" /> " +
        "<ArrivalAirport LocationCode=\"COR\" /> " +
        "<MarketingAirline>XX</MarketingAirline> " +
        "</Reservation> " +
        "</Air> " +
        "</Item> " +
        "</ReservationItems> " +
        "<ItineraryPricing ItemRPHList=\"01\" > " +
        "<Cost AmountBeforeTax=\"383\" AmountAfterTax=\"493.61\" /> " +
        "<Taxes> " +
        "<Tax TaxCode=\"DL\" Amount=\"41.5\" CurrencyCode=\"ARS\" /> " +
        "<Tax TaxCode=\"QN\" Amount=\"12.26\" CurrencyCode=\"ARS\" /> " +
        "<Tax TaxCode=\"TQ\" Amount=\"1\" CurrencyCode=\"ARS\" /> " +
        "<Tax TaxCode=\"XR\" Amount=\"17.55\" CurrencyCode=\"ARS\" /> " +
        "<Tax TaxCode=\"YR\" Amount=\"38.3\" CurrencyCode=\"ARS\" /> " +
        "</Taxes> " +
        "</ItineraryPricing> " +
        "<Ticketing TicketingStatus=\"1\" TicketTimeLimit=\"2012-11-13T19:03:00\" " +
        "/> " +
        "</ItineraryInfo> " +
        "</TravelItinerary> " + 
        "</KIU_TravelItineraryRS>"; 
    
    public static String strXmlTravelItineraryRSTicket = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><KIU_TravelItineraryRS EchoToken=\"1\" " +
        "TimeStamp=\"2015-03-12T19:34:53+00:00\" Target=\"Testing\" Version=\"3.0\" " +
        "SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<ItineraryInfo> " +
        "<Ticketing> " +
        "<TicketAdvisory><![CDATA[<HTML><HEAD><STYLE>.small {font-size: " +
        "8px;}.medium {font-size: 12px;}.big {font-size: 14px;}</STYLE></HEAD><BODY><PRE " +
        "class=\"medium\"> ELECTRONIC TICKET <B> * DUPLICATE *</B> " +
        "*** TEST MODE // RECEIPT NOT VALID *** " +
        "PASSENGER ITINERARY RECEIPT TICKET NBR: <B>9992200038032</B> " +
        "RECIBO DE ITINERARIO DE PASAJEROS BOLETO NRO: " +
        "<B>VENTAS AEROPARQUE </B> ISSUE DATE/FECHA DE EMISION: 12 MAR 2015 " +
        "PELLEGRINI 676 ISSUE AGENT/AGENTE EMISOR: KIUHELPDA " +
        "CAP.FEDERAL NAME/NOMBRE: <B>MARTINEZ/MAYRA MRS </B> " +
        "CAP.FEDERAL, ARGENTINA FOID/D.IDENTIDAD: PP 23366893 " +
        "OFFICE ID: AR-00001-0 " +
        "TELEPHONE/TELEFONO: +99 99 999-9999 " +
        "MAIL INFO/EMAIL: SOPORTE@KIUSYS.COM " +
        "ISSUING AIRLINE/LINEA AEREA EMISORA : LINEAS AERAS XX " +
        "VAT REG. : 111111 " +
        "TICKET NUMBER/NRO DE BOLETO : 999-2200038032 " +
        "BOOKING REF./CODIGO DE RESERVA: C1/<B>IKEIKZ</B> " +
        "FROM/TO FLIGHT CL DATE DEP FARE BASIS NVB NVA BAG ST " +
        "DESDE/HACIA VUELO CL FECHA HORA BASE TARIFARIA EQP. " +
        "ESTATUS " +
        "BUENOS AIRES XX 103 B 14MAR 0930 BNATITA 20K OK " +
        "CORDOBA *** NOT VALID FOR TRAVEL *** " +
        "CORDOBA XX4177 B 16MAR 2240 BNATITA 20K OK " +
        "BUENOS AIRES /OPERADO POR *** NOT VALID FOR TRAVEL *** " +
        "</PRE><PRE class=\"medium\">FOR CHECK IN AT THE AIRPORT YOU MUST PRESENT A VALID " +
        "ID " +
        "</PRE><PRE class=\"small\"><B><I>NUEVO</I></B></PRE><PRE class=\"medium\"> " +
        "</PRE><PRE class=\"medium\"> " +
        "ENDORSEMENTS/ENDOSOS-RESTRICCIONES : NON END NON REF PENALTIES APPLY FOR CHANGES " +
        "TOUR CODE : " +
        "FORM OF PAYMENT/FORMA DE PAGO : CASH " +
        "*** TEST MODE // RECEIPT NOT VALID *** " +
        "</PRE><PRE class=\"medium\">FARE CALC./CALCULO DE TARIFA: BUE XX COR 100.00BNATITA " +
        "XX BUE 100.00BNATITA ARS200.00END (ADT) " +
        "</PRE><PRE class=\"medium\"> " +
        "AIR FARE/TARIFA : ARS 200.00 " +
        "TAX/IMPUESTOS : ARS 21.67DL 9.00QN 20.00TQ " +
        "55.44XR 70.00YR " +
        "TOTAL : ARS 376.11<B> * DUPLICADO - NO VALIDO PARA CREDITO FISCAL " +
        "*</B> " +
        "</PRE><PRE class=\"small\">CARRIAGE AND OTHER SERVICES PROVIDED BY THE CARRIER ARE " +
        "SUBJECT TO CONDITIONS OF CONTRACT, " +
        "WHICH ARE HEREBY INCORPORATED BY REFERENCE. THESE CONDITIONS MAY BE OBTAINED " +
        "FROM THE ISSUING CARRIER. " +
        "THE ITINERARY/RECEIPT CONSTITUTES THE PASSENGER TICKET FOR THE PURPOSES OF " +
        "ARTICLE 3 OF " +
        "THE WARSAW CONVENTION, EXCEPT WHERE THE CARRIER DELIVERS TO THE PASSENGER " +
        "ANOTHER DOCUMENT " +
        "COMPLYING WITH THE REQUIREMENTS OF ARTICLE 3. " +
        "NOTICE " +
        "IF THE PASSENGERS JOURNEY INVOLVES AN ULTIMATE DESTINATION OR STOP IN A COUNTRY " +
        "OTHER THAN " +
        "THE COUNTRY OF DEPARTURE THE WARSAW CONVENTION MAY BE APPLICABLE AND THE " +
        "CONVENTION GOVERNS " +
        "AND IN MOST CASES LIMITS THE LIABILITY OF CARRIERS FOR DEATH OR PERSONAL INJURY " +
        "AND IN RESPECT OF LOSS OF OR DAMAGE TO BAGGAGE. " +
        "<HR>PRINTED BY AGENT NET00XXWW / MAR 12 2015 " +
        "7:35</PRE></BODY></HTML>]]></TicketAdvisory> " +
        "</Ticketing> " +
        "</ItineraryInfo> " +
        "</KIU_TravelItineraryRS>";  
   
    public static String strXmlTravelItineraryRSTicketConMail = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><KIU_TravelItineraryRS EchoToken=\"1\" " +
        "TimeStamp=\"2015-03-12T19:34:53+00:00\" Target=\"Testing\" Version=\"3.0\" " +
        "SequenceNmbr=\"1\"> " +
        "<Success/> " +
        "<ItineraryInfo> " +
        "<Ticketing> " +
        "<TicketAdvisory><![CDATA[]]></TicketAdvisory> " +
        "</Ticketing> " +
        "</ItineraryInfo> " +
        "</KIU_TravelItineraryRS>";
    
}
