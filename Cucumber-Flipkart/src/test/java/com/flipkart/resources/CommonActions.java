package com.flipkart.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class CommonActions {
	
	
	static WebDriver driver;
	public void launching_flipkart_application_for_purchase(String url) {
		
		System.out.println("Browser Launching");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		
		}
	
	public void handle_login(WebElement closeicon) {
		
		try {
			closeicon.isDisplayed();
			closeicon.click();
			}catch (Exception e) {
		System.out.println("Login is not required");
			}
	}
	
    String name = "";
	public void searching_mobile(WebElement search,String mobile){
	System.out.println("Mobile Searching");
	name = mobile;
	search.sendKeys(name,Keys.ENTER);
	 
	}
	public void taking_Mobile_list(String s, List<WebElement> a, WebElement b)throws Exception {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("EXCEL CREATION");
	  
        File xl = new File("C:\\Users\\vrder\\OneDrive\\Desktop\\mobile.xlsx");
	  
	    FileInputStream f = new FileInputStream(xl);
	    Workbook wb = new XSSFWorkbook(f);
	    Sheet sht = wb.createSheet(s);
	    for(int i=0; i<a.size();i++)
	    {
	    Row row = sht.createRow(i);
	    Cell cell = row.createCell(0);
	    cell.setCellValue(a.get(i).getText());
	            }
	    Row row = sht.getRow(0);
	    Cell cell1 = row.createCell(1);
	    cell1.setCellValue(b.getText());
	    FileOutputStream x =  new FileOutputStream(xl);
	    wb.write(x);
	}

	public void selecting_Mobile(WebElement Filter, WebElement product){
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Filter.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   	product.click();
	}

	public void windows_Handling(){
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 }

	public void taking_Screenshot(String filename) throws Exception{
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\"+filename+".png");
	  	FileUtils.copyFile(src, trg); 
	}

	public void user_doing_Validation(String s,  String mobilename, WebElement price){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  File xl = new File("C:\\Users\\vrder\\OneDrive\\Desktop\\mobile.xlsx");
	    FileInputStream f = new FileInputStream(xl);
	    Workbook wb = new XSSFWorkbook(f);
	    Sheet sht = wb.getSheet(s);
	    Row row = sht.getRow(0);
	    Cell cell = row.getCell(0);
	    String scv = cell.getStringCellValue();
	    boolean contains = mobilename.contains(scv);
	   Assert.assertTrue(contains);
	    System.out.println("Same Product ");
	    Cell cell2 = row.getCell(1);
	    String pric =cell2.getStringCellValue();
	    System.out.println(pric);
	    System.out.println(price.getText());
	    Assert.assertEquals(pric, price.getText());
	      System.out.println("Same Price");
	}

	public void buying_the_mobile(WebElement available, WebElement buynow)
	{
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    boolean displayed1 = available.isDisplayed();
	   Assert.assertTrue(displayed1); 
	    System.out.println("Displaying available offer");
	    boolean displayed2 = buynow.isDisplayed();
	  Assert.assertTrue(displayed2); 
	    System.out.println("Displaying Buy now button");
	}

	public void radio_button_check(WebElement r1,WebElement r2, WebElement pin, WebElement msg)throws InterruptedException
	{
		 Thread.sleep(3000);
		 if(r1.isSelected()){
			System.out.println("(Buy Without Exchange - Radio button is selected as default");
			}
		
			System.out.println("Entering pincode");
			pin.sendKeys("123456", Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String text = msg.getText();
			if(text.contains("Not a valid pincode"))
			{
				System.out.println("Pincode Invalid showing correctly");
			}

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	for(int i=0; i<6;i++)
	{
			pin.sendKeys(Keys.BACK_SPACE);
	}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			pin.sendKeys("600125", Keys.ENTER);
			Thread.sleep(15000);
			try
			{
				
			r2.click();
				}
			catch (StaleElementReferenceException e){
			}
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			
	}

	public void delivery_Details( WebElement delivery){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println( delivery.getText());
	    }
	
	public void pricedetails(WebElement head, List<WebElement> prices, List<WebElement> amts, WebElement dis) throws InterruptedException
	{
		Thread.sleep(3000);
	System.out.println(head.getText());
	System.out.println(prices.get(0).getText()+ "  "+ amts.get(0).getText());
	System.out.println(prices.get(1).getText()+"  "+dis.getText());

	for(int i =2; i<prices.size()-1;i++)
			{

		WebElement x =prices.get(i);
		WebElement y =amts.get(i-1);
		
		System.out.println(x.getText()+"  "+ y.getText());
		
			}}

	public void close()
	{
		driver.quit();
	}



}
