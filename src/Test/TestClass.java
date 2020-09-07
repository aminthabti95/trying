package Test;

import org.openqa.selenium.WebDriver;


public class TestClass  {
	public static void main(String[] args) {
	       System.setProperty("webdriver.chrome.driver","/home/amin/Downloads/chromedriver");	// <-- Change this path
	       WebDriver driver = new ChromeDriver();
	       String baseUrl = "https://experitest.com/free-trial/";
	       String expectedTitle = "Free trial";
	       String actualTitle = "";
	       driver.get(baseUrl);
	       actualTitle = driver.getTitle();
	       if (actualTitle.contentEquals(expectedTitle)){
	           System.out.println("TEST PASSED!");
	       } else {
	           System.out.println("TEST FAILED");
	       }
	       driver.close();
	   }	
	

}
