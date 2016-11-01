package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	
	@FindBy(xpath="//a[text()='Shop']")WebElement shopLink;
	@FindBy(xpath="//a[text()='Cart']")WebElement cartLink;
	@FindBy(xpath="//a[text()='My Account']")WebElement myAccountLink;
	
	public void clickOnShopLink(){
		shopLink.click();
	}
	
	public void clickOnCartLink(){
		cartLink.click();
	}
	
	public void clickOnMyAccountLink(){
		myAccountLink.click();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
}
