package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class ProductPage extends HelperFunctions {
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//div[@class='cmp-error__title']")
	private WebElement errorTitle;
	
	@FindBy(xpath="//div[@class='cmp-error__description']")
	private WebElement errorDescription;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement myProductCatDropdown;
	
	@FindBy(xpath="//h1[@class='cmp-all-resources__top-bar-title']")
	private WebElement allResources;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5resources;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5resources;
	
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']")
	private static List<WebElement> myProductCatDropdownList;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private WebElement footerContent;
	
	@FindBy(xpath="//div[@class='ap-footer-link-group']")
	private WebElement footerLinkGroup;
	
	@FindBy(xpath="//span[.='Next']")
	private WebElement nextButtonforResources;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample10.pdf.coredownload.inline.pdf.coredownload.inline.pdf']")
	private WebElement firstResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample13.png.coredownload.inline.png.coredownload.inline.png']")
	private WebElement secondResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample16.jpg.coredownload.inline.jpg.coredownload.inline.jpg']")
	private WebElement thirdResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/7E1c.gif.coredownload.inline.gif.coredownload.inline.gif']")
	private WebElement forthResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/gif.coredownload.inline.gif.gif.coredownload.inline.gif.coredownload.inline.gif']")
	private WebElement fifthResource;
	
	@FindBy(xpath="//button[@id='showMore']")
	private WebElement viewMoreButton;
	
	@FindBy(xpath="//button[@id='showLess']")
	private WebElement viewLessButton;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/my-products.html']")
	private WebElement myProductItemOnSitemap;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div")
	private static List<WebElement> myProductCatDropdownList2;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement selectDropdown;
	
	@FindBy(xpath="//*[@id=\"listPage\"]/div/div/div[2]/div[3]")
	private WebElement cardCat;
	
	@FindBy(xpath="//div[@id='tagElements']")
	private WebElement documentDropdown;
	
	
	@FindBy(xpath="//div[@class='cmp-all-resources__card-category']")
	private WebElement cardCategory;
	
	@FindBy(xpath="//img[@src='/us/en/errors/403/_jcr_content/root/container/container/error/image.coreimg.svg/1668507894105/403-error-illus-%281%29.svg']")
	private WebElement errorImage;
	
	@FindBy(xpath="//div[@id='searchProductDropdown']")
	private WebElement productDropdown;
	
	@FindBy(xpath="//div[@id='docDropdown']")
	private WebElement catDropdown;
	
	@FindBy(xpath="//div[@id='searchSortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//input[@id='gatedSearchInput']")
	private WebElement myProductSearchField;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample10.pdf.coredownload.inline.pdf']")
	private WebElement resource1forProduct2;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample13.png.coredownload.inline.png']")
	private WebElement resource2forProduct2;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample16.jpg.coredownload.inline.jpg']")
	private WebElement resource3forProduct2;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/7E1c.gif.coredownload.inline.gif']")
	private WebElement resource4forProduct2;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/gif.gif.coredownload.inline.gif']")
	private WebElement resource5forProduct2;
	
	@FindBy(xpath="//a[@href='/us/en/my-products/product-2.html']")
	private WebElement product2;
	
	@FindBy(xpath="//a[@href='/us/en/my-products/product-4.html']")
	private WebElement product4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/Transparency-Hub-Support-Guide-test.pdf.coredownload.inline.pdf']")
	private WebElement resource1forProduct4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/Resell Data Processing addendum.png.coredownload.inline.png']")
	private WebElement resource2forProduct4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/sample7.jpg.coredownload.inline.jpg']")
	private WebElement resource3forProduct4;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5Assets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5Assets;
	
	@FindBy(xpath="//div[@class='cmp-my-products-tile__text']")
	private static List<WebElement> titleofAssets;
	
	@FindBy(xpath="//div[@class='cmp-for-you__txt']")
	private WebElement forYouTitle;
	
	@FindBy(xpath="//span[.='Product 2']")
	private WebElement product2Title;
	
	@FindBy(xpath="//span[.='Product 4']")
	private WebElement product4Title;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/my-products.html']")
	private WebElement myProductOnLeftNavigation;
	
	@FindBy(xpath="//div[@class='cmp-hero-promotion']")
	private WebElement heroPromotion;
	
	@FindBy(xpath="((//div[@class='cmp-tabs__tab-search-container'])[1]//li)[position()=1]")
	private WebElement firstProduct;
	
	@FindBy(xpath="//span[@class='cmp-header__cta-avatar-initials']")
	private WebElement userInitials;
	
	
	
	
	
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	
	
	
	
	
	
	
	
	public void setDocCategory() {
		
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", allResources);
		
        
		for(WebElement eachdocCat: myProductCatDropdownList) {
			System.out.println(eachdocCat.getText());
			
			if(eachdocCat.getText().contains("Customer engagement") && eachdocCat.getText().contains("Operational improvement")&& eachdocCat.getText().contains("Risk mitigation")
					&& eachdocCat.getText().contains("Strategic intelligence")&& eachdocCat.getText().contains("Workforce experience")) {
				
				Assert.assertTrue(true);}else {Assert.assertTrue(false);}}
		
		for(WebElement eachdocCat:myProductCatDropdownList) {
			if(eachdocCat.getText().contains("Customer engagement")) {
				eachdocCat.click();
				break;
			}
		}	
		
		
	}
	
	public void setFooterWithoutLogin() {
		
		 JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
	        js.executeScript("arguments[0].scrollIntoView(true);", footerContent);
	        if(footerContent.isDisplayed() && footerLinkGroup.isEnabled() ) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
	
	}
	
	public void setFooterWithLogin() {
		
		 JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
	        js.executeScript("arguments[0].scrollIntoView(true);", footerContent);
	        System.out.println(footerContent.getText());
	       
	        if(footerContent.isDisplayed() && footerLinkGroup.isDisplayed() ) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
	      
	
	}
	
	public void setErrorMessage() {
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/my-products/product-3.html");
	    HelperFunctions.staticWait(5);
	    String actualErrorTitle=errorTitle.getText();
		String expectedErrorTitle="403- Forbidden Access";
		
		String actualErrorDescription=errorDescription.getText();
	    String expectedErrorDescription="You do not have access to this page. Please contact our support team for further assistance. (Link to service now where user can submit a ticket)";
		
		Assert.assertEquals(actualErrorTitle, expectedErrorTitle, "Actual and expected error title do not match");
		Assert.assertEquals(actualErrorDescription, expectedErrorDescription, "Actual and expected error description do not match");
	    
		
	}
	
	public void setErrorPage() {
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/content/pc/us/en/my-products/product-3.html");
	    HelperFunctions.staticWait(5);
	    
		
		if(errorImage.isDisplayed() && errorTitle.isDisplayed() &errorDescription.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
		
	}
	
	
	
public void setDisplayResources() {
	HelperFunctions.waitForPageToLoad(3);
	product2.click();
	HelperFunctions.waitForPageToLoad(3);
	
	 JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
     js.executeScript("arguments[0].scrollIntoView(true);", allResources);
     for(WebElement eachResources: first5resources) {
    	 if(eachResources.isDisplayed()) {
    		 Assert.assertTrue(true);
    	 }else {
    		 Assert.assertTrue(false);
    	 }
     }
     nextButtonforResources.click();
     for(WebElement eachResources2: last5resources) {
    	 if(eachResources2.isDisplayed()) {
    		 Assert.assertTrue(true);
    	 }else {
    		 Assert.assertTrue(false);
    	 }
     }
     
    }
public void setNewTabAssets() {
	HelperFunctions.staticWait(3);
	product2.click();
	HelperFunctions.staticWait(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
    HelperFunctions.staticWait(3);
    resource1forProduct2.click();
    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
    Driver.getDriver().switchTo().window(tabs.get(2));
    System.out.println(Driver.getDriver().getCurrentUrl());
    String actualUrl=Driver.getDriver().getCurrentUrl();
    String expectedUrl="https://productcentral-qa.products.pwc.com/content/dam/productcentral/en_us/products/product-2/myproducts/sample10.pdf.coredownload.inline.pdf";
    Assert.assertEquals(actualUrl, expectedUrl);
    Driver.getDriver().close();
    Driver.getDriver().switchTo().window(tabs.get(1));
    HelperFunctions.staticWait(3);
	
}

public void setMyProductSitemap() {
	HelperFunctions.waitForPageToLoad(3);
	if(myProductItemOnSitemap.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}

public void setTagsAccompany() {
	HelperFunctions.staticWait(3);
	product2.click();
	HelperFunctions.staticWait(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
    
    selectDropdown.click();
    
    String expected1="Technical Guide";
    
    
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("Technical Guide")) {
		tags.click();
		Assert.assertEquals(cardCat.getText(), expected1);
		}
	}
	HelperFunctions.staticWait(3);
	selectDropdown.click();
	String expected2="Resel Alliance Terms";
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("Resel Alliance Terms")) {
		tags.click();
		Assert.assertEquals(cardCat.getText(), expected2);
		}
	}
	HelperFunctions.staticWait(3);
	selectDropdown.click();
	String expected3="FAQ";
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("FAQ")) {
		tags.click();
		Assert.assertEquals(cardCat.getText(), expected3);
		}
	}
	HelperFunctions.staticWait(3);
	selectDropdown.click();
	String expected4="Product Overview";
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("Product Overview")) {
		tags.click();
		Assert.assertEquals(cardCat.getText(), expected4);
		}
	}
	HelperFunctions.staticWait(3);
	selectDropdown.click();
	String expected5="Quick Reference Guide";
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("Quick Reference Guide")) {
		tags.click();
		Assert.assertEquals(cardCat.getText(), expected5);
		}
	}
	
	
}

public void setMyProductSearch() {
	
	HelperFunctions.waitForPageToLoad(3);
	myProductSearchField.click();
	myProductSearchField.sendKeys("Product 2");
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(3);
	if(productDropdown.isEnabled() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	
}

public void setResourcesBasedonProducts() {
	product2.click();
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", allResources);
    
   if(resource1forProduct2.isDisplayed() && resource2forProduct2.isDisplayed() && resource3forProduct2.isDisplayed() && resource4forProduct2.isDisplayed() && resource5forProduct2.isDisplayed()) {
	   Assert.assertTrue(true);
   }else
	   Assert.assertTrue(false);
   
   
   
   myProductItemOnSitemap.click();
   HelperFunctions.waitForPageToLoad(5);
   
   product4.click();
   
   JavascriptExecutor js1 = ((JavascriptExecutor) Driver.getDriver());
   js1.executeScript("arguments[0].scrollIntoView(true);", allResources);
    
   if(resource1forProduct4.isDisplayed() && resource2forProduct4.isDisplayed() && resource3forProduct4.isDisplayed()) {
	   Assert.assertTrue(true);
   }else
	   Assert.assertTrue(false);
    
   
   
    
  
   
   
}

public void setNotSupportMultiSelect() {
	product2.click();
	HelperFunctions.waitForPageToLoad(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
	   documentDropdown.click();    
	    
	    
		for(WebElement tags:myProductCatDropdownList) {
			tags.click();
			Assert.assertFalse(tags.isDisplayed());
			
		}
	   
}

public void setLoadMoreButton() {
	HelperFunctions.waitForPageToLoad(3);
	product2.click();
	HelperFunctions.waitForPageToLoad(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      if(viewLessButton.isDisplayed()) {
      	for(WebElement eachAsset: first5Assets) {
      		if(eachAsset.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      	      	Assert.assertTrue(false);
            }
      	}
      	for(WebElement eachAsset2:last5Assets) {
      		if(eachAsset2.isDisplayed()) {
      			Assert.assertTrue(true);
      		}
      	}
      }else {
      	Assert.assertTrue(false);
      }
	
	
}

public void setClickLoadMoreButton() {
	HelperFunctions.waitForPageToLoad(3);
	product2.click();
	HelperFunctions.waitForPageToLoad(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      
      	
      	for(WebElement eachAsset2:last5Assets) {
      		if(eachAsset2.isDisplayed() && viewLessButton.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      			Assert.assertTrue(false);
      		}
      	}
      
	
	
}

public void setClickLoadLessButton() {
	HelperFunctions.waitForPageToLoad(3);
	product2.click();
	HelperFunctions.waitForPageToLoad(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      
      	
      if(viewLessButton.isDisplayed()) {
        	for(WebElement eachAsset: first5Assets) {
        		if(eachAsset.isDisplayed()) {
        			Assert.assertTrue(true);
        		}else {
        	      	Assert.assertTrue(false);
              }
        	}
        	for(WebElement eachAsset2:last5Assets) {
        		if(eachAsset2.isDisplayed()) {
        			Assert.assertTrue(true);
        		}
        	}
        }else {
        	Assert.assertTrue(false);
        }
      
      JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
      executor2.executeScript("arguments[0].click();", viewLessButton);
      
      if(viewMoreButton.isDisplayed()) {
      	for(WebElement eachAsset: first5Assets) {
      		if(eachAsset.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      	      	Assert.assertTrue(false);
            }
      	}
      	for(WebElement eachAsset2:last5Assets) {
      		if(!eachAsset2.isDisplayed()) {
      			Assert.assertTrue(true);
      		}
      	}
      }else {
      	Assert.assertTrue(false);
      }
  	
      
	
	
}

public void setTitleOfAssets() {
	HelperFunctions.waitForPageToLoad(3);
	product2.click();
	HelperFunctions.waitForPageToLoad(3);
	JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
    js.executeScript("arguments[0].scrollIntoView(true);", forYouTitle);
    int hasMoreThan3Line=0;
    System.out.println(titleofAssets.size());
	for(WebElement eachTitleOfAssets: titleofAssets) {
		System.out.println(eachTitleOfAssets.getCssValue("-webkit-line-clamp"));
		if(eachTitleOfAssets.getCssValue("-webkit-line-clamp").equals("3")) {
			Assert.assertTrue(true);
		}else {
			hasMoreThan3Line++;
			System.out.println(hasMoreThan3Line);
			Assert.assertTrue(false);
//			logger.error("The description is more than 6 lines");
			
		}
	}
}

public void setActiveTab() {
	HelperFunctions.waitForPageToLoad(3);
	String s = product2Title.getCssValue("color");
    System.out.println("Color is :" + s);
    String s2 = product4Title.getCssValue("color");
    System.out.println("Color is :" + s2);
    if(s.equals("rgba(70, 70, 70, 0.7)") && s2.equals("rgba(65, 83, 133, 1)") ) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
    HelperFunctions.staticWait(3);
    product2.click();
    HelperFunctions.staticWait(3);
    String s3 = product2Title.getCssValue("color");
    System.out.println("Color is :" + s3);
    String s4 = product4Title.getCssValue("color");
    System.out.println("Color is :" + s4);
       
    if(s3.equals("rgba(65, 83, 133, 1)") && s4.equals("rgba(70, 70, 70, 0.7)") ) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
    

}

public void setFirstTabActive() {
	HelperFunctions.waitForPageToLoad(3);
	myProductOnLeftNavigation.click();
	HelperFunctions.waitForPageToLoad(3);
    /*String s3 = product2Title.getCssValue("color");
    System.out.println("Color is :" + s3);
    String s4 = product4Title.getCssValue("color");
    System.out.println("Color is :" + s4);
       
    if(s3.equals("rgba(65, 83, 133, 1)") && s4.equals("rgba(70, 70, 70, 0.7)") ) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }*/
	String activeColor="rgba(65, 83, 133, 1)";
	String fp=firstProduct.getCssValue("color");
	if(fp.equals(activeColor)) {
		Assert.assertTrue(true);
	}else {
    	Assert.assertTrue(false);
    }
    

}

public void setHeroPromotion() {
	HelperFunctions.waitForPageToLoad(3);
	 String attr = heroPromotion.getAttribute("src");
	    if (attr == null){
	        System.out.println("Hero promotion is not clickable");
	        Assert.assertTrue(true);
	    }

	    else {
	    	System.out.println("Hero promotion is clickable");
	    	Assert.assertTrue(false);
	    }

	
	
}

public void setUserInitials() throws Exception {
	read1.setExcelFile("./testdata.xlsx", "QA");
	HelperFunctions.waitForPageToLoad(3);
	String email=read1.getCellData("DATA", 1);
	String firstInit=email.substring(0,1);
	String lastInit=email.substring(email.indexOf(".")+1);
	String lastInit2=lastInit.substring(0,1);
	String userInitials2=userInitials.getText();
	String firstAndLastInit=firstInit+lastInit2;
	System.out.println(userInitials.getText());
	System.out.println(firstInit+lastInit2);
	Assert.assertTrue(userInitials2.equalsIgnoreCase(firstAndLastInit));
	
	
}



	
	
	
	
	
	
	

 
	
	

	
	
	

	
	
	
	
	
	

}
