package com.simpaisa.workflows;

import com.simpaisa.common.framework.test.SimPaisaScript;
import com.simpaisa.common.framework.utility.APIRequests;
import com.simpaisa.common.framework.utility.APIResponses;
import com.simpaisa.common.framework.utility.AssertTest;
import org.testng.annotations.Test;

public class TestFlow extends SimPaisaScript {
  APIRequests request = new APIRequests();
  APIResponses response = new APIResponses();
  String sql = null;

  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void make_transasction_wifi() {
    System.out.println("################ Work Flow Test - START ################");
    sql = "update recursion set status = 0 where status = 1 and Mobileno = '" + this.getMobileNumber() + "'";


    AssertTest.assertValue(executeSql(sql), true, "Fail: row update failed", "Pass: row update");

    System.out.println(" STEP01: === Initiating Make Transaction Request (POST) ");
    response = new APIResponses(request.wifi_make_transaction());
    displayResponses();

    AssertTest.assertValue(response.getValue("message"), "Success", "FAIL: Unexpected response message", "PASS: Expected response message");
    AssertTest.assertValue(response.getValue("status"), "0000", "FAIL: Unexpected response status", "PASS: Expected response status");
    resetParams();

    System.out.println(" STEP02: === Initiating Get OTP Request (GET)");
    String otp = request.wifi_get_OTP();
    System.out.println("This is OTP Code received: " + otp);
    resetParams();

    System.out.println(" STEP03: === Initiating Verify Transaction Request (POST) ");
    response = new APIResponses(request.wifi_verify_payment(otp));
    displayResponses();
    AssertTest.assertValue(response.getValue("message"), "Success", "FAIL: Unexpected response message", "PASS: Expected response message");
    resetParams();

    sql = "select mobileno,status,typeid from recursion where Mobileno = '" + this.getMobileNumber() + "' and status = '1' order by 1 desc";

    AssertTest.assertValue((getSqlQueryValue(sql, "mobileNo")), this.getMobileNumber(), "FAIL: Unexpected mobile No", "PASS: Expected mobile No");
    AssertTest.assertValue((getSqlQueryValue(sql, "status")), "0", "FAIL: Unexpected status", "PASS: Expected status");
    AssertTest.assertValue((getSqlQueryValue(sql, "typeid")), "12", "FAIL: Unexpected typeid", "PASS: Expected typeid");

    System.out.println("################ Work Flow Test - END ################");
  }

  @Test(enabled = false)
  private void displayResponses() {
    System.out.println("  < Display Request Responses >");
    System.out.println(response.response_body());
    System.out.println(response.content_type());
    System.out.println(response.response_time());
    System.out.println(response.status_code());
    System.out.println(response.getValue("message"));
    System.out.println(response.getAll());
    System.out.println(response.getValues());
    System.out.println(response.getKeys());
  }

  @Test(enabled = false)
  private void resetParams() {
    request = new APIRequests();
    response = new APIResponses();
    sql = null;
  }
}