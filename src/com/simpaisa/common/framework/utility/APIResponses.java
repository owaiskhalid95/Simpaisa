package com.simpaisa.common.framework.utility;

import io.restassured.response.Response;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class APIResponses {

  private Response response;
  HashMapper hash = null;

  public APIResponses() {
    //
  }

  public APIResponses(Response post) {
    this.response = post;
    this.hash = new HashMapper(misc1());
  }

  public String response_body() {
    return response.asString();
  }

  public String response_time() {
    return String.valueOf(response.getTime());
  }

  public String status_code() {
    return String.valueOf(response.getStatusCode());
  }

  public String content_type() {
    return response.getContentType();
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


  // HASH work
  public void body() {
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
    HashMapper hash = new HashMapper(respMap);
  }

  public Collection getValues() {
    return this.hash.responseHash.values();
  }

  public Object getKeys() {
    return this.hash.responseHash.keySet();
  }

  public boolean containsKey(String key) {
    return this.hash.containsKey(key);
  }

  public boolean containsValue(String value) {
    return this.hash.containsValue(value);
  }

  public String getValue(Object key) {

    return String.valueOf(this.hash.getValue(key));
  }

  public Map getAll() {
    return this.hash.responseHash;
  }
}
