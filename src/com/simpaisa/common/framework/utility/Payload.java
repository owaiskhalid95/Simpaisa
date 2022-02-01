package com.simpaisa.common.framework.utility;

import com.simpaisa.common.framework.test.SimPaisaScript;
import org.json.simple.JSONObject;

public class Payload extends SimPaisaScript {

  public String post_payload() {
    JSONObject parameters = new JSONObject();
    parameters.put("merchantId", this.getQATestProperties().getSpmerchantId());
    parameters.put("productId", this.getQATestProperties().getSpProductID());
    parameters.put("msisdn", this.getQATestProperties().getSpMobileNo());
    parameters.put("userKey", this.getQATestProperties().getSpUserKey());
    parameters.put("operatorId", this.getQATestProperties().getSpOperatorID());



    return parameters.toString();
  }
}
