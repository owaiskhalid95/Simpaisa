package com.simpaisa.discard;

import com.simpaisa.utilities.SimpaisaAPIRequests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpaisaGetRequest  {

    public SimpaisaGetRequest() throws IOException {

        // LEVEL #1
        SimpaisaAPIRequests uri = new SimpaisaAPIRequests();

//        RestAssured.baseURI  = uri.telenor_create_acr();

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

     //   http://api.simpaisa.com:9991/dcb-integration/transaction/b5l6alobm3n9o9j4scdsa474b8/WEB/fetch-msisdn?userKey=255882&productID=1007
        Response response_object = RestAssured.get("http://api.simpaisa.com:9991/dcb-integration/transaction/b5l6alobm3n9o9j4scdsa474b8/WEB/fetch-msisdn?userKey=255882&productID=1007");
// Response response_object = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");

        int tv = response_object.getStatusCode();

        System.out.println("this is the code we get " + tv);

        Assert
                .assertEquals(tv, 200);
        String response_data = response_object.asString();

        // LEVEL #1 - end


 /// mid level
//        URIBuilder uri = new URIBuilder();
//        RestAssured.baseURI = uri.wifi_make_transaction();
//
//        RequestSpecification httpRequest = RestAssured.given();
//        httpRequest.header("Content-Type", "application/json");
//
//        PayloadBuilder payload = new PayloadBuilder();
//
//        httpRequest.body(payload.make_transaction().toString());
//
//        RresponseParser responses =new RresponseParser();
//        responses.response(httpRequest.post());
        /// mid level - end

        // LEVEL #2

        Response response_object1 = RestAssured.get("http://api.simpaisa.com:9991/dcb-integration/transaction/b5l6alobm3n9o9j4scdsa474b8/WEB/fetch-msisdn?userKey=255882&productID=1007");

        String response_data1 = response_object.asString();

        System.out.println("this is response body " + response_data);
        String referenceId = response_data.split(",")[5].split(":")[1];
        System.out.println(referenceId);
        Response create_acr = RestAssured.get("http://acr.telenordigital.com/partner/acr/create?partnerId=publishex&operatorId=TLN-PK&redirect=false&referenceId=" + referenceId);

//if (referenceId.equals(0)
        int response_codeACR = create_acr.getStatusCode();
        System.out.println("This is the code we receive from Create ACR: " + response_codeACR);
        Assert.assertEquals(response_codeACR, 200);


        // LEVEL #2 - end

    }

    public void responses() {
    }

    public static class SimpaisaConfigData {

      private String protocol = null;
      private String host = null;
      private String port = null;
      private String path = null;
      private String productID = null;
      private String userKey = null;
      private String operatorID = null;
      private String mobileNo = null;


      Properties prop;

      public SimpaisaConfigData() throws IOException {
        File src = new File("./simpaisa.properties");
        FileInputStream fis = new FileInputStream(src);

        prop = new Properties();
        prop.load(fis);
      }

      public String getProtocol() {
        return prop.getProperty("protocol");

      }

      public String getProductId() {
        return prop.getProperty("productID");
      }

      public String getHost() {
        return prop.getProperty("host");
      }

      public String getPort() {
        return prop.getProperty("port");
      }

      public String getPath() {
        return prop.getProperty("path");
      }

      public String getPathVerifyPayment() {
        return prop.getProperty("verify_payment");
      }

      public String getPathMakeTransaction() {
        return prop.getProperty("make_transaction");
      }

      public String getUserKey() {
        return prop.getProperty("userKey");
      }

      public String getoperatorID() {
        return prop.getProperty("operatorID");
      }

      public String getMobileNo() {
        return prop.getProperty("mobileNo");
      }

      public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
      }

      public String getCodeOTP() {
        return prop.getProperty("codeOTP");
      }

      public static class SimpaisaConfig {

        Properties prop;

        public SimpaisaConfig() throws IOException {
          File src = new File("./simpaisa.properties");
          FileInputStream fis = new FileInputStream(src);

          prop = new Properties();
          prop.load(fis);
        }

        public String getProtocol() {
          return prop.getProperty("protocol");
        }

        public String getProductId() {
          return prop.getProperty("productID");
        }

        public String getHost() {
          return prop.getProperty("host");
        }

        public String getPort() {
          return prop.getProperty("port");
        }

        public String getPath() {
          return prop.getProperty("path");
        }

        public String getPathVerifyPayment() {
          return prop.getProperty("verify_payment");
        }

        public String getOTP() {
          return prop.getProperty("get_otp");
        }

        public String getOperatorID() {
          return prop.getProperty("operatorID");
        }


        public String getPathMakeTransaction() {
          return prop.getProperty("make_transaction");
        }

        public String getMobileNo() { return prop.getProperty("mobileNo");
        }
      }
    }
}
