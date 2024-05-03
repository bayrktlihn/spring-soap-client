package io.bayrktlihn.springsoapclient;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {

    public <TRESPONSE, TREQUEST> TRESPONSE callSoapServiceWithLocation(String location, String soapAction, TREQUEST request) {
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        SoapActionCallback soapActionCallback = new SoapActionCallback(soapAction);
        return (TRESPONSE) webServiceTemplate.marshalSendAndReceive(location, request, soapActionCallback);
    }

    public <TRESPONSE, TREQUEST> TRESPONSE callSoapServiceWithLocation(String location, TREQUEST request) {
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        return (TRESPONSE) webServiceTemplate.marshalSendAndReceive(location, request);
    }


    public <TRESPONSE, TREQUEST> TRESPONSE callSoapService(String soapAction, TREQUEST request) {
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        SoapActionCallback soapActionCallback = new SoapActionCallback(soapAction);
        return (TRESPONSE) webServiceTemplate.marshalSendAndReceive(request, soapActionCallback);
    }


    public <TRESPONSE, TREQUEST> TRESPONSE callSoapService( TREQUEST request) {
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        return (TRESPONSE) webServiceTemplate.marshalSendAndReceive(request);
    }
}