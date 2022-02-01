package com.simpaisa.common.framework.test;

import java.util.Properties;

public class QATestProperties {

  private String dbName = null;
  private String dbDriver = null;
  private String dbClassname = null;
  private String dbURL = null;
  private String dbUsername = null;
  private String dbPassword = null;
  private String spproductId = null;
  private String spuserKey = null;
  private String spoperatorId = null;
  private String spmsisdn = null;
  private String spmerchantId = null;
  private String reqProtocol = null;
  private String reqPath = null;
  private String reqHost = null;
  private String reqPort = null;
  private String apiMakeTransaction = null;
  private String apiVerifyPayment = null;
  private String apiGetOtp = null;
  private String reqAuth = null;
  private String reqFragment = null;
  private String reqQuery = null;


  private String conActiveHE = null;
  private String conActiveWifi = null;
  private String conActiveBucket = null;
  private String conActiveRetry = null;
  private String conActiveReminder = null;
  private String conActiveFreeTrial = null;
  private String conCreatedDate = null;
  private String conCreatedBy = null;
  private String conID = null;

  public QATestProperties() {
    // Non-public constructor
  }


  public QATestProperties(Properties properties) {
    if (properties == null || properties.isEmpty())
      throw new IllegalArgumentException("Invalid Properties Argument.");

    setSpProductID(properties.getProperty("sp.merchantId"));
    setSpProductID(properties.getProperty("sp.productId"));
    setSpUserKey(properties.getProperty("sp.userKey"));
    setSpOperatorID(properties.getProperty("sp.operatorId"));
    setSpMobileNo(properties.getProperty("sp.msisdn"));
    setSpmerchantId(properties.getProperty("sp.merchantId"));

    setReqProtocol(properties.getProperty("req.protocol"));
    setReqHost(properties.getProperty("req.host"));
    setReqPort(properties.getProperty("req.port"));
    setReqPath(properties.getProperty("req.path"));
    setReqQuery(properties.getProperty("req.query"));
    setReqAuth(properties.getProperty("req.auth"));
    setReqFragment(properties.getProperty("req.fragment"));

    setDbName(properties.getProperty("db.name"));
    setDbDriver(properties.getProperty("db.driver"));
    setDbClassname(properties.getProperty("db.classname"));
    setDbURL(properties.getProperty("db.url"));
    setDbUsername(properties.getProperty("db.username"));
    setDbPassword(properties.getProperty("db.password"));

    setActiveHE(properties.getProperty("con.active_HE"));
    setActiveWifi(properties.getProperty("con.active_Wifi"));
    setActiveBucket(properties.getProperty("con.active_Bucket"));
    setActiveRetry(properties.getProperty("con.active_Retry"));
    setActiveReminder(properties.getProperty("con.active_Reminder"));
    setActiveFreeTrial(properties.getProperty("con.active_freeTrial"));
    setCreatedDate(properties.getProperty("con.createdDate"));
    setCreatedBy(properties.getProperty("con.createdBy"));
    setConfigID(properties.getProperty("con.id"));
  }

  public String getConfigID() {
    return conID;
  }

  public void setConfigID(String value) {
    if (value != null && !value.isEmpty())
      this.conID = value;
  }

  public String getCreatedBy() {
    return conCreatedBy;
  }

  public void setCreatedBy(String value) {
    if (value != null && !value.isEmpty())
      this.conCreatedBy = value;
  }

  public String getCreatedDate() {
    return conCreatedDate;
  }

  public void setCreatedDate(String value) {
    if (value != null && !value.isEmpty())
      this.conCreatedDate = value;
  }

  public String getActiveFreeTrial() {
    return conActiveFreeTrial;
  }

  public void setActiveFreeTrial(String value) {
    if (value != null && !value.isEmpty())
      this.conActiveFreeTrial = value;
  }

  public String getActiveReminder() {
    return conActiveReminder;
  }

  public void setActiveReminder(String value) {
    if (value != null && !value.isEmpty())
      this.conActiveReminder = value;
  }

  public String getActiveRetry() {
    return conActiveRetry;
  }

  public void setActiveRetry(String value) {
    if (value != null && !value.isEmpty())
      this.conActiveRetry = value;
  }

  public String getActiveBucket() {
    return conActiveBucket;
  }

  public void setActiveBucket(String value) {
    if (value != null && !value.isEmpty())
      this.conActiveBucket = value;
  }

  public String getActiveHE() {
    return conActiveHE;
  }

  public void setActiveHE(String value) {
    if (value != null && !value.isEmpty())
      this.conActiveHE = value;
  }

  public String getActiveWifi() {
    return conActiveWifi;
  }

  public void setActiveWifi(String value) {
    if (value != null && !value.isEmpty())
      this.conActiveWifi = value;
  }

  public String getSpProductID() {
    return spproductId;
  }

  public void setSpProductID(String value) {
    if (value != null && !value.isEmpty())
      this.spproductId = value;
  }

  public String getSpUserKey() {
    return spuserKey;
  }

  public void setSpUserKey(String value) {
    if (value != null && !value.isEmpty())
      this.spuserKey = value;
  }

  public String getSpOperatorID() {
    return spoperatorId;
  }

  public void setSpOperatorID(String value) {
    if (value != null && !value.isEmpty())
      this.spoperatorId = value;
  }

  public String getSpMobileNo() {
    return spmsisdn;
  }

  public void setSpMobileNo(String value) {
    if (value != null && !value.isEmpty())
      this.spmsisdn = value;
  }

  public String getSpmerchantId() {
    return spmerchantId;
  }

  public void setSpmerchantId(String value) {
    if (value != null && !value.isEmpty())
      this.spmerchantId = value;
  }

  public String getReqProtocol() {
    return reqProtocol;
  }

  public void setReqProtocol(String value) {
    if (value != null && !value.isEmpty())
      this.reqProtocol = value;
  }

  public String getReqQuery() {
    return reqQuery;
  }

  public void setReqQuery(String value) {
    if (value != null && !value.isEmpty())
      this.reqQuery = value;
  }

  public String getReqAuth() {
    return reqAuth;
  }

  public void setReqAuth(String value) {
    if (value != null && !value.isEmpty())
      this.reqAuth = value;
  }

  public String getReqFragment() {
    return reqFragment;
  }

  public void setReqFragment(String value) {
    if (value != null && !value.isEmpty())
      this.reqFragment = value;
  }

  public String getReqPath() {
    return reqPath;
  }

  public void setReqPath(String value) {
    if (value != null && !value.isEmpty())
      this.reqPath = value;
  }

  public String getReqHost() {
    return reqHost;
  }

  public void setReqHost(String value) {
    if (value != null && !value.isEmpty())
      this.reqHost = value;
  }

  public String getReqPort() {
    return reqPort;
  }

  public void setReqPort(String value) {
    if (value != null && !value.isEmpty())
      this.reqPort = value;
  }

  public void setApiGetOtp(String value) {
    if (value != null && !value.isEmpty())
      this.apiGetOtp = value;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String value) {
    if (value != null && !value.isEmpty())
      this.dbName = value;
  }

  public String getDbDriver() {
    return dbDriver;
  }

  public void setDbDriver(String value) {
    if (value != null && !value.isEmpty())
      this.dbDriver = value;
  }

  public String getDbClassname() {
    return dbClassname;
  }

  public void setDbClassname(String value) {
    if (value != null && !value.isEmpty())
      this.dbClassname = value;
  }

  public String getDbURL() {
    return dbURL;
  }

  public void setDbURL(String value) {
    if (value != null && !value.isEmpty())
      this.dbURL = value;
  }

  public String getDbUsername() {
    return dbUsername;
  }

  public void setDbUsername(String value) {
    if (value != null && !value.isEmpty())
      this.dbUsername = value;
  }

  public String getDbPassword() {
    return dbPassword;
  }

  public void setDbPassword(String value) {
    if (value != null && !value.isEmpty())
      this.dbPassword = value;
  }
}