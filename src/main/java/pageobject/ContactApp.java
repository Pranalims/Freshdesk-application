package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactApp {

	public WebDriver driver;
	public ContactApp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//div[@data-test-id='app_191496_title']")
	private WebElement contactApptoggle;
	
	
	
	public WebElement contactApptoggle() {
		
		return contactApptoggle;
	}
	
	

		
	
}
