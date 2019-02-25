package com.simpaisa.framework;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.simpaisa.utilities.SimpaisaConfigData;
import com.simpaisa.utilities.SimpaisaPayloadBuilder;
import com.simpaisa.utilities.SimpaisaAPIRequests;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Properties;

public class Simpaisa {

    private static final String CONFIG_KEY = "./example.properties";
    private SimpaisaConfigData testProperties = null;
    protected String protocol;
    protected String host;
    protected String port;
    protected String path;

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @Test
    public void make_transasction_wifi_mobilink() throws IOException, URISyntaxException {



        SimpaisaAPIRequests uri = new SimpaisaAPIRequests();
//        RestAssured.baseURI = uri.wifi_make_transaction();

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        SimpaisaPayloadBuilder payload = new SimpaisaPayloadBuilder();

        httpRequest.body(payload.make_transaction().toString());

//        SimpaisaResponseParser responses =new SimpaisaResponseParser();
//        responses.response(httpRequest.post());




        SimpaisaAPIRequests uri_1 = new SimpaisaAPIRequests();
//        RestAssured.baseURI = uri_1.wifi_verify_payment();

        RequestSpecification httpRequest_1 = RestAssured.given();
        httpRequest_1.header("Content-Type", "application/json");

        SimpaisaPayloadBuilder payload_1 = new SimpaisaPayloadBuilder();

//        httpRequest_1.body(payload_1.verify_payment().toString());

//        SimpaisaResponseParser responses_1 =new SimpaisaResponseParser();
//        responses_1.response(httpRequest_1.post());

    }


    @Test(enabled=true, groups={"init"})
    public void initialize() throws Exception {
        // Initialize properties
        initConfig();
    }

    @BeforeSuite
    public void setUp() {
        // start reporters
        htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }


    @AfterSuite
    public void tearDown(){
        extent.flush();

    }
    @Test(enabled=false)
    public void initConfig(){
        // Read properties file
        Properties prop = new Properties();
        try {
            try {
                File propertyFile = new File(System.getProperty(CONFIG_KEY));
                prop.load(new FileInputStream(propertyFile));
            } catch (NullPointerException npe) { //
                // If system config not defined load backup file
                prop.load(new FileInputStream("./Config/example.properties"));
            }
        } catch (IOException e) { //
            throw new RuntimeException("Config File Not Found.");
        }
//        this.testProperties = new SimpaisaConfigData(prop);
//
//        protocol = testProperties.getProtocol();
//        host = testProperties.getHost();
//        port = testProperties.getPort();
//        path = testProperties.getPath();
    }
}
