package com.pwc.productcentral;



import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
	
	
	Logger logger=Logger.getLogger("SanityTestCases");
	
	ReadXLSdata read1=new ReadXLSdata();
	


	
	@BeforeSuite
	public void setUp() {
		 PropertyConfigurator.configure(".\\log4j.properties");
		 read = new ConfigurationsReader();
		 platform = read.getPlatform();
		 read.platformName();
		 htmlReporter = new ExtentHtmlReporter("Automation Report for QA.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	     
	}
			
	@BeforeMethod
	public void initTest() throws Exception {
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
		//Driver.getDriver().get(ConfigurationsReader.getProperties("URL"));
	}
	
	
	/*******************************************************Sanity Test Case********************************************************/
	
	
	@Test(enabled=false)
	public void WEB_1() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the promotion banner must contain an image");
	    test.info("The promotion banner contains an image");
	    hp.setImage();
	    logger.info("Test WEB_1 has passed");
	    
	}
	@Test(enabled=false)
	public void WEB_2() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the promotion banner must contain a description  'PwC's home for information on legal terms & conditions, security, and compliance for our licensed products.'");
	    test.info("The promotion banner contains a description");
	    hp.setDescriptionOfBanner();
	    logger.info("Test WEB_2 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_3() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the promotion banner is visible to all users on homepage");
	    test.info("The promotion banner is visible to all users on homepage");
	    hp.setPromotionBanner();
	    logger.info("Test WEB_3 has passed");
	}
	@Test (enabled=false)
	public void WEB_4() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify related links are visible to all users on content page");
	    test.info("Related links are visible to all users on content page");
	    plp.setAllLinks();
		logger.info("Test WEB_4 has passed");
		  	   
	}
	@Test(enabled=false)
	public void WEB_5() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify that user is able to click the breadcrumb and navigate to the previous page(Products Page)");
	    test.info("The user is able to click the breadcrumb and navigate to the previous page");
	    plp.setBreadcrumbs();
		logger.info("Test WEB_5 has passed");
	
	}
	@Test(enabled=false)
	public void WEB_5_2() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify that user is able to click the breadcrumb and navigate to the previous page(Legal Page)");
	    test.info("The user is able to click the breadcrumb and navigate to the previous page");
	    lp.setlegalTiles();
		logger.info("Test WEB_5_2 has passed");
	}
	@Test(enabled=false)
	public void WEB_6() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify that breadcrumb contains a link");
	    test.info("The breadcrumb contains a link");
	    plp.setLinkOfBreadcrumbs();
		logger.info("Test WEB_6 has passed");
	}
	@Test(enabled=false)
	public void WEB_7() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the user is able to view the page title and description");
	    test.info("The user is able to view the page title and description");
	    hp.setTitleAndDescription();
	    logger.info("Test WEB_7 has passed");
	}
	@Test(enabled=false)
	public void WEB_8() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify the user is able to view the related links and content");
	    test.info("The user is able to view the related links and content");
	    plp.setAllLinks();
		logger.info("Test WEB_8 has passed");
	}
	@Test(enabled=false)
	public void WEB_9() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify each link represents the content page for the product");
	    test.info("Each link represents the content page for the product");
	    plp.setLinks();
		logger.info("Test WEB_9 has passed");
	}

	
	@Test (enabled=false)
	public void WEB_10() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify description can only be a maximum of 6 lines, anything more than that will be truncated");
	    test.info("The description is not more than 6 lines");
	    hp.setDescriptionOfTiles();
	    logger.info("Test WEB_10 has passed");
	}
	@Test (enabled=false)
	public void WEB_11() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify homepage tile is visible to all users on homepage");
	    test.info("The homepage tile is visible to all users on homepage");
	    hp.sethomePageTiles();
	    logger.info("Test WEB_11 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_12() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify PDF viewer/controls appear at the bottom of the page");
	    test.info("PDF viewer/controls appear at the bottom of the page");
	    plp.setPdfControllers();
		logger.info("Test WEB_12 has passed");
	}
	
	
	
	@Test(enabled=false)
	public void WEB_13() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("(Home Page)Verify that when left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    test.info("(Home Page)When left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    BasePage.setCollapseButton();
		logger.info("Test WEB_13 has passed");
	}
	@Test(enabled=false)
	public void WEB_13_1() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("(Legal Page)Verify that when left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    test.info("(Legal Page)When left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    BasePage.setCollapseButton();
		logger.info("Test WEB_13_1 has passed");
	}
	@Test(enabled=false)
	public void WEB_13_2() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("(Product Listing Page)Verify that when left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    test.info("(Product Listing Page)When left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    BasePage.setCollapseButton();
		logger.info("Test WEB_13_2 has passed");
	}
	@Test(enabled=false)
	public void WEB_13_3() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("(Reseller Page)Verify that when left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    test.info("(Reseller Page)When left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'");
	    BasePage.setCollapseButton();
		logger.info("Test WEB_13_3 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_14() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify left navigation component is visible to user(Home Page)");
	    test.info("Left navigation component is visible to user");
	    BasePage.setLeftNavigationItems2();
		logger.info("Test WEB_15 has passed");
	}
	@Test(enabled=false)
	public void WEB_14_1() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify left navigation component is visible to user(Legal Page)");
	    test.info("Left navigation component is visible to user");
	    BasePage.setLeftNavigationItems2();
		logger.info("Test WEB_15_1 has passed");
	}
	@Test(enabled=false)
	public void WEB_14_2() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify left navigation component is visible to user(Product Listing Page)");
	    test.info("Left navigation component is visible to user");
	    BasePage.setLeftNavigationItems2();
		logger.info("Test WEB_14_2 has passed");
	}
	@Test(enabled=false)
	public void WEB_14_3() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify left navigation component is visible to user(Reseller Page)");
	    test.info("Left navigation component is visible to user");
	    BasePage.setLeftNavigationItems2();
		logger.info("Test WEB_14_3 has passed");
	}
	@Test(enabled=false)
	public void WEB_15() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that when user clicks on the tile then user navigate to a hyperlink page within the tab");
	    test.info("When user clicks on the tile then user navigate to a hyperlink page within the tab");
	    hp.setLegalTile();
	    System.out.println(Driver.getDriver().getTitle());
	    logger.info("Test WEB_15 has passed");
	}
	@Test (enabled=false)
	public void WEB_16() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that each tile will contain a title");
	    test.info("Each tile contains a title");
	    hp.setTitleOfTiles();
	    logger.info("Test WEB_16 has passed");
	}
	@Test (enabled=false)
	public void WEB_17() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that title is like 'One stop shop, for all your Product needs' as per pre defined");
	    test.info("The title is like 'One stop shop, for all your Product needs' as per pre defined");
	    hp.setOneStopTitle();
	    logger.info("Test WEB_17 has passed");
	}
	
	
	
	@Test(enabled=false)
	public void WEB_18() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the footer section size style and design should be fixed and cannot be editable");
	    test.info("The footer section size style and design are fixed and are not been editable");
	    BasePage.setFooterHome();
	    logger.info("Test WEB_18 has passed");
	}
	
	
	@Test (enabled=false)
	public void WEB_19() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the no spelling mistake for the text on the footer section");
	    test.info("There is no spelling mistake for the text on the footer section");
	    BasePage.setHomePageTemplateElements();
	    BasePage.setFooterTextandPosition();
	    logger.info("Test WEB_19 has passed");
	}
	@Test (enabled=false)
	public void WEB_20() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the position of the footer");
	    test.info("The footer is on the right position");
	    BasePage.setFooterTextandPosition();
	    logger.info("Test WEB_20 has passed");
	}
	@Test (enabled=false)
	public void WEB_21() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 11));
		ExtentTest test = extent.createTest("Verify that flow is same in legal for security");
	    test.info("Verified that flow is same in legal for security");
	    sp.setSecurityTiles();
	    logger.info("Test WEB_21 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_22() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify on click of a search results the user will be navigated to the content type");
	    test.info("On click of a search results the user is navigated to the content type");
	    hp.setSearchButton();
	    logger.info("Test WEB_22 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_23() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify on selection, the results are automatically sorted");
	    test.info("Verified, the results are automatically sorted");
	    hp.setSortedResult();
	    logger.info("Test WEB_23 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_24() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify that on selection a result, display the relevant product on the page");
	    test.info("Verified that on selection a result, display the relevant product on the page");
	    plp.setSearchBox();
	    logger.info("Test WEB_24 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_25() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify that search results are based on keywords");
	    test.info("Verified that search results are based on keywords");
	    plp.setSearchResult();
	    logger.info("Test WEB_25 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_26() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 11));
		ExtentTest test = extent.createTest("Verify that no change to the home page or side nav");
	    test.info("Verified that no change to the home page or side nav");
	    BasePage.setLeftNavigationItems2();
	    logger.info("Test WEB_26 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_27() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 11));
		ExtentTest test = extent.createTest("Verify the filter will be a dropdown which will display the My products document categories matching the search results");
	    test.info("The filter is a dropdown which displays the My products document categories matching the search results");
	    hp.setDropdown();
	    logger.info("Test WEB_27 has passed");
	}
	
	
	@Test (enabled=false)
	public void WEB_28() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
	    ExtentTest test = extent.createTest("Verify the doc categories will be based on Taxonomy document");
	    test.info("Verified the doc categories will be based on Taxonomy document");
		ap.setDocCategory();
	}
	
	@Test (enabled=false)
	public void WEB_29() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that message shown is 403: You do not have access to this page.Please contact our support team for further assistance.(Link to service now where user can submit a ticket)");
	    test.info("Verified that message shown is 403: You do not have access to this page.Please contact our support team for further assistance. (Link to service now where user can submit a ticket)");
	    lpo.setLogin();
	    pp.setErrorMessage();
	    logger.info("Test WEB_29 has passed");
	}
	
	
	@Test (enabled=false)
	public void WEB_30() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that dropdown list will display the Product & document category as per the latest Tag taxonomy document");
	    test.info("The dropdown list displays the Product & document category as per the latest Tag taxonomy document");
	    hp.setDropdownList();
	    hp.setDropdownList2();
	    logger.info("Test WEB_30 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_31() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the user should see different footer items if logged in");
	    test.info("The user does not see footer link group if logged in");
	    pp.setFooterWithoutLogin();
	    logger.info("Test WEB_31 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_31_1() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the user should see different footer items if logged in");
	    test.info("The user sees footer link group if logged in");
	    lpo.setLogin();
	    pp.setFooterWithLogin();
	    logger.info("Test WEB_31_1 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_32() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify when the user clicks on next will display the next 5 assets of my product landing page");
	    test.info("When the user clicks on next,the next 5 assets of my product landing page are displayed");
	    lpo.setLogin();
	    pp.setDisplayResources();
	    logger.info("Test WEB_32 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_33() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify when the user clicks on any item the specified asset/page must be loaded in the new tab");
	    test.info("When the user clicks on any item the specified asset/page is loaded in the new tab");
	    lpo.setLogin();
	    pp.setNewTabAssets();
	    logger.info("Test WEB_33 has passed");
	}
	
	
	
	@Test(enabled=false)
	public void WEB_34() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify if user is logged in, then My Products heading in the sitemap is visible");
	    test.info("When user is logged in,My Products heading in the sitemap is visible");
	    lpo.setLogin();
	    pp.setMyProductSitemap();
	    logger.info("Test WEB_34 has passed");
	}
	
	@Test  (enabled=false)
	public void WEB_35() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the tags accompany the items which are assets");
	    test.info("Verified the tags accompany the items which are assets");
	    lpo.setLogin();
	    pp.setTagsAccompany();
	    logger.info("Test WEB_35 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_36() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that this page should appear to all Site Visitors that are logged in but do not have the right level of permissions to access the page");
	    test.info("Verified that this page should appear to all Site Visitors that are logged in but do not have the right level of permissions to access the page)");
	    lpo.setLogin();
	    pp.setErrorPage();
	    logger.info("Test WEB_36 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_37() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify there are 2 filters with minor differences between Global and My Products search");
	    test.info("Verified there are 2 filters with minor differences between Global and My Products search");
	    lpo.setLogin();
	    pp.setMyProductSearch();
	    logger.info("Test WEB_37 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_38() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the all resources component is presenting a list of 5 assets that are relevant to the product on the product landing page");
	    test.info("Verified the all resources component is presenting a list of 5 assets that are relevant to the product on the product landing page");
	    lpo.setLogin();
	    pp.setResourcesBasedonProducts();
	    logger.info("Test WEB_38 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_39() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify that page title is visible on page and it displays the name of the product");
	    test.info("Verified that page title is visible on page and it displays the name of the product");
	    rp.setPageTitleAndProducts();
	    logger.info("Test WEB_39 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_40() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify that breadcrumb will contain a link of the previous page of the site and must respect the UI design");
	    test.info("The breadcrumb contains a link of the previous page of the site and respect the UI design");
	    rp.setBreadcrumbs();
	    logger.info("Test WEB_40 has passed");
	}
	
	@Test  (enabled=false)
	public void WEB_41() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify the content pages will be tagged accordingly");
	    test.info("Verified the content pages are tagged accordingly");
	    lp.setContentPageTags();
	    logger.info("Test WEB_41 has passed");
	}
	
	
	
	@Test (enabled=false)
	public void WEB_42() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify document tile can have 3 lines of description");
	    test.info("Verified document tiles have 3 lines of description");
	    lp.setDescriptionOfTiles();
	    logger.info("Test WEB_42 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_43() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify display a tile per document category");
	    test.info("Verified display a tile per document category");
	    lp.setDisplayTilePerDocumentCat();
	    logger.info("Test WEB_43 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_44() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 14));
		ExtentTest test = extent.createTest("Verify that user entered keyword remains into search bar either user select suggested product name or not & submitted keyword doesn't match any result");
	    test.info("Verified that user entered keyword remains into search bar either user select suggested product name or not & submitted keyword doesn't match any result");
	    plp.setSearchBarKeywordforNegativeTest();
	    logger.info("Test WEB_44 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_45() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Breadcrumb must be visible to user");
	    test.info("Verified breadcrumb is be visible to user");
	    lp.setBreadcrumb();
	    logger.info("Test WEB_45 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_46() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify document tile can have only 2 line product name, anything more than that will be truncated(fit to size)");
	    test.error("Document tile can have 3 line product name");
	    plp.setDocumentTileLine();
	    logger.error("Test WEB_46 has failed");
	}
	
	@Test (enabled=false)
	public void WEB_47() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify clicking on the tile will navigate the user to the content page in the same tab");
	    test.info("Verified clicking on the tile navigates the user to the content page in the same tab");
	    plp.setContentPageSameTab();
	    logger.info("Test WEB_47 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_48() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify if the user is already logged in don't display 'log in to my products' link");
	    test.info("Verified if the user is already logged in don't display 'log in to my products' link");
	    ap.setDisplayingLogintomyProductLink();
	    logger.info("Test WEB_48 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_49() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 15));
		ExtentTest test = extent.createTest("Verify on clicking 'login to my products' tile the user is navigated to the PC login page");
	    test.info("Verified on clicking 'login to my products' tile the user is navigated to the PC login page");
	    hp.setLoginToMyProductLink();
	    logger.info("Test WEB_49 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_50() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the hyperlinks in the component will be populated by the system(both title & URL)");
	    test.info("Verified the hyperlinks in the component will be populated by the system(both title & URL)");
		ap.setHyperlinks();
		logger.info("Test WEB_50 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_51() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the filter does not support multi-select");
	    test.info("Verified the filter does not support multi-select");
	    lpo.setLogin();
	    pp.setNotSupportMultiSelect();
	    logger.info("Test WEB_51 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_52() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 14));
		ExtentTest test = extent.createTest("Verify the product listing page does not have broken images");
	    test.error("The product listing page has broken images");
	    BasePage.setAllImages();
	    logger.info("Test WEB_42 has failed");
	}
	@Test (enabled=false)
	public void WEB_52_1() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the home page does not have broken images");
	    test.info("Verified the home page does not have broken images");
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_1 has passed");
	}
	@Test (enabled=false)
	public void WEB_52_2() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify the reseller page does not have broken images");
	    test.info("Verified the reseller does not have broken images");
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_2 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_52_3() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify the legal page does not have broken images");
	    test.info("Verified the legal does not have broken images");
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_3 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_52_4() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 11));
		ExtentTest test = extent.createTest("Verify the security page does not have broken images");
	    test.info("Verified the security does not have broken images");
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_4 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_52_5() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the my product page does not have broken images");
	    test.info("Verified the my product page does not have broken images");
	    lpo.setLogin();
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_5 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_53() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify on click on load more, another 5 assets must be loaded");
	    test.info("Verified on click on load more, another 5 assets are loaded");
	    lpo.setLogin();
	    pp.setLoadMoreButton();
	    logger.info("Test WEB_53 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_54() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the assets title cannot be more than 3 lines");
	    test.error("Undefined asset title line");
	    lpo.setLogin();
	    pp.setTitleOfAssets();
	    logger.info("Test WEB_54 has passed");
	}
	
	
	@Test(enabled=false)
	public void WEB_55() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the user is able to click on load more button");
	    test.info("Verified the user is able to click on load more button");
	    lpo.setLogin();
	    pp.setClickLoadMoreButton();
	    logger.info("Test WEB_55 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_56() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify clicking on view less will revert this section to its original state with 5 tiles");
	    test.info("Verified clicking on view less reverts this section to its original state with 5 tiles");
	    lpo.setLogin();
	    pp.setClickLoadLessButton();
	    logger.info("Test WEB_56 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_57() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify active tab will be underlined");
	    test.info("Verified active tab is underlined ");
	    lpo.setLogin();
	    pp.setActiveTab();
	    logger.info("Test WEB_57 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_58() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify by default the first tab will be active when the user landing on the page");
	    test.error("Not Verified by default the first tab is active when the user landing on the page");
	    lpo.setLogin();
	    pp.setFirstTabActive();
	    logger.info("Test WEB_58 has failed");
	}
	
	@Test (enabled=false)
	public void WEB_59() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify hero promotion card is static, not clickable");
	    test.info("Verified hero promotion card is static, not clickable");
	    lpo.setLogin();
	    pp.setHeroPromotion();
	    logger.info("Test WEB_59 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_60() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify an image can be an image pattern");
	    test.info("Verified an image can be an image pattern");
	    lpo.setLogin();
	    BasePage.setAllImages();
	    logger.info("Test WEB_60 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_61() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify author is able to author the site map will all the links");
	    test.info("Verified author is able to author the site map will all the links");
	    ap.setSitemap();
	    logger.info("Test WEB_61 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_62() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify author is able to hide pages from displaying within the site map");
	    test.info("Verified author is able to hide pages from displaying within the site map");
	    ap.setHideSitemap();
	    logger.info("Test WEB_62 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_63() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify tiles are partially authorable");
	    test.info("Verified tiles are partially authorable");
	    ap.setTilesAuthorization();
	    logger.info("Test WEB_63 has passed");
	}
	

	@Test (enabled=false)
	public void WEB_64() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that not all products will have all categories listed on the page but some will have a combination of them");
	    test.info("Verified that not all products will have all categories listed on the page but some will have a combination of them");
	    ap.setCatCombination();
	    logger.info("Test WEB_64 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_65() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify last updated date will be pulled from asset metadata");
	    test.info("Verified last updated date is pulled from asset metadata");
	    ap.setUpdatedDateFromAssets();
	    logger.info("Test WEB_65 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_66() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify last updated date will also be reflected under the title");
	    test.info("Verified last updated date is also be reflected under the title");
	    ap.setUpdatedDateVisibility();
	    logger.info("Test WEB_66 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_67() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify homepage tile component is system authored");
	    test.info("Verified homepage tile component is system authored");
	    ap.setHomepageTileAuthorization();
	    logger.info("Test WEB_67 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_68() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that the value of the filters are based on the tags/properties of the search results");
	    test.error("The value of the filters are NOT based on the tags/properties of the search results");
	    hp.setSearchResult();
	    logger.info("Test WEB_68 has failed");
	}
	
	@Test (enabled=false)
	public void WEB_69() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify unpublish workflow is available both sites and assets");
	    test.info("Verified unpublish workflow is available both sites and assets");
	    ap.setUnpublishWorkflow();
	    logger.info("Test WEB_69 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_70() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that once content is approved and published, the system will record the date of publishing");
	    test.info("Verified that once content is approved and published, the system will record the date of publishing");
	    ap.setUpdatedDate();
	    logger.info("Test WEB_70 has passed");
	}
	

	@Test (enabled=false)
	public void WEB_71() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the author is able to author the title and the description");
	    test.info("Verified the author is able to author the title and the description");
	    ap.setContentAuthorization();
	    logger.info("Test WEB_71 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_72() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify users icons must present User's First and Last name initials of user");
	    test.info("Verified users icons present User's First and Last name initials of user");
	    lpo.setLogin();
	    pp.setUserInitials();
	    logger.info("Test WEB_72 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_73() throws Exception{
		read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify all the sections on the header");
	    test.info("Verified all the sections on the header");
	    lpo.setLogin();
	    BasePage.setAllSectionsOnHeader();
	    logger.info("Test WEB_73 has passed");
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	

	
	
	/******************************************************************************************************************************/
	
	
	
	
	
	@AfterSuite
	public void closingBrowser() {
		extent.flush();
		//Driver.closeDriver();
	}
	


	

}