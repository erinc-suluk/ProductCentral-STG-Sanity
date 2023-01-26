package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class LegalPage extends HelperFunctions {
	public LegalPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal/maintenance---support.html']")
	private WebElement maintenanceAndSupportLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal/data-processing-addendum.html']")
	private WebElement dataProcessingLink;
	
	@FindBy(xpath="//a[@href='/us/en/products/change-navigator/offering-overview.html']")
	private WebElement changeNavigatorLink;
	
	@FindBy(xpath="//a[@href='/us/en/products/customer-link/maintenance---support.html']")
	private WebElement customerLink;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement maintenanceAndSupportTitle;
	
	@FindBy(xpath="//a[@href='https://productcentral-qa.products.pwc.com/us/en/automation/legal/maintenance---support.html']")
	private WebElement maintenanceAndSupportBreadcrumb;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement ContentTitle;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']//a")
	private static List<WebElement> tilesComponents;
	
	@FindBy(xpath="//a[@href='/us/en/automation/legal.html']")
	private WebElement backtoLegalBreadcrumb;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> legalTiles;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']")
	private static List<WebElement> legalTilesOffering;
	
	@FindBy(xpath="//span[@class='cmp-breadcrumb__link-title']")
	private WebElement offeringOverviewBreadcrumb;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-desc']")
	private static List<WebElement> descriptionOfTiles;
	
	@FindBy(xpath="//a[@id='referrer-module']")
	private WebElement backtoLegalBreadcrumbfromContent;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-title']")
	private static List<WebElement> legalTilesTitle;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	public void setlegalTiles() {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : legalTiles) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
	}
	public void setDescriptionOfTiles() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachDescription: descriptionOfTiles) {
			System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
			if(eachDescription.getCssValue("-webkit-line-clamp").equals("3")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
		}
	}
	
	public void setContentPageTags() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachTiles: tilesComponents) {
			 try {
				 String hrefValue = eachTiles.getAttribute("href");
				 eachTiles.click();
				 HelperFunctions.staticWait(3);
				 String currentUrl = Driver.getDriver().getCurrentUrl();
				 Assert.assertEquals(hrefValue, currentUrl);
				 Driver.getDriver().navigate().back();
	    	    } catch (StaleElementReferenceException e) {
	    	       
	    	    }
		}
			
	}
	public void setDisplayTilePerDocumentCat() throws Exception {
		HelperFunctions.waitForPageToLoad(3);
		//read1.setExcelFile("./testdata.xlsx", "QA");
		 FileInputStream file = new FileInputStream("C:\\Users\\erong\\git\\ProductCentralProject-Automation1\\testdata.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(file);
         XSSFSheet sheet = workbook.getSheetAt(1); 
         
         int columnIndex3 = 0;
         HashSet<String> cellValues3 = new HashSet<String>();
         for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
             XSSFRow row = sheet.getRow(rowNum);
             if(row == null) continue;
             XSSFCell cell = row.getCell(columnIndex3);
             if(cell == null) continue;
             cellValues3.add(cell.getStringCellValue());
         }
         for (WebElement element3 : legalTilesTitle) {
             if(element3.isDisplayed() && element3.isEnabled()){
                 String elementText3 = element3.getText();
                 if(elementText3!=null && !elementText3.isEmpty()){
                     Assert.assertTrue(cellValues3.contains(elementText3), "element text: " + elementText3 + " not found in the column: " + columnIndex3);
                 }else{
                     System.out.println("Element text is empty or null, skipping the element");
                 }
             }else{
                 System.out.println("Element is not interactable or not visible, skipping the element");
             }
         }
	
	}
	
	public void setBreadcrumb() {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : breadcrumbLinks) {
			 Assert.assertTrue(link.isDisplayed());
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
	}
	
	
	
	
	
	

}
