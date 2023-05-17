package StepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pages.homePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class steps_ShubhamKumbhar {
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	@Before 
	public void SetUp() {
// Setting up to perform Test
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("user on goibibo page")
	public void user_on_goibibo_page() {
	   homePage objtrip= new homePage(driver) ;
	   
//Checking the Home page is opened or not.
	   String expect = "https://www.goibibo.com/";
	   String url = driver.getCurrentUrl();
	   System.out.println("We get: "+url);
	   
	   Assert.assertEquals(expect, url);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("user select Oneway trip on goibibo page")
	public void user_select_oneway_trip_on_goibibo_page() {
		homePage objtrip= new homePage(driver) ;
		
//Clicking on Oneway Trip Radio Button
	    objtrip.clickOneway();
	}

	@When("user select the start and end point of travelling location for Onewaytrip")
	public void user_select_the_start_and_end_point_of_travelling_location_for_Onewaytrip(DataTable dataTable) {
		homePage objtrip= new homePage(driver) ;
		
//Creating action to perform operations related to traveling. 
		Actions act = new Actions(driver);
		
//Entering Starting point of traveling.
		objtrip.clickFrom();
		WebElement start = objtrip.enterFrom();		
		//act.click(start).perform();
		
// Listing up the data from datatable.
		List<List<String>> traveller = dataTable.asLists(String.class);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		act.sendKeys(start,traveller.get(0).get(0));
		act.pause(1000).perform();
		//act.sendKeys(start, Keys.DOWN);
		act.sendKeys(start,Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
//Entering destination of traveling.
		
		objtrip.clickTo();
		WebElement end = objtrip.enterDestination();
		act.sendKeys(end, traveller.get(0).get(1));
		act.pause(1000).perform();
		//act.sendKeys(end, Keys.ARROW_DOWN);
		act.sendKeys(end,Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
	}

	@When("user select Departure date and future returning date")
	public void user_select_departure_date_and_future_returning_date(DataTable dataTable) {
		homePage objtrip= new homePage(driver) ;
		
//Selecting Departure date

//Creating list of future date from data-table.
		List<List<String>> dDate = dataTable.asLists(String.class);
		String Month = dDate.get(0).get(0);
		String Year = dDate.get(0).get(1);
		
		while(true) {

//Selecting Departure Month and Year as shown in feature file.
			
			String monthyear = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div")).getText();
			System.out.println("We get The Month and Year: "+monthyear);
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			//System.out.println("Month : "+mon);
			String yr = arr[1];
			
			//System.out.println("Year : "+yr);
			if(Month.equalsIgnoreCase(mon) && Year.equals(yr)) {
				break;
			}
			else {
				driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				objtrip.clickNextMonthArrow();
			}
		}
//Creating the list of all days and choosing particular date which shown in feature file.
		
		List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div//p[1]"));
		 //System.out.println("Data: "+dDate.get(0).get(2));
		  for(WebElement ele:allDates) {	 
			  String dt = ele.getText();
			  System.out.println(dt);
			  String get = dDate.get(0).get(2);
			  if(dt.equals(get)) {
				  System.out.println("Departure Date: "+dt);
				  ele.click();
				  break;
			  }
		  }
		//Select Future Date
		
//Creating list of future date from data-table.
		
		List<List<String>> dDate1 = dataTable.asLists(String.class);
		String Month1 = dDate1.get(0).get(3);
		String Year1 = dDate1.get(0).get(4);
		objtrip.clickFuture();
		
//Selecting Future Month and Year as shown in feature file.
		
		while(true) {
			String monthyear1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div")).getText();
			System.out.println("Future Date and Month : "+monthyear1);
			String arr1[] = monthyear1.split(" ");
			
			String mon1 = arr1[0];
			String yr1 = arr1[1];
			System.out.println("Fut Month : "+mon1);
			System.out.println("Fut Month : "+yr1);
			if(Month1.equalsIgnoreCase(mon1) && Year1.equals(yr1)) {
				System.out.println("Equal : "+monthyear1);
				break;
			}
			else {
				driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				objtrip.clickNextMonthArrow();
			}
		}

//Creating the list of all days and choosing particular date which shown in feature file.
		
		List<WebElement> allDates1 = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div//p"));
		  
		  for(WebElement ele:allDates1) {
			 
			  String dt = ele.getText();
			  System.out.println("We Get: "+dt);
			  String get = dDate.get(0).get(5);
			  if(dt.equals(get)) {
				  ele.click();
				  break;
			  }
		  }
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,200)");
		  
		  objtrip.clickDatedone();
		  driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}

	@When("user select the travelling details as Student and travel class from page")
	public void user_select_the_travelling_details_as_Student_and_travel_class_from_page() {
		homePage objtrip= new homePage(driver) ;

//Selecting Fare type and traveling details.
		
	    //objtrip.clickTravelclass();
	    //objtrip.clickAdultadd();
	    //objtrip.clickChildadd();
	    //objtrip.ClickInfantadd();
	   // driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	    //objtrip.clickEconomy();
		objtrip.clickStudent();
	    driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	    objtrip.clickClassdone();
	    
	    
	}

	@When("user search and select cheapest price")
	public void user_search_and_select_cheapest_price() {
		homePage objtrip= new homePage(driver) ;
		
//Clicking on Search button.
	    objtrip.clickSearchFlight();
	    driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}

	@When("user click on Book now button")
	public void user_click_on_book_now_button() {
		homePage objtrip= new homePage(driver) ;
		
		//Performing actions on Booking flight.
		if(driver.getPageSource().contains(objtrip.getInsideText())) {
			System.out.println("Welcome! Now You can Book Your Flight and View Flight Details.");
			
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		    objtrip.clickBook();
		}else {
			System.out.println("This Page is Unable to load< Try again later. ");
		}
		
		
	}

	@Then("user should get details regarding booking")
	public void user_should_get_details_regarding_booking() {
		homePage objtrip= new homePage(driver) ;
		
//Getting the information related booked flights.
		
		if(driver.getPageSource().contains(objtrip.getFinalText())) {
			   String Travel = objtrip.getTravelDetails();
			   System.out.println("Get Travelling details: "+Travel);
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
			   String Return = objtrip.getReturnDetails();
			   System.out.println("Get Returning details: "+Return);
		}
		else {
			System.out.println("Currently Page is Down, Try Later.");
		}
	   
	}

	@When("user select Round trip on goibibo page")
	public void user_select_round_trip_on_goibibo_page() {
		homePage objtrip= new homePage(driver) ;

//Selecting Roundtrip button.	
	    
		objtrip.clickOnroundtrip();
	
	}
	@When("user select the start and end point of travelling location for Roundtrip")
	public void user_select_the_start_and_end_point_of_travelling_location_for_Roundtrip(DataTable dataTable) {
		homePage objtrip= new homePage(driver) ;

//Creating action to perform operations related to traveling.		
		Actions act = new Actions(driver);
		
//Entering Starting point of traveling.
		
		objtrip.clickFrom();
		WebElement start = objtrip.enterFrom();		
		//act.click(start).perform();
		
// Listing up the data from datatable.
		
		List<List<String>> traveller = dataTable.asLists(String.class);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.sendKeys(start,traveller.get(0).get(0));
		act.pause(1000).perform();
		//act.sendKeys(start, Keys.DOWN);
		act.sendKeys(start,Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
//Entering destination of traveling.
		
		objtrip.clickTo();
		WebElement end = objtrip.enterDestination();
		act.sendKeys(end, traveller.get(0).get(1));
		act.pause(1000).perform();
		//act.sendKeys(end, Keys.ARROW_DOWN);
		act.sendKeys(end,Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
	}
	@When("user select the travelling details as Regular and travel class from page")
	public void user_select_the_travelling_details_as_Regular_and_travel_class_from_page() {
		homePage objtrip= new homePage(driver) ;
		
//Creating action to perform operations related to traveling. 
		
		Actions act = new Actions(driver);
		objtrip.clickRegular();
	    //objtrip.clickTravelclass();
		//driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	    WebElement Addadult = objtrip.clickAdultadd();
	    act.moveToElement(Addadult);
	    act.click().build().perform();

//Selecting Fare type and traveling details.
	   
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    WebElement AddChild = objtrip.clickChildadd();
	    act.moveToElement(AddChild).click().build().perform();
	    driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	    WebElement AddInfants =  objtrip.ClickInfantadd();
	    act.moveToElement(AddInfants).click().build().perform();
	    driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	    objtrip.clickFirstclass();
		
	    driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	    objtrip.clickClassdone();	    
	    
	}
	@When("user should get the Not Flight Available Message")
	public void user_should_get_the_Not_Flight_Available_Message() {
		homePage objtrip= new homePage(driver) ;
		
//Getting Messages related to No flight Available.		
		
		if(driver.getPageSource().contains( objtrip.getRecommendedFlight())) {
			 String get = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[1]/p[2]")).getText();
			 System.out.println("Get Message: "+get);
		 }
		 else {
			 System.out.println("Page Not Showing anything.");
		 }
		
	}
	@Then("user should go back to original Page")
	public void user_should_go_back_original_Page() {
		homePage objtrip= new homePage(driver) ;

//Backing to Home Page.		
		
		driver.navigate().back();
		String expect = "https://www.goibibo.com/";
		String actual  = driver.getCurrentUrl();
		
		Assert.assertEquals(expect, actual);
	}
	@After
	public void endUp() {

//Closing the Browser
		
		driver.close();
	}

}
