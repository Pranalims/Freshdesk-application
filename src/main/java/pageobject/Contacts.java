package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {

	public WebDriver driver;
	public Contacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[@aria-label=\"Contacts\"]")
	private WebElement sidemenu;
	
	
	@FindBy(id="ember6597")
	private WebElement contactselect;
	
	
	@FindBy(xpath="//div[@data-test-id='app_191496_title']")
	private WebElement contactapptoggle;
	
	
	
	@FindBy(xpath="(//iframe)[4]")
	private WebElement contactiframe;
	
	@FindBy(xpath="(//fw-button[@class='hydrated'])[3]")
			private WebElement crbutton;
	
	@FindBy(id="submit-btn")	
	private WebElement submitbutton;
	
	

	
public WebElement submitbutton() {
		
		return submitbutton;
	}
	
public WebElement crbutton() {
		
		return crbutton;
	}
	
public WebElement contactiframe() {
		
		return contactiframe;
	}
	

	
	public WebElement sidemenu() {
		
		return sidemenu;
	}
	
public WebElement contactselect() {
		
		return contactselect;
	}
public WebElement contactapptoggle() {
	
	return contactapptoggle;
}
	
}
