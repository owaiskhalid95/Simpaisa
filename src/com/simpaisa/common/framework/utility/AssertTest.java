package com.simpaisa.common.framework.utility;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.NumberFormat;
import java.text.ParseException;


public class AssertTest {
  public static Object actual;
  public static Object expected;
  public static String failmessage;
  public static String passmessage;
  private static boolean passed = true;
  private static boolean current = false;

  public static void assertNotEqual(Object actualValue, Object expectedValue, String failedMessage,String passMessage){
      actual = actualValue;
      expected = expectedValue;
      failmessage = failedMessage;
      passmessage = passMessage;
      assertNotEequalTest();
  }

  public static void assertValue(Object actualValue, Object expectedValue,
                                 String failedMessage,String passedMessage) {
    actual = actualValue;
    expected = expectedValue;
    failmessage = failedMessage;
    passmessage = passedMessage;
    assertTest();
  }

  public static boolean assertValue(Object actualValue, Object expectedValue, String failedMessage) {
    actual = actualValue;
    expected = expectedValue;
    failmessage = failedMessage;
    passmessage = null;
    Boolean passed = assertTest();

    return passed;
  }

  public static boolean assertValue2(Object actualValue, Object expectedValue, String failedMessage) {
    actual = actualValue;
    expected = expectedValue;
    failmessage = failedMessage;
    passmessage = null;
    Boolean testPassed = assertTest2();

    return testPassed;
  }

  public static void assertPassed(String failedMessage) {
    Assert.assertTrue(isPassed(), failedMessage);
  }

  private static boolean assertTest() {
    current = false;
    try {
      current = compare();
    }
    catch (Exception e) {
      current = false;
    }
    check();

    return current;
  }

    private static void assertNotEequalTest() {
        current = true;
        try {
            current = !compare();
        }
        catch (Exception e) {
            current = true;
        }
        check();
    }

  private static boolean assertTest2() {
    current = false;
    try {
      current = compare();
    }
    catch (Exception e) {
      current = false;
    }
    check();

    return current;
  }

  private static boolean compare() {
    if (expected == null && actual == null)
      return true;

    if (expected instanceof Number && actual instanceof String ||
        actual instanceof Number && expected instanceof String) {
      try {
        expected = NumberFormat.getInstance().parse(
            expected.toString().replace("$","").replace("(","-").replace(")","")).doubleValue();
      } catch (ParseException e) {
        expected = null;
      }
      try {
        actual = NumberFormat.getInstance().parse(
            actual.toString().replace("$","").replace("(","-").replace(")","")).doubleValue();
      } catch (ParseException e) {
        actual = null;
      }
    }

    return (expected != null) ? expected.equals(actual) : actual.equals(expected);
  }

  private static void check() {
    if (!current) {
      System.err.println("java.lang.AssertionError: " + failmessage);
      System.err.println("Expected: " + expected);
      System.err.println("Actual: " + actual);
    } else if (passmessage != null && passmessage.trim().length() > 0) {
      System.out.println(passmessage);
    }
    passed = passed & current;
  }

  @Test(enabled=false)
  public static boolean isPassed() {
    return passed;
  }

  @Test(enabled=false)
  public static void clearState() {
    passed = true;
    actual = null;
    expected = null;
    failmessage = null;
    passmessage = null;
    current = false;
  }
}
