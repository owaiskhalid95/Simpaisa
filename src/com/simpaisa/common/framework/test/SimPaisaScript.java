package com.simpaisa.common.framework.test;

import com.simpaisa.common.framework.utility.JDBCUtility;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SimPaisaScript {
  private static final String CONFIG_KEY = "simpaisa.properties";
  private QATestProperties qaTestProperties = null;


  @Test(enabled = true, groups = {"init"})
  public void initialize() throws Exception {
    // Initialize properties
    initConfig();
  }

  @Test(enabled = false)
  public void initConfig() {
    // Read properties file
    Properties prop = new Properties();
    try {
      try {
        File propertyFile = new File(System.getProperty(CONFIG_KEY));
        prop.load(new FileInputStream(propertyFile));
      } catch (NullPointerException npe) { //
        // If system config not defined load backup file
        prop.load(new FileInputStream("./simpaisa.properties"));
      }
    } catch (IOException e) { //
      throw new RuntimeException("Config File Not Found.");
    }
    this.qaTestProperties = new QATestProperties(prop);
  }

  @Test(enabled = false)
  public QATestProperties getQATestProperties() {
    System.out.println("this method called");
    return qaTestProperties;
  }

  @Test(enabled = false)
  public String getMobileNumber() {
    initConfig();
    return qaTestProperties.getSpMobileNo();
  }

  @Test(enabled = false)
  public String getProductIdD() {
    initConfig();
    return qaTestProperties.getSpProductID();
  }

  @Test(enabled = false)
  public String getMerchantId() {
    initConfig();
    return qaTestProperties.getSpmerchantId();
  }

  @Test(enabled = false)
  public String getOperatorID() {
    initConfig();
    return qaTestProperties.getSpOperatorID();
  }

// JDBC

  @Test(enabled = false)
  protected JDBCUtility createJDBCUtility() {
    return new JDBCUtility(
        qaTestProperties.getDbURL() + qaTestProperties.getDbName(), qaTestProperties.getDbUsername(), qaTestProperties.getDbPassword());
  }

  @Test(enabled = false)
  public ResultSet getResultSet(String sql) {
    // Return a set of values
    initConfig();
    JDBCUtility jdbc = createJDBCUtility();
    ResultSet rs = jdbc.execute(sql);
    return rs;
  }

  @Test(enabled = false)
  public String getSqlQueryValue(String sqlQuery, String column) {
    // Return a single value
    String outputValue = null;

    try {
      ResultSet rs = getResultSet(sqlQuery);

      while (rs.next()) {
        outputValue = rs.getString(column);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return outputValue;
  }

  @Test(enabled = false)
  public boolean executeSql(String sql) {
    JDBCUtility jdbc = createJDBCUtility();
    try {
      jdbc.executeUpdate(sql);
    } catch (Exception e) {
      jdbc.destroy();
      return false;
    }
    jdbc.destroy();

    return true;
  }

  @Test(enabled = false)
  public ResultSet sqlResults(String sql) {
    initConfig();
    ResultSet resultSet = null;
    JDBCUtility jdbc = createJDBCUtility();
    try {
      resultSet = jdbc.execute(sql);
    } catch (Exception e) {
      //
    }
    return resultSet;
  }

  @Test(enabled = false)
  public boolean rowExists(String sql) {
    // Check if a record already exists
    initConfig();
    boolean recordExists = false;
    JDBCUtility jdbc = createJDBCUtility();
    ResultSet rs = jdbc.execute(sql);
    try {
      rs.next();
      int rsCount = rs.getInt(1);
      System.out.println("count of rows: " + rsCount);
      if (rsCount > 0) {
        recordExists = true;
      }
    } catch (Exception e) { //
      jdbc.destroy();
    }
    jdbc.destroy();

    return recordExists;
  }

  // API

  @Test(enabled = false)
  public String base_uri(String request) {

    initConfig();
    URI uri = null;
    try {
      uri = new URI(qaTestProperties.getReqProtocol(), qaTestProperties.getReqAuth(), qaTestProperties.getReqHost(),
          Integer.parseInt(qaTestProperties.getReqPort()), request, qaTestProperties.getReqQuery(),
          qaTestProperties.getReqFragment());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return uri.toString();
  }

  @Test(enabled = false)
  public String path(String endPoint) {
    initConfig();
    return qaTestProperties.getReqPath() + endPoint;
  }

  @Test(enabled = false)
  public String path(String path, String endPoint) {
    initConfig();
    return path + endPoint;
  }

  @Test(enabled = false)
  public String base_uri(String request, String query) {
    initConfig();
    URI uri = null;
    try {
      uri = new URI(qaTestProperties.getReqProtocol(), qaTestProperties.getReqAuth(), qaTestProperties.getReqHost(), Integer.parseInt(qaTestProperties.getReqPort()), request, query, qaTestProperties.getReqFragment());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return uri.toString();
  }

  @Test(enabled = false)
  public String query_string() {
    initConfig();
    String query = "operatorId=" + qaTestProperties.getSpOperatorID() + "&msisdn=" + qaTestProperties.getSpMobileNo()+ "&productId=" + qaTestProperties.getSpProductID();
    return query;
  }

  @Test(enabled = false)
  public String post_payload() {
    JSONObject parameters = new JSONObject();
    initConfig();
    parameters.put("merchantId", qaTestProperties.getSpmerchantId());
    parameters.put("productId", qaTestProperties.getSpProductID());
    parameters.put("msisdn", qaTestProperties.getSpMobileNo());
    parameters.put("userKey", qaTestProperties.getSpUserKey());
    parameters.put("operatorId", qaTestProperties.getSpOperatorID());



    return parameters.toString();
  }


  @Test(enabled = false)
  public String post_payload(String mobileNo, String userKey) {
    JSONObject parameters = new JSONObject();
    initConfig();
    parameters.put("merchantId", qaTestProperties.getSpmerchantId());
    parameters.put("productId", qaTestProperties.getSpProductID());
    parameters.put("msisdn", mobileNo);
    parameters.put("userKey",userKey);
    parameters.put("operatorId", qaTestProperties.getSpOperatorID());



    return parameters.toString();
  }
  @Test(enabled = false)
  public String post_payload_threshold() {
    JSONObject parameters = new JSONObject();
    initConfig();

    parameters.put("productId", qaTestProperties.getSpProductID());
    parameters.put("msisdn", qaTestProperties.getSpMobileNo());
    parameters.put("operatorId", qaTestProperties.getSpOperatorID());

    return parameters.toString();
  }

  @Test(enabled = false)
  public String post_payload(String otp) {
    JSONObject parameters = new JSONObject();
    initConfig();
    parameters.put("productId", qaTestProperties.getSpProductID());
    parameters.put("userKey", qaTestProperties.getSpUserKey());
    parameters.put("operatorId", qaTestProperties.getSpOperatorID());
    parameters.put("msisdn", qaTestProperties.getSpMobileNo());
    parameters.put("merchantId", qaTestProperties.getSpmerchantId());
    parameters.put("otp", otp);

    return parameters.toString();
  }

  @Test(enabled = false)
  public String save_config_payload() {
    JSONObject parameters = new JSONObject();
    initConfig();
    parameters.put("productID", qaTestProperties.getSpProductID());
    parameters.put("operatorID", qaTestProperties.getSpOperatorID());
    parameters.put("active_HE", qaTestProperties.getActiveHE());
    parameters.put("active_Wifi", qaTestProperties.getActiveWifi());
    parameters.put("active_Bucket", qaTestProperties.getActiveBucket());
    parameters.put("active_Retry", qaTestProperties.getActiveRetry());
    parameters.put("active_freeTrial", qaTestProperties.getActiveFreeTrial());
    parameters.put("createdDate", qaTestProperties.getCreatedDate());
    parameters.put("createdBy", qaTestProperties.getCreatedBy());
    parameters.put("id", qaTestProperties.getConfigID());

    return parameters.toString();
  }

  @Test(enabled = false)
  public String get_payload() {
    return null;
  }

  @Test(enabled = false)
  public void display_properties() {
    initConfig();
    System.out.println("============== API REQUEST PROPERTIES ===============");
    System.out.println("req.protocol : " + qaTestProperties.getReqProtocol());
    System.out.println("req.host : " + qaTestProperties.getReqHost());
    System.out.println("req.port : " + Integer.parseInt(qaTestProperties.getReqPort()));
    System.out.println("req.path : " + qaTestProperties.getReqPath());
    System.out.println("req.auth : " + qaTestProperties.getReqAuth());
    System.out.println("req.query : " + qaTestProperties.getReqQuery());
    System.out.println("req.fragment : " + qaTestProperties.getReqFragment());
    System.out.println("============== SIMPAISA TEST PROPERTIES ===============");
    System.out.println("sp.operatorID : " + qaTestProperties.getSpOperatorID());
    System.out.println("sp.productID : " + qaTestProperties.getSpProductID());
    System.out.println("sp.userKey : " + qaTestProperties.getSpUserKey());
    System.out.println("sp.mobileNo : " + qaTestProperties.getSpMobileNo());
    System.out.println("============== JDBC PROPERTIES ===============");
    System.out.println("db.name : " + qaTestProperties.getDbName());
    System.out.println("db.driver : " + qaTestProperties.getDbDriver());
    System.out.println("db.classname : " + qaTestProperties.getDbClassname());
    System.out.println("db.url : " + qaTestProperties.getDbURL());
    System.out.println("db.username : " + "******");
    System.out.println("db.password : " + "******");
    System.out.println("============== PRODUCT CONFIG PROPERTIES ===============");
    System.out.println("sp.operatorID : " + qaTestProperties.getSpOperatorID());
    System.out.println("sp.productID : " + qaTestProperties.getSpProductID());
    System.out.println("active_HE : " + qaTestProperties.getActiveHE());
    System.out.println("active_Wifi : " + qaTestProperties.getActiveWifi());
    System.out.println("active_Bucket : " + qaTestProperties.getActiveBucket());
    System.out.println("active_Retry : " + qaTestProperties.getActiveRetry());
    System.out.println("active_Reminder : " + qaTestProperties.getActiveReminder());
    System.out.println("active_freeTrial : " + qaTestProperties.getActiveFreeTrial());
    System.out.println("createdDate : " + qaTestProperties.getCreatedDate());
    System.out.println("createdBy : " + qaTestProperties.getCreatedBy());
    System.out.println("id : " + qaTestProperties.getConfigID());
    System.out.println("=============================================");
  }
}
