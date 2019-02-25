package com.simpaisa.discard;

import com.simpaisa.utilities.SimpaisaAPIRequests;
import com.simpaisa.utilities.SimpaisaHashMapper;
import com.simpaisa.utilities.SimpaisaResponseParser;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class SimpaisaParams {
    public static final String ALL_TENANTS = "0";
    // Global
    public String recordTimer = null;
    public String transaction = null;
    public String tranx_type = null;
    public String line_no = "0";
    public String no_lines = "0";
    public String no_sublines = "0";
    public String edit_clerk = "";
    public String edit_clerk2 = "";
    public String edit_clerk3 = "";
    public String edit_date = "";


    HashMap<Integer,String> udf = new HashMap<Integer,String>();
    public SimpaisaParams() {
    }

    public void addUDFVariable(String variable, String value) {
        udf.put(variable.hashCode(),value);
    }

    public String getUDFVariable(String variable) {
        return udf.get(variable.hashCode());
    }
    public void resetUDFVariables() {
        udf.clear();
    }

  public static class TestLevelTwo {

      @Test(enabled = true, groups = {"mobilink", "wifi"})
      public void make_transasction_wifi_mobilink() throws IOException, URISyntaxException {


          SimpaisaAPIRequests request1 = new SimpaisaAPIRequests();
          com.simpaisa.utilities.SimpaisaResponseParser response1 = request1.wifi_make_transaction();

          SimpaisaHashMapper myMap2 = new SimpaisaHashMapper(response1.misc1());

          myMap2.getAll(); // returns response body


          System.out.println(myMap2.getValues()); // return all value
          System.out.println(myMap2.getKeys());
          System.out.println(myMap2.containsKey("status"));
          System.out.println(myMap2.containsKey("statddus"));
          System.out.println(myMap2.getValue("transactionID"));


  //        Assert.assertEquals(myMap2.containsKey("status"), true);
  //
  //        SimpaisaAPIRequests request2 = new SimpaisaAPIRequests();
  //        SimpaisaResponseParser response2 = request2.wifi_get_OTP();
  //
  //        SimpaisaHashMapper myMap4 = new SimpaisaHashMapper(response2.misc1());
  //
  //        myMap4.getAll(); // returns response body
  //
  //
  //



  //        public static void verifyInvoiceGeneratorHeader(String status, String utilityType, String billingPeriod)
  //        {
  //            System.out.println("\n-(LEVEL-01)------- validating Invoice Generator (Header Contents) ---------");
  //            String actStatus = browser.getTextValue("mainForm:UM_INVOICE_GENERATOR_VIEW_content:umInvGenStatusZoom:statusCode");
  //            String actUtilityType = browser.getTextValue("mainForm:UM_INVOICE_GENERATOR_VIEW_content:utilityType:level0");
  //            String actBillingPeriod = browser.getTextValue("mainForm:UM_INVOICE_GENERATOR_VIEW_content:billingPeriod:level0");
  //
  //            AssertTest.clearState();
  //            Boolean allPassed = true;
  //            if(AssertTest.assertValue(actStatus, status,"FAIL: Actual and Expected 'Status' don't match")==false){
  //                allPassed = false;
  //            };
  //            if(AssertTest.assertValue(actUtilityType, utilityType, "FAIL: Actual Utility Type DOES NOT match Expected Utility Type ")==false){
  //                allPassed = false;
  //            };
  //            if(AssertTest.assertValue(actBillingPeriod, billingPeriod, "FAIL: Actual Billing Period DOES NOT match Expected Billing Period")==false){
  //                allPassed = false;
  //            };
  //
  //            if(allPassed==true){
  //                System.out.println("PASS: Invoice Generator (Header Contents) values match expected for [" + actUtilityType + "/" + actBillingPeriod +"]");
  //            }
  //        }


          SimpaisaAPIRequests request3 = new SimpaisaAPIRequests();
          SimpaisaResponseParser response3 = request3.wifi_verify_payment("");
          response3.body();
          response3.response_time();
          response3.status_code();
          response3.content_type();
          response3.misc1();

          SimpaisaHashMapper myMap5 = new SimpaisaHashMapper(response3.misc1());

          myMap5.getAll(); // returns response body



      }
  }
}
