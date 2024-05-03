package io.bayrktlihn.springsoapclient;

import io.bayrktlihn.soap.ws.client.ExecuteVposRequest;
import io.bayrktlihn.soap.ws.client.ExecuteVposRequestResponse;
import io.bayrktlihn.soap.ws.client.VposRequest;
import io.bayrktlihn.soap.ws.client.VposResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class SpringSoapClientApplication {
    public static void main(String[] args) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("io.bayrktlihn.soap.ws.client");

        SoapClient soapClient = new SoapClient();
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);
        soapClient.setDefaultUri("https://onlineodemetest.vakifbank.com.tr:4443/VposService/TransactionServices.asmx");


        ExecuteVposRequest executeVposRequest = new ExecuteVposRequest();
        VposRequest vposRequest = new VposRequest();
        vposRequest.setMerchantId("deneme");
        vposRequest.setPassword("1232132");
        vposRequest.setCardHoldersName("alihan bayraktar");
        vposRequest.setCvv("111");
        vposRequest.setPan("5454545454545454");
        executeVposRequest.setVposRequest(vposRequest);

        ExecuteVposRequestResponse o = soapClient.callSoapService("PayFlexVPosWebService/ExecuteVposRequest", executeVposRequest);

        VposResponse vposResponse = o.getExecuteVposRequestResult();

        System.out.println(vposResponse.getResultCode());
        System.out.println(vposResponse.getResultDetail());


    }
}
