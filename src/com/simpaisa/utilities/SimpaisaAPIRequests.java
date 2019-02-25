package com.simpaisa.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SimpaisaAPIRequests {

  SimpaisaConfigData conf = new SimpaisaConfigData();
  String protocol = conf.getProtocol();
  String host = conf.getHost();
  int port = Integer.parseInt(conf.getPort());
  String path = conf.getPath();
  String make_transaction = conf.getPathMakeTransaction();
  String verify_payment = conf.getPathVerifyPayment();
  String get_otp = conf.getOTP();
  String auth = null;
  String fragment = null;
  String operatorID = conf.getOperatorID();
  String mobileNo = conf.getMobileNo();

  public SimpaisaAPIRequests() throws IOException {
  }


  public SimpaisaResponseParser wifi_make_transaction() throws IOException, URISyntaxException {

    URI uri = new URI(protocol, auth, host, port, make_transaction, null, fragment);
    String url = uri.toString();

    RestAssured.baseURI = url;
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");

    SimpaisaPayloadBuilder payload = new SimpaisaPayloadBuilder();

    httpRequest.body(payload.make_transaction().toString());

    SimpaisaResponseParser responses = new SimpaisaResponseParser(httpRequest.post());

    return responses;
  }

  public SimpaisaResponseParser wifi_verify_payment(String otpCode) throws URISyntaxException, IOException {

    URI uri = new URI(protocol, auth, host, port, verify_payment, null, fragment);
    String url = uri.toString();

    RestAssured.baseURI = url;

    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");

    SimpaisaPayloadBuilder payload = new SimpaisaPayloadBuilder();

    httpRequest.body(payload.verify_payment(otpCode).toString());

    SimpaisaResponseParser responses = new SimpaisaResponseParser(httpRequest.post());

    return responses;
  }



  public String wifi_get_OTP() throws URISyntaxException, IOException {
    String query = "operatorId="+operatorID+"&msisdn="+mobileNo;
    URI uri = new URI(protocol, auth, host, port, get_otp, query, fragment);
    String url = uri.toString();
    RestAssured.baseURI = url;
    Response response = RestAssured.get(url);

    return response.asString();
  }


}
