package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.github.javafaker.Faker;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;



public class ProductListingPage extends HelperFunctions {
	public ProductListingPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	
	
	@FindBy(xpath="//div[@class='cmp-related-links__items']//div//a")
	private static List<WebElement> allLinks;
	
	@FindBy(xpath="//div[@class='cmp-related-links']")
	private static List<WebElement> allLinks2;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewFromCloud;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/terms---conditions.html']")
	private WebElement termsAndConditionsLink;
	
	@FindBy(xpath="(//span[.='PricewaterhouseCoopers2'])[1]")
	private WebElement termsAndConditionsTitle;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/maintenance---support.html']")
	private WebElement maintenanceAndSupportLink;
	
	@FindBy(xpath="(//span[.='sample (5)'])[1]")
	private WebElement headerForMaintenanceAndSupport;
	
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="(//span[.='PDF Template for AEM Testing'])[1]")
	private WebElement offeringOverviewLinkTitle;
	
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/documentation.html']")
	private WebElement documentationLink;
	
	@FindBy(xpath="(//span[.='PDF Template for AEM Testing'])[2]")
	private WebElement documentationTitle;
	
	@FindBy(xpath="//div[@class='HUDView__hudContainer___3mx_O HUDView__immersiveShow___1pWVE']")
	private WebElement offeringPdfIcon;
	
	@FindBy(xpath="//nav[@id='skinny-rail']")
	private WebElement pdfIcon;
	
	@FindBy(linkText="Back to Cloud")
	private WebElement backToCloudBreadcrumb;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement cloudTitle;
	
	@FindBy(linkText="Back to Products")
	private WebElement backToProductsBreadcrumb;
	
	@FindBy(xpath="//h1[@class='cmp-product-list__search-bar-title']")
	private WebElement productsTitle;
	
	@FindBy(xpath="//input[@aria-label='Search Product']")
	private WebElement searchProduct;
	
	@FindBy(xpath="//div[@class='ap-option-item']")
	private WebElement searchItem;
	
	@FindBy(xpath="//span[@class='cmp-product-list__card-title ']")
	private WebElement products;
	
	@FindBy(xpath="//a[@data-product-name='Strategic']")
	private WebElement strategicProduct;
	
	@FindBy(xpath="//a[@data-product-name='Cloud']")
	private WebElement cloudProduct;
	
	@FindBy(xpath="//a[@data-product-name='Risk']")
	private WebElement riskProduct;
	
	@FindBy(xpath="//input[@placeholder='Search Products']")
	private WebElement productSearchBar;
	
	@FindBy(xpath="//div[@class='has-no-results']")
	private WebElement noResult;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']//span[2]")
	private static List<WebElement> titleofTiles;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement contentTitle;
	
	@FindBy(xpath="//div[@id='pdfviewer-cc9adec430-content']")
	private WebElement termsConditionContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-4fb6948d1d-content']")
	private WebElement offeringOverviewContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-4fb8297d06-content']")
	private WebElement documentationContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-033ffa1470-content']")
	private WebElement maintenanceContent;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	@FindBy(xpath="//div[@class='cmp-pdfviewer']")
	private WebElement pdfViewer;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']//span")
	private static List<WebElement> cardTitle;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> productLinks;
	
	
	
	
	
	
	
	



   

    public void setAllLinks() throws IOException { 
    	HelperFunctions.waitForPageToLoad(5);
    	  for (WebElement link : allLinks) {
            
              String href = link.getAttribute("href");

          
              if (!href.isEmpty()) {
            
                  System.out.println(href);
                  Assert.assertTrue(true);
              }else {
            	  Assert.assertTrue(false);
              }
          }
    	
    }


	
    
    public void setLinks() {
    	
    	for (WebElement link : allLinks) {
    	    try {
    	        link.click();   
    	        Assert.assertNotNull(pdfViewer);
    	    } catch (StaleElementReferenceException e) {
    	       
    	    }
    	}
    }
    
    public void setPdfControllers() {
    	
    	for (WebElement link : allLinks) {
    	    try {
    	        link.click();   
    	        Assert.assertNotNull(pdfIcon);
    	    } catch (StaleElementReferenceException e) {
    	       
    	    }
    	}
    	
    
    }

	

	public void setBreadcrumbs() {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
    
         
			 
	
	
	}
	public void setLinkOfBreadcrumbs() {
		HelperFunctions.waitForPageToLoad(5);
    
		for (WebElement link : breadcrumbLinks) {
			if(link.getAttribute("href")!=null) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}

		
	}
	
	public void setSearchBox() {
		HelperFunctions.waitForPageToLoad(5);
		searchProduct.click();
		searchProduct.sendKeys("Customer Link");
		searchItem.click();
		for(WebElement title:cardTitle) {
			if(title.getText().contains("Customer Link")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		/*if(cloudProduct.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}*/
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		searchProduct.click();
		searchProduct.sendKeys("Digital on Demand");
		searchItem.click();
		HelperFunctions.staticWait(3);
		for(WebElement title:cardTitle) {
			if(title.getText().contains("Digital on Demand")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		/*if(strategicProduct.isDisplayed() ) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		searchProduct.click();
		searchProduct.sendKeys("Risk");
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(riskProduct.isDisplayed() ) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}*/
			
		
		
	}
	
	public void setSearchResult() {
		HelperFunctions.waitForPageToLoad(5);
		searchProduct.click();
		searchProduct.sendKeys("Cl");
		HelperFunctions.staticWait(3);
		searchItem.click();
		if(cloudProduct.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		searchProduct.click();
		searchProduct.sendKeys("St");
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(strategicProduct.isDisplayed() ) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		searchProduct.click();
		searchProduct.sendKeys("Ri");
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(riskProduct.isDisplayed() ) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
			
		
	}
	
	public void setSearchBarKeywordforNegativeTest() {
		HelperFunctions.waitForPageToLoad(5);
		productSearchBar.click();
		Faker faker=new Faker();
		productSearchBar.sendKeys(faker.name().firstName());
		if(noResult.isDisplayed() && noResult.getText().contains("Nothing matches your results")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
	}
	
	public void setDocumentTileLine() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachProductTitle: titleofTiles) {
			System.out.println(eachProductTitle.getCssValue("-webkit-line-clamp"));
			if(eachProductTitle.getCssValue("-webkit-line-clamp").equals("2")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
		}
	}
	public void setContentPageSameTab() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement each:productLinks) {
			each.click();
			break;
		}
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : productLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
		
	}
	
	
    
    
	
	
	
   
        
	
		
		
	     
     
	    
	      
	
	
	

}
