
package com.simpaisa.example;

import com.simpaisa.common.framework.test.SimPaisaScript;
import com.simpaisa.common.framework.utility.APIRequests;
import com.simpaisa.common.framework.utility.APIResponses;
import com.simpaisa.common.framework.utility.AssertTest;
import org.testng.annotations.Test;


public class SaveConfig_example extends SimPaisaScript {

  APIRequests request = new APIRequests();
  APIResponses response = new APIResponses();

  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void save_configuration() {

    response = new APIResponses(request.product_configuration());

    System.out.println("  < Display Request Responses >");
    System.out.println(response.response_body());
    resetParams();
  }

  @Test(enabled = false)
  public void resetParams() {
    request = new APIRequests();
    response = new APIResponses();
  }
}