package inventario;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Inventario {
	WebDriver driver = new FirefoxDriver();
	String url = "http://localhost/perfumespococi/";

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test
	public void login() {
		//Login form inputs and button
		WebElement usernameInput = driver.findElement(By.id("login"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.id("submit"));
		
		usernameInput.sendKeys("paul");
		passwordInput.sendKeys("canastos123");
		btnLogin.click();
	}
	
	@Test
	public void update() throws InterruptedException {
		//Go to inventario
		driver.navigate().to(url+"home/inventario.php");
		
		Thread.sleep(6000);

		WebElement btnEditar = driver.findElement(By.xpath("//*[@id=\"MulticontentTable\"]/tbody/tr[1]/td[14]/a[1]"));
		btnEditar.click();
		
		Thread.sleep(6000);
		
		WebElement stockInput = driver.findElement(By.id("stock"));
		WebElement stock2Input = driver.findElement(By.id("stock2"));
		WebElement stock3Input = driver.findElement(By.id("stock3"));
		WebElement stock4Input = driver.findElement(By.id("stock4"));
		
		//Clear inputs
		stockInput.clear();
		stock2Input.clear();
		stock3Input.clear();
		stock4Input.clear();
		
		//Set inputs value
		stockInput.sendKeys("0");
		stock2Input.sendKeys("0");
		stock3Input.sendKeys("0");
		stock4Input.sendKeys("10");
		
		Thread.sleep(6000);

		WebElement btnGuardar = driver.findElement(By.name("SubmitButton"));
		btnGuardar.click();
		driver.navigate().refresh();
	}
	@Test
	public void searchByCod() throws InterruptedException {
		driver.navigate().to(url+"home/inventario.php");
		//Thread.sleep(6000);
		
		driver.findElement(By.id("cipl")).sendKeys("05028");
		WebDriverWait wait = new WebDriverWait(driver,1000);
		WebElement btnSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
		btnSubmit.click();
		Thread.sleep(6000);

	}
	
	@Test
	public void openNewTab()  throws InterruptedException{
		WebElement usernameInput = driver.findElement(By.id("login"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.id("submit"));
		
		usernameInput.sendKeys("paul");
		passwordInput.sendKeys("canastos123");
		btnLogin.click();
		
		driver.navigate().to(url+"home/");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.get("https://www.facebook.com");
		Thread.sleep(6000);
	}
	
	@AfterTest
	public void finishTest() {
		driver.close();
	}

}
