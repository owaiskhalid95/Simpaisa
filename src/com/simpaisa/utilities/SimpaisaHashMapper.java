package com.simpaisa.utilities;

import java.util.Collection;
import java.util.Map;


public class SimpaisaHashMapper {

  public Map responseHash;

  public SimpaisaHashMapper(Map<String, String> hash) {
    this.responseHash = hash;
  }

  public Collection getValues() {
    return responseHash.values();
  }

  public Object getKeys() {
    return responseHash.keySet();
  }

  public boolean containsKey(String key) {
    return responseHash.containsKey(key);
  }

  public boolean containsValue(String value) {
    return responseHash.containsValue(value);
  }

  public Object getValue(Object key) {
    return responseHash.get(key);
  }

  public void getAll() {
    System.out.println(responseHash);
  }
}
