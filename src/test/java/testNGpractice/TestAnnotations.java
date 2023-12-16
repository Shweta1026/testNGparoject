package testNGpractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAnnotations{
  @Test
  public void Test1() {
	  System.out.println("Test1 method");
  }
  @Test
  public void Test2() {
	  System.out.println("Test2 method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test method");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite method");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite method");
  }

}
