package com.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		/* Browser Invoke */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		/* Validate DropDown Box */
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select se = new Select(country);

		List originalList = new ArrayList();
		List<WebElement> options = se.getOptions();

		for (WebElement e : options) {
			originalList.add(e.getText());
		}

		System.out.println("Before Sorting");
		System.out.println("List of Countries" + "\n" + originalList + "\n");

		List templist = new ArrayList();
		templist = originalList;

		Collections.sort(templist);
		System.out.println("After Sorting");
		System.out.println("List of Countries" + "\n" + templist + "\n");

		if (originalList == templist) {
			System.out.println("List is sorted" + "\n");
		} else {
			System.out.println("List is NOT sorted" + "\n");
		}

		country.click();
		WebElement Germany = driver.findElement(By.xpath("//*[@id=\"country\"]/option[4]"));
		Germany.click();

		String selectedCountry = Germany.getText();
		System.out.println("Selected Country" + "\n" + selectedCountry + "\n");
        Thread.sleep(2000);
        
		driver.quit();

	}

}
