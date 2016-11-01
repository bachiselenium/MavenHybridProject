package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	@FindBy(id="username")WebElement unameField;
	@FindBy(name="password")WebElement pwdField;
	@FindBy(xpath="//input[@value='Login']")WebElement loginButton;
	//@FindBy(xpath="//a[text()='Logout']")WebElement logoutLink;
	By signout = By.xpath("//a[text()='Logout']") ;
	
	public void loginApplication(String username, String password){	
		unameField.sendKeys(username);
		pwdField.sendKeys(password);
		loginButton.click();
		
	}
	
	public void verifyLogOutLink(){
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text = ele.getText();
		System.out.println(text);
		Assert.assertEquals(text, "Logout", "Signout link not verified");
		
	}

}
