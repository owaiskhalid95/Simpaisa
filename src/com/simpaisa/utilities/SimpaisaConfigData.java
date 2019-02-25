package com.simpaisa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpaisaConfigData {

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


  public Object getUserKey() { return prop.getProperty("userKey");
  }


}
