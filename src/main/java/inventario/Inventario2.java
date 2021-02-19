package inventario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Inventario2 {

	@Test
	public void login() {
		String url = "http://localhost/perfumespococi";
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		//Login form inputs and button
		WebElement usernameInput = driver.findElement(By.id("login"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.id("submit"));
		
		usernameInput.sendKeys("paul");
		passwordInput.sendKeys("canastos123");
		btnLogin.click();
		
		//Inventario
		WebElement btnInventario = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[4]/a"));
		btnInventario.click();
	}
	
	@Test
	public void Update() {
		
	}
	@Test
	public void Delete() {
		
	}
}
