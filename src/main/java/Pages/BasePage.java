package Pages;

import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;

public class BasePage extends HelperFunctions {
	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	@FindBy(id="initEmail")
	private static WebElement email;
	
	@FindBy(className="a-btn a-btn-primary a-btn-xl")
	private static WebElement nextButton;
	
	@FindBy(className="a-text-input a-input-lg ng-pristine ng-invalid ng-touched")
	private static WebElement password;
	
	@FindBy(className="a-btn a-btn-primary a-btn-xl mt-4 submit-btn")
	private static WebElement submitButton;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static WebElement footer;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/static-assets/pwc-final-logo.svg']")
	private static WebElement logo;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private static WebElement search;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static WebElement footerHome;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']")
	private static List<WebElement> leftNavigationItems2;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']//span")
	private static List<WebElement> leftNavigationItems;
	
	@FindBy(xpath="//a[@href='#collapseNavBtn']")
	private static WebElement collapseButton;
	
	@FindBy(xpath="//span[@class='ap-icon icon-enter-left-outline']")
	private static WebElement expandButton;
	
	@FindBy(tagName="img")
	private static List<WebElement> productsListImages;
	
	@FindBy(tagName="a")
	private static List<WebElement> alltags;
	
	@FindBy(xpath="//span[@class='cmp-header__cta-avatar-initials']")
	private static WebElement userInitials;
	
	
	
	
	
	public static void setHomePageTemplateElements() {
		
		if(footer.isDisplayed() && logo.isDisplayed() && search.isDisplayed()) {
			Assert.assertTrue(true);//
		}else {
			Assert.assertTrue(false);
		}
	}
	
	public static void setFooterTextandPosition() {
		String actualFooterText=footer.getText();
		String expectedFooterText="© 2023 PwC. All rights reserved. PwC refers to the US member firm of the PwC network or one of its subsidiaries or affiliates.";
		System.out.println(actualFooterText);
		Assert.assertEquals(actualFooterText, expectedFooterText);
		Point locationOfFooter=footer.getLocation();
		System.out.println(footer.getLocation());
		int x=560;
		int y=1055;
		if(locationOfFooter.getX()==x && locationOfFooter.getY()==y) {
			Assert.assertTrue(true);
			System.out.println("The footer is on the right position");
		}else {
			Assert.assertTrue(false);
			System.out.println("The footer is NOT on the right position");
		}
	}
	
public static void setFooterHome() {
	String actualColor = footerHome.getCssValue("color");
	String actualHexCodeForColor = Color.fromString(actualColor).asHex();
	String expectedColor="rgba(37, 37, 37, 1)";
	String expectedHexCodeForColor="#252525";
	
	System.out.println(actualColor);
	System.out.println(actualHexCodeForColor);
	
	
	
	if(footerHome.getCssValue("font-size").equals("16px") && footerHome.getCssValue("font-family").equals("\"PwC Helvetica Neue\"") && actualColor.equals(expectedColor)&&
			actualHexCodeForColor.equals(expectedHexCodeForColor)) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
	
	
    
	
	}
public static void setLeftNavigationItems2() {
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement items:leftNavigationItems2) {
		System.out.println(items.getText());
		if (items.getText().contains("Home") && items.getText().contains("Legal")&& items.getText().contains("Products")
				&& items.getText().contains("Security")&& items.getText().contains("Compliance")
				&& items.getText().contains("Privacy")&& items.getText().contains("Accesiblility")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
}
}
public static void setCollapseButton() {
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
     executor.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
     executor2.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
}

public static void setAllImages()  {
	
	int brokenImages=0;
	System.out.println(productsListImages.size());
	 for (WebElement ele : productsListImages) {
		
		 
		 String attr = ele.getAttribute("src");
		    if (attr == null){
		    	brokenImages++;
		    	System.out.println("The number of broken images : "+brokenImages);
		        System.out.println("Attribute does not exist");
		        Assert.assertTrue(false);
		    }

		    else if (attr.equals("")){
		        System.out.println("Attribute is empty string");
		    }
	 }}
/*public static void setfooter()  {
	String expectedFooterText="© 2022 PwC. All rights reserved. PwC refers to the US member firm of the PwC network or one of its subsidiaries or affiliates.";
for(int i=0; i<alltags.size(); i++) {
	System.out.println(alltags.get(i).getAttribute("href"));
	System.out.println(alltags.get(i).getText());
	alltags.get(i).click();
	
}


	

}*/
public static void setLeft() {
	System.out.println("No of links are "+ alltags.size());  
    
	//checking the links fetched.
	for(int i=0;i<alltags.size();i++)
	{
	    WebElement E1= alltags.get(i);
	    String url= E1.getAttribute("href");
	    if(url!=null) {
	    	System.out.println(url); 
	    	
	    }
	    
	  
	}
}


public static void setAllSectionsOnHeader() {
	HelperFunctions.waitForPageToLoad(5);
	if(logo.isDisplayed() && search.isDisplayed() && userInitials.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}

}
