package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	WebDriver driver;
	
	public homePage(WebDriver driver){
		this.driver = driver;
	}
	// All Locating Element Related to Way of Traveling.
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/ul/li[1]/span[2]")
	WebElement oneway;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/ul/li[2]/span[2]")
	WebElement roundtrip;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/ul/li[3]/span[2]")
	WebElement MultiCity;
	
	//All Locating Element related to travel point and destination point.
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div/p")
	WebElement fromBtn;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/input")
	WebElement from;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[2]/div/div/p")
	WebElement toBtn;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/input")
	WebElement to;
	
	//All locating elements related to dates
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div/p[1]")
	WebElement departure;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[2]/p[1]")
	WebElement future;
	@FindBy(xpath="//*[@id=\\\"root\\\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]")
	WebElement futureDate;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]")
	WebElement departureDate;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]/span[2]")
	WebElement dateDone;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]/span[2]")
	WebElement dateCancel;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")
	WebElement nextmonthArrow;
	
	//All locating elements related to Traveler and Class.
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div/p[1]")
	WebElement travellerClass;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[1]/div/span[3]")
	WebElement adultAdd;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[1]/div/span[3]")
	WebElement adultSub;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[2]/div/span[3]")
	WebElement childAdd;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[2]/div/span[1]")
	WebElement childSub;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[3]/div/span[3]")
	WebElement infantsAdd;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[3]/div/span[1]")
	WebElement infantsSub;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[1]")
	WebElement economy;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[2]")
	WebElement premium;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[3]")
	WebElement business;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[4]")
	WebElement firstClass;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[3]/a[2]")
	WebElement classDone;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[3]/a[1]")
	WebElement classCancel;	
	
	// Locating Elements related to Fare Type
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[2]/div[1]/div/ul/li[1]/span[2]")
	WebElement fareRegular;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[2]/div[1]/div/ul/li[2]/span[3]")
	WebElement fareArm;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[2]/div[1]/div/ul/li[3]/span[3]")
	WebElement fareSenior;
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[2]/div[1]/div/ul/li[4]/span[2]")
	WebElement fareStudent;
	
	//Locating element for searching file and Elements after search
	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div/div[3]/span")
	WebElement searchFlight;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/span[2]")
	WebElement book;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/div[1]/a/div/div[1]")
	WebElement insideText;
	
	//All locating elements after booking
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/span")
	WebElement finalText;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/div/div[1]/p[3]")
	WebElement recommendedAvail;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[2]/div[2]/div/div[1]/div")
	WebElement TravelDetails;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[2]/div[2]/div/div[4]")
	WebElement ReturnDetails;
	
	public void clickOneway() {
		oneway.click();
	}
	public void clickOnroundtrip() {
		roundtrip.click();
	}
	public void clickOnMulticity() {
		MultiCity.click();
	}
	public void clickFrom() {
		 fromBtn.click();
	}
	public WebElement enterFrom() {
		 return from;
	}
	public WebElement clickTo() {
		 return toBtn;
	}
	public WebElement enterDestination() {
		 return to;
	}
	public void clickDeparture() {
		departure.click();
	}
	public void clickFuture() {
		future.click();
	}
	public WebElement selectDepartureDate() {
		return departureDate;
	}
	public WebElement selectFutureDate() {
		return futureDate;
	}
	public void clickDatedone() {
		dateDone.click();
	}
	public void clickTravelclass() {
		travellerClass.click();
	}
	public WebElement clickAdultadd() {
		return adultAdd;
	}
	public WebElement clickAdultsub() {
		return adultSub;
	}
	public WebElement clickChildadd() {
		return childAdd;
	}
	public WebElement clickChildsub() {
		return childSub;
	}
	public WebElement ClickInfantadd() {
		return infantsAdd;
	}
	public WebElement ClickInfantsub() {
		return infantsSub;
	}
	public void clickEconomy() {
		economy.click();
	}
	public void clickPremium() {
		premium.click();
	}
	public void clickBusiness() {
		business.click();
	}
	public void clickFirstclass() {
		firstClass.click();
	}
	public void clickClassdone() {
		classDone.click();
	}
	public void clickClasscancel() {
		classCancel.click();
	}
	public void clickRegular() {
		fareRegular.click();
	}
	public void clickArmed() {
		fareArm.click();
	}
	public void clickSenior() {
		fareSenior.click();
	}
	public void clickStudent() {
		fareStudent.click();
	}
	public void clickSearchFlight() {
		searchFlight.click();
	}
	public void clickBook() {
		book.click();
	}
	public void clickNextMonthArrow() {
		nextmonthArrow.click();
	}
	public String getInsideText() {
		return insideText.getText();
	}
	public String getFinalText() {
		return finalText.getText();
	}
	public String getRecommendedFlight() {
		return recommendedAvail.getText();
	}
	public String getReturnDetails() {
		return ReturnDetails.getText();
	}
	public String getTravelDetails() {
		return TravelDetails.getText();
	}
}
