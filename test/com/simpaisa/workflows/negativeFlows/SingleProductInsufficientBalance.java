package com.simpaisa.workflows.negativeFlows;

import com.simpaisa.utilities.SimpaisaAPIRequests;
import com.simpaisa.utilities.SimpaisaHashMapper;
import com.simpaisa.utilities.SimpaisaResponseParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SingleProductInsufficientBalance {


    @Test(enabled = true, groups = {"wifi","workflow"})
    public void SingleProductInsufficientBalance() throws IOException, URISyntaxException {

        //Pre-Req: No Threshold Applied, insufficient balance , Product, Operator, mobile all in place (properties)

        SimpaisaAPIRequests request1 = new SimpaisaAPIRequests();
        System.out.println(" STEP01: === Single Product Initiating Make Transaction Request  (POST) ");
        SimpaisaResponseParser response1 = request1.wifi_make_transaction();

        SimpaisaHashMapper output1 = new SimpaisaHashMapper(response1.misc1());
        System.out.println("  < Display Request Responses >");

        // Assumption OTP will generate on every request

        SimpaisaAPIRequests request2 = new SimpaisaAPIRequests();
        System.out.println(" STEP02: === Initiating Get OTP Request (GET)");
        String response2 = request2.wifi_get_OTP();
        System.out.println("  < Display Request Responses >");
        System.out.println("OTP Code : " + response2);


        System.out.println(" STEP03: === Initiating Verify Transaction Request (POST) ");
        SimpaisaAPIRequests request3 = new SimpaisaAPIRequests();
        SimpaisaResponseParser response3 = request3.wifi_verify_payment(response2);

        SimpaisaHashMapper output3 = new SimpaisaHashMapper(response3.misc1());

        System.out.println("  < Display Request Responses >");

        System.out.println("Response Body Message : " + output3.getValue("message"));
        Assert.assertEquals(output3.getValue("message"), "Insufficient Balance");

        //TODO: must have DB verification, There must not be entry of user in Recursion table and user must have entry in Transaction table, with satus = 0
    }


}
