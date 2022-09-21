package com.flipkart.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.resources.CommonActions;

public class Validation {
	CommonActions c = new CommonActions();

	 WebDriver driver;

	
public Validation()
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//button[text()='✕']")
private WebElement close;

@FindBy(name="q")
private WebElement search;

@FindBy(xpath="//span[text()='Filters']")
private WebElement Filter;

@FindBys(@FindBy(xpath="//div[@class='_4rR01T']"))
private List<WebElement> Product;

@FindBy(xpath="//button[text()='BUY NOW']")
private WebElement Buynow;

@FindBy(tagName="h1")
private WebElement productName;

@FindBy(xpath="(//div[contains(text(),'₹')])[1]")
private WebElement productPrice;

@FindBy(xpath="//div[contains(text(),'Available')]")
private WebElement Available;

@FindBy(xpath="(//input[@class='_3DAmyP'])[1]")
private WebElement radio1;

@FindBy(xpath="(//div[@class='_1XFPmK'])[2]")
private WebElement radio2;

@FindBy(id="pincodeInputId")
private WebElement pin;

@FindBy(xpath="//span[text()='Check']")
private WebElement check;

@FindBy(xpath="//button[contains(text(),'Yes,')]")
private WebElement cancel;

@FindBy(xpath="//button[text()='ADD TO CART']")
private WebElement cart;

@FindBy(xpath="//span[contains(text(),'Price details')]")
private WebElement pricedetails;

@FindBys(@FindBy(xpath="//div[@class='_2npqm0']"))
private List<WebElement> prices;

@FindBys(@FindBy(xpath="//div[@class='Ob17DV']/span"))
private List<WebElement> amts;


@FindBy(xpath="//div[contains(text(),'− ₹')]")
private WebElement disprice;



@FindBy(xpath="//div[contains(text(),'Not a valid')]")
private WebElement NV;
@FindBy(xpath="//div[contains(text(),'Delivery by')]")
private WebElement deliveryby;



public List<WebElement> getAmts() {
	return amts;
}

public List<WebElement> getPrices() {
	return prices;
}

public WebElement getDeliveryby() {
	return deliveryby;
}

public WebElement getNV() {
	return NV;
}

public List<WebElement> getProduct() {
	return Product;
}

public WebElement getBuynow() {
	return Buynow;
}

public WebElement getProductName() {
	return productName;
}

public WebElement getCancel() {
	return cancel;
}

public WebElement getProductPrice() {
	return productPrice;
}

public WebElement getAvailable() {
	return Available;
}

public WebElement getRadio1() {
	return radio1;
}

public WebElement getRadio2() {
	return radio2;
}

public WebElement getPin() {
	return pin;
}

public WebElement getCheck() {
	return check;
}

public WebElement getCart() {
	return cart;
}

public WebElement getPricedetails() {
	return pricedetails;
}

public WebElement getDisprice() {
	return disprice;
}

public WebElement getClose() {
	return close;
}

public WebElement getSearch() {
	return search;
}

public WebElement getFilter() {
	return Filter;
}

}
