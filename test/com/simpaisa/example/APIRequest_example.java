package com.simpaisa.example;

import com.simpaisa.common.framework.test.SimPaisaScript;
import com.simpaisa.common.framework.utility.APIRequests;
import com.simpaisa.common.framework.utility.APIResponses;
import com.simpaisa.common.framework.utility.AssertTest;
import org.testng.annotations.Test;


public class APIRequest_example extends SimPaisaScript {

  APIRequests request = new APIRequests();
  APIResponses response = new APIResponses();

  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void make_transasction_wifi() {
    // Note: Threshold Applied, insufficient balance , Product, Operator, mobile all in place (properties)
    // Out of scope : Mobile messages , mobile balance

    System.out.println(" STEP00: === Optional SQL check ");
    String sql = "select * from recursion where Mobileno = '" + this.getMobileNumber() + "'  and status = '0' order by 1 desc";
    System.out.println(sql);
    if (rowExists(sql)) {
      System.out.println("Pass: row exists ");
    } else {
      System.out.println("Fail: row doesn't exist ");
    }
    Boolean r = rowExists(sql);
    AssertTest.assertValue(r, true,
        "FAIL: row does not exists", "PASS: row exists");
    resetParams();

    System.out.println(" STEP01: === Initiating Make Transaction Request (POST) ");

    response = new APIResponses(request.wifi_make_transaction());

    System.out.println("  < Display Request Responses >");

    System.out.println(response.response_body());
    System.out.println(response.content_type());
    System.out.println(response.response_time());
    System.out.println(response.status_code());
    System.out.println(response.getValue("message"));
    System.out.println(response.getAll());
    System.out.println(response.getValues());
    System.out.println(response.containsValue("The transaction is in PIN request status"));
    System.out.println(response.getKeys());
    System.out.println(response.containsKey("status"));

    AssertTest.assertValue(response.getValue("message"), "The transaction is in PIN request status",
        "FAIL: Unexpected response message", "PASS: Expected response message");
    resetParams();

    System.out.println(" STEP02: === Initiating Get OTP Request (GET)");
    String otp = request.wifi_get_OTP();
    System.out.println("This is OTP Code received: " + otp);
    System.out.println("  < Display Request Responses >");
    resetParams();

    System.out.println(" STEP03: === Initiating Verify Transaction Request (POST) ");
    response = new APIResponses(request.wifi_verify_payment(otp));
    System.out.println("  < Display Request Responses >");
    System.out.println(response.getAll());
    System.out.println(response.getValues());
    System.out.println(response.containsValue("The transaction is in PIN request status"));
    System.out.println(response.getKeys());
    System.out.println(response.containsKey("status"));
    System.out.println(response.getValue("message"));
    resetParams();
  }

  @Test(enabled = false)
  public void resetParams() {
    request = new APIRequests();
    response = new APIResponses();
  }
}
