package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.AddNewAsset;
import pageobject.Contacts;
import pageobject.FreshdeskLogin;
import resources.basedata;

public class contacttest extends basedata {

	
public WebDriver diver;
	

	
	@Test
	public void logintest() throws IOException, InterruptedException {
		diver = openbrowser();
		driver.get(prop.getProperty("url"));
		
		FreshdeskLogin login =new FreshdeskLogin(diver);
		login.logintab().click();
		login.emailid().sendKeys(prop.getProperty("email"));
		login.password().sendKeys(prop.getProperty("password"));
		login.loginbutton().click();
		login.username().sendKeys(prop.getProperty("email"));
		login.password1().sendKeys(prop.getProperty("password"));
		login.createbutton().click();
	
	Thread.sleep(30000);
		Contacts contactapp=new Contacts(diver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='app_191496_title']") ));
		contactapp.contactapptoggle().click();
		System.out.println("clicked on contact toggle");
		
		
			if(driver.findElement(By.xpath("//*[text()=\"Contact App\"]")).isDisplayed()) {
				
				System.out.println("Inside frame");
			}
		
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe)[4]")));
		WebElement iframe = contactapp.contactiframe();
		
				
		driver.switchTo().frame(iframe);
		System.out.println("Switched to frame");
		
		/*
		WebElement contactbutton=contactapp.crbutton();
		
		contactbutton.click();
		
		Thread.sleep(2000);
		
		WebElement lastname = driver.findElement(By.xpath("//fw-input[@id='lname']")).getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your Last Name']"));
		lastname.sendKeys("test");
		
		Actions a= new Actions(driver);
		WebElement submit=contactapp.submitbutton();
				a.moveToElement(submit).click().perform();
				
				Assert.assertTrue(driver.findElement(By.id("[id=details]")).isDisplayed());
				*/
		
				contactapp.submitbutton().click();
					
			if(driver.findElement(By.xpath("(//input[@type='radio' and @value='yes'])[1]")) .isSelected()) {
				System.out.println("Proceeding with serial no");
				
			}
			AddNewAsset newasset=new AddNewAsset(driver);
			Thread.sleep(2000);
			newasset.proceedwithserailno().click();
			
			newasset.addingserialno().sendKeys(prop.getProperty("serialno"));
			Thread.sleep(2000);
			newasset.checkbutton().click();
			
			
			Thread.sleep(2000);
		
				
			WebElement searilnotoast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-toast")));
			 
			 String actualresult=searilnotoast.findElement(By.id("toast-message-button")).getText();
			 String expectedresult="Serial No Does Not exist.Would you Like to try another one or proceed with the same";
			     	 
			 
			 if(actualresult.equals(expectedresult)) {
				 
				 System.out.println("serial no does not exist");
			 }else {
				 System.out.println("serial no exist");
			 }
     	 
 newasset.proceedbutton().click();

 //WebElement categoryselection = newasset.category();
 
 Select category=new Select(newasset.category());
 category.selectByVisibleText("REF");
	
 Select brand=new Select(newasset.Brand());
 brand.selectByVisibleText("Condura");

 Select type=new Select(newasset.type());
 type.selectByIndex(1);

 Select capacity=new Select(newasset.capacity());
 capacity.selectByIndex(2);
 
 WebElement installationlocation = driver.findElement(By.xpath("//fw-input[@id='installed-location']")).getShadowRoot().findElement(By.cssSelector("input[placeholder='Location Name']"));
 installationlocation.sendKeys("installtest");
	Actions a= new Actions(driver);
	
	a.moveToElement(newasset.purchasedate()).click().perform();

 newasset.purchasedate().sendKeys("10/24/2024");
 a.moveToElement(newasset.registerbutton()).click().perform();
 
 

 WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast")));
 

 String actualMessage = toastMessage.findElement(By.id("toast-message")).getText();
 String expectedMessage = "Asset created successfully"; 

 if (actualMessage.equals(expectedMessage)) {
     System.out.println("toast message matched");
 } else {
     System.out.println("Toast message does not match");
 }

	}
 }
	

     
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	//Thread.sleep(20000);
		
//		WebElement fr=driver.findElement(By.xpath("(//iframe)[4]"));
		
		//WebElement fr = contactapp.contactiframe();
//		System.out.println("Switching to frame");
//	Thread.sleep(2000);
	
//	Thread.sleep(2000);
		
		//Actions a= new Actions(driver);
		//WebElement crcreate = driver.findElement(By.xpath("(//fw-button[@class='hydrated'])[3]"));
		
		//a.moveToElement(contactapp.crbutton()).click().perform();
//contactapp.crbutton().click();
		
		//WebElement ele = contactapp.crbutton();
		//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	
		//wait.until( d -> ele.isDisplayed());
		
		//WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait2.until(ExpectedConditionss.;
		//contactapp.crbutton().click();
	
	//WebElement crs=driver.findElement(By.xpath("(//fw-button[@class='hydrated'])[3]"));
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].click()",crs );
		//System.out.println("clicked");
		//WebElement element=driver.findElement(By.xpath("(//fw-button[@class='hydrated'])[3]")).getShadowRoot().findElement(By.cssSelector("Create Contact"));
		//element.click(); 
		
	//JavascriptExecutor js= (JavascriptExecutor)driver;
	//WebElement ele=(WebElement)js.executeScript("return document.querySelector("#createButton > div:nth-child(2) > fw-button").shadowRoot.querySelector("button > span.fw-btn--label"));
	//js.executeScript("arguments[0].click();", ele);
	//System.out.println("clicked on button");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement els=(WebElement) js.executeScript("return document.querySelector(\"#createButton > div:nth-child(2) > fw-button\").shadowRoot.querySelector(\"button\")" );
		
		//String ls=("argument[0].click()",js);
		//js.executeScript(ls, els);
	
	/*WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"No contacts found. Please add one to begin.\"]")));
	JavascriptExecutor js= (JavascriptExecutor)driver;
	WebElement shadowroot=(WebElement)js.executeScript("return arguements[0].shadowroot",shadowHost);		
	//WebElement elementinsideshadowdom=(WebElement) js.executeScript("return arguments[0].querySelector('document.querySelector(\"#createButton > div:nth-child(2) > fw-button\")')",shadowroot);
	WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver) .executeScript("return arguments[0].shadowRoot", shadowHost);
Thread.sleep(6000);*/
        // Now you can find elements within the shadow DOM using XPath
       // WebElement shadowElement = driver.findElement(By.xpath("//*[@id=\"createButton\"]/div[2]//*[text()=\"Create Contact\"]"));
	
	

	
		
		


