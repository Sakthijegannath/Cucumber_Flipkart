package com.flipkart.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.objectrepository.Validation;
import com.flipkart.resources.CommonActions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class MobilePurchase extends CommonActions {
	CommonActions c = new CommonActions();
	Validation v = new Validation();
	String name="";
@Given("Launching flipkart application for purchase")
public void launching_flipkart_application_for_purchase() {
	
	System.out.println("login");
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	v.getClose().click();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
}


@When("Searching mobile {string}")
public void searching_mobile(String string) {
	
	name=string;
	c.searching_mobile(v.getSearch(), name);
}

@When("Taking Mobile list")
public void taking_Mobile_list() throws Exception {
	
	c.taking_Mobile_list(name, v.getProduct(), v.getProductPrice());

}

@When("Selecting Mobile")
public void selecting_Mobile() {
	
	c.selecting_Mobile(v.getFilter(), v.getProduct().get(0));

}

@When("Windows Handling")
public void windows_Handling() {
	
	c.windows_Handling();

}

@When("Taking Screenshot")
public void taking_Screenshot() throws Exception {

	c.taking_Screenshot(name); 
}

@When("User doing Validation")
public void user_doing_Validation() {
	
	c.user_doing_Validation(name, v.getProductName().getText(), v.getProductPrice());

}

@When("Buying the mobile")
public void buying_the_mobile() {
	
	c.buying_the_mobile(v.getAvailable(), v.getBuynow());

}

@When("Radio button check")
public void radio_button_check() throws Exception {
	
	c.radio_button_check(v.getRadio1(), v.getRadio2(), v.getPin(), v.getNV());
	Thread.sleep(5000);
	v.getClose().click();
	Thread.sleep(5000);
	v.getCancel().click();
	Thread.sleep(3000);
	v.getCart().click();

}

@When("Delivery Details")
public void delivery_Details() {
	
	c.delivery_Details(v.getDeliveryby());

}

@When("Price Details")
public void price_Details() throws Exception {
	
	c.pricedetails(v.getPricedetails(), v.getPrices(), v.getAmts(), v.getDisprice());
	c.taking_Screenshot(name+"1");

}

@Then("User close the application")
public void user_close_the_application() {
    c.close();

}
}
