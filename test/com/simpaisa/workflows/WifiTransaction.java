package com.simpaisa.workflows;

import com.simpaisa.common.framework.utility.APIRequests;
import com.simpaisa.common.framework.utility.APIResponses;

import com.simpaisa.common.framework.utility.AssertTest;
import org.testng.annotations.Test;



public class WifiTransaction {

    APIRequests request = new APIRequests();
    APIResponses response = new APIResponses();

    @Test(enabled = true, groups = {"wifi", "workflow"})
    public void make_transasction_wifi() {
        // Note: Threshold Applied, insufficient balance , Product, Operator, mobile all in place (properties)
        // Out of scope : Mobile messages , mobile balance


        System.out.println(" STEP01: === Initiating Make Transaction Request (POST) ");

        response = new APIResponses(request.wifi_make_transaction());
        //response = new APIResponses(request.flush());


        System.out.println("  < Display Request Responses >");
        System.out.println(response.response_body());
        System.out.println(response.content_type());
        System.out.println(response.response_time());
        System.out.println(response.status_code());
        System.out.println(response.getValue("message"));
        AssertTest.assertValue(response.getValue("message"),"Success","FAIL: Unexpected response message","PASS: Expected response message");

        System.out.println(response.getAll());
        System.out.println(response.getValues());
        System.out.println(response.containsValue("Success"));
        System.out.println(response.getKeys());
        System.out.println(response.containsKey("status"));
        System.out.println(request.post_payload());

        resetParams();

        System.out.println(" STEP02: === Initiating Get OTP Request (GET)");
        String otp = request.wifi_get_OTP();
        System.out.println("THis is OTP Code received: " + otp);
        System.out.println("  < Display Request Responses >");
        resetParams();

        System.out.println(" STEP03: === Initiating Verify Transaction Request (POST) ");
        response = new APIResponses(request.wifi_verify_payment(otp));
        System.out.println("  < Display Request Responses >");
        System.out.println(request.post_payload());
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
        resetParams();
    }

    @Test(enabled = false)
    public void resetParams() {
        request = new APIRequests();
        response = new APIResponses();
    }
}
