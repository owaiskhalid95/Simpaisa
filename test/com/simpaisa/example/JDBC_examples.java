package com.simpaisa.example;

import com.simpaisa.common.framework.test.QATestProperties;
import com.simpaisa.common.framework.test.SimPaisaScript;
import org.testng.annotations.Test;
import java.sql.ResultSet;



public class JDBC_examples extends SimPaisaScript {
  private QATestProperties qaTestProperties = null;
  QATestProperties prop = new QATestProperties();
  String mob = prop.getSpMobileNo();

  @Test(enabled = true, groups = {"demo", "sql"})
  public void sql_rowExist_check() {
  this.display_properties();
    String sql = "select * from recursion where Mobileno = '" + this.getMobileNumber() + "'  and status = '1' order by 1 desc";
    System.out.println(sql);
    if (rowExists(sql)) {
      System.out.println("Pass: row exists ");
    } else {
      System.out.println("Fail: row doesn't exist ");
    }
    // OR
    Boolean r = rowExists(sql);
    System.out.println("result : " + r);
  }

  @Test(enabled = true, groups = {"demo", "sql"})
  public void sql_column_value() {

    String sql = "select * from recursion where Mobileno = '" + this.getMobileNumber() + "'  and status = '0' order by 1 desc";
    System.out.println(sql);
    String value = getSqlQueryValue(sql, "mobileNo");
    System.out.println(" value : " + value);
  }


  @Test(enabled = true, groups = {"demo", "sql"})
  public void sql_update() {

    String sql = "update transaction set status = 0 where status = 1 and Mobileno = '" + this.getMobileNumber() + "'";
    if (executeSql(sql)) {
      System.out.println("Pass: row update ");
    } else {
      System.out.println("Fail: row update failed  ");
    }
    // OR
    Boolean r = executeSql(sql);
    System.out.println("result : " + r);
  }

  @Test(enabled = true, groups = {"demo", "sql"})
  public void sql_resultset() {
    String sql = "select * from recursion where Mobileno = '" + this.getMobileNumber() + "' and status = '1' order by 1 desc";

    try {
      ResultSet rs = sqlResults(sql);
      while (rs.next()) {
        String mobileNo = rs.getString("mobileno");
        String status = rs.getString("status");
        String typeId = rs.getString("typeid");
        System.out.println(mobileNo + "\t" + status +
            "\t" + typeId + "\t");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
