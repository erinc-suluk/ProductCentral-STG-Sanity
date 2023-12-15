package com.pwc.productcentral;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Pages.AuthoringPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.HomePageTemplatePage;
import Pages.LegalPage;
import Pages.LoginPageObjects;

import Pages.ProductListingPage;
import Pages.ProductPage;
import Pages.ResellerPage;
import Pages.SecurityPage;
import Pages.UMSPage;


public class SanityTestCases extends BasePage {
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static ConfigurationsReader read;
	String platform = null;
	LoginPageObjects lpo=new LoginPageObjects();
	HomePage hp=new HomePage();
	ProductListingPage plp=new ProductListingPage();
	HomePageTemplatePage hpt=new HomePageTemplatePage();
	ResellerPage rp=new ResellerPage();
	LegalPage lp=new LegalPage();
	SecurityPage sp=new SecurityPage();
	ProductPage pp=new ProductPage();
	AuthoringPage ap=new AuthoringPage();
	UMSPage ums=new UMSPage();
	screenshotUtil ssu=new screenshotUtil();
	private ExtentTest test;
	
	
	
	Logger logger=Logger.getLogger("SanityTestCases");
	
	ReadXLSdata read1=new ReadXLSdata();
	
	


	
	@BeforeSuite
	public void setUp() {
		PropertyConfigurator.configure(".\\log4j.properties");
	    read = new ConfigurationsReader();
	    platform = read.getPlatform();
	    read.platformName();
	    String reportFilePrefix = "Sanity Automation Report for Product Central";
	    String reportFileName = reportFilePrefix + ".html";
	    
	   
	    File existingReport = new File(reportFileName);
	    
	    if (existingReport.exists()) {
	       
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	        String timestamp = dateFormat.format(new Date());
	        String newReportFileName = reportFilePrefix + "_" + timestamp + ".html";
	        
	        if (existingReport.renameTo(new File(newReportFileName))) {
	            System.out.println("Renamed existing report to: " + newReportFileName);
	        } else {
	            System.out.println("Failed to rename existing report.");
	        }
	    }

	
	    htmlReporter = new ExtentHtmlReporter(reportFileName);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	     
	}
		
	@BeforeMethod
	public void initTest() throws Exception {
	    Driver.getDriver();
	    read1.setExcelFile("./testdata.xlsx", "STG");
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
	}
	
	
	/*******************************************************Sanity Test Case********************************************************/
	
	
	@Test
	public void WEB_1() throws Exception{
		 String testName = "Verify that the sorting order of tiles are matching to the related links or not";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 48));
		        lpo.setLogin3();
		        ap.setReorderTiles(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_2() throws Exception{
		String testName = "Verify author is able to author the site map will all the links";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 16));
            lpo.setLogin4();
    	    ap.setSitemap(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_3() throws Exception{
		String testName = "Verify author is able to hide pages from displaying within the site map";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 17));
            lpo.setLogin4();
    	    ap.setHideSitemap(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	@Test
	public void WEB_4() throws Exception{
		String testName = "Verify the user should see different footer items if logged in";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 2));
            pp.setFooterWithoutLogin(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_5() throws Exception{
		String testName = "Verify the user should see different footer items if logged in";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setFooterWithLogin(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_6() throws Exception{
		String testName = "Verify tiles are partially authorable";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 19));
            lpo.setLogin4();
    	    ap.setTilesAuthorization(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	

	
	@Test
	public void WEB_7() throws Exception{
		String testName = "Verify when the user clicks on any item the specified asset/page must be loaded in the new tab";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setNewTabAssets(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	
	@Test
	public void WEB_8() throws Exception{
		String testName = "Verify if user is logged in, then My Products heading in the sitemap is visible";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setMyProductSitemap(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_9() throws Exception{
		String testName = "Verify the tags accompany the items which are assets";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setTagsAccompany(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_10() throws Exception{
		String testName = "Verify that this page should appear to all Site Visitors that are logged in but do not have the right level of permissions to access the page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setErrorPage(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_11() throws Exception{
		String testName = "Verify there are 2 filters with minor differences between Global and My Products search";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setMyProductSearch(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_12() throws Exception{
		String testName = "Verify the all resources component is presenting a list of 5 assets that are relevant to the product on the product landing page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setResourcesBasedonProducts(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_13() throws Exception{
		String testName = "Verify unpublish workflow is available both sites and assets";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 17));
            lpo.setLogin4();
    	    ap.setUnpublishWorkflow(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_14() throws Exception{
		String testName = "Verify that once content is approved and published, the system will record the date of publishing";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 17));
            lpo.setLogin4();
    	    ap.setUpdatedDate(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	
	}
	

	@Test
	public void WEB_15() throws Exception{
		String testName = "Verify the author is able to author the title and the description";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 20));
            lpo.setLogin4();
    	    ap.setContentAuthorization(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	
	@Test
	public void WEB_16() throws Exception{
		String testName = "Verify all the sections on the header";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    BasePage.setAllSectionsOnHeader(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_17() throws Exception{
		String testName = "Verify the scroll functionality";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    BasePage.setScrollFunctionality(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_18() throws Exception{
		String testName = "Verify that not all products will have all categories listed on the page but some will have a combination of them";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 23));
            lpo.setLogin4();
    	    ap.setCatCombination(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	 @Test
	    public void WEB_19() throws Exception{
	        String testName = "Verify as an Author, I am able to publish assets using the workflows";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 17));
	            lpo.setLogin4();
	            ap.setWorkflowApproval(test);
	            test.pass("Test passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
	        
	    }
	    @Test
	    public void WEB_20() throws Exception{
	        String testName = "Verify that we can push a page to workflow from the siteadmin view and from the page properties";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 17));
	            lpo.setLogin4();
	            ap.setWorkflowApproval2(test);
	            test.pass("Test passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
	        
	    }
	    @Test
		public void WEB_21() throws Exception{
			String testName = "Verify the hyperlinks in the component will be populated by the system(both title & URL)";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 17));
	            lpo.setLogin4();			 
	    		ap.setHyperlinks(test);
	            test.pass("Test passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
			
		}
	
	
	@Test
	public void WEB_22() throws Exception{
		String testName = "Verify on clicking 'login to my products' tile the user is navigated to the PC login page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setLoginToMyProductLink(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	
	@Test
	public void WEB_23() throws Exception{
		String testName = "Verify the filter does not support multi-select";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setNotSupportMultiSelect(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	@Test
	public void WEB_24() throws Exception{
		String testName = "Verify the pages does not have broken images";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            BasePage.setAllImages(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_25() throws Exception{
		String testName = "Verify on click on load more, another 5 assets must be loaded";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setLoadMoreButton(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	
	@Test
	public void WEB_26() throws Exception{
		String testName = "Verify that dropdown list will display the Product & document category as per the latest Tag taxonomy document";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 2));
            hp.setDropdownList();
    	    hp.setDropdownList2(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_27() throws Exception{
		String testName = "Verify that pagination is removed from My resources section on My products template";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setDisplayResources(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_28() throws Exception{
		String testName = "Verify last updated date will also be reflected under the title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setDateFormat(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	

	@Test
	public void WEB_29() throws Exception{
		String testName = "Breadcrumb must be visible to user";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 9));
            lp.setBreadcrumb(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	@Test
	public void WEB_30() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to the content page in the same tab";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 6));
            plp.setContentPageSameTab(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_31() throws Exception{
		String testName = "Verify that the value of the filters are based on the tags/properties of the search results";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setSearchResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_32() throws Exception{
		String testName = "Verify that page title is visible on page and it displays the name of the product";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 8));
            rp.setPageTitleAndProducts(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	@Test
	public void WEB_33() throws Exception{
		String testName = "Verify the content pages will be tagged accordingly";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 9));
            lp.setContentPageTags(test); 
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_34() throws Exception{
		String testName = "Verify document tile can have 3 lines of description";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 42));
            lp.setDescriptionOfTiles(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_35() throws Exception{
		String testName = "Verify display a tile per document category"
				+"/Verify that Resell Alliances tile's title is changed to Resell Alliance Terms";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 42));
            lp.setDisplayTilePerDocumentCat(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_36() throws Exception{
		String testName = "Verify that user entered keyword remains into search bar either user select suggested product name or not & submitted keyword doesn't match any result";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 14));
            plp.setSearchBarKeywordforNegativeTest(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_37() throws Exception{
		String testName = "User clicks on the sort by the filter, the user must see two options in the dropdown I,e 1- A-Z "
				+ "(arranges products in ascending order) 2- Z-A (arranges products in descending order)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 42));
	        lp.setFilterOptions(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_38() throws Exception{
		String testName = "Verify breadcrumbs will be populated based on the site hierarchy.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setBreadcrumbsHierarchy(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_39() throws Exception{
		String testName = "Verify this component must contain a link/button for my product page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setAllProductsButtonFunctionality(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_40() throws Exception{
		String testName = "Verify if there is any error, the system must highlight the respective field in red";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setMandatoryFieldError(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_41() throws Exception{
		String testName = "verify the user name and email is present in the light box";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUsernameEmailVisibility(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_42() throws Exception{
		String testName = "Verify the format of the title <product name> user list";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setDialogTitle(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_43() throws Exception{
		String testName = "Verify the title of the lightbox is displayed the top left corner";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setVerifyCompanyTitle(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}

	@Test
	public void WEB_44() throws Exception{
		String testName = "Verify after canceling navigates the user back to UMS homepage";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCancelAddUser(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_45() throws Exception{
		String testName = "Verify Cancel aborts add user function";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setCancelAddUser2(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_46() throws Exception{
		String testName = "Verify after clicking on Save button user's data gets saved";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSaveButton(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_47() throws Exception{
		String testName = "Verify if the user selects the role as a user then they need to select the product(s) "
				+ "from the select product dropdown for which they need to provide them access.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserNeedsSelectProduct(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_48() throws Exception{
		String testName = "Verify If the email address already exist in the system, then don't allow the user to add it again. Activate the Save button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setUserAlreadyExist(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_49() throws Exception{
		String testName = "Verify if the email address is not already registered";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ums.setSaveButtonActivation(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	

	@Test
	public void WEB_50() throws Exception{
		String testName = "Verify users can be assigned to one product or multiple products";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setAssigningMultipleProducts(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	@Test
	public void WEB_51() throws Exception{
		String testName = "Verify if the user selects role as Admin, then by default the user gets admin rights to all products in the company";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setAdminRights(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
    public void WEB_52() throws Exception{
        String testName = "Verify that the Component is accessibility compliant ";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 47));
            plp.setRelatedLinkSize(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	@Test
    public void WEB_53() throws Exception{
        String testName = "Verify that the PwC logo populated at the template level";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 45));
            lpo.setLogin4();
            ap.setPWClogo(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	@Test
    public void WEB_54() throws Exception{
        String testName = "Verify that the user clicks on the profile avatar";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setClickAvatar(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_55() throws Exception{
        String testName = "Verify if the user is on PC Homepage and clicks on the pwc logo the PC Homepage should be loaded.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setOpenHomePagePwcLogo(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_56() throws Exception{
        String testName = "Verify if the user is login the homepage is their My Product Page.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            hp.setOpenMyProductPagePwcLogo();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_57() throws Exception{
        String testName = "Verify banner is displayed below the global header on a page and is sticky as the user scrolls down";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 85));
            //lpo.setLogin4();
            ap.setBannerSticky(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_58() throws Exception{
		String testName = "Verify end user is able to close the banner using keyboard"
        		+"/Verify that automated banners are displayed on the My Products and My products+pages"
        		+"/Verify that UMS outage or degradation notifications are displayed in AEM notifications banner on my product pages"
        		+"/Verify that when user reloads/refresh the page the closed banner should not appear";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 85));
            lpo.setLogin4();
            ap.setBannerClose(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	@Test
    public void WEB_60() throws Exception{
        String testName = "Verify that all the content that is within the myproducts (including assets) should not be accessible to the user w/o authentication.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            //lpo.setLogin2();
            pp.setDocumentsAccesibility(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
    @Test
    public void WEB_61() throws Exception{
    	String testName = "Verify that when user logs in ,the user should be redirected to the asset they were trying to access"+
        		"/ Verify that for any page and asset(pdf,excel,image) MyProducts Document Category tag(eg-user guide,techinal guide) is visible"
        		+"/ Verify that if the title of the asset or page is longer than 3 lines, then it will be displayed with ellipsis";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setMyProductPageAccessibility(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
    @Test
    public void WEB_62() throws Exception{
    	 String testName = "Verify that within the modal an eyeball icon is displayed in the product that matches the Site Visitor's current MyProduct product page"
         		+"/Verify system status indicators are visible in the hero component and MyProduct modal window.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setFirstTabActive(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
   
   
    @Test
	public void WEB_64() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to the content page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setNavigateContentPage(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
    @Test
	public void WEB_65() throws Exception{
		String testName = "verify on clicking collapsed the left nav should return to its original state, "
				+ "where the user can see the icon/image and the verbiage for the items in the left nav.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
    @Test
	public void WEB_66() throws Exception{
		String testName = "Verify that when user click on collapse icon under the left nav,then left nav will collapse and only the icons/image for each item will appear";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
    @Test
	public void WEB_67() throws Exception{
		String testName = "Verify that when user click on collapse icon then left navigation component name will be collapsing and after click then expanding";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseExpandButton(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
    @Test
	public void WEB_68() throws Exception{
		String testName = "Verify the product title and description are visible to the users of the page/site";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        plp.setProductTitleandDescriptionVisibility(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
    @Test
	public void WEB_69() throws Exception{
		String testName = "Verify the user is able to see view less button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setViewLessButton(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
  
	@Test
	public void WEB_71() throws Exception{
		String testName = "Verify document tile can have only 2 line product name anything more than that will be truncated (fit to size )";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.set2LineProductName(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	@Test
	public void WEB_75() throws Exception{
		String testName = "Verify that the PDF Viewer to support upgrade of PDF";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setUpgradePDF(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_77() throws Exception{
		 String testName = "Verify that the title bumps up on the tile replacing the category label.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setReplacingCategoryLabel(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_78() throws Exception{
		 String testName = "Verify these assets are tagged with appropriate PC docs category tag value";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setAssetsTag(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_79() throws Exception{
		String testName = "Verify My products tile will contain a ‘login to my products’ tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTilesHasLoginLink(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_80() throws Exception{
		String testName = "Verify that icon allow expand and collapse and it moves to the bottom";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setItemsinNeedHelpExpandCollapse(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_81() throws Exception{
		String testName = "Verify the extension for documents.Pdfs, videos file types to be considered.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAllResourcesContent(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_82() throws Exception{
		String testName = "Verify that Preferences are only available to logged in users";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setPreferencesModal(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_83() throws Exception{
		String testName = "Verify that flow is same in legal for security";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 11));
            sp.setSecurityTiles(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	

	@Test
	public void WEB_84() throws Exception{
		String testName = "Verify on selection, the results are automatically sorted";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setSortedResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_85() throws Exception{
		String testName = "Verify that on selection a result, display the relevant product on the page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 6));
            plp.setSearchBox(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_86() throws Exception{
		String testName = "Verify that search results are based on keywords";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 6));
            plp.setSearchResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_87() throws Exception{
		String testName = "Verify that no change to the home page or side nav";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 11));
            BasePage.setLeftNavigationItems2(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_88() throws Exception{
		String testName = "Verify the filter will be a dropdown which will display the My products document categories matching the search results";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 11));
            hp.setDropdown(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	@Test
	public void WEB_89() throws Exception{
		String testName = "Verify that after removal of new statement the default statement is visible on the My Products page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 55));
	        lpo.setLogin4();
	        ap.setBannerTextField(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_90() throws Exception{
		String testName = "Verify that author can add maximum 55 Characters (3lines) in the title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setHeroLines(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_91() throws Exception{
		String testName = "Verify that when user clicks on the video result, it'll open the video player on the same page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setClickVideo(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_92() throws Exception{
		String testName = "Verify that when user clicks on the video result, it'll open the video player on the same page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 56));
	        //lpo.setLogin2();
	        pp.setAnonymous(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	

	@Test
	public void WEB_93() throws Exception{
		String testName = "Verify that the at the page level, an Author should be able to hide the copyright (not edit the text) from their page i ) "
				+ "By default the copyright is visible on all pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 71));
	        lpo.setLogin4();
	        ap.setPrivacyFooterCopyWrite();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_94() throws Exception{
		String testName = "Verify that the system generated date of the date the page was published";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 67));
	        lpo.setLogin4();
	        ap.setPrivacyHubPublishingDate();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_95() throws Exception{
		String testName = "Verify that authored links are visible below header"
				+"Verify that author is able to re-arrange the links within the components";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        lpo.setLogin4();
	        ap.setRelatedLinksAuthoringandRearrangeRelated();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_96() throws Exception{
		String testName = "Verify that PwC logo is always displaying at the top left along with the text Privacy Hub in any case user is accessing the product or page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 73));
	        //lpo.setLogin4();
	        ap.setPrivacyHubLogoandTitleVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_97() throws Exception{
		String testName = "Verify author can add bulleted and numbered lists";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        lpo.setLogin4();
	        ap.setAddingBulletList();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_98() throws Exception{
		String testName = "Verify PwC super admin should be able to add SC_Account_ID to the existing companies";
				
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setSC_AccountID(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_99() throws Exception{
		String testName = "Verify user is able to edit products";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setEditProduct(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_100() throws Exception{
		String testName = "Verify user is able to add feature and it is mandatory";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setAddFeature(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_101() throws Exception{
		String testName = "Verify reset button clear all the search form details";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setResetResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_102() throws Exception{
		String testName = "Verify user is able to select product from 'Select a Product' dropdown and it is single select only";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setSingleSelectProductDropdown(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_103() throws Exception{
		String testName = "Verify user can access company reports only for the company they manage"
				+"Verify user is able to access company report";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setDownloadCompanyReport(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_104() throws Exception{
		String testName = "Verify company admin is added to the company and is displayed in the Administrator section";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setAddNewCompany(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_105() throws Exception{
		String testName = "Verify locked toggle button is visible and by default 'All' selected";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setAllToggle(test);
            test.pass("WEB_105 passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_106() throws Exception{
		String testName = "Verify that the lock symbol appears on UMS screen when company is locked";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setLockedSymbolVisibility(test);
            test.pass("WEB_106 passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	@Test
	public void WEB_107() throws Exception{
		String testName = "Verify that the locked company is still accessible to company Admin through UMS but should not able to add/edit user";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 13));
            ums.setLockedSymbolNotEditable(test);
            test.pass("WEB_107 passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
    public void WEB_108() throws Exception{
        String testName = "Verify for 'Scheduled Maintenance' banner color is 'White' and can be accessible to product admin";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 78));
            lpo.setLogin4();
            ap.setBanner(test);
            test.pass("Web_108 passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	 @Test
	    public void WEB_109() throws Exception{
	        String testName = "Verify the name of archived file is unique and consistent so that files do not overwrite and conflict with each other";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 46));
	            lpo.setLogin4();
	            ap.setAssetConflict(test);
	            test.pass("Test passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
	        
	    }
	
	  @Test
		public void WEB_110() throws Exception{
			String testName = "Verify that by default check box is not ticked and pages are visible";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 20));
		        lpo.setLogin4();
		        ap.setCheckboxNotTicked(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
		}
	
	  @Test
		public void WEB_111() throws Exception{
			String testName = "Verify that we can push a page to workflow from the siteadmin view and from the page properties";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 19));
		        lpo.setLogin4();
		        ap.setPushingPageSiteAdmin(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
		}
		@Test
		public void WEB_112() throws Exception{
			String testName = "Verify author ( It should be admin and restricted role ) need to have right permission access to edit or use following experience components while authoring the web pages i.e      ";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 53));
		        lpo.setLogin4();
		        ap.setAuthorExperienceFragment(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		
		@Test
		public void WEB_113() throws Exception{
			String testName = "Verify as a author should be able to create a variation for specific for Page authoring and should be sync with master experience fragment";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 54));
		        lpo.setLogin4();
		        ap.setCreateVariationExperienceFragment(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		@Test
		public void WEB_114() throws Exception{
			String testName = "Verify that as an author able to define a page as 'top level' of the document"
					+"Verify that if 'Documents' or 'Children pages of that document' are recently updated then the Document page is presented in the 'Latest' and 'For You' component";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 79));
		        lpo.setLogin4();
		        ap.setTopLevel(test);
		        test.pass("WEB_74 passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		@Test
		public void WEB_115() throws Exception{
			String testName = "Verify that for each column author may add image, image thumbnail components";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 81));
		        lpo.setLogin4();
		        ap.setColumnImage(test);
		        test.pass("WEB_74 passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		@Test
		public void WEB_116() throws Exception{
			String testName = "Verify'Digital MIM Supported' field support only boolean values and by default it is set as true"
					+"/ Verify PwC super admin is able to add product"
					+"/Verify when products are digital MIM supported then each product must be visible either Green, Yellow or Red system indicators.";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 13));
	            ums.setDigitalMIM(test);
	            test.pass("WEB_99 passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
			
		}
		@Test
		public void WEB_117() throws Exception{
			String testName = "Verify UMS validates mandatory fields while adding products";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 13));
	            ums.setMandatoryProductSCs(test);
	            test.pass("WEB_99 passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
			
		}
		
		@Test
		public void WEB_118() throws Exception{
			String testName = "Verify in asset workflow by default 'Generate Zip Archive' field is 'Yes'";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 82));
	            lpo.setLogin4();
	            ap.setUserWorkflowApprovalforAsset(test);
	            test.pass("WEB_99 passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
			
		}
		@Test
		public void WEB_119() throws Exception{
			String testName = "Verify the workflows affected are: Approval publishing workflow and unpublishing workflow"+
		"/ Verify workflow group notifications applies to the approval workflows only (publishing or unpublishing the content)"
					+"/ Verify in page workflow by default 'Generate Zip Archive' field is 'No'";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 17));
		        lpo.setLogin4();
		        ap.setUserWorkflowApproval(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		@Test
		public void WEB_120() throws Exception{
			String testName = "Verify that author able to embed, copy and paste, HTML code";
		
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 86));
		        lpo.setLogin4();
		        ap.setEmbedHTML(test);
		        test.pass("WEB_119 passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		
		@Test
		public void WEB_121() throws Exception{
			String testName = "Verify that author is able to configure the link to open in same or new window";
		
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 87));
		        lpo.setLogin4();
		        ap.setLatestTabs();
		        test.pass("WEB_119 passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		@Test
		public void WEB_122() throws Exception{
			String testName = "Verify that on clicking 'Customize cookie settings' link cookies preference window is opening";
		
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 73));
		        //lpo.setLogin4();
		        ap.setCustomizeCookies();
		        test.pass("WEB_119 passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		
		@Test
		public void WEB_123() throws Exception{
			String testName = "Verify author is able to add/pick any video from Kaltura repository that they want to add on page"
					+"/ Verify published page is displaying one or more videos and user is able to see these videos"
					+"Verify that as a user able to see the search box on the pages created using my product+ template";
		
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 90));
		        lpo.setLogin4();
		        ap.setVideoEdit(test);
		        test.pass("WEB_119 passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
			
		}
		
		@Test
		public void WEB_126() throws Exception{
			String testName = "Verify that if schedule is in future then workflow will hold the page/asset until publish date/time is reached";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 82));
	            lpo.setLogin4();
	            ap.setAssetSchedule(test);
	            test.pass("WEB_99 passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
			
		}
		@Test
		public void WEB_127() throws Exception{
			String testName = "Verify user is able to view generic content"
					+"/ Verify the following components will get impacted for personalization.";
	        ExtentTest test = extent.createTest(testName);

	        try {
	            Driver.getDriver().get(read1.getCellData("VALUE", 91));
	            lpo.setLogin4();
	            ap.setGenericContent(test);
	            Driver.getDriver().get(read1.getCellData("VALUE", 15));
	            lpo.setLogin5();
	            pp.setGenericCheck(test);
	            test.pass("WEB_99 passed");
	        } catch (Exception e) {
	            String screenshotPath = takeScreenshot(testName);
	            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	            Assert.fail("Test case failed: " + testName);
	        }
			
		}
		
	
	
	
	
	

	
	
	/******************************************************************************************************************************/
	public String takeScreenshot(String screenshotName) throws IOException {
        WebDriver driver = Driver.getDriver();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "C:\\Users\\GLBL_RDP_USER_01\\eclipse-workspace\\ProductCentralProject-STG-SanityAutomation\\screenshots\\" + screenshotName + ".png";
        File target = new File(destination);
        FileUtils.copyFile(source, target);
        return destination;
    }
	public void captureScreenshotAndAddToReport(String testName) throws IOException {
	    String screenshotPath = takeScreenshot(testName);
	    ExtentTest test = extent.createTest(testName);
	    test.addScreenCaptureFromPath(screenshotPath);
	}
	@AfterMethod
    public void closeTabs() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
            	Driver.getDriver().switchTo().window(window);
            	Driver.getDriver().close();
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
         }
	public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Take screenshot if test method fails
            String screenshotPath = takeScreenshot(result.getName() + "_failed");
            test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            // Take screenshot if test method passes
            String screenshotPath = takeScreenshot(result.getName() + "_passed");
            test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        extent.flush();
    }
	public String captureScreen() throws IOException {
		File dir = new File(".//screenshots");
        if (!dir.exists()) {
            dir.mkdir();
        }
         TakesScreenshot screen = (TakesScreenshot) Driver.getDriver();
            File src = screen.getScreenshotAs(OutputType.FILE);
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.png'").format(new Date());
            String dest = "C:\\Users\\GLBL_RDP_USER_01\\eclipse-workspace\\ProductCentralProject-STG-SanityAutomation\\screenshots\\" + fileName;
            System.out.println(dest);
            File target = new File(dest);
            FileUtils.copyFile(src, target);
            return dest;
        
		}

      @AfterSuite
	public void closingBrowser() {
		extent.flush();
		//Driver.closeDriver();
	}
	


	

}