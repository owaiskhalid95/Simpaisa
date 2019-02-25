package com.simpaisa.example;

import com.simpaisa.utilities.SimpaisaAPIRequests;
import com.simpaisa.utilities.SimpaisaHashMapper;
import com.simpaisa.utilities.SimpaisaResponseParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URISyntaxException;


public class TestLevelOne {

    @Test(enabled = true, groups = {"wifi","workflow"})
    public void make_transasction_wifi() throws IOException, URISyntaxException {

        SimpaisaAPIRequests request1 = new SimpaisaAPIRequests();
        System.out.println(" STEP01: === Initiating Make Transaction Request (POST) ");
        SimpaisaResponseParser response1 = request1.wifi_make_transaction();

        SimpaisaHashMapper output1 = new SimpaisaHashMapper(response1.misc1());
        System.out.println("  < Display Request Responses >");

        System.out.println("Response Body Message : " + output1.getValue("message"));
        Assert.assertEquals(output1.getValue("message"), "The transaction is in PIN request status");

        SimpaisaAPIRequests request2 = new SimpaisaAPIRequests();
        System.out.println(" STEP02: === Initiating Get OTP Request (GET)");
        String response2 = request2.wifi_get_OTP();
        System.out.println("  < Display Request Responses >");
        System.out.println("OTP COde : " + response2);

        System.out.println(" STEP03: === Initiating Verify Transaction Request (POST) ");
        SimpaisaAPIRequests request3 = new SimpaisaAPIRequests();
        SimpaisaResponseParser response3 = request3.wifi_verify_payment(response2);

        SimpaisaHashMapper output3 = new SimpaisaHashMapper(response3.misc1());

        System.out.println("  < Display Request Responses >");

        System.out.println("Response Body Message : " + output3.getValue("message"));
        Assert.assertEquals(output3.getValue("message"), "Free-Trial-Activated");
    }
}
