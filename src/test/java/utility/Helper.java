package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinaton = "C:/Users/bhaskar/workspace1/com.selenium.hybrid/Screenshots/"+screenshotName+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src, new File(destinaton));
		} catch (Exception e) {
			System.out.println("Failed to capture screendshoot"+e.getMessage());
		}
		return destinaton;
		
	}

}
