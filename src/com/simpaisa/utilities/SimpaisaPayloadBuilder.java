package com.simpaisa.utilities;

import org.json.simple.JSONObject;
import java.io.IOException;

public class SimpaisaPayloadBuilder {


  public JSONObject make_transaction() throws IOException {

    SimpaisaConfigData data = new SimpaisaConfigData();

    JSONObject parameters = new JSONObject();
    parameters.put("productID", data.getProductId());
    parameters.put("userKey", data.getUserKey());
    parameters.put("operatorID", data.getOperatorID());
    parameters.put("mobileNo", data.getMobileNo());

    return parameters;
  }

  public JSONObject verify_payment(String otpCode) throws IOException {

    SimpaisaConfigData data = new SimpaisaConfigData();
    JSONObject parameters = new JSONObject();
    parameters.put("productID", data.getProductId());
    parameters.put("userKey", data.getUserKey());
    parameters.put("operatorID", data.getOperatorID());
    parameters.put("mobileNo", data.getMobileNo());
    parameters.put("codeOTP", otpCode);

    return parameters;
  }

  public JSONObject get_otp() throws IOException {

    SimpaisaConfigData data = new SimpaisaConfigData();

    JSONObject parameters = new JSONObject();
    parameters.put("productID", data.getProductId());
    parameters.put("msisdn" , data.getMobileNo());

    return parameters;
  }

}
