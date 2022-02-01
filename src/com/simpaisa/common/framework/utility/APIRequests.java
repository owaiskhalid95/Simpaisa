package com.simpaisa.common.framework.utility;

import com.simpaisa.common.framework.test.SimPaisaScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIRequests extends SimPaisaScript {

  POST post = new POST();
  GET get = new GET();
  Response response = null;
  ;

  public Response wifi_make_transaction() {
    response = post.post_method(this.base_uri(this.path(EndPoint.MAKE_TRANSACTION.getValue())));
    return response;
  }

  public String wifi_get_OTP() {
    String otp = get.get_method(this.base_uri(this.path(EndPoint.GET_OTP.getValue()), this.query_string()));
    return otp;
  }

  public Response wifi_verify_payment(String otp) {
    response = post.post_method(this.base_uri(this.path(EndPoint.VERIFY_PAYMENT.getValue())), otp);
    return response;
  }

  public Response product_configuration() {
    String path = "/dcb-integration/product/configuration/";
    response = post.config_method(this.base_uri(this.path(path, EndPoint.SAVE.getValue())));
    return response;
  }

  public Response flush() {
    //String path=http://staging.simpaisa.com:9919/redis/flushdb
     response= RestAssured.get("http://staging.simpaisa.com:9919/redis/flushdb");
     System.out.println(response.getBody().asString());
    return  response;
  }
}
