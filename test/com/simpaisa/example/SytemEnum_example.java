package com.simpaisa.example;

import com.simpaisa.common.framework.test.SimPaisaScript;
import com.simpaisa.common.framework.utility.EndPoint;
import org.testng.annotations.Test;

public class SytemEnum_example extends SimPaisaScript {

  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void display_config_properties() {
    System.out.println(EndPoint.MAKE_TRANSACTION.getValue());
  }


  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void build_path() {
    String path = this.path(EndPoint.MAKE_TRANSACTION.getValue());
    System.out.println(path);
  }
}
