package com.simpaisa.common.framework.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.simpaisa.common.framework.test.SimPaisaScript;

public class POST extends SimPaisaScript {

  Response response = null;

  public Response post_method(String uri) {
    RestAssured.baseURI = uri;
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(post_payload());
    response = httpRequest.post();
    return response;
  }

  public Response post_method(String uri, String otp) {
    System.out.println("otp >>>" + otp);
    RestAssured.baseURI = uri;
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(post_payload(otp));
    response = httpRequest.post();
    return response;
  }

  public Response config_method(String uri) {
    RestAssured.baseURI = uri;
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(save_config_payload());
    return httpRequest.post();

  }
}
