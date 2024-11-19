package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreation {

	public WebDriver driver;
	
	public ContactCreation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(xpath="//button[@aria-label='New']")
	private WebElement newbutton;
	
	
	@FindBy(xpath="//a[@data-test-id='new-contact']")
	private WebElement newcontactbutton;
	
	@FindBy(xpath="//input[@placeholder='Enter the name of this person']")
	private WebElement fullname;
	
	@FindBy(xpath="//input[@data-test-id='email-test-id']")
	private WebElement emailid;
	

	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobileno;
	
	@FindBy(xpath="//span[@data-test-id='contact__info__name']")
	private WebElement contactcreated;
	
	@FindBy(xpath="//button[@data-test-id='create-contact']")
	private WebElement createbutton;
	
public WebElement contactcreated() {
		
		return contactcreated;
		
	}

public WebElement createbutton() {
	
	return createbutton;
	
}
	
	public WebElement newbutton() {
		
		return newbutton;
		
	}
public WebElement fullname() {
		
		return fullname;
		
	}
public WebElement emailid() {
	
	return emailid;
	
}
public WebElement newcontactbutton() {
	
	return newcontactbutton;
	
}
public WebElement mobileno() {
	
	return mobileno;
	
}
}
