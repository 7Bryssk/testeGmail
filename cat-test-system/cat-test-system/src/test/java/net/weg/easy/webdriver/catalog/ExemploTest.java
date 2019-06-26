
package net.weg.easy.webdriver.catalog;

import java.io.Console;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class ExemploTest extends TestCase {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testCarrinho() throws Exception {
		driver.get("http://www.gmail.com/");
		WebDriverWait wait = new WebDriverWait(driver, 120);

		WebElement campoDeTexto = driver.findElement(By.id("identifierId"));
		campoDeTexto.sendKeys("testefacul767@gmail.com");

		WebElement botao1 = driver.findElement(By.id("identifierNext"));
		botao1.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

		WebElement campoDeSenha = driver.findElement(By.name("password"));
		campoDeSenha.sendKeys("Senha854");

		WebElement botao2 = driver.findElement(By.id("passwordNext"));
		botao2.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(ByAll.xpath("//*[contains(text(), 'Compose')]")));

		WebElement botao3 = driver.findElement(ByAll.xpath("//*[contains(text(), 'Compose')]"));
		botao3.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));

		WebElement campoTo = driver.findElement(By.name("to"));
		campoTo.sendKeys("testefacul767@gmail.com");

		WebElement campoAssunto = driver.findElement(By.name("subjectbox"));
		campoAssunto.sendKeys("Teste de Sistema");

		WebElement campoMensagem = driver.findElement(By.xpath("//div[@aria-label=\"Message Body\"]"));
		campoMensagem.sendKeys("Selenium webdrive é legal!");

		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> unreadMails = driver.findElements(By.xpath("//*[@class='zF']"));
		
		for (WebElement mail : unreadMails) {
			if (mail.isDisplayed() == true) {
				mail.click();
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByAll.xpath("//span[@class='ams bkH']")));
		driver.findElement(ByAll.xpath("//*[@class='ams bkH']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label=\"Message Body\"]")));
		
		WebElement campoMensagem2 = driver.findElement(By.xpath("//div[@aria-label=\"Message Body\"]"));
		campoMensagem2.sendKeys("Ok, email lido Obrigado.");

		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title=\"Inbox\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"oZ-jc T-Jo J-J5-Ji \"]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA\"]")));
		driver.findElement(By.xpath("//div[@class=\"T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA\"]")).click();
		Thread.sleep(1000);
		
		
		
		driver.findElement(By.xpath("//div[@class=\"n6\"]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-tooltip=\"Trash\"]")));
		driver.findElement(By.xpath("//div[@data-tooltip=\"Trash\"]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@aria-label=\"Google Account: testefacul767@gmail.com\"]")).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Sign out')]")));
		driver.findElement(By.xpath("//a[contains(text(), 'Sign out')]")).click();
		
		Thread.sleep(10000);
	}

}
