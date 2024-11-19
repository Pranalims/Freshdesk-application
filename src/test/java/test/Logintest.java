package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageobject.AddNewAsset;
import pageobject.ContactApp;
import pageobject.ContactCreation;
import pageobject.Contacts;
import pageobject.FreshdeskLogin;
import resources.basedata;

public class Logintest extends basedata {
	
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
		
		Thread.sleep(15000);
		
		
		ContactCreation contactcreation=new ContactCreation(diver);
		contactcreation.newbutton().click();
		Thread.sleep(10000);
		contactcreation.newcontactbutton().click();
		Thread.sleep(5000);
		
		Faker faker=new Faker();
		String name = faker.name().fullName();
	contactcreation.fullname().sendKeys(name);;
	
	
	
	String emailid = faker.internet().emailAddress();
     contactcreation.emailid().sendKeys(emailid);;
	
	
	
	String mobileno = faker.numerify("6##########");
	contactcreation.mobileno().sendKeys(mobileno);
	
	
	
	contactcreation.createbutton().click();
	
	Assert.assertTrue(contactcreation.contactcreated().isDisplayed());
	
	Thread.sleep(3000);
	
		
	Contacts contactapp=new Contacts(diver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='app_191496_title']") ));
	contactapp.contactapptoggle().click();
	System.out.println("clicked on contact toggle");
	
	
		if(driver.findElement(By.xpath("//*[text()=\"Contact App\"]")).isDisplayed()) {
			
			System.out.println("Inside frame");
		}
	
	Thread.sleep(5000);
	
	WebElement iframe = contactapp.contactiframe();
	
			
	driver.switchTo().frame(iframe);
	System.out.println("Switched to frame");
	
	 Thread.sleep(7000);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//fw-button[@class='hydrated'])[3]")));
	WebElement contactbutton=contactapp.crbutton();
	
	contactbutton.click();
	
	Thread.sleep(5000);
	String lname = faker.name().lastName();
	WebElement lastname = driver.findElement(By.xpath("//fw-input[@id='lname']")).getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your Last Name']"));
	lastname.sendKeys(lname);
	
	Thread.sleep(2000);
	Actions a= new Actions(driver);
	WebElement submit=contactapp.submitbutton();
			a.moveToElement(submit).click().perform();
			
			
			
			Thread.sleep(3000);
			
			Assert.assertTrue(driver.findElement(By.id("details")).isDisplayed());
			
	WebElement newAssetbutton = driver.findElement(By.xpath("(//fw-icon[@class='hydrated'])[2]"));
	a.moveToElement(newAssetbutton).click().perform();
	
	
				
		if(driver.findElement(By.xpath("(//input[@type='radio' and @value='yes'])[1]")) .isSelected()) {
			System.out.println("Proceeding with serial no");
			
		}
		AddNewAsset newasset=new AddNewAsset(driver);
		Thread.sleep(2000);
		newasset.proceedwithserailno().click();
		
		String number = faker.numerify("2##");
		newasset.addingserialno().sendKeys(number);
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
Actions a1= new Actions(driver);

a1.moveToElement(newasset.purchasedate()).click().perform();

newasset.purchasedate().sendKeys("10/24/2024");
a1.moveToElement(newasset.registerbutton()).click().perform();



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



	


