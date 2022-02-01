package com.simpaisa.common.framework.utility;

import com.simpaisa.common.framework.test.SimPaisaScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class GET extends SimPaisaScript {

  public String get_method(String uri) {
    System.out.println("get otp url: " + uri);
    RestAssured.baseURI = uri;
    Response response = RestAssured.get(uri);
    return response.asString();
  }

  public String get_method(String uri, JSONObject payload) {
    return null;
  }
}
