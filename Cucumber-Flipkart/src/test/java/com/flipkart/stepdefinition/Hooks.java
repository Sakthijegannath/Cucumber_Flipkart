package com.flipkart.stepdefinition;

import java.time.LocalTime;

import com.flipkart.resources.CommonActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonActions{
	
	CommonActions c = new CommonActions();
	@Before
	public void beforeScene()
	{
		LocalTime now = java.time.LocalTime.now();
		System.out.println("Starts testing at: " +now);
		c.launching_flipkart_application_for_purchase("https://www.flipkart.com/");
	}

	@After
	public void afterScene()
	{
		LocalTime now = java.time.LocalTime.now();
		System.out.println("Ends testing at: " +now);
	}

}
