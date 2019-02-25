package com.simpaisa.utilities;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class SimpaisaResponseParser {

  private Response response;

  public SimpaisaResponseParser(Response post) {
    this.response = post;
  }

  public void body() {
    String response_data = response.asString();
  }

  public void response_time() {
    long response_time = response.getTime();
  }

  public void status_code() {
    int code = response.getStatusCode();
  }

  public void content_type() {
    String content_type = response.getContentType();
  }

  public Map<String, String> misc1() {
    String response_data = response.asString()
        .replaceAll("}", "")
        .replaceAll("\\{", "")
        .replaceAll("\"", "");

    String[] values = response_data.split(":");

    Map<String, String> respMap = new HashMap<String, String>();

    String[] pairs = response_data.split(",");
    for (int i = 0; i < pairs.length; i++) {
      String pair = pairs[i];
      String[] keyValue = pair.split(":");
      respMap.put(keyValue[0], (keyValue[1]));
    }
    return respMap;
  }
}
