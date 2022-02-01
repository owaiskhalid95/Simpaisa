package com.simpaisa.example;

import com.simpaisa.common.framework.test.SimPaisaScript;
import org.testng.annotations.Test;

public class DisplayProperties_example extends SimPaisaScript {
  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void display_config_properties() {
    this.display_properties();
  }
}
