package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreshdeskLogin {

	
	
	public WebDriver driver;
	
	public  FreshdeskLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(id="emailInput")
	private WebElement emailid;
	
	@FindBy(id="passwordInput")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginbutton;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement logintab;
	
	
	@FindBy(id="username")
	private  WebElement username;
	
	@FindBy(id="password")
	private  WebElement password1;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement createbutton;
	
	
	
	
	public WebElement emailid() {
		return emailid;
		
	}
	
	public WebElement password() {
		return password;
		
	}
	public WebElement loginbutton() {
		return loginbutton;
		
	}
	
	
	public WebElement logintab() {
		return logintab;
		
	}
	
	public WebElement createbutton() {
		return createbutton;
		
	}
	
	public WebElement username() {
		return username;
		
	}
	public WebElement password1() {
		return password1;
		
	}
	
	
	
}
