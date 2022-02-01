package com.simpaisa.common.framework.utility;

import java.sql.*;
import java.util.Properties;

public class JDBCUtility {

  private Connection conn = null;
  private ResultSet currentRS = null;

  public JDBCUtility(String dbURL, String dbUsername, String dbPassword) {
    initConnection(dbURL, dbUsername, dbPassword);
  }




  private void initConnection(String dbURL, String dbUsername, String dbPassword) {
    // Create connection
    try {
//      spring.datasource.url=
//      spring.datasource.username= qa
//      spring.datasource.password = Hjdrt@rsfT21Yu
      Properties properties = new Properties(); // Create Properties object
      properties.put("user", "qa");         // Set user ID for connection
      properties.put("password", "Hjdrt@rsfT21Yu");     // Set password for connection
      String url = "jdbc:mysql://111.119.160.215:3306/dcbdatasource?useSSL=false";
      conn = DriverManager.
              getConnection(url,properties);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConn() {
    return conn;
  }

  public ResultSet execute(String query) {
    ResultSet rs = null;
    try {
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      currentRS = rs;
    } catch (SQLException e) {
      currentRS = null;
    }
    return rs;
  }

  public boolean executeUpdate(String sql) {
    try {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      return false;
    }

    return true;
  }

  public void destroy() {
    if (conn != null)
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
}