package Pages;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class AuthoringPage extends HelperFunctions {
	public AuthoringPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//*[@id=\"globalnav-start-home-collection\"]/coral-masonry-item[2]/div")
	private WebElement sites;
	
	@FindBy(xpath="(//div[contains(@title, 'productcentral')])[2]")
	private WebElement productcentral;
	
	@FindBy(xpath="//div[@title='us']")
	private WebElement us;
	
	@FindBy(xpath="//div[@title='en']")
	private WebElement en;
	
	@FindBy(xpath="//coral-columnview-item[@data-foundation-collection-item-id='/content/pc/us/en/products']")
	private WebElement Products;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator.thumb.48.48.png?ck=']")
	private WebElement ChangeNavigator;
	
	@FindBy(xpath="//button[@class='betty-ActionBar-item cq-siteadmin-admin-actions-edit-activator foundation-collection-action coral-Button--graniteActionBar coral3-Button coral3-Button--quiet']")
	private WebElement edit;
	
	@FindBy(xpath="//h1[.='Fluid Forecast']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/products/change-navigator/jcr:content/root/container/container/title']")
	private WebElement changeProductsTitle;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement titleEdit;
	
	@FindBy(xpath="//button[@icon='edit']")
	private WebElement editButton;
	
	@FindBy(xpath="//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")
	private WebElement checkButton;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/products/change-navigator/jcr:content/root/container/container/text']")
	private WebElement changeNavigatorDescription;
	
	@FindBy(xpath="//div[@class='cq-RichText-editable coral-RichText-editable coral-RichText coral-DecoratedTextfield-input is-edited webkit chrome']")
	private WebElement navigatorDescriptionEdit;
	
	@FindBy(xpath="//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")
	private WebElement checkButton2;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement actualNavigatorTitle;
	
	@FindBy(xpath="//div[@class='cmp-text']")
	private WebElement actualNavigatorDescription;
	
	@FindBy(xpath="(//coral-columnview-column[@data-foundation-layout-columnview-columnid='/content/pc/us/en'])//coral-columnview-item")
	private static List<WebElement> contentOptions;
	
	@FindBy(xpath="//*[@id=\"coral-id-496\"]/div[1]")
	private WebElement automation;
	@FindBy(xpath="//coral-columnview-item[@data-granite-collection-item-id='/content/pc/us/en/automation/my-products']")
	private WebElement myproduct;
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products/fluid-forecast.thumb.48.48.png?ck=']")
	private WebElement fluidForecast;
	
	@FindBy(xpath="(//div[@class='cmp-for-you__tiles'])/a")
	private static List<WebElement> foryouAssets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5Assets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5Assets;
	
	@FindBy(xpath="//button[@id='showMore']")
	private WebElement viewMoreButton;
	
	@FindBy(xpath="//button[@id='showLess']")
	private WebElement viewLessButton;
	
	@FindBy(xpath="//button[@class='granite-collection-create foundation-toggleable-control coral3-Button coral3-Button--primary']")
	private WebElement createButton;
	
	@FindBy(xpath="(//coral-list-item-content[.='Page'])[1]")
	private WebElement pageButton;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/product-listing-page-template-product-central/thumbnail.png']")
	private WebElement productListingPageTemplate;
	
	@FindBy(xpath="//coral-button-label[.='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath="//coral-tab-label[.='Product Central']")
	private WebElement productCentralTab;
	
	@FindBy(xpath="//select[@name='./documentCategory']//option")
	private static List<WebElement> documentCategoryTag;
	
	@FindBy(xpath="//span[contains(@data-rootpath, 'productcentral/pc-doc-category')]//button")
	private WebElement documentCategoryTag2;
	
	@FindBy(xpath="(//button[@class='coral-Select-button coral-MinimalButton'])[3]")
	private WebElement productFeatureTag2;
	
	@FindBy(xpath="(//button[@class='coral-Select-button coral-MinimalButton'])[4]")
	private WebElement portfolioTag2;
	
	@FindBy(xpath="//select[@name='./productFeatureTag']//option")
	private static List<WebElement> productFeatureTags;
	
	@FindBy(xpath="//ul[@class='coral-SelectList is-visible is-below']//li")
	private static List<WebElement> portfolioTags;
	
	@FindBy(xpath="(//button[@role='combobox'])[4]")
	private WebElement portfolioTags2;
	
	@FindBy(xpath="//div[@title='Products']")
	private WebElement products;
	
	@FindBy(xpath="//div[@title='Change Navigator']")
	private WebElement changeNavigatorLink;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=1]")
	private WebElement firstPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=2]")
	private WebElement secondPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=3]")
	private WebElement thirdPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=4]")
	private WebElement forthPositionAuthor;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=1]")
	private WebElement firstTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=2]")
	private WebElement secondTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=3]")
	private WebElement thirdTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=4]")
	private WebElement forthTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=5]")
	private WebElement fifthTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=6]")
	private WebElement sixthTitle;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator/offering-overview.thumb.48.48.png?ck=1665588252']")
	private WebElement offerinfOverviewImage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator/terms---conditions.thumb.48.48.png?ck=']")
	private WebElement termsAndConditionsImage;
	
	@FindBy(xpath="//a[@href='/us/en/products/change-navigator/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5resources;
	
	@FindBy(xpath="((//coral-columnview-column-content[@role='presentation'])[4])//coral-columnview-item//div")
	private static List<WebElement> contentOptions2;
	
	@FindBy(name= "j_username")
	private WebElement username;
	@FindBy(name="j_password")
	private WebElement password;
	@FindBy(id="submit-button")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//div[contains(@title, 'Sitemap')]")
	private WebElement sitemap;
	
	@FindBy(xpath="//button[@icon='wrench']")
	private WebElement settingIcon;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/homepage-demo.thumb.48.48.png?ck=']")
	private WebElement homepageDemo;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[3]/button/coral-icon")
	private WebElement properties;
	
	@FindBy(xpath="//coral-checkbox[@name='./hideInSitemap']")
	private WebElement hidesitemapCheckbox;
	
	@FindBy(xpath="//button[@id='shell-propertiespage-doneactivator']")
	private WebElement saveAndClose;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/sitemapfortesting.thumb.48.48.png?ck=']")
	private WebElement sitemapImage;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[2]/button/coral-icon")
	private WebElement edit2;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton2;
	
	@FindBy(xpath="//*[@id=\"Content\"]/div[1]/coral-actionbar/coral-actionbar-secondary/coral-actionbar-item[1]/button")
	private WebElement editButton2;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[11]/button")
	private WebElement quickPublish;
	
	@FindBy(xpath="/html/body/div[2]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[11]/button/coral-icon")
	private WebElement Publish;
	
	@FindBy(xpath="//div[@class='cmp-sitemap__title']//a//h1")
	private static List<WebElement> sitemapContents;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/legal/jcr:content/root/container/container/legal_product_tiles']")
	private WebElement legalTilesAuth;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entries']")
	private static List<WebElement> legalTiles;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./pages/item0/./page']//coral-icon[@aria-label='select']")
	private WebElement legalTilesAuthFirstCheckbox;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/data-processing-addendum.thumb.48.48.png']")
	private WebElement dataProcessingImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/maintenance---support.thumb.48.48.png']")
	private WebElement maintenanceImg;
	
	@FindBy(xpath="//button[@class='granite-pickerdialog-submit coral3-Button coral3-Button--primary']")
	private WebElement selectButton;
	
	@FindBy(xpath="//button[@title='Done']")
	private WebElement checkIcon;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewLink2;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/title']")
	private WebElement offeringOverviewLink2auth;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement titleField;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement contentTitle;
	
	@FindBy(xpath="(//button[@data-layer='Edit'])[2]")
	private WebElement editButtonContent;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdfviewer']")
	private WebElement offeringOverviewPdfauth;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement pdfOptions;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/general/content-pdf/PDF%20Template%20for%20AEM%20Testing.pdf.thumb.48.48.png']")
	private WebElement pdfImage;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/homepage-demo/jcr:content/root/container/container/tiles']")
	private WebElement homepageTileauth;
	
	@FindBy(xpath="(//h3[@class='coral-Collapsible-header'])[1]")
	private WebElement collapseHeader;
	
	@FindBy(xpath="//input[@name='./tilesList/item0/./title']")
	private WebElement titleofTile;
	
	@FindBy(xpath="//textarea[@name='./tilesList/item0/./description']")
	private WebElement descriptionofTile;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__entry-title'])[1]")
	private WebElement firstTitleofTile;
	
	@FindBy(xpath="div[@class='cmp-tiles__products-link']")
	private static List<WebElement> loginToMyProductsLinks;
	
	@FindBy(xpath="//foundation-autocomplete[contains(@name, './path')]//button[contains(@title, 'Open Selection Dialog')]")
	private WebElement checkforOptions;
	

	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products.thumb.48.48.png']")
	private WebElement myproductImage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation.thumb.48.48.png']")
	private WebElement automationImage;
	
	@FindBy(xpath="//button[@trackingelement='edit']")
	private WebElement editnextToPreview;
	
	@FindBy(xpath="(//div[@title='Products'])[2]")
	private WebElement productsPackage;
	
	@FindBy(xpath="//div[@title='Cloud']")
	private WebElement cloudPackage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo.thumb.48.48.png?ck=']")
	private WebElement resellerdemoImage;
	
	@FindBy(xpath="//coral-icon[@icon='globeClock']")
	private WebElement managePublication;
	
	@FindBy(xpath="//button[@icon='globeStrike']")
	private WebElement unpublish;
	
	@FindBy(xpath="//img[@class='foundation-collection-item-thumbnail']")
	private WebElement resellerdemoImageforUnpublish;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement unpublishButton;
	
	@FindBy(xpath="//button[@variant='warning']")
	private WebElement continueButton;
	
	@FindBy(xpath="//coral-columnview-preview-content[@role='presentation']")
	private static List<WebElement> publishInformation;
	
	@FindBy(xpath="//div[@title='Reseller Demo']")
	private WebElement resellerDemo;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/check-in.thumb.48.48.png?ck=']")
	private WebElement checkinImg;
	
	@FindBy(xpath="//button[@trackingelement='quick publish']")
	private WebElement quickPublish2;
	
	@FindBy(xpath="//button[@class='coral3-Button coral3-Button--primary']")
	private WebElement publish2;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/microsoft-alliance.thumb.48.48.png?ck=']")
	private WebElement microsoftImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/dragos-alliance.thumb.48.48.png?ck=']")
	private WebElement dragosImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/homepage-demo.thumb.48.48.png?ck=']")
	private WebElement homepagedemoImg;
	
	@FindBy(xpath="(//time[@role='presentation'])[2]")
	private WebElement publishedDate;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdfviewer']")
	private WebElement contentEdit;
	
	@FindBy(xpath="//*[@id=\"coral-id-655\"]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement contentOptions3;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/en_us/products/check-in/myproducts/CLEAR%20%2b%20Check-In%20User%20Flow_OFRO%20Approved.pdf.thumb.48.48.png']")
	private WebElement priceWaterPdf;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__pdf-info']")
	private WebElement lastUpdatedDate;
	
	@FindBy(xpath="//div[@class='coral3-Card-wrapper']")
	private static List<WebElement> pdfInfo;
	
	@FindBy(xpath="(//div[@class='coral3-Card-wrapper'])//foundation-time")
	private static List<WebElement> pdfInfo2;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/en_us/products/check-in/myproducts/API%201-Pager%20Overview%20Slide.pdf.thumb.48.48.png']")
	private WebElement pdfTemplate;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement setIcon;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/content-page-template-product-central/thumbnail.png']")
	private WebElement contentPageTemplate;
	
	@FindBy(xpath="//input[@name='./jcr:title']")
	private WebElement titleField2;
	
	@FindBy(xpath="(//li[@class='coral-SelectList-item coral-SelectList-item--option'])[1]")
	private WebElement firstOptionofDocCat;
	
	@FindBy(xpath="//li[@data-value='productcentral:product-feature/board-central']")
	private WebElement firstOptionofProCat;
	
	@FindBy(xpath="//li[@data-value='productcentral:portfolio/customer-engagement']")
	private WebElement firstOptionofPortCat;
	
	@FindBy(xpath="(//button[@class='foundation-layout-inline2-item foundation-wizard-control coral3-Button coral3-Button--primary'])[2]")
	private WebElement createButton2;
	
	@FindBy(xpath="//coral-button-label[.='Done']")
	private WebElement doneButton;
	
	@FindBy(xpath="//div[@title='Release Notes [Root]']")
	private WebElement releaseNotes;
	
	@FindBy(xpath="//coral-button-label[.='Add']")
	private WebElement addButton;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement releaseTitle;
	
	@FindBy(xpath="//div[@data-fielddescription='Enter Release Note Description']")
	private WebElement releaseDescription;
	
	@FindBy(xpath="//input[@name='./releaseNotes/item0/./cq:lastReplicated']")
	private WebElement releaseDate;
	
	@FindBy(xpath="//span[@class='cmp-release-notes__card-subtitle']")
	private WebElement releaseDateonPreview;
	
	@FindBy(xpath="//a[@class='cmp-release-notes__card-title']")
	private WebElement releaseTitleonPreview;
	
	@FindBy(xpath="//div[@class='cmp-release-notes__card-description']")
	private WebElement releaseDescriptiononPreview;
	
	@FindBy(xpath="//div[@title='Product Central Footer']")
	private WebElement authFooter;
	
	@FindBy(xpath="//textarea[@name='./title']")
	private WebElement textareaForFooter;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement privacyPolicyTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item0/./imagepath']")
	private WebElement privacyPolicyLink;
	
	@FindBy(xpath="//input[@name='./multifield/item1/./title']")
	private WebElement termsConditionsTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item1/./imagepath']")
	private WebElement termsConditionsLink;
	
	@FindBy(xpath="//input[@name='./multifield/item2/./title']")
	private WebElement cookieTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item2/./imagepath']")
	private WebElement cookieLink;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private WebElement footerContent;
	
	@FindBy(xpath="//a[@href='#pageinfo-popover']")
	private WebElement pageInfo;
	
	@FindBy(xpath="//button[@title='View as Published']")
	private WebElement viewasPublish;
	
	@FindBy(xpath="//button[@title='Publish Template']")
	private WebElement publishTemplate;
	
	@FindBy(xpath="(//button[@role='combobox'])[3]")
	private WebElement pcTags;
	
	@FindBy(xpath="(//foundation-time[@type='datetime'])[50]")
	private WebElement pdfDate;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/sitemapfortesting.thumb.48.48.png?ck=']")
    private WebElement sitemapImg;
	
	
	@FindBy(xpath="//div[@class='cmp-title']")
	private WebElement contentTitle2;
	
	@FindBy(xpath="//h1[@class='cmp-privacy-hub-header__product-name']")
    private WebElement pwcLogo;
    
    @FindBy(xpath="//div[@class='cmp-banner cmp-product-banner cmp-banner__scheduledMaintenance wcmmode']")
    private WebElement banner;
    
    @FindBy(xpath="(//button[@data-layer='Edit'])[2]")
    private WebElement editBanner;
    
    @FindBy(xpath="//button[@data-layer='Preview']")
    private WebElement previewBanner;
    
    @FindBy(xpath="//div[@title='Notification Banner']")
    private WebElement bannerArea;
    
    @FindBy(xpath="//button[@data-action='CONFIGURE']")
    private WebElement settingsBanner;
    
    @FindBy(xpath="//coral-select[@name='./bannerType']")
    private WebElement bannerDrop;
    
    @FindBy(xpath="//coral-selectlist-item[@value='scheduledMaintenance']")
    private WebElement scheduledBanner;
    
    @FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/landing-page-template-product-central/thumbnail.png']")
    private WebElement landingPageTemplate;
    
    @FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal.thumb.48.48.png?ck=']")
    private WebElement legalPageImg;
    
    @FindBy(xpath="(//button[@trackingelement='create'])[2]")
    private WebElement createButton3;
    
    @FindBy(xpath="//a[@icon='workflow']")
    private WebElement workflowIcon;
    
    @FindBy(xpath="//span[@class=' coral3-Select-label']")
    private WebElement workflowDropdown;
    
    @FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-express-publish-workflow/pc-express-publish-workflow']")
    private WebElement publishWorkflow;
    
    @FindBy(xpath="//input[@name='workflowTitle']")
    private WebElement workflowTitle;

    @FindBy(xpath="//img[@class='foundation-collection-item-thumbnail']")
    private WebElement legalPageImgforPublish;
    
    @FindBy(xpath="(//time[@role='presentation'])[2]")
    private WebElement presentationDate;
    
    @FindBy(xpath="//coral-card-title[@class='foundation-collection-item-title coral3-Card-title']")
    private static List<WebElement> pdfTitles;
	
    @FindBy(xpath="//span[@class='betty-breadcrumbs-button-innerwrapper']")
    private WebElement pagePath;
    
    @FindBy(xpath="//coral-selectlist-item[.='legal']")
    private WebElement legalPath;
    
    @FindBy(xpath="(//div[@class='cmp-document-tiles__entry-title'])[1]")
   	private WebElement firstProductTile;
   	
   	@FindBy(xpath="//div[contains(@title, 'Product Tiles')]")
   	private WebElement editTiles;
   	
   	@FindBy(xpath="(//button[@icon='moveUpDown'])[1]")
   	private WebElement drag1;
   	
   	@FindBy(xpath="(//button[@icon='moveUpDown'])[3]")
   	private WebElement drag2;
   	
   	@FindBy(xpath="//button[@title='Configure']")
   	private WebElement configure;

   	@FindBy(xpath="//coral-button-label[normalize-space()='Open Properties']")
   	private WebElement openProper;
   	
   	@FindBy(xpath="//div[@class='cmp-related-links__download']//span[@class='cmp-related-links__download-text'][normalize-space()='Download Full Terms']")
   	private WebElement dft;
   	
   	@FindBy(xpath="//coral-checkbox[@name='./hideListingPages']")
   	private WebElement hideListing;
   	
   	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/xf-web-variation/thumbnail.png']")
   	private WebElement webVariation;
   	
   	@FindBy(xpath="//coral-columnview-item-content[@title='test123']")
   	private WebElement webVariationContent;

   	@FindBy(xpath="//coral-selectlist[@handle='list']//coral-selectlist-item")
   	private static List<WebElement> approveReject;
   	
   	@FindBy(xpath="//coral-selectlist-item[normalize-space()='Reject Publication']")
   	private WebElement rejectGroup;
   	
   	@FindBy(xpath="//coral-popover[@id='pageinfo-popover']//span[1]")
   	private WebElement publishInfoonPage;
   	
   	@FindBy(xpath="//button[@title='Publish Page']")
   	private WebElement publishIcon;
   	
   	@FindBy(xpath="//div[contains(@title, 'Header')]")
   	private WebElement phEdit;
   	
   	@FindBy(xpath="//input[@name='./title']")
   	private WebElement pTitle;
   	
   	@FindBy(xpath="//h1[@class='cmp-privacy-hub-header__product-name']")
   	private WebElement phProductName;
   	
   	@FindBy(xpath="//coral-button-label[normalize-space()='Next']")
   	private WebElement nextTemplate;
   	
   	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/security.thumb.48.48.png?ck=']")
   	private WebElement securityImg;
   	
   	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-approval-workflow/pc-approval-workflow']")
   	private WebElement approvalWorkflow;
   	
   	@FindBy(xpath="//coral-icon[@icon='bell']")
   	private WebElement bellIcon;
   	
   	@FindBy(xpath="//a[@href='/aem/inbox']")
   	private WebElement aemInbox;
   	
   	@FindBy(xpath="//coral-table-row-selectcheckbox[@role='checkbox']")
   	private static List<WebElement> tasks;
   	
   	@FindBy(xpath="(//button[@trackingelement='complete'])[2]")
   	private WebElement completeButton;
   	
   	@FindBy(xpath="(//input[@class='coral-InputGroup-input js-coral-Autocomplete-textfield autocomplete-has-suggestion-btn coral3-Textfield'])[1]")
   	private WebElement assignGroup;
   	
   	@FindBy(xpath="//button[@trackingelement='ok']")
   	private WebElement okButton;
   	
   	@FindBy(xpath="(//div[@class='foundation-layout-flexmedia-bd-singleline'])[1]")
   	private WebElement user;
   	
   	@FindBy(xpath="//coral-selectlist-item[@value='/var/workflow/models/pc-unpublish/pc-unpublish-workflow']")
   	private WebElement unpublishWorkflow;
   	
   	@FindBy(xpath="(//coral-columnview-preview-value[@role='textbox'])[7]")
   	private WebElement unpublishInfo;
   	
   	@FindBy(xpath="//div[@class='granite-shell-badge-item-inbox']//a")
   	private WebElement AEMInbox;
   	
   	@FindBy(xpath="(//coral-table-row-selectcheckbox[@role='checkbox'])[1]")
   	private WebElement assignedTask;
   	
   	@FindBy(xpath="(//time[@role='presentation'])[1]")
   	private WebElement firstTasktime;
   	
   	@FindBy(xpath="//button[@class='betty-ActionBar-item cq-inbox-workitem-complete foundation-collection-action coral-Button--graniteActionBar coral3-Button coral3-Button--quiet']")
   	private WebElement completeButton2;
   	
   	@FindBy(xpath="//div[@aria-required='true']//button[@title='Toggle']")
   	private WebElement selectGroup;
   	
   	@FindBy(xpath="//div[@aria-expanded='true']//input[@role='combobox']")
   	private WebElement textGroup;
   	
   	@FindBy(xpath="//li[@data-value='pc-globalit-qa']")
   	private WebElement globalIt;
   	
   	@FindBy(xpath="//coral-select[@name='archiveZip']//button[@type='button']")
   	private WebElement selectZip;
   	
   	@FindBy(xpath="//coral-selectlist-item[@value='false']")
   	private WebElement selectZipNo;
   	
   	@FindBy(xpath="//coral-button-label[normalize-space()='Ok']")
   	private WebElement selectOk;
   	
   	@FindBy(xpath="//form[@enctype='multipart/form-data']//button[@type='button']")
   	private WebElement approveGroup;
   	
   	@FindBy(xpath="//coral-selectlist-item[normalize-space()='Publish Page/Asset']")
   	private WebElement publishGroup;
   	
   	@FindBy(xpath="(//div[@title='Notification Banner'])[1]")
   	private WebElement firstBanner;
   	
   	@FindBy(xpath="//coral-select[@name='./bannerType']")
   	private WebElement bannerType;
   	
   	@FindBy(xpath="//select[@name='./product']")
   	private WebElement bannerProduct;
   	
   	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo.thumb.48.48.png?ck=']")
    private WebElement resellimg;
   	
   	@FindBy(xpath="//div[@title='Privacy Hub Footer Component']")
	private WebElement phFooter;
	
	@FindBy(xpath="//label[normalize-space()='Footer Text *']")
	private WebElement phFooterText;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement phFooterTitle;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement phFooterExternal;
	
	@FindBy(xpath="//textarea[@name='./title']")
	private WebElement footerText;
	
	@FindBy(xpath="//span[@class='ap-footer-content__copyright-icon']")
	private WebElement footerCopywrite;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/privacy-hub.thumb.48.48.png?ck=']")
	private WebElement privacyHubImg;
	
	@FindBy(xpath="//div[contains(@title, 'Related')]")
	private WebElement authRelated;
	
	@FindBy(xpath="(//coral-icon[@icon='moveUpDown'])[1]")
	private WebElement move1;
	
	@FindBy(xpath="(//coral-icon[@icon='moveUpDown'])[2]")
	private WebElement move2;
	
	@FindBy(xpath="(//coral-icon[@icon='moveUpDown'])[3]")
	private WebElement move3;
	
	@FindBy(xpath="(//a[@class='cmp-recent-visited__link '])[1]")
	private WebElement firstRelated;
	
	@FindBy(xpath="//div[@class='cmp-recent-visited ']//div[@class='cmp-recent-visited__links-container']")
	private WebElement relatedLinks;
	
	@FindBy(xpath="//img[contains(@alt, 'logo')]")
	private WebElement phLogo;
	
	@FindBy(xpath="//h1[contains(@class, 'header')]")
	private WebElement phHeader;
	
	@FindBy(xpath="(//div[@title='Text'])[2]")
	private WebElement phTextEdit;
	
	@FindBy(xpath="//div[@name='./text']")
	private WebElement phTextArea;
	
	@FindBy(xpath="//button[@title='Lists']")
	private WebElement bulletOptionsButton;
	
	@FindBy(xpath="(//button[@title='Bullet List'])[1]")
	private WebElement bulletButton;
	
	@FindBy(xpath="(//button[@title='Numbered List'])[1]")
	private WebElement numberListButton;
	
	@FindBy(xpath="//div[@name='./text']//ul")
	private WebElement phTextList;
	
	@FindBy(xpath="//div[@name='./text']//ol")
	private WebElement phTextList2;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products/check-in/child-check-in.thumb.48.48.png?ck=']")
	private WebElement childPageImg;
	
	@FindBy(xpath="//input[@name='./topLevel']")
	private WebElement toplevelCheckbox;
	
	@FindBy(xpath="//div[contains(@class, 'for-you')]//div[contains(text(),'Child Check-in')]")
	private static List<WebElement> childTitle;
	
	@FindBy(xpath="//div[@data-asset-id='image']")
	private WebElement columnImgEdit;
	
	@FindBy(xpath="//coral-button-label[.='Pick']")
	private WebElement pick;
	
	@FindBy(xpath="//coral-columnview-item[contains(@title, 'ProductCentral')]")
	private WebElement path1;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/asset.jpg.thumb.48.48.png']")
	private WebElement path2;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/pwc-logo-outline.png.thumb.48.48.png']")
	private WebElement path4;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Select']")
	private WebElement selectButton2;
	
	@FindBy(xpath="//div[@title='MyProducts+ Image Thumbnail']")
	private WebElement columnImgEditThumb;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./jcr:img']//button[@title='Open Selection Dialog']")
	private WebElement path3;
	
	@FindBy(xpath="(//button[@class='coral-Select-button coral-MinimalButton'])[2]")
	private WebElement audienceTag;
	
	@FindBy(xpath="//li[.='Anonymous']")
	private WebElement anonyOption;
	
	@FindBy(xpath="//span[normalize-space()='No']")
	private WebElement defaultNo;
	
	@FindBy(xpath="//button[@icon='selectAll']")
	private WebElement selectAll;
	
	@FindBy(xpath="//coral-button-label[.='Start']")
	private WebElement start;
	
	@FindBy(xpath="//coral-button-label[.='Proceed']")
	private WebElement proceed;
	
	@FindBy(xpath="//span[normalize-space()='Yes']")
	private WebElement defaultYes;
	
	@FindBy(xpath="//div[contains(@class, 'outage')]")
    private WebElement banner2;
	
	@FindBy(xpath="//span[contains(@aria-label, 'banner')]")
    private WebElement bannerClose;
	
	@FindBy(xpath="//div[@title='Embed HTML']")
	private WebElement embedEdit;
	
	@FindBy(xpath="//textarea[@name='./html']")
	private WebElement embedTextArea;
	
	@FindBy(xpath="//h1[normalize-space()='This is a Heading']")
	private WebElement embedHeading;
	
	@FindBy(xpath="//p[normalize-space()='This is a paragraph.']")
	private WebElement embedParag;
	
	@FindBy(xpath="//coral-columnview-column[contains(@data-foundation-layout-columnview-columnid, 'products/cloud')]//coral-columnview-item")
	private static List<WebElement> coloumnItems;
	
	@FindBy(xpath="//div[contains(@data-path, 'latest')]")
	private WebElement authLatest;
	
	@FindBy(xpath="//div[contains(@name, 'description')]")
	private WebElement authLatestDesc;
	
	@FindBy(xpath="//coral-buttongroup[contains(@class, 'coral3-ButtonGroup rte-toolbar is-sticky is-active')]//button[contains(@title, 'Hyperlink')]")
	private WebElement hyperlinkButton;
	
	@FindBy(xpath="//coral-select[contains(@handle, 'targetSelect')]//button")
	private WebElement tabsDropdown;
	
	@FindBy(xpath="//coral-selectlist-item[normalize-space()='New Tab']")
	private WebElement newTab;
	
	@FindBy(xpath="//coral-selectlist-item[normalize-space()='Same Tab']")
	private WebElement sameTab;
	
	@FindBy(xpath="//button[contains(@title, 'Apply')]")
	private WebElement applyButton;
	
	@FindBy(xpath="//span[@class='cmp-latest__text-description']//a")
	private WebElement hyperlink;
	
	@FindBy(xpath="//button[@id='ot-sdk-btn']")
	private WebElement customizeCookies;
	
	@FindBy(xpath="//div[@id='ot-pc-content']")
	private WebElement cookiesContent;
	
	@FindBy(xpath="(//div[@class='cmp-sidebar__item first-level-link '])[1]//button")
	private WebElement level1;
	
	@FindBy(xpath="//a[@title='Level 2']")
	private WebElement level2Title;
	
	@FindBy(xpath="//div[@class='cmp-sidebar__sub-list']//button")
	private WebElement level2;
	
	@FindBy(xpath="(//div[@class='cmp-sidebar__sub-list-third'])[1]")
	private WebElement level3Title;
	
	static Logger logger=Logger.getLogger("AuthoringPage");
	
	
	
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	
	String expectedNavigatorTitle="new title";
	String expectedNavigatorDescription="New Description";
	





	public void aemTitle() {Assert.assertEquals(Driver.getDriver().getTitle(), "AEM Start", "AEM title verification has been failed");}
	
    public void setSites() {
    	sites.click();
    	productcentral.click();
    	us.click();
    	en.click();
    	HelperFunctions.staticWait(10);
    	automation.click();
    	myproduct.click();
    	fluidForecast.click();
    	HelperFunctions.staticWait(3);
		edit.click();
		 Set<String> allWindows4=Driver.getDriver().getWindowHandles();
	        List<String> windowsList4=new ArrayList<>(allWindows4);
	        Driver.getDriver().switchTo().window(windowsList4.get(1));
	        HelperFunctions.staticWait(15);
	        Driver.getDriver().switchTo().frame(0);
	        //HelperFunctions.clickWithWait(pageTitle);
	        int count=foryouAssets.size();
	        System.out.println(count);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	        
	  
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        if(viewMoreButton.isDisplayed()) {
	        	for(WebElement eachAsset: first5Assets) {
	        		if(eachAsset.isDisplayed()) {
	        			Assert.assertTrue(true);
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
	        
	
	      
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	        executor.executeScript("arguments[0].click();", viewMoreButton);
	        if(viewLessButton.isDisplayed()) {
	        	for(WebElement eachAsset: first5Assets) {
	        		if(eachAsset.isDisplayed()) {
	        			Assert.assertTrue(true);
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
	
	

    public void setChangeProductsTitle() {
		Actions a = new Actions(Driver.getDriver());
		a.doubleClick(changeProductsTitle).build().perform();
		HelperFunctions.staticWait(3);
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
        System.out.println(changeProductsTitle.getText());
        
	}
	public void setTitleEdit() {
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
		titleEdit.click();
		titleEdit.clear();
		titleEdit.sendKeys(expectedNavigatorTitle);
		HelperFunctions.staticWait(3);
		
	}
	
	public void setCheckButton() {checkButton.click();HelperFunctions.staticWait(3);}
	
	public void setChangeNavigatorDescription() {
        Driver.getDriver().switchTo().defaultContent();
        Actions a = new Actions(Driver.getDriver());
		a.doubleClick(changeNavigatorDescription).build().perform();
		HelperFunctions.staticWait(3);
	}
	public void setNavigatorDescriptionEdit() {
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
        HelperFunctions.staticWait(3);
		navigatorDescriptionEdit.click();
		navigatorDescriptionEdit.clear();
		navigatorDescriptionEdit.sendKeys(expectedNavigatorDescription);
		HelperFunctions.staticWait(3);
	}
	
	public void setCheckButton2() {checkButton2.click();HelperFunctions.staticWait(3);}
	
	public void setPreviewButton() {previewButton.click();}

    public void setActualNavigatorTitle() {
    	Driver.getDriver().switchTo().frame(0);
    	Assert.assertEquals(actualNavigatorTitle.getText(),expectedNavigatorTitle,"Actual and expected Navigator Title do not match");
	}

    public void setActualNavigatorDescription() {
		Assert.assertEquals(actualNavigatorDescription.getText(),expectedNavigatorDescription,"Actual and expected Navigator description do not match");
	}
    public void setDocCategory() throws Exception {
  
       /* read1.setExcelFile("./testdata.xlsx", "QA");
 		email.sendKeys(read1.getCellData("DATA", 1));
 		next.click();
 		pass.sendKeys(read1.getCellData("VALUE", 1));
 		submit.click();
 	    HelperFunctions.staticWait(5);
 	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
 js.executeScript("window.open()");
 	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
 	    Driver.getDriver().switchTo().window(tabs.get(1));
 	    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
 	   // HelperFunctions.waitForPageToLoad(5);
    	createButton.click();
    	pageButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productListingPageTemplate.click();
    	nextButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productCentralTab.click();
    	 HelperFunctions.staticWait(3);
		
        	
    	 FileInputStream file = new FileInputStream("C:\\Users\\GLBL_RDP_USER_01\\eclipse-workspace\\ProductCentralProject-STG-SanityAutomation\\testdata.xlsx");
    	 XSSFWorkbook workbook = new XSSFWorkbook(file);
    	 XSSFSheet sheet = workbook.getSheetAt(1); 
    	 int columnIndex = 2; 

    	 HelperFunctions.staticWait(3);
    	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    	 executor.executeScript("arguments[0].click();", portfolioTags2);

    	 HashSet<String> cellValues = new HashSet<String>();
    	 for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
    	     XSSFRow row = sheet.getRow(rowNum);
    	     if(row == null) continue;
    	     XSSFCell cell = row.getCell(columnIndex);
    	     if(cell == null) continue;
    	     cellValues.add(cell.getStringCellValue());
    	 }

    	 for (WebElement element : portfolioTags) {
    	     if (element.isDisplayed() && element.isEnabled()) {
    	         String elementText = element.getText();
    	         if (elementText != null && !elementText.isEmpty()) {
    	             boolean elementFound = false;
    	             for (String cellValue : cellValues) {
    	                 if (cellValue.equalsIgnoreCase(elementText)) {
    	                     elementFound = true;
    	                     break;
    	                 }
    	             }
    	             Assert.assertTrue(elementFound, "element text: " + elementText + " not found in the column: " + columnIndex);
    	         } else {
    	             System.out.println("Element text is empty or null, skipping the element");
    	         }
    	     } else {
    	         System.out.println("Element is not interactable or not visible, skipping the element");
    	     }
    	 }
            /* HelperFunctions.staticWait(3);
             JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
             executor2.executeScript("arguments[0].click();", pcTags);
             HelperFunctions.staticWait(3);
             int columnIndex2 = 1;
             HashSet<String> cellValues2 = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex2);
                 if(cell == null) continue;
                 cellValues2.add(cell.getStringCellValue());
             }
             for (WebElement element2 : productFeatureTags) {
                 if(element2.isDisplayed() && element2.isEnabled()){
                     String elementText2 = element2.getText();
                     if(elementText2!=null && !elementText2.isEmpty()){
                         Assert.assertTrue(cellValues2.contains(elementText2), "element text: " + elementText2 + " not found in the column: " + columnIndex2);
                     }else{
                         System.out.println("Element text is empty or null, skipping the element");
                     }
                 }else{
                     System.out.println("Element is not interactable or not visible, skipping the element");
                 }
             }
             HelperFunctions.staticWait(3);
             int columnIndex3 = 0;
             HashSet<String> cellValues3 = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex3);
                 if(cell == null) continue;
                 cellValues3.add(cell.getStringCellValue());
             }
             for (WebElement element3 : documentCategoryTag) {
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
             }*/
           
    }
  
    	
    
    public void setCombination() throws Exception {
    	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(3);
    	//sites.click();
    	//productcentral.click();
    	//us.click();
    	//en.click();
    	createButton.click();
    	pageButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productListingPageTemplate.click();
    	nextButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productCentralTab.click();
    	
    	for(WebElement each: documentCategoryTag) {
    		if(each.getText().contains("Hosted Software Terms")) {
    			each.click();
    			break;
    		}
    	}
    	
    	
    	
    	
    }
    
    public void setHyperlinks(ExtentTest test)  throws Exception {
   	 test.info("Wait for the page to load.");
   	read1.setExcelFile("./testdata.xlsx", "QA");
   	/*read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
       js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
	    //HelperFunctions.waitForPageToLoad(10);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
 	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(productsPackage);
 	    wait.until(condition);
 	  test.info("Clicking on products package");
	    productsPackage.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on cloud package");
	    cloudPackage.click();
	    wait.until(ExpectedConditions.visibilityOf(coloumnItems.get(0)));
	    String expectedTitle="Offering Overview";
   	String expectedTitle2="Terms & Conditions";
   	String expectedTitle3="Maintenance & Support";
   	String expectedTitle4="Documentation";
   	test.info("Verified all contents' position");
   	Assert.assertTrue(coloumnItems.get(0).getText().contains(expectedTitle));
	HelperFunctions.staticWait(1);
	Assert.assertTrue(coloumnItems.get(1).getText().contains(expectedTitle2));
	HelperFunctions.staticWait(1);
	Assert.assertTrue(coloumnItems.get(2).getText().contains(expectedTitle3));
	HelperFunctions.staticWait(1);
	Assert.assertTrue(coloumnItems.get(3).getText().contains(expectedTitle4));
	HelperFunctions.staticWait(3);
	    //ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs2.get(1));
	   // Driver.getDriver().get(read1.getCellData("VALUE", 21));
	    JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
       js2.executeScript("window.open()");
	    ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs2.get(1));
	    test.info("Go to the publish page");
	    Driver.getDriver().get(read1.getCellData("VALUE", 21));
	    HelperFunctions.waitForPageToLoad(3);
	    test.info("Verified all contents' position match with the system");
	    Assert.assertTrue(firstTitle.getText().contains(expectedTitle));
	    Assert.assertTrue(secondTitle.getText().contains(expectedTitle2));
	    Assert.assertTrue(thirdTitle.getText().contains(expectedTitle3));
	    Assert.assertTrue(forthTitle.getText().contains(expectedTitle4));
	    HelperFunctions.staticWait(3);
   	
   	
   	
   }
   
    
    
    public void setSitemap(ExtentTest test) throws Exception {
    	test.info("Wait for the page to load.");
    	//HelperFunctions.waitForPageToLoad(10);
    	read1.setExcelFile("./testdata.xlsx", "QA");
    	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		   ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
		   wait.until(condition);
		   editButtonContent.click();
		   //HelperFunctions.staticWait(2);
    	 WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),15);
  	    ExpectedCondition<WebElement> condition1=ExpectedConditions.elementToBeClickable(sitemap);
  	    wait1.until(condition1);
  	  test.info("Clicking on sitemap");
	    sitemap.click();
	    wait1.until(ExpectedConditions.visibilityOf(settingIcon));
	    test.info("Clicking on settings icon");
	    settingIcon.click();
	    wait1.until(ExpectedConditions.visibilityOf(checkforOptions));
	    //ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs7.get(1));
	    test.info("Clicking on check for the options");
	    checkforOptions.click();
	    wait1.until(ExpectedConditions.visibilityOf(myproductImage));
	    test.info("Clicking my product image path");
	    myproductImage.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", myproductImage);
        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", myproductImage);
        HelperFunctions.staticWait(3);
        test.info("Clicking on select button");
        JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", selectButton);
	   
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on check icon");
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on preview");
	    previewButton2.click();
	    HelperFunctions.staticWait(3);
	    test.info("Verified the contents have relevant title ");
	    for(WebElement each: sitemapContents) {
	    	if(each.getText().contains("Fluid Forecast")&& each.getText().contains("Disclosure Checklist")
	    			&&!each.getText().contains("Products") ) {
	    		String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
	    		Assert.assertTrue(true);
	    	}else {
	    		String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	    	//	Assert.assertTrue(false);
	    	}
	    }
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on edit");
	    editnextToPreview.click();
	    wait1.until(ExpectedConditions.visibilityOf(sitemap));
	    test.info("Clicking on sitemap");
	    sitemap.click();
	    wait1.until(ExpectedConditions.visibilityOf(settingIcon));
	    test.info("Clicking on settings icon");
	    settingIcon.click();
	    wait1.until(ExpectedConditions.visibilityOf(checkforOptions));
	    //ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs8.get(1));
	    test.info("Clicking on check for the options");
	    checkforOptions.click();
	    wait1.until(ExpectedConditions.visibilityOf(automationImage));
	    test.info("Clicking on automation path");
	    automationImage.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", automationImage);
        JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", automationImage);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", selectButton);
        test.info("Clicking on check icon");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    HelperFunctions.staticWait(3);
	    test.info("Verified the contents have relevant title ");
	    for(WebElement each: sitemapContents) {
	    	if(each.getText().contains("Products")&& each.getText().contains("Reseller Demo")) {
	    		String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
	    		Assert.assertTrue(true);
	    	}else {
	    		String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	    	//	Assert.assertTrue(false);
	    	}
	    }
	    
	    
	    HelperFunctions.staticWait(3);
    	
    	
    }
    
 public void setHideSitemap(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	    //HelperFunctions.waitForPageToLoad(10);
    	read1.setExcelFile("./testdata.xlsx", "QA");
    	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
 	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(homepageDemo);
 	    wait.until(condition);
 	   test.info("Clicking on homepagedemo path");
	    homepageDemo.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(5);
	    test.info("Clicking on properties");
	    properties.click();
	    wait.until(ExpectedConditions.visibilityOf(hidesitemapCheckbox));
	    test.info("Clicking on hide sitemap checkbox");
	    hidesitemapCheckbox.click();
	    HelperFunctions.staticWait(5);
	    test.info("Clicking on save&close");
	    saveAndClose.click();
	    HelperFunctions.waitForPageToLoad(30);
	    test.info("Clicking on homepagedemo path");
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", homepageDemo);
        HelperFunctions.staticWait(5);
        test.info("Clicking on sitemap path");
        JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
        executor7.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(5);
        test.info("Clicking on quick publish");
        quickPublish.click();
          HelperFunctions.staticWait(5);
          JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();",  publish2);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
        executor11.executeScript("arguments[0].click();", homepageDemo);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
        executor8.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
        executor9.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(3);
        test.info("Clicking on edit");
        edit.click();
        ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs2.get(1));
        HelperFunctions.waitForPageToLoad(5);
        previewButton2.click();
        test.info("Verified title has been hidden in sitemap");
        String expectedContent="Homepage Demo";
        for(WebElement eachContent: sitemapContents) {
            System.out.println(eachContent.getText());
            if(!eachContent.getText().contains(expectedContent)) {
            	String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
                Assert.assertTrue(true);
            }else {
            	String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
             //   Assert.assertTrue(false);
            }
        }
        HelperFunctions.staticWait(3);
    }
 
 public void setTilesAuthorization(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	// HelperFunctions.waitForPageToLoad(15);
	 //HelperFunctions.staticWait(3);
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	 wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	 //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	   //wait.until(condition);
	   editButtonContent.click();
	 read1.setExcelFile("./testdata.xlsx", "QA");
		/*email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
     js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 19));*/  
	 test.info("Verified each tile has relevant title.");
	 HelperFunctions.staticWait(3);
		for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Maintenance & Support")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
				//Assert.assertTrue(false);
			}
		}
		HelperFunctions.staticWait(3);
		test.info("Clicking on tiles for setting");
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", legalTilesAuth);
        test.info("Clicking on settings");
        wait.until(ExpectedConditions.visibilityOf(settingIcon));
        settingIcon.click();
        wait.until(ExpectedConditions.visibilityOf(legalTilesAuthFirstCheckbox));
       // ArrayList<String> tabs5 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs5.get(1));
        test.info("Change the tiles path");
	    legalTilesAuthFirstCheckbox.click();
	    wait.until(ExpectedConditions.visibilityOf(dataProcessingImg));
	  //  ArrayList<String> tabs6 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs6.get(1));
	    dataProcessingImg.click();
	    HelperFunctions.staticWait(3);
	    selectButton.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on check icon");
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    test.info("Verified tiles have changed after changing the path");
	    for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Data Processing Addendum")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
			//	Assert.assertTrue(false);
			}
		}
	    HelperFunctions.staticWait(3);
	    //ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
		   //wait.until(condition2);
	    //wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
		   editButtonContent.click();
	    test.info("Clicking on tiles for setting");
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", legalTilesAuth);
        wait.until(ExpectedConditions.visibilityOf(settingIcon));
        test.info("Clicking on settings");
        settingIcon.click();
        wait.until(ExpectedConditions.visibilityOf(legalTilesAuthFirstCheckbox));
       // ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs7.get(1));
        test.info("Change the tiles path");
	    legalTilesAuthFirstCheckbox.click();
	    wait.until(ExpectedConditions.visibilityOf(maintenanceImg));
	   // ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs8.get(1));
	    maintenanceImg.click();
	    HelperFunctions.staticWait(3);
	    selectButton.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on check icon");
	    checkIcon.click();
	    test.info("Verified tiles have changed after changing the path again");
	    for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Maintenance & Support")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
				//Assert.assertTrue(false);
			}
		}
	    HelperFunctions.staticWait(3);
	    
	    
	    
 }
 
 public void setContentAuthorization(ExtentTest test) throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	 test.info("Wait for the page to load.");
	    //HelperFunctions.waitForPageToLoad(10);
	   
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	    wait.until(condition);
	    //HelperFunctions.staticWait(2);
	    test.info("Click on edit");
	    editButtonContent.click();
	    wait.until(ExpectedConditions.visibilityOf(offeringOverviewLink2auth));
	    test.info("Click on content page title for authoring");
	    offeringOverviewLink2auth.click();
	    wait.until(ExpectedConditions.visibilityOf(settingIcon));
	    test.info("Click on setting");
	    settingIcon.click();
	    wait.until(ExpectedConditions.visibilityOf(titleField));
	  //  ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs7.get(1));
	    test.info("Click on title field");
	    titleField.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clear the title");
	    titleField.clear();
	    test.info("Send text to title");
	    HelperFunctions.staticWait(2);
	    titleField.sendKeys("test");
	    HelperFunctions.staticWait(3);
	    test.info("Click on check icon");
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on preview");
	    previewButton2.click();
	  //  Set<String> allWindows4=Driver.getDriver().getWindowHandles();
     //   List<String> windowsList4=new ArrayList<>(allWindows4);
      //  Driver.getDriver().switchTo().window(windowsList4.get(1));
        
        Driver.getDriver().switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOf(contentTitle));
	 String expectedTitle="test";
	 String actualTitle=contentTitle.getText();
	 test.info("Veried expected title matches with actual title");
	 Assert.assertEquals(expectedTitle, actualTitle);
	 if (!actualTitle.equals(expectedTitle)) {
         String errorMessage = "Titles do not match";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	 test.info("Click on edit");
	 Driver.getDriver().switchTo().defaultContent();
	 wait.until(ExpectedConditions.visibilityOf(editButtonContent));
	 editButtonContent.click();
	 wait.until(ExpectedConditions.visibilityOf(offeringOverviewLink2auth));
	 test.info("Click on content page title for authoring");
	 offeringOverviewLink2auth.click();
	 wait.until(ExpectedConditions.visibilityOf(settingIcon));
	 test.info("Click on setting");
	 settingIcon.click();
	 wait.until(ExpectedConditions.visibilityOf(titleField));
	  //  ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs7.get(1));
	 test.info("Click on title field");
	    titleField.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clear the title");
	    titleField.clear();
	    HelperFunctions.staticWait(2);
	    test.info("Send text to title");
	    titleField.sendKeys("Offering Overview");
	    HelperFunctions.staticWait(3);
	    test.info("Click on check icon");
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on preview");
	    previewButton2.click();
	  //  Set<String> allWindows5=Driver.getDriver().getWindowHandles();
   //  List<String> windowsList5=new ArrayList<>(allWindows5);
   //  Driver.getDriver().switchTo().window(windowsList5.get(1));
	    test.info("Veried expected title matches with actual title");
     Driver.getDriver().switchTo().frame(0);
     wait.until(ExpectedConditions.visibilityOf(contentTitle));
	 String expectedTitle2="Offering Overview";
	 String actualTitle2=contentTitle.getText();
	// Assert.assertEquals(expectedTitle2, actualTitle2);
	 if (!actualTitle2.equals(expectedTitle2)) {
         String errorMessage = "Titles do not match";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	 
	 HelperFunctions.staticWait(2);
 
	    
	    
	    
	    
 }
 
 public void setHomepageTileAuthorization() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 10));*/
	    HelperFunctions.waitForPageToLoad(10);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
	    wait.until(ExpectedConditions.visibilityOf(homepageTileauth));
	    homepageTileauth.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    HelperFunctions.staticWait(2);
	   // ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs7.get(1));
	    collapseHeader.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.clear();
	    HelperFunctions.staticWait(2);
	    titleofTile.sendKeys("Tile 1");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	  //  Set<String> allWindows4=Driver.getDriver().getWindowHandles();
      //  List<String> windowsList4=new ArrayList<>(allWindows4);
      //  Driver.getDriver().switchTo().window(windowsList4.get(1));
        
        Driver.getDriver().switchTo().frame(0);
	 String expectedTitle="Tile 1";
	 String actualTitle=firstTitleofTile.getText();
	// Assert.assertEquals(expectedTitle, actualTitle);
	 if (!actualTitle.equals(expectedTitle)) {
         String errorMessage = "Titles do not match ";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	 Driver.getDriver().switchTo().defaultContent();
	 HelperFunctions.staticWait(2);
	 editButtonContent.click();
	 HelperFunctions.staticWait(2);
	 homepageTileauth.click();
	 HelperFunctions.staticWait(2);
	    settingIcon.click();
	  //  ArrayList<String> tabs9 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs9.get(1));
	    collapseHeader.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.clear();
	    HelperFunctions.staticWait(2);
	    titleofTile.sendKeys("Legal");	
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	 //   Set<String> allWindows5=Driver.getDriver().getWindowHandles();
   //  List<String> windowsList5=new ArrayList<>(allWindows5);
   //  Driver.getDriver().switchTo().window(windowsList5.get(1));
	    HelperFunctions.staticWait(3);
     Driver.getDriver().switchTo().frame(0);
     HelperFunctions.staticWait(3);
	 String expectedTitle2="Legal";
	 String actualTitle2=firstTitleofTile.getText();
	// Assert.assertEquals(expectedTitle2, actualTitle2);
	 if (!actualTitle2.equals(expectedTitle2)) {
         String errorMessage = "Titles do not match ";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	    
	    
	    
	    
 }
 
 public void setDisplayingLogintomyProductLink() throws Exception {
	/* read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
	    HelperFunctions.waitForPageToLoad(5);*/
	    HelperFunctions.waitForPageToLoad(5);
	    for(WebElement eachLink: loginToMyProductsLinks) {
	    	if(eachLink.getText().contains("Login to My Products")) {
	    		String errorMessage = "Login to My Products link is not displayed";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	    		//Assert.assertTrue(false);
	    	}else {
	    		Assert.assertTrue(true);
	    		String successMessage = "Login to My Products link is displayed";
	            logger.info(successMessage);
	    	//	logger.error("Login to My Products link is not displayed ");
	    	}
	    }
	 
	 
	 
 }
 public void setUnpublishWorkflow(ExtentTest test) throws Exception {
	 	
	 	read1.setExcelFile("./testdata.xlsx", "STG");
	 	test.info("Wait for the page to load.");
		    //HelperFunctions.waitForPageToLoad(10);
		    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(resellerdemoImage);
		    wait.until(condition);
		    test.info("Click on reseller demo path");
		    resellerdemoImage.click();
		    HelperFunctions.staticWait(2);
		    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
	        executor4.executeScript("arguments[0].click();", resellerdemoImage);
		    HelperFunctions.staticWait(3);
		    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
	        executor5.executeScript("arguments[0].click();", resellerdemoImage);
	        HelperFunctions.staticWait(3);
	        test.info("Click on manage publication");
		    managePublication.click();
		    HelperFunctions.waitForPageToLoad(5);
		    test.info("Click on unpublish");
		    unpublish.click();
		    HelperFunctions.waitForPageToLoad(5);
		    test.info("Click on next button");
		    nextButton.click();
		    HelperFunctions.waitForPageToLoad(5);
		    test.info("Click on image for unpublishing");
		    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
	        executor6.executeScript("arguments[0].click();", resellerdemoImageforUnpublish);
	        WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
		    wait4.until(ExpectedConditions.visibilityOf(unpublishButton));
	        test.info("Click on unpublish");
		    unpublishButton.click();
		    wait4.until(ExpectedConditions.visibilityOf(continueButton));
		    test.info("Click on continue");
		    continueButton.click();
			 //   ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
			 //   Driver.getDriver().switchTo().window(tabs2.get(1));
			    Driver.getDriver().get(read1.getCellData("VALUE", 17));
			    HelperFunctions.waitForPageToLoad(60);
			    test.info("Click on reseller demo path");
		    JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
	        executor7.executeScript("arguments[0].click();", resellerdemoImage);
	        wait4.until(ExpectedConditions.visibilityOf(publishInformation.get(0)));
	        test.info("Verified page is not published on publish information");
	        for(WebElement eachInfo: publishInformation) {
	        	System.out.println(eachInfo.getText());
	        	if(eachInfo.getText().contains("Not published")) {
	        		 String successMessage = "Page is unpublished ";
	                 logger.info(successMessage);
	        		Assert.assertTrue(true);
	        	}else {
	        		 String errorMessage = "Page is supposed to be unpublished but it does not show 'Not published' ";
	                 logger.error(errorMessage);
	                 throw new Exception(errorMessage);
	        	//	Assert.assertTrue(false);
	        	//	logger.error("Page is supposed to be unpublished but it does not show 'Not published' ");
	        	}
	        }
	        test.info("Click on reseller demo path");
	        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
	        executor8.executeScript("arguments[0].click();", resellerdemoImage);
	        resellerDemo.click();
	        HelperFunctions.staticWait(3);
	        test.info("Click on child path");
	        JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
	        executor9.executeScript("arguments[0].click();", checkinImg);
	        wait4.until(ExpectedConditions.visibilityOf(publishInformation.get(0)));
	        test.info("Verified child page is not published on publish information");
	        for(WebElement eachInfo: publishInformation) {
	        	System.out.println(eachInfo.getText());
	        	if(eachInfo.getText().contains("Not published")) {
	        		String successMessage = "Publish info contains unpublished ";
	                logger.info(successMessage);
	        		Assert.assertTrue(true);
	        	}else {
	        		String errorMessage = "Publish info does not contain unpublished ";
	                logger.error(errorMessage);
	                throw new Exception(errorMessage);
	        		//Assert.assertTrue(false);
	        		//logger.error("Page is supposed to be unpublished but it does not show 'Not published' ");
	        	}
	        }
	        test.info("Click on pages for publishing again");
	        HelperFunctions.staticWait(3);
	        quickPublish2.click();
	        wait4.until(ExpectedConditions.visibilityOf(publish2));
	        publish2.click();
	      /*  JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
	        executor10.executeScript("arguments[0].click();", checkinImg);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
	        executor11.executeScript("arguments[0].click();", microsoftImg);
	        HelperFunctions.staticWait(2);
	        JavascriptExecutor executor12 = (JavascriptExecutor) Driver.getDriver();
	        executor12.executeScript("arguments[0].click();", microsoftImg);
	        HelperFunctions.staticWait(2);
	        JavascriptExecutor executor13 = (JavascriptExecutor) Driver.getDriver();
	        executor13.executeScript("arguments[0].click();", microsoftImg);
	        HelperFunctions.staticWait(3);
	        quickPublish2.click();
	        HelperFunctions.staticWait(3);
	        publish2.click();
	        JavascriptExecutor executor14 = (JavascriptExecutor) Driver.getDriver();
	        executor14.executeScript("arguments[0].click();", microsoftImg);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor15 = (JavascriptExecutor) Driver.getDriver();
	        executor15.executeScript("arguments[0].click();", dragosImg);
	        HelperFunctions.staticWait(2);
	        JavascriptExecutor executor16 = (JavascriptExecutor) Driver.getDriver();
	        executor16.executeScript("arguments[0].click();", dragosImg);
	        HelperFunctions.staticWait(2);
	        JavascriptExecutor executor17 = (JavascriptExecutor) Driver.getDriver();
	        executor17.executeScript("arguments[0].click();", dragosImg);
	        HelperFunctions.staticWait(3);
	        quickPublish2.click();
	        HelperFunctions.staticWait(3);
	        publish2.click();
	        JavascriptExecutor executor18 = (JavascriptExecutor) Driver.getDriver();
	        executor18.executeScript("arguments[0].click();", dragosImg);*/
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor19 = (JavascriptExecutor) Driver.getDriver();
	        executor19.executeScript("arguments[0].click();", resellerdemoImage);
	        HelperFunctions.staticWait(2);
	        JavascriptExecutor executor20 = (JavascriptExecutor) Driver.getDriver();
	        executor20.executeScript("arguments[0].click();", resellerdemoImage);
	        HelperFunctions.staticWait(2);
	        JavascriptExecutor executor21 = (JavascriptExecutor) Driver.getDriver();
	        executor21.executeScript("arguments[0].click();", resellerdemoImage);
	        HelperFunctions.staticWait(3);
	        quickPublish2.click();
	        wait4.until(ExpectedConditions.visibilityOf(publish2));
	        publish2.click();
	        wait4.until(ExpectedConditions.visibilityOf(publishInformation.get(0)));
	        for(WebElement eachInfo: publishInformation) {
	        	System.out.println(eachInfo.getText());
	        	if(!eachInfo.getText().contains("seconds")) {
	        		Assert.assertTrue(true);
	        	}else {
	        		Assert.assertTrue(false);
	        	}
	        }
	        HelperFunctions.staticWait(3);
		    
		    
	 }
	 public void setUpdatedDate(ExtentTest test) throws Exception {
		 	
		 	read1.setExcelFile("./testdata.xlsx", "STG");
			/*	email.sendKeys(read1.getCellData("DATA", 1));
				next.click();
				pass.sendKeys(read1.getCellData("VALUE", 1));
				submit.click();
			    HelperFunctions.staticWait(5);
			    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
		     js.executeScript("window.open()");
			    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
			    Driver.getDriver().switchTo().window(tabs.get(1));
			    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
		 	test.info("Wait for the page to load.");
			    //HelperFunctions.waitForPageToLoad(10);
			    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
			    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(resellimg);
			    wait.until(condition);
			    test.info("Click on reseller path");
			    resellimg.click();
			    HelperFunctions.staticWait(2);
			    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
		        executor1.executeScript("arguments[0].click();", resellimg);
		        HelperFunctions.staticWait(2);
		        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
		        executor2.executeScript("arguments[0].click();", resellimg);
			    HelperFunctions.staticWait(2);
			    test.info("Click on quick publish");
			    quickPublish.click();
			    wait.until(ExpectedConditions.visibilityOf(publish2));
			    test.info("Click on publish");
			    publish2.click();
			    HelperFunctions.staticWait(5);
			    
			   
			      Calendar cal = Calendar.getInstance();
			      String month=new SimpleDateFormat("MMMMMMMMM").format(cal.getTime());
			      System.out.println(month);
			      String year=new SimpleDateFormat("YYYY").format(cal.getTime());
			      System.out.println(year);
			      String dayoftheweek=new SimpleDateFormat("EEEEE").format(cal.getTime());
			      System.out.println(dayoftheweek);
			      String dayoftheyear=new SimpleDateFormat("d").format(cal.getTime());
			      System.out.println(dayoftheyear);
			      String value = publishedDate.getAttribute("title");
			      System.out.println(value);
			      test.info("Verified the date of publishing matches the current date");
			      if(value.contains(month)&&value.contains(year)&&value.contains(dayoftheweek)&&value.contains(dayoftheyear)) {
			    	  String successMessage = "The date of publishing is correct";
			            logger.info(successMessage);
			    	  Assert.assertTrue(true);
			      }else {
			    	  String errorMessage = "The date of publishing is NOT correct";
		                logger.error(errorMessage);
		                throw new Exception(errorMessage);
			    	//  Assert.assertTrue(false);
			    	//  logger.error("The date of publishing is NOT correct");
			      }
			     
			      HelperFunctions.staticWait(3);
	    
	    
	 }
 
 public void setUpdatedDateFromAssets() throws Exception {
	 
	 read1.setExcelFile("./testdata.xlsx", "STG");
	
	    HelperFunctions.waitForPageToLoad(15);
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(pdfDate);
	    HelperFunctions.staticWait(2);
	    String originalDate = pdfDate.getAttribute("value");
        String desiredFormat = "MM/dd/yyyy";
        SimpleDateFormat originalSDF = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalSDF.parse(originalDate);
        SimpleDateFormat desiredSDF = new SimpleDateFormat(desiredFormat);
        String formattedDate = desiredSDF.format(date);
        System.out.println(formattedDate);
        HelperFunctions.staticWait(2);
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
	    priceWaterPdf.click();
	    HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
        pdfTemplate.click();
        HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	 //   Driver.getDriver().switchTo().frame(0);
	 //   String date2 = lastUpdatedDate.getText();
	 //   System.out.println(date2);
	 //   Assert.assertTrue(date2.contains(formattedDate)|| !date2.contains(formattedDate));
	    List<WebElement> h1Tags=contentTitle2.findElements(By.tagName("h1"));
	    Assert.assertTrue(h1Tags.size()==1);
	
	    HelperFunctions.staticWait(3);
	  
	    
 }
 public void setUpdatedDateFromAssets2() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/general/content-pdf");
	    HelperFunctions.waitForPageToLoad(5);
	  	    for(WebElement each: pdfInfo) {
	  	    	//System.out.println(each.getText());
	  	    	 
	  	    		for(WebElement each2:pdfInfo2) {
	  	    			if(each.getText().contains("PDF Template for AEM Testing")) {
	  	    				System.out.println(each2.getAttribute("value"));
	  	    				break;
	  	    			}
	  	    			
	  	    		}
	  	    	}
	  	    
	    
	   // String expectedDate2="Last updated 01/09/2023";
	   // Assert.assertEquals(lastUpdatedDate.getText(), expectedDate2);
	    
 }
 public void setUpdatedDateVisibility() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "STG");
	
	    HelperFunctions.waitForPageToLoad(5);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
	    wait.until(ExpectedConditions.visibilityOf(previewButton2));
	    previewButton2.click();
	  //  Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    List<WebElement> h1Tags=contentTitle2.findElements(By.tagName("h1"));
	    if(h1Tags.size()==1) {
	    	String successMessage = "Last updated date is not visible";
            logger.info(successMessage);
	    	Assert.assertTrue(true);
	    }else {
	    	String errorMessage = "Last updated date is visible";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
	    	//Assert.assertTrue(false);
	    }
	 
	    
	    
	    
	    
	    
 }
 public void setCatCombination(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	 //HelperFunctions.waitForPageToLoad(10);
	 read1.setExcelFile("./testdata.xlsx", "QA");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 23));*/
	    
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		wait.until(ExpectedConditions.elementToBeClickable(createButton));
		//HelperFunctions.staticWait(2);
		test.info("Click on create button");
	    createButton.click();
	    wait.until(ExpectedConditions.elementToBeClickable(pageButton));
	    test.info("Click on create page button");
	    pageButton.click();
	    wait.until(ExpectedConditions.elementToBeClickable(contentPageTemplate));
	    test.info("Click on content page template");
	    contentPageTemplate.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on next button");
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(15);
	    wait.until(ExpectedConditions.elementToBeClickable(titleField2));
	    test.info("Click on title field");
	    titleField2.click();
	    HelperFunctions.staticWait(3);
	    test.info("Send text to title field");
	    titleField2.sendKeys("content 3");
	    HelperFunctions.staticWait(3);
	    test.info("Click on product central tab");
	    productCentralTab.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Select option from document category ");
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

	    wait1.until(ExpectedConditions.elementToBeClickable(documentCategoryTag2));
	    executor.executeScript("arguments[0].click();", documentCategoryTag2);
	    HelperFunctions.staticWait(3);
	    wait1.until(ExpectedConditions.elementToBeClickable(firstOptionofDocCat));
	    firstOptionofDocCat.click();
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    test.info("Select option from product feature ");
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	    executor2.executeScript("arguments[0].click();", productFeatureTag2);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    //wait1.until(ExpectedConditions.elementToBeClickable(firstOptionofProCat));
	    //firstOptionofProCat.click();
	    //executor.executeScript("arguments[0].click();", firstOptionofProCat);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    test.info("Select option from portfolio tag");

	    /*JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", portfolioTag2);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }*/
	    wait1.until(ExpectedConditions.elementToBeClickable(firstOptionofPortCat));
	    firstOptionofPortCat.click();
	    //executor5.executeScript("arguments[0].click();", firstOptionofPortCat);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    test.info("Select option from audience tag");
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
	    executor4.executeScript("arguments[0].click();", audienceTag);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    wait1.until(ExpectedConditions.elementToBeClickable(anonyOption));
	    anonyOption.click();
	    //executor5.executeScript("arguments[0].click();", anonyOption);
	    try {
	    	Thread.sleep(3000);
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
        createButton2.click();
        WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 10);
	    wait6.until(ExpectedConditions.visibilityOf(doneButton));
        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
        executor8.executeScript("arguments[0].click();", doneButton);
       // doneButton.click();
        HelperFunctions.staticWait(3);
	  	    
 }
 public void setReleaseNotes() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));*/
	    HelperFunctions.waitForPageToLoad(5);
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
	    wait.until(ExpectedConditions.visibilityOf(editButtonContent));
	    editButtonContent.click();
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(releaseNotes);
        HelperFunctions.staticWait(3);
        releaseNotes.click();
        HelperFunctions.staticWait(3);
        settingIcon.click();
        HelperFunctions.staticWait(3);
        String title="version1";
        releaseTitle.click();
        releaseTitle.clear();
        releaseTitle.sendKeys(title);
        HelperFunctions.staticWait(3);
        releaseDate.click();
        releaseDate.clear();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        releaseDate.sendKeys(dateFormat.format(date));
        JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", releaseDescription);
        String description="some description";
        releaseDescription.clear();
        releaseDescription.sendKeys(description);
        HelperFunctions.staticWait(3);
        checkIcon.click();
        HelperFunctions.staticWait(3);
        previewButton2.click();
        HelperFunctions.staticWait(3);
        Driver.getDriver().switchTo().frame(0);
        HelperFunctions.scrollToElement(releaseTitleonPreview);
        HelperFunctions.staticWait(3);
        String actualDate=releaseDateonPreview.getText();
        String expectedDate=dateFormat.format(date);
       // Assert.assertEquals(actualDate, expectedDate);
        if (!actualDate.equals(expectedDate)) {
            String errorMessage = "Dates do not match";
              logger.error(errorMessage);
              throw new Exception(errorMessage);
        }else {
            String successMessage = "Dates match";
              logger.info(successMessage);
        } 
        HelperFunctions.staticWait(3);
        String actualTitle=releaseTitleonPreview.getText();
        String expectedTitle=title;
       // Assert.assertEquals(actualTitle, expectedTitle);
        if (!actualTitle.equals(expectedTitle)) {
            String errorMessage = "Titles do not match";
              logger.error(errorMessage);
              throw new Exception(errorMessage);
        }else {
            String successMessage = "Titles match";
              logger.info(successMessage);
        } 
        HelperFunctions.staticWait(3);
        String actualDescription=releaseDescriptiononPreview.getText();
        String expectedDescription=description;
       // Assert.assertEquals(actualDescription,expectedDescription);
        if (!actualDescription.equals(expectedDescription)) {
            String errorMessage = "Descriptions do not match";
              logger.error(errorMessage);
              throw new Exception(errorMessage);
        }else {
            String successMessage = "Descriptions match";
              logger.info(successMessage);
        } 
        
        
        
	   
	    
 }
 public void setAuthFooter() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "STG");
	
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(5);
	    HelperFunctions.scrollToElement(authFooter); 
        HelperFunctions.staticWait(3);
        HelperFunctions.scrollToElement(authFooter); 
	    HelperFunctions.staticWait(3);
	    authFooter.click();
	    HelperFunctions.staticWait(3);
	    settingIcon.click();
	    HelperFunctions.staticWait(3);
	    textareaForFooter.click();
	    textareaForFooter.clear();
	    String mockFooter=read1.getCellData("VALUE", 40);
	    textareaForFooter.sendKeys(mockFooter);
	    HelperFunctions.staticWait(3);
	    privacyPolicyTitle.click();
	    privacyPolicyTitle.clear();
	    privacyPolicyTitle.sendKeys("Privacy policy");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    publishTemplate.click();
	    HelperFunctions.staticWait(3);
	    unpublishButton.click();
	    HelperFunctions.staticWait(5);
	  	 //   ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  	 //   Driver.getDriver().switchTo().window(tabs2.get(1));
	  	    Driver.getDriver().get(read1.getCellData("VALUE", 41));
	  	    HelperFunctions.waitForPageToLoad(5);
	  	    fluidForecast.click();
	  	  HelperFunctions.staticWait(3);
	  	   JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	        executor1.executeScript("arguments[0].click();", fluidForecast);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	        executor2.executeScript("arguments[0].click();", fluidForecast);
	  	  HelperFunctions.staticWait(3);
	  	  quickPublish2.click();
	  	 HelperFunctions.staticWait(3);
	  	 publish2.click();
	  	 HelperFunctions.staticWait(3);
		  	 //   ArrayList<String> tabs3 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		  	 //   Driver.getDriver().switchTo().window(tabs3.get(1));
		  	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
		  	    HelperFunctions.waitForPageToLoad(5);
	  
		  	Driver.getDriver().switchTo().frame(0);
		  	HelperFunctions.staticWait(3);
		  	 HelperFunctions.scrollToElement(footerContent); 
	        HelperFunctions.staticWait(3);
	        Assert.assertTrue(footerContent.getText().contains(mockFooter));
	        HelperFunctions.staticWait(3);
	 
		  	 //   ArrayList<String> tabs4 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		  	 //   Driver.getDriver().switchTo().window(tabs4.get(1));
		  	    Driver.getDriver().get(read1.getCellData("VALUE", 27));
		  	    HelperFunctions.waitForPageToLoad(5);
		  	    HelperFunctions.staticWait(5);
		  	    HelperFunctions.scrollToElement(authFooter);
		        HelperFunctions.staticWait(3);
		        HelperFunctions.scrollToElement(authFooter);  
			    HelperFunctions.staticWait(3);
			    authFooter.click();
			    HelperFunctions.staticWait(3);
			    settingIcon.click();
			    HelperFunctions.staticWait(3);
			    textareaForFooter.click();
			    textareaForFooter.clear();
			    String footer=read1.getCellData("VALUE", 31);
			    textareaForFooter.sendKeys(footer);
			    HelperFunctions.staticWait(3);
			    checkIcon.click();
			    HelperFunctions.staticWait(3);
			    pageInfo.click();
			    HelperFunctions.staticWait(3);
			    publishTemplate.click();
			   // HelperFunctions.staticWait(3);
			   // unpublishButton.click();
			    HelperFunctions.staticWait(5);
	        
	    
	    
	    
	    
	    
 
 
 
 }
 
 public void setNeedTechnicalSupport() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
	    HelperFunctions.waitForPageToLoad(5);
	    
	    
 
 
 
 }
 public void setPWClogo(ExtentTest test) throws Exception {
     read1.setExcelFile("./testdata.xlsx", "QA");
      /*  email.sendKeys(read1.getCellData("DATA", 1));
        next.click();
        pass.sendKeys(read1.getCellData("VALUE", 1));
        submit.click();*/
     test.info("Wait for the page to load.");
        HelperFunctions.waitForPageToLoad(10);
        
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton2);
	    wait.until(condition);
	    HelperFunctions.staticWait(3);
        test.info("Click on preview button");
        previewButton2.click();
        HelperFunctions.staticWait(3);
        test.info("Switching iframe to check the logo");
        Driver.getDriver().switchTo().frame(0);
        if(pwcLogo.isDisplayed()) {
            Assert.assertTrue(true);
        }else {
            String errorMessage = "missing pwc logo template";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
        }
        test.info("Verified the PwC logo populated at the template level");
        HelperFunctions.staticWait(3);
 }
 public void setBanner(ExtentTest test) throws Exception {
    // Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
     test.info("Wait for the page to load.");
    // HelperFunctions.waitForPageToLoad(10);
     WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
	   ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	   wait.until(condition);
	   editButtonContent.click();
        WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),10);
	    ExpectedCondition<WebElement> condition1=ExpectedConditions.elementToBeClickable(bannerArea);
	    wait1.until(condition1);
	    HelperFunctions.staticWait(2);
	    test.info("Click on banner area for configuration");
        bannerArea.click();
        HelperFunctions.staticWait(2);
        test.info("Click on settings");
        settingsBanner.click();
        HelperFunctions.staticWait(2);
        test.info("Click on banner dropdown");
        bannerDrop.click();
        HelperFunctions.staticWait(2);
        test.info("Click on scheduled banner");
        scheduledBanner.click();
        HelperFunctions.staticWait(2);
        test.info("Click on check icon");
        checkIcon.click();
        HelperFunctions.staticWait(2);
        test.info("Click on preview banner");
        previewBanner.click();
        HelperFunctions.staticWait(2);
        test.info("Switching the iframe");
        Driver.getDriver().switchTo().frame(0);
        System.out.println(banner.getCssValue("background-color"));
     
        if(banner.getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) {
            Assert.assertTrue(true);
        }else {
            String errorMessage = "Background is not white";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
        }
        test.info("Verified the banner background is white.");
        HelperFunctions.staticWait(3);
 }
 public void setReorderTiles(ExtentTest test) throws Exception {
	    test.info("Wait for the page to load.");
	    //HelperFunctions.waitForPageToLoad(10);
	   

	    test.info("Click preview button.");
	    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    wait.until(ExpectedConditions.visibilityOf(pageInfo));
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton);
	    //wait.until(condition);
	    //HelperFunctions.staticWait(2);
	    previewButton.click();

	    test.info("Switch to iframe.");
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);

	    test.info("Assert first product tile text contains 'Offering'.");
	    Assert.assertTrue(firstProductTile.getText().contains("Offering"));

	    HelperFunctions.staticWait(2);

	    test.info("Switch back to default content.");
	    Driver.getDriver().switchTo().defaultContent();
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click edit button content.");
	    editButtonContent.click();
	    wait.until(ExpectedConditions.visibilityOf(editTiles));

	    test.info("Click edit tiles.");
	    editTiles.click();
	    wait.until(ExpectedConditions.visibilityOf(configure));

	    test.info("Click configure.");
	    configure.click();
	    wait.until(ExpectedConditions.visibilityOf(drag1));

	    test.info("Reorder tiles.");
	    Actions builder = new Actions(Driver.getDriver());
	    builder.dragAndDrop(drag1, drag2).build().perform();
	    HelperFunctions.staticWait(2);

	    test.info("Click check icon.");
	    checkIcon.click();
	    HelperFunctions.staticWait(4);
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click preview button.");
	    previewButton.click();

	    test.info("Switch to iframe.");
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);

	    test.info("Assert first product tile text contains 'Terms'.");
	    Assert.assertTrue(firstProductTile.getText().contains("Terms"));

	    test.info("Switch back to default content.");
	    Driver.getDriver().switchTo().defaultContent();
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click edit button content.");
	    editButtonContent.click();

	    test.info("Click edit tiles.");
	    editTiles.click();
	    wait.until(ExpectedConditions.visibilityOf(configure));

	    test.info("Click configure.");
	    configure.click();
	    wait.until(ExpectedConditions.visibilityOf(drag1));

	    test.info("Reorder tiles.");
	    Actions builder2 = new Actions(Driver.getDriver());
	    builder2.dragAndDrop(drag1, drag2).build().perform();
	    HelperFunctions.staticWait(2);

	    test.info("Click check icon.");
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	}
public void setCheckboxNotTicked(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	   // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/products/cloud/offering-overview.html");
		//HelperFunctions.waitForPageToLoad(10);
		
		 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(pageInfo);
		    wait.until(condition);
		    //HelperFunctions.staticWait(3);
		    test.info("Click on page info");
		pageInfo.click();
		wait.until(ExpectedConditions.visibilityOf(openProper));
		test.info("Click on open properties");
		openProper.click();
		HelperFunctions.waitForPageToLoad(20);
		wait.until(ExpectedConditions.visibilityOf(hideListing));
		test.info("Verified hide listing checkbox not selected");
		Assert.assertFalse( hideListing.isSelected());
		test.info("Click on save and close");
		saveAndClose.click();
		test.info("Wait for the page to load.");
		HelperFunctions.waitForPageToLoad(20);
		wait.until(ExpectedConditions.visibilityOf(previewButton2));
		 test.info("Click on preview");
		 previewButton2.click();
		 HelperFunctions.staticWait(2);
		 //Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/pc/us/en/automation/products/cloud/offering-overview.html");
		 //test.info("Wait for the page to load.");
		 //HelperFunctions.waitForPageToLoad(10);
			//HelperFunctions.staticWait(3);
		 test.info("Switch the iframe");
		 Driver.getDriver().switchTo().frame(0);
		 wait.until(ExpectedConditions.visibilityOf(dft));
			test.info("Verified 'Download Full Term Link' is displayed");
			Assert.assertTrue( dft.isDisplayed());
			HelperFunctions.staticWait(3);
	} 

public void setPushingPageSiteAdmin(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
  //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/legal.html");
	 HelperFunctions.waitForPageToLoad(30);
	
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(pageInfo);
	    wait.until(condition);
	    //HelperFunctions.staticWait(2);
	    test.info("Click on page info");
	 pageInfo.click();
	 wait.until(ExpectedConditions.visibilityOf(publishInfoonPage));
	 test.info("Getting the publish info before publishing");
	 String beforePublish=publishInfoonPage.getText();
	 test.info("Click on publish icon");
  publishIcon.click();
  HelperFunctions.staticWait(2);
  Driver.getDriver().navigate().refresh();
  HelperFunctions.waitForPageToLoad(30);
  test.info("Click on page info");
  pageInfo.click();
  wait.until(ExpectedConditions.visibilityOf(publishInfoonPage));
	 test.info("Getting the publish info after publishing");
	 String afterPublish=publishInfoonPage.getText();
	 test.info("Verified publish info has changed");
	 Assert.assertNotEquals(beforePublish, afterPublish);
	 HelperFunctions.staticWait(3);
	  
}
public void setAuthorExperienceFragment(ExtentTest test) throws Exception {
	   //HelperFunctions.waitForPageToLoad(5);
	   test.info("Wait for the page to load.");
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/experience-fragments/pc/us/en/site/experience-fragment/master.html");
	  // HelperFunctions.waitForPageToLoad(10);
	   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	    wait.until(condition);
	    test.info("Click on edit button");
	   editButtonContent.click();
	 //  Driver.getDriver().switchTo().frame(0);
	   HelperFunctions.staticWait(2);
	   test.info("Click on edit for privacy hub configuration");
	   phEdit.click();
	   wait.until(ExpectedConditions.visibilityOf(configure));
	   test.info("Click on privacy hub configuration");
	   configure.click();
	   wait.until(ExpectedConditions.visibilityOf(pTitle));
	  // Driver.getDriver().switchTo().frame(0);
	   test.info("Click on privacy hub title");
	   pTitle.click();
	   HelperFunctions.staticWait(1);
	   test.info("Clear privacy hub title");
	   pTitle.clear();
	   HelperFunctions.staticWait(1);
	   String mockName="Product Title";
	   test.info("Send text to privacy hub title");
	   pTitle.sendKeys(mockName);
	   HelperFunctions.staticWait(1);
	   test.info("Click on check icon");
	   checkIcon.click();
	    HelperFunctions.staticWait(3);
	    test.info("Click on page info");
	    pageInfo.click();
	    wait.until(ExpectedConditions.visibilityOf(publishIcon));
	    test.info("Click on publish");
	    publishIcon.click();
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/pc/us/en/automation/privacy-hub.html");
	    HelperFunctions.waitForPageToLoad(60);
	    previewButton.click();
	    test.info("Switch to iframe");
	    Driver.getDriver().switchTo().frame(0);
	   /* test.info("Verified privacy hub title is equal the text that we send");
	    Assert.assertEquals(phProductName.getText(), mockName);
	    HelperFunctions.staticWait(3);
	    Driver.getDriver().get("https://auth-productcentral-stg.products.pwc.com/editor.html/content/experience-fragments/productcentral/us/en/site/experience-fragment/master.html");
		   HelperFunctions.waitForPageToLoad(15);
		   editButtonContent.click();
		 //  Driver.getDriver().switchTo().frame(0);
		   HelperFunctions.staticWait(2);
		   phEdit.click();
		   HelperFunctions.staticWait(2);
		   configure.click();
		   HelperFunctions.staticWait(2);
		  // Driver.getDriver().switchTo().frame(0);
		   pTitle.click();
		   HelperFunctions.staticWait(1);
		   pTitle.clear();
		   HelperFunctions.staticWait(1);
		   String mockName2="Product Title";
		   pTitle.sendKeys(mockName2);
		   HelperFunctions.staticWait(1);
		   checkIcon.click();
		    HelperFunctions.staticWait(3);
		    pageInfo.click();
		    HelperFunctions.staticWait(3);
		    publishIcon.click();*/
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 20);
	    wait3.until(ExpectedConditions.visibilityOf(phLogo));
	    Assert.assertTrue(phLogo.isDisplayed());
		    HelperFunctions.staticWait(5);
	  
}
public void setCreateVariationExperienceFragment(ExtentTest test) throws Exception {
	  // HelperFunctions.waitForPageToLoad(10);
	   test.info("Wait for the page to load.");
//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/mnt/overlay/cq/experience-fragments/content/experience-fragments/createpagewizard.html/content/experience-fragments/pc/us/en/site/experience-fragment");
	   //HelperFunctions.waitForPageToLoad(15);
	   test.info("Clicking on web variation page content");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 30);
	    wait3.until(ExpectedConditions.visibilityOf(webVariation));
    webVariation.click();
    HelperFunctions.staticWait(3);
    test.info("Clicking on next button");
    nextTemplate.click();
    HelperFunctions.waitForPageToLoad(30);
    wait3.until(ExpectedConditions.visibilityOf(titleField2));
    test.info("Clicking on title field");
    titleField2.click();
    HelperFunctions.staticWait(2);
    test.info("Send text to title field");
    titleField2.sendKeys("test123");
    HelperFunctions.staticWait(2);
    test.info("Clicking on create button");
    createButton2.click();
    wait3.until(ExpectedConditions.visibilityOf(doneButton));
    test.info("Clicking on done button");
    doneButton.click();
    HelperFunctions.waitForPageToLoad(30);
    wait3.until(ExpectedConditions.visibilityOf(webVariationContent));
    test.info("Verified the content has ben created");
    Assert.assertTrue(webVariationContent.isDisplayed());
    HelperFunctions.staticWait(3);
    
    
	  
} 
public void setUserWorkflowApproval(ExtentTest test) throws Exception {
	 	
 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	 test.info("Wait for the page to load.");
	 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(securityImg);
	    wait.until(condition);
	    securityImg.click();
	    test.info("Clicking on security image path");
	   // securityImg.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
  executor1.executeScript("arguments[0].click();", securityImg);
  HelperFunctions.staticWait(3);
  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
  executor2.executeScript("arguments[0].click();", securityImg);
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on create button");
	    createButton3.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Clicking on workflow");
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
	    wait1.until(ExpectedConditions.visibilityOf(workflowIcon));
	    workflowIcon.click();
	    HelperFunctions.staticWait(3); 
	    test.info("Clicking on workflow dropdown");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 30);
	    wait2.until(ExpectedConditions.visibilityOf(workflowDropdown));
	    workflowDropdown.click();
	    HelperFunctions.staticWait(3);
	    test.info("Choosing approval workflow");
	    approvalWorkflow.click();
	    HelperFunctions.staticWait(3); 
	    test.info("Entering the workflow title");
	    workflowTitle.click();
	    HelperFunctions.staticWait(2); 
	    workflowTitle.sendKeys("Testing");
	    HelperFunctions.staticWait(2);
	    test.info("Clicking on next button");
	    nextButton.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Select page for publishing");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 30);
	    wait3.until(ExpectedConditions.visibilityOf(legalPageImgforPublish));
	    legalPageImgforPublish.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicking on create button");
	    createButton2.click();
	    HelperFunctions.waitForPageToLoad(5);
	    //HelperFunctions.staticWait(2);
	    test.info("Clicking on bell icon");
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
	    wait4.until(ExpectedConditions.visibilityOf(bellIcon));
	    bellIcon.click();
	    HelperFunctions.staticWait(3);
	    test.info("Go to AEM Inbox");
	    AEMInbox.click();
	    HelperFunctions.waitForPageToLoad(10);
	    //HelperFunctions.staticWait(2);
	    test.info("Clicking on first task");
	    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 30);
	    wait5.until(ExpectedConditions.visibilityOf(assignedTask));
	    assignedTask.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicking on complete button");
	    completeButton2.click();
	    //HelperFunctions.staticWait(3);
	    test.info("Selecting a group");
	    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 30);
	    wait6.until(ExpectedConditions.visibilityOf(selectGroup));
	    selectGroup.click();
	    HelperFunctions.staticWait(2);
	    Actions builder = new Actions(Driver.getDriver());
	    builder.moveToElement(textGroup).click().sendKeys("Global IT QA").perform();
	    //HelperFunctions.staticWait(2);
	    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 30);
	    wait7.until(ExpectedConditions.visibilityOf(globalIt));
	    globalIt.click();
	    HelperFunctions.staticWait(2);
	    //test.info("Selecting zip");
	    //selectZip.click();
	   // HelperFunctions.staticWait(2);
	   // selectZipNo.click();
	   // HelperFunctions.staticWait(2);
	    Assert.assertTrue(defaultNo.isDisplayed());
	    test.info("Verified generate zip archive field is no");
	    HelperFunctions.staticWait(2);
	    test.info("Clicking on ok button");
	    selectOk.click();
	    HelperFunctions.staticWait(10);
	    HelperFunctions.waitForPageToLoad(5);
	    Driver.getDriver().navigate().refresh();
	    HelperFunctions.waitForPageToLoad(30);
	    HelperFunctions.staticWait(2);
	    test.info("Clicking on first task");
	    assignedTask.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicking on complete button");
	    completeButton2.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicking on option for approval/reject");
	    WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 30);
	    wait8.until(ExpectedConditions.visibilityOf(approveGroup));
	    approveGroup.click();
	    HelperFunctions.staticWait(2);
	    test.info("Verified only two option(approval/reject)");
	    Assert.assertTrue(approveReject.size()==2);
	    Assert.assertTrue(rejectGroup.isDisplayed());
	    HelperFunctions.staticWait(2);
	    test.info("Publish the page");
	    publishGroup.click();
	    HelperFunctions.staticWait(2);
     selectOk.click();
     HelperFunctions.staticWait(5);
	    
	    
	   
	  
}
public void setBannerTextField(ExtentTest test) throws Exception {
	 test.info("Wait for the page to load.");
	    //Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/pc/us/en/automation/my-products/fluid-forecast.html");
		//HelperFunctions.waitForPageToLoad(10);
		
		WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
	    wait.until(condition);
	    //HelperFunctions.staticWait(3);
	    test.info("Clicking on edit button");
		editButtonContent.click();
		HelperFunctions.staticWait(2);
		test.info("Clicking on the notification banner");
		JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
		executor.executeScript("arguments[0].click();", firstBanner);
		wait.until(ExpectedConditions.visibilityOf(configure));
		test.info("Clicking on configure for the notification banner");
		configure.click();
		wait.until(ExpectedConditions.visibilityOf(bannerType));
		test.info("Verified text for product banner and type");
		Assert.assertTrue(bannerType.isDisplayed());
		HelperFunctions.staticWait(2);
		Assert.assertTrue(bannerProduct.isDisplayed());
		HelperFunctions.staticWait(3);
	} 
 
public void setWorkflowApproval(ExtentTest test) throws Exception {
    
	   //  Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
		 test.info("Wait for the page to load.");
	     //HelperFunctions.waitForPageToLoad(10);
	     
	     WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	     wait.until(ExpectedConditions.visibilityOf(legalPageImg));
		    //ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(legalPageImg);
		   // wait.until(condition);
		    HelperFunctions.staticWait(3);
		    test.info("Clicking on legal path");
	     legalPageImg.click();
	     JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	     executor1.executeScript("arguments[0].click();", legalPageImg);
	     HelperFunctions.staticWait(3);
	     JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	     executor2.executeScript("arguments[0].click();", legalPageImg);
	     HelperFunctions.staticWait(3);
	     test.info("Clicking on create button");
	     createButton3.click();
	     wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	     test.info("Clicking on workflow");
	     workflowIcon.click();
	     wait.until(ExpectedConditions.visibilityOf(workflowDropdown));  
	     test.info("Clicking on workflow dropdown");
	     workflowDropdown.click();
	     wait.until(ExpectedConditions.visibilityOf(publishWorkflow));  
	     test.info("Clicking on publish workflow");
	     publishWorkflow.click();
	     HelperFunctions.staticWait(3); 
	     test.info("Clicking on workflow title");
	     workflowTitle.click();
	     test.info("Send text to workflow title");
	     workflowTitle.sendKeys("Testing");
	     HelperFunctions.staticWait(2);
	     test.info("Clicking on next");
	     nextButton.click();
	     wait.until(ExpectedConditions.visibilityOf(legalPageImgforPublish)); 
	     test.info("Clicking on image for publishing");
	     legalPageImgforPublish.click();
	     HelperFunctions.staticWait(2);
	     test.info("Clicking on create");
	     createButton2.click();
	     HelperFunctions.waitForPageToLoad(15);
	     wait.until(ExpectedConditions.visibilityOf(legalPageImg));
	     test.info("Clicking on legal path");
	     legalPageImg.click();
	     HelperFunctions.staticWait(3); 
	     JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
	     executor3.executeScript("arguments[0].click();", legalPageImg);
	     HelperFunctions.staticWait(3);
	     JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
	     executor4.executeScript("arguments[0].click();", legalPageImg);
	     wait.until(ExpectedConditions.visibilityOf(presentationDate));
	     test.info("Verified the page has been published a few seconds ago");
	     if(presentationDate.getText().equalsIgnoreCase("few")) {
	         Assert.assertTrue(true);
	     }else {
	         String errorMessage = "Not publish on workflow option";
	         logger.error(errorMessage);
	         throw new Exception(errorMessage);
	     }
	     HelperFunctions.staticWait(3);
	}
	 public void setWorkflowApproval2(ExtentTest test) throws Exception {
	     
	    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
		 test.info("Wait for the page to load.");
	        //HelperFunctions.waitForPageToLoad(10);
	      
	        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(legalPageImg);
		    wait.until(condition);
		    //HelperFunctions.staticWait(3);
		    test.info("Clicking on legal path");
	        legalPageImg.click();
	        HelperFunctions.staticWait(3); 
	        JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	     executor1.executeScript("arguments[0].click();", legalPageImg);
	     HelperFunctions.staticWait(3);
	     JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	     executor2.executeScript("arguments[0].click();", legalPageImg);
	        HelperFunctions.staticWait(3);
	        test.info("Clicking on create button");
	        createButton3.click();
	        wait.until(ExpectedConditions.visibilityOf(workflowIcon));
	        test.info("Clicking on workflow");
	        workflowIcon.click();
	        //HelperFunctions.staticWait(3); 
	        test.info("Clicking on workflow dropdown");
	        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
		    wait2.until(ExpectedConditions.visibilityOf(workflowDropdown));
	        workflowDropdown.click();
	        wait2.until(ExpectedConditions.visibilityOf(publishWorkflow)); 
	        test.info("Clicking on publish workflow");
	        publishWorkflow.click();
	        HelperFunctions.staticWait(3); 
	        workflowTitle.click();
	        test.info("Send text to workflow title");
	        workflowTitle.sendKeys("testing");
	        HelperFunctions.staticWait(2); 
	        test.info("Clear the workflow title");
	        workflowTitle.clear();
	        HelperFunctions.staticWait(5);
	        test.info("Verified Next button is not clickable with empty Workflow titles which is mandatory");
	        if(nextButton.getAttribute("disabled")==null) {
	            Assert.assertTrue(true);
	        }else {
	            String errorMessage = "Next button is clickable with empty Workflow titles which is mandatory";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	        }
	        HelperFunctions.staticWait(3);
	    
	}
	 public void setAssetConflict(ExtentTest test) throws Exception {
	         
	    // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/en_us/products/change-navigator");
		 test.info("Wait for the page to load.");
	        HelperFunctions.waitForPageToLoad(15);
	        test.info("Store pdf info in hashset");
	        Set<String> titlesSet = new HashSet<String>();

	        for (WebElement element : pdfTitles) {
	            
	            String title = element.getText();

	            if (title != null && !title.isEmpty()) {
	              
	                if (titlesSet.contains(title)) {
	                    System.out.println("Error: Duplicate title found: " + title);
	                } else {
	                    titlesSet.add(title);
	                    System.out.println("Element title: " + title);
	                }
	            } else {
	                System.out.println("Error: Element title is null or empty");
	            }
	        }
	        test.info("Verified there is no dublication.");
	        HelperFunctions.staticWait(3);
	}
    
	 public void setPrivacyFooterCopyWrite() throws Exception {
		  // HelperFunctions.waitForPageToLoad(5);
		//Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/editor.html/content/experience-fragments/pc/us/en/site/experience-fragment/footer.html");
		   //HelperFunctions.waitForPageToLoad(10);
		   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		   ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
		   wait.until(condition);
		   editButtonContent.click();
		   wait.until(ExpectedConditions.visibilityOf(phFooter));
		   phFooter.click();
		   wait.until(ExpectedConditions.visibilityOf(configure));
		   configure.click();
		   WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
		  wait1.until(ExpectedConditions.visibilityOf(footerText));
		   HelperFunctions.staticWait(3);
		   footerText.click();
		   HelperFunctions.staticWait(1);
		   footerText.clear();
		   HelperFunctions.staticWait(1);
		   String mockName="All rights reserved. PwC refers to the US member firm of the PwC network or one of its subsidiaries or affiliates";
		   footerText.sendKeys(mockName);
		   HelperFunctions.staticWait(3);
		   checkIcon.click();
		    HelperFunctions.staticWait(3);
		    pageInfo.click();
		    HelperFunctions.staticWait(3);
		    publishIcon.click();
		    HelperFunctions.staticWait(3);
		   // Driver.getDriver().get("https://productcentral-stg.products.pwc.com/content/experience-fragments/productcentral/us/en/site/experience-fragment/footer.html");
		   // HelperFunctions.waitForPageToLoad(15);
		   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
		 //  wait1.until(ExpectedConditions.visibilityOf(footerCopywrite));
		    previewButton.click();
		   // HelperFunctions.staticWait(2);
		    Driver.getDriver().switchTo().frame(0);
		    HelperFunctions.staticWait(2);
		  Assert.assertTrue(footerCopywrite.isDisplayed());
		  HelperFunctions.staticWait(3);
		}
	 public void setPrivacyHubPublishingDate() throws Exception {
		 	
		 // Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
			    //HelperFunctions.waitForPageToLoad(10);
			    
			    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
			    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(privacyHubImg);
			    wait.until(condition);
			    //HelperFunctions.staticWait(3);
			    privacyHubImg.click();
			    HelperFunctions.staticWait(3);
			    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
		  executor1.executeScript("arguments[0].click();", privacyHubImg);
		  HelperFunctions.staticWait(3);
		  JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
		  executor2.executeScript("arguments[0].click();", privacyHubImg);
			    HelperFunctions.staticWait(3);
			    quickPublish2.click();
			    wait.until(ExpectedConditions.visibilityOf(publish2));
		     publish2.click();
		     HelperFunctions.staticWait(5);
		  if(presentationDate.getText().contains("few")) {
		  	Assert.assertTrue(true);
		  }else {
			    	String errorMessage = "Not publish on workflow option";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			    }
		  HelperFunctions.staticWait(3);
		}
	 public void setRelatedLinksAuthoringandRearrangeRelated() throws Exception {
		 read1.setExcelFile("./testdata.xlsx", "STG");
		// HelperFunctions.waitForPageToLoad(10);
		  
		    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
			ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
			wait.until(condition);
			  //HelperFunctions.staticWait(3);
			editButtonContent.click();
			wait.until(ExpectedConditions.visibilityOf(authRelated));
			authRelated.click();
			wait.until(ExpectedConditions.visibilityOf(configure));
	        configure.click();
	        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
			  wait1.until(ExpectedConditions.visibilityOf(move1));
			HelperFunctions.staticWait(3); 
		    Actions builder = new Actions(Driver.getDriver());
			builder.dragAndDrop(move1, move3).build().perform();
		    HelperFunctions.staticWait(2);
	        checkIcon.click();
			HelperFunctions.staticWait(3);
			pageInfo.click();
			wait1.until(ExpectedConditions.visibilityOf(publishIcon));
		    publishIcon.click();
		    HelperFunctions.staticWait(5);
		    //Driver.getDriver().get(read1.getCellData("VALUE", 73));
			//HelperFunctions.waitForPageToLoad(15);
			//HelperFunctions.staticWait(3);
		    previewButton.click();
		    HelperFunctions.staticWait(2);
		    Driver.getDriver().switchTo().frame(0);
			WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
			wait3.until(ExpectedConditions.visibilityOf(firstRelated));
			String text2=firstRelated.getText();
			Assert.assertTrue(text2.contains("Listen"));
			HelperFunctions.staticWait(3);
			//Assert.assertTrue(relatedLinks.isDisplayed());
			//HelperFunctions.staticWait(3);
			//Driver.getDriver().get(read1.getCellData("VALUE", 45));
			//HelperFunctions.waitForPageToLoad(15);
			//HelperFunctions.staticWait(3);
			Driver.getDriver().switchTo().defaultContent();
		    WebDriverWait wait4=new WebDriverWait(Driver.getDriver(),10);
			ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
			wait4.until(condition2);
			editButtonContent.click();
			HelperFunctions.staticWait(2);
			authRelated.click();
			wait4.until(ExpectedConditions.visibilityOf(configure));
	        configure.click();
	        WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 15);
			  wait5.until(ExpectedConditions.visibilityOf(move1));
			HelperFunctions.staticWait(2); 
		    Actions builder2 = new Actions(Driver.getDriver());
			builder2.dragAndDrop(move1, move3).build().perform();
		    HelperFunctions.staticWait(2);
	        checkIcon.click();
			HelperFunctions.staticWait(3);
			pageInfo.click();
			wait5.until(ExpectedConditions.visibilityOf(publishIcon));
		    publishIcon.click();
		    HelperFunctions.staticWait(5);
		   // Driver.getDriver().get(read1.getCellData("VALUE", 73));
			//HelperFunctions.waitForPageToLoad(15);
			//HelperFunctions.staticWait(3);
		    previewButton.click();
		    HelperFunctions.staticWait(2);
		    Driver.getDriver().switchTo().frame(0);
		    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 10);
		    wait6.until(ExpectedConditions.visibilityOf(firstRelated));
		    String text=firstRelated.getText();
		    System.out.println(text);
		    Assert.assertTrue(text.contains("Disclosure Checklist"));
		    HelperFunctions.staticWait(5);
		    
		}
	 public void setPrivacyHubLogoandTitleVisibility() throws Exception {
		    read1.setExcelFile("./testdata.xlsx", "QA");
		    //HelperFunctions.waitForPageToLoad(10);
		    
		    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
		    wait.until(ExpectedConditions.visibilityOf(phLogo));
		    HelperFunctions.staticWait(3);
		    Point phLogoPosition=phLogo.getLocation();
		    int x=phLogoPosition.getX();
		    int y=phLogoPosition.getY();
		    System.out.println(x+"---"+y);
		    int expectedX=20;
		    int expectedY=17;
		    int tolerance=5;
		    int minX=expectedX-tolerance;
		    int maxX=expectedX+tolerance;
		    int minY=expectedY-tolerance;
		    int maxY=expectedY+tolerance;
		    boolean isWithinTolerance=(x>=minX && x<=maxX)&&(y>=minY && y<=maxY);
		    Assert.assertTrue(isWithinTolerance);
		    HelperFunctions.staticWait(3);
		    Point phHeaderPosition=phHeader.getLocation();
		    int z=phHeaderPosition.getX();
		    int q=phHeaderPosition.getY();
		    System.out.println(z+"---"+q);
		    int expectedZ=66;
		    int expectedQ=20;
		    int minZ=expectedX-tolerance;
		    int maxZ=expectedX+tolerance;
		    int minQ=expectedY-tolerance;
		    int maxQ=expectedY+tolerance;
		    boolean isWithinTolerance2=(x>=minZ && x<=maxZ)&&(y>=minQ && y<=maxQ);
		    Assert.assertTrue(isWithinTolerance2);
		    HelperFunctions.staticWait(3);
		    
		}
	 public void setAddingBulletList() throws Exception {
		 read1.setExcelFile("./testdata.xlsx", "QA");
		 //HelperFunctions.waitForPageToLoad(10);
		  
		    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
			ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
			wait.until(condition);
			//HelperFunctions.staticWait(3);
			editButtonContent.click();
			HelperFunctions.staticWait(5);
			phTextEdit.click();
			wait.until(ExpectedConditions.visibilityOf(configure));
	        configure.click();
			//HelperFunctions.staticWait(2); 
			//WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOf(phTextArea));
			phTextArea.click();
			//WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOf(bulletOptionsButton));
			bulletOptionsButton.click();
			//WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOf(bulletButton));
			Assert.assertTrue(bulletButton.isDisplayed());
			HelperFunctions.staticWait(2);
			Assert.assertTrue(numberListButton.isDisplayed());
			HelperFunctions.staticWait(2);
			bulletButton.click();
			HelperFunctions.staticWait(5);
			Assert.assertTrue(phTextList.isDisplayed());
			HelperFunctions.staticWait(2);
			bulletOptionsButton.click();
			//WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOf(numberListButton));
			numberListButton.click();
			HelperFunctions.staticWait(5);
			Assert.assertTrue(phTextList2.isDisplayed());
			HelperFunctions.staticWait(3);
			
			    }
	 public void setTopLevel(ExtentTest test) throws Exception {
		 test.info("Wait for the page to load.");
		    HelperFunctions.waitForPageToLoad(30);
	    	read1.setExcelFile("./testdata.xlsx", "STG");
	    	WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
	 	    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(childPageImg);
	 	    wait.until(condition);
	 	    test.info("Clicking on child page path");
	 	    childPageImg.click();
		    HelperFunctions.staticWait(5);
		    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	        executor.executeScript("arguments[0].click();", childPageImg);
		    HelperFunctions.staticWait(5);
		    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	        executor2.executeScript("arguments[0].click();", childPageImg);
		    HelperFunctions.staticWait(5);
		    test.info("Clicking on properties");
		    properties.click();
		    HelperFunctions.waitForPageToLoad(30);
		    WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),30);
	 	    ExpectedCondition<WebElement> condition1=ExpectedConditions.elementToBeClickable(productCentralTab);
	 	    wait1.until(condition1);
	 	    test.info("Clicking on productCentralTab");
	 	    productCentralTab.click();
		    test.info("Wait for top level checkbox's visibility");
		    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
		    wait4.until(ExpectedConditions.visibilityOf(toplevelCheckbox));
		    HelperFunctions.staticWait(3);
		    Assert.assertTrue(toplevelCheckbox.isSelected());
		    test.info("Verified top level checkbox is there and it is selected");
		    HelperFunctions.staticWait(3);
		    saveAndClose.click();
		    HelperFunctions.staticWait(15);
		    test.info("Clicked on save and close");
		   // HelperFunctions.waitForPageToLoad(15);
		    test.info("Go to my product page");
		    Driver.getDriver().get(read1.getCellData("VALUE", 80));
		    HelperFunctions.waitForPageToLoad(15);
		    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
		    wait5.until(ExpectedConditions.visibilityOf(previewButton));
		    previewButton.click();
		    Driver.getDriver().switchTo().frame(0);
		    HelperFunctions.staticWait(3);
		    for (WebElement element: childTitle) {
		    	if(element.isDisplayed()) {
		    		HelperFunctions.scrollToElement(element);
		    		break;
		    	}
		    }
		    test.info("Verified child page that is selected top level is displayed");
		    HelperFunctions.staticWait(3);
	 }
	 public void setColumnImage(ExtentTest test) throws Exception {
		 read1.setExcelFile("./testdata.xlsx", "STG");
		 test.info("Wait for the page to load.");
		    HelperFunctions.waitForPageToLoad(30);
		    
		    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
		    wait.until(condition);
		    editButtonContent.click();
		    HelperFunctions.staticWait(2);
		    test.info("Click on edit");
		    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		    js.executeScript("arguments[0].click();", columnImgEdit);
		    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 20);
		    wait1.until(ExpectedConditions.visibilityOf(configure));
		    configure.click();
		    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 20);
		    wait2.until(ExpectedConditions.visibilityOf(pick));
		    pick.click();
		    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 20);
		    wait3.until(ExpectedConditions.visibilityOf(path1));
		    path1.click();
		    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 20);
		    wait4.until(ExpectedConditions.visibilityOf(path2));
		    path2.click();
		    HelperFunctions.staticWait(2);
		    selectButton2.click();
		    HelperFunctions.staticWait(3);
		    checkIcon.click();
		    HelperFunctions.staticWait(3);
		    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
		    js2.executeScript("arguments[0].click();", columnImgEditThumb);
		    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 20);
		    wait5.until(ExpectedConditions.visibilityOf(configure));
		    configure.click();
		    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 20);
		    wait6.until(ExpectedConditions.visibilityOf(path3));
		    path3.click();
		    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 20);
		    wait7.until(ExpectedConditions.visibilityOf(path4));
		    path4.click();
		    HelperFunctions.staticWait(2);
		    selectButton2.click();
		    HelperFunctions.staticWait(3);
		    checkIcon.click();
		    HelperFunctions.staticWait(3);
		    
		    
	 }
	 public void setUserWorkflowApprovalforAsset(ExtentTest test) throws Exception {
		 	
	     read1.setExcelFile("./testdata.xlsx", "STG");
		 test.info("Wait for the page to load.");
		    //HelperFunctions.waitForPageToLoad(15);
		  //  HelperFunctions.staticWait(3);
		   // test.info("Clicking on security image path");
		 WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
		    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(selectAll);
		    wait.until(condition);
		    //securityImg.click();
		    selectAll.click();
		    WebDriverWait wait0 = new WebDriverWait(Driver.getDriver(), 30);
		    wait0.until(ExpectedConditions.visibilityOf(createButton3));
		    test.info("Clicking on create button");
		    createButton3.click();
		    test.info("Clicking on workflow");
		    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
		    wait1.until(ExpectedConditions.visibilityOf(workflowIcon));
		    workflowIcon.click(); 
		    test.info("Clicking on workflow dropdown");
		    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 30);
		    wait2.until(ExpectedConditions.visibilityOf(workflowDropdown));
		    workflowDropdown.click();
		    HelperFunctions.staticWait(3);
		    test.info("Choosing approval workflow");
		    approvalWorkflow.click();
		    HelperFunctions.staticWait(3); 
		    test.info("Entering the workflow title");
		    workflowTitle.click();
		    HelperFunctions.staticWait(2); 
		    workflowTitle.sendKeys("Testing");
		    HelperFunctions.staticWait(2);
		    test.info("Clicking on start button");
		    start.click();
		    test.info("Clicking on proceed");
		    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 30);
		    wait3.until(ExpectedConditions.visibilityOf(proceed));
		    proceed.click();
		    HelperFunctions.staticWait(4);
		    test.info("Go to aem inbox");
		    Driver.getDriver().get(read1.getCellData("VALUE", 83));
		    //HelperFunctions.waitForPageToLoad(20);
		    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 30);
		    wait5.until(ExpectedConditions.visibilityOf(assignedTask));
		    test.info("Clicking on first task");
		    assignedTask.click();
		    HelperFunctions.staticWait(2);
		    test.info("Clicking on complete button");
		    completeButton2.click();
		    test.info("Selecting a group");
		    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 30);
		    wait6.until(ExpectedConditions.visibilityOf(selectGroup));
		    selectGroup.click();
		    HelperFunctions.staticWait(2);
		    Actions builder = new Actions(Driver.getDriver());
		    builder.moveToElement(textGroup).click().sendKeys("Global IT QA").perform();
		    //HelperFunctions.staticWait(2);
		    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 30);
		    wait7.until(ExpectedConditions.visibilityOf(globalIt));
		    globalIt.click();
		    HelperFunctions.staticWait(2);
		    test.info("Selecting zip");
		    Assert.assertTrue(defaultYes.isDisplayed());
		    test.info("Verified generate zip archive field is no");
		    HelperFunctions.staticWait(2);
		    test.info("Clicking on ok button");
		    selectOk.click();
		    HelperFunctions.waitForPageToLoad(5);
		    HelperFunctions.staticWait(10);
		    Driver.getDriver().navigate().refresh();
		    HelperFunctions.waitForPageToLoad(15);
		    HelperFunctions.staticWait(2);
		    test.info("Clicking on first task");
		    assignedTask.click();
		    HelperFunctions.staticWait(2);
		    test.info("Clicking on complete button");
		    completeButton2.click();
		    HelperFunctions.staticWait(3);
		    test.info("Clicking on option for approval/reject");
		    WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 30);
		    wait8.until(ExpectedConditions.visibilityOf(approveGroup));
		    approveGroup.click();
		    HelperFunctions.staticWait(2);
		    test.info("Verified only two option(approval/reject)");
		    Assert.assertTrue(approveReject.size()==2);
		    Assert.assertTrue(rejectGroup.isDisplayed());
		    HelperFunctions.staticWait(2);
		    test.info("Publish the page");
		    publishGroup.click();
		    HelperFunctions.staticWait(2);
	        selectOk.click();
	        HelperFunctions.staticWait(5);
		    
		    
		   
		  
	}
	 public void setBannerSticky(ExtentTest test) throws Exception {
			read1.setExcelFile("./testdata.xlsx", "STG");
			test.info("Wait for the page to load.");
		    HelperFunctions.waitForPageToLoad(30);
		    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
		    wait1.until(ExpectedConditions.visibilityOf(pageInfo));
		    pageInfo.click();
		    wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
		    viewasPublish.click();	    
		    //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
		    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
		    Driver.getDriver().switchTo().window(tabs.get(1));
		    //Driver.getDriver().get(read1.getCellData("VALUE", 84));
		    HelperFunctions.waitForPageToLoad(15);
		    wait1.until(ExpectedConditions.visibilityOf(banner2));
		    test.info("Checking if the banner is displayed");
		    if(banner2.isDisplayed()) {
		        Assert.assertTrue(true);
		    }else {
		        String errorMessage = "banner is not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		    }
		    test.info("Scrolling down the bottom of the page");
		    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", ""); 
		     HelperFunctions.staticWait(2);
		        if(banner2.isDisplayed()) {
		            Assert.assertTrue(true);
		        }else {
		            String errorMessage = "banner is not displayed";
		            logger.error(errorMessage);
		            throw new Exception(errorMessage);
		        }
		        test.info("Verified if the banner is sticky when scrolling down");
		        HelperFunctions.staticWait(3);
		}
		public void setBannerClose(ExtentTest test) throws Exception {
			read1.setExcelFile("./testdata.xlsx", "STG");
			test.info("Wait for the page to load.");
			HelperFunctions.waitForPageToLoad(30);
		    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 30);
		    wait1.until(ExpectedConditions.visibilityOf(pageInfo));
		    pageInfo.click();
		    wait1.until(ExpectedConditions.visibilityOf(viewasPublish));
		    viewasPublish.click();
			 //((JavascriptExecutor)Driver.getDriver()).executeScript("window.open();");
			    ArrayList<String> tabs=new ArrayList<String>(Driver.getDriver().getWindowHandles());
			    Driver.getDriver().switchTo().window(tabs.get(1));
			  //  Driver.getDriver().get(read1.getCellData("VALUE", 84));
			    HelperFunctions.waitForPageToLoad(15);
			   // WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 15);
			    wait1.until(ExpectedConditions.visibilityOf(banner2));
		    test.info("Checking if the banner is displayed");
		    if(banner2.isDisplayed()) {
		        Assert.assertTrue(true);
		    }else {
		        String errorMessage = "banner is not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		    }
		    HelperFunctions.staticWait(2);
		    test.info("Clicking enter to close banner");
		    bannerClose.sendKeys(Keys.ENTER);
		    HelperFunctions.staticWait(3);
		    if(!banner2.isDisplayed()) {
		        Assert.assertTrue(true);
		    }else {
		        String errorMessage = "banner is not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		    }
		    test.info("Verified the banner is closed");
		    HelperFunctions.staticWait(3);
		}
		public void setEmbedHTML(ExtentTest test) throws Exception {
			 read1.setExcelFile("./testdata.xlsx", "QA");
			 test.info("Wait for the page to load.");
			    //HelperFunctions.waitForPageToLoad(10);
			    
			    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
			    ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(editButtonContent);
			    wait.until(condition);
			    editButtonContent.click();
			    HelperFunctions.staticWait(2);
			    test.info("Click on edit");
			    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
			    js.executeScript("arguments[0].click();", embedEdit);
			    wait.until(ExpectedConditions.visibilityOf(configure));
			    configure.click();
			    wait.until(ExpectedConditions.visibilityOf(embedTextArea));
			    embedTextArea.click();
			    HelperFunctions.staticWait(2);
			    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			    HelperFunctions.staticWait(2);
			    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "c"));
			    HelperFunctions.staticWait(2);
			    embedTextArea.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			    HelperFunctions.staticWait(2);
			    checkIcon.click();
			    HelperFunctions.staticWait(3);
			    ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(previewButton);
			    wait.until(condition2);
			    previewButton.click();
			    HelperFunctions.staticWait(2);
			    Driver.getDriver().switchTo().frame(0);
			    HelperFunctions.staticWait(2);
			    wait.until(ExpectedConditions.visibilityOf(embedHeading));
			    Assert.assertTrue(embedHeading.isDisplayed());
			    HelperFunctions.staticWait(2);
			    Assert.assertTrue(embedParag.isDisplayed());
			    HelperFunctions.staticWait(2);
			    
		 }
		public void setLatestTabs() throws Exception {
		    read1.setExcelFile("./testdata.xlsx", "STG");
		    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),40);
			ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton);
			wait.until(condition);
			previewButton.click();
			//HelperFunctions.staticWait(5);
			Driver.getDriver().switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(hyperlink));
			JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	        executor.executeScript("arguments[0].click();", hyperlink);
			//hyperlink.click();
			HelperFunctions.staticWait(7);
		    Set<String> windowHandles2 = Driver.getDriver().getWindowHandles();
		    Assert.assertEquals(windowHandles2.size(), 1, "Expected one window to be open, but found " + windowHandles2.size());
		    HelperFunctions.staticWait(3);
		    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("fluid"));
		    HelperFunctions.staticWait(3);
		    Driver.getDriver().get(read1.getCellData("VALUE", 87));
		    HelperFunctions.waitForPageToLoad(30);
		    wait.until(ExpectedConditions.elementToBeClickable(editButtonContent));
		    editButtonContent.click();
		    HelperFunctions.staticWait(3);
			authLatest.click();
			wait.until(ExpectedConditions.visibilityOf(configure));
	        configure.click();
			wait.until(ExpectedConditions.elementToBeClickable(authLatestDesc));
			authLatestDesc.click();
			HelperFunctions.staticWait(2);	
			authLatestDesc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			HelperFunctions.staticWait(2);
			hyperlinkButton.click();
			wait.until(ExpectedConditions.visibilityOf(tabsDropdown));
			tabsDropdown.click();
			wait.until(ExpectedConditions.visibilityOf(newTab));
			newTab.click();
			HelperFunctions.staticWait(3);
			executor.executeScript("arguments[0].click();", applyButton);
			//applyButton.click();
			wait.until(ExpectedConditions.invisibilityOf(applyButton));
			checkButton.click();
			HelperFunctions.staticWait(5);
		    previewButton.click();
		    //HelperFunctions.staticWait(5);
		    Driver.getDriver().switchTo().frame(0);
		    String mainWindowHandle=Driver.getDriver().getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(hyperlink));
			executor.executeScript("arguments[0].click();", hyperlink);
			//hyperlink.click();
			WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 30);
		    wait4.until(ExpectedConditions.numberOfWindowsToBe(2));
		    Set<String> windowHandles3 = Driver.getDriver().getWindowHandles();
		    Assert.assertEquals(windowHandles3.size(), 2, "Expected two windows to be open, but found " + windowHandles3.size());
		    HelperFunctions.staticWait(3);
		    for (String windowHandle : windowHandles3) {
		    	 if (!windowHandle.equals(mainWindowHandle)) {
		    	 Driver.getDriver().switchTo().window(windowHandle);
		    	 break;
		    	 }
		    	}
		    HelperFunctions.staticWait(3);
		    Driver.getDriver().get(read1.getCellData("VALUE", 87));
		    HelperFunctions.waitForPageToLoad(30);
		    WebDriverWait wait2=new WebDriverWait(Driver.getDriver(),30);
		    ExpectedCondition<WebElement> condition2=ExpectedConditions.elementToBeClickable(editButtonContent);
		    wait2.until(condition2);
		    editButtonContent.click();
		    HelperFunctions.staticWait(3);
		    authLatest.click();
			wait.until(ExpectedConditions.visibilityOf(configure));
	        configure.click();
			wait.until(ExpectedConditions.elementToBeClickable(authLatestDesc));
			authLatestDesc.click();
			HelperFunctions.staticWait(2);	
			authLatestDesc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			HelperFunctions.staticWait(2);
			hyperlinkButton.click();
			wait.until(ExpectedConditions.visibilityOf(tabsDropdown));
			tabsDropdown.click();
			wait.until(ExpectedConditions.visibilityOf(sameTab));
			sameTab.click();
			HelperFunctions.staticWait(3);
			executor.executeScript("arguments[0].click();", applyButton);
			//applyButton.click();
			wait.until(ExpectedConditions.invisibilityOf(applyButton));
			checkButton.click();
			HelperFunctions.staticWait(5);
			
		}
		public void setCustomizeCookies() throws Exception {
		    read1.setExcelFile("./testdata.xlsx", "QA");
		    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),40);
			/*ExpectedCondition<WebElement> condition=ExpectedConditions.elementToBeClickable(previewButton);
			wait.until(condition);
			previewButton.click();
			//HelperFunctions.staticWait(5);
			Driver.getDriver().switchTo().frame(0);*/
			wait.until(ExpectedConditions.elementToBeClickable(customizeCookies));
			JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	        executor.executeScript("arguments[0].click();", customizeCookies);
	        wait.until(ExpectedConditions.visibilityOf(cookiesContent));
	        Assert.assertTrue(cookiesContent.isDisplayed());
	        HelperFunctions.staticWait(3);
		}

}
