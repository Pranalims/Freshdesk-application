package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAsset {

	
	public WebDriver driver;
	public AddNewAsset(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	
	
	
	@FindBy(id="proceed-to-check")
	private WebElement proceedwithserailno;
	
	@FindBy(id="serialno-check")
	private WebElement addingserialno;
	
	
	@FindBy(id="serialNoCheckBtn")
	private WebElement checkbutton;
	
	
	@FindBy(id="proceedToCreatAsset")
	private WebElement proceedbutton;
	
	@FindBy(id="category")
	private WebElement category;
	
	
	@FindBy(id="brandname")
	private WebElement Brand;
	
	

	@FindBy(id="type")
	private WebElement type;
	
	@FindBy(id="capacity")
	private WebElement capacity;
	
	@FindBy(id="installed-location")
	private WebElement installedlocation;
	
	@FindBy(id="purchased-date")
	private WebElement purchasedate;
	
	@FindBy(id="registerbtn")
	private WebElement registerbutton;
	
	

	
public WebElement registerbutton() {
		
		return registerbutton;
	}
public WebElement purchasedate() {
		
		return purchasedate;
	}
	
public WebElement installedlocation() {
		
		return installedlocation;
	}
	
public WebElement type() {
		
		return type;
	}

public WebElement capacity() {
	
	return capacity;
}

	
public WebElement Brand() {
		
		return Brand;
	}
	
public WebElement category() {
		
		return category;
	}	
	
public WebElement proceedbutton() {
		
		return proceedbutton;
	}	
	
	
public WebElement checkbutton() {
		
		return checkbutton;
	}
	
public WebElement proceedwithserailno() {
		
		return proceedwithserailno;
	}
	
public WebElement addingserialno() {
	
	return addingserialno;
}
}
