package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;

public class ResellerPage extends HelperFunctions {
	public ResellerPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/check-in.html']")
	private WebElement checkInLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/dragos-alliance.html']")
	private WebElement complianceLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/microsoft-alliance.html']")
	private WebElement microsoftAllianceLink;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> productList;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/check-in/resell-offering-overview.html']")
	private WebElement resellOfferingOverviewLink;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement resellOfferingOverviewTitle;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/automation/reseller-demo/check-in.html']")
	private WebElement backtoCheckinBreadcrumb;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/automation/reseller-demo.html']")
	private WebElement backtoResellerDemoBreadcrumb;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	
	public void setBreadcrumbs() {
		
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement link:productList) {
			link.click();
			break;
		}
		HelperFunctions.waitForPageToLoad(5);
		
		 for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
	}
	
	public void setPageTitleAndProducts() {
		HelperFunctions.waitForPageToLoad(3);
		Assert.assertTrue(pageTitle.isDisplayed());
		
		  for (WebElement link : productList) {
	            
              String href = link.getAttribute("href");

          
              if (!href.isEmpty()) {
            
                  System.out.println(href);
                  Assert.assertTrue(true);
              }else {
            	  Assert.assertTrue(false);
              }
          }
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
