package Desafio_Geofusion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;



public class Adicionar_Produto {

	
	/** Variável utilizada para carregar o Web Driver, inicializa o navegador */
	WebDriver driver;

	/** Variável utilizada para carregar o Web Driver Selenium*/
	WebDriverBackedSelenium selenium;
	
	public void startSelenium() {
		driver = new FirefoxDriver();
		String baseUrl = "http://desafio.geofusion.tech";
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	
	public void stopSelenium() {
		//driver.close();
	}
	


	public void cadastrar_produto() throws Exception {
	
		try {
			
			/*Acessando a url do desafio Geofusion*/
			String url="http://desafio.geofusion.tech";
			System.out.println("Acessando a home");
			driver.get("http://desafio.geofusion.tech");
			driver.get(url);

			/*Preenchendo o campo nome completo*/
			System.out.println("Preenchendo o nome do participante");
			driver.findElement(By.name("data[owner]")).clear();
		    driver.findElement(By.name("data[owner]")).sendKeys("Monica Macedo Costa");	
		    System.out.println("Clicando no submit");
		    WebElement buttonSubmitName = driver.findElement(By.className("input-group-btn"));
		    buttonSubmitName.click();	
		    
		    /*Clique no botão para cadastrar um novo produto*/
		    System.out.println("Cadastrando um novo produto");
		    WebElement buttonNovoProduto = driver.findElement(By.linkText("Novo Produto"));
		    buttonNovoProduto.click();
		    
		    /*Inserindo o nome do novo produto*/
		    System.out.println("Inserindo o nome do produto");
		    driver.findElement(By.name("name")).sendKeys("Produto Selenium Web Driver");	
			
		    /*Inserindo o preço do novo produto*/
		    System.out.println("Inserindo o preço do produto");
		    driver.findElement(By.name("price")).sendKeys("200,00");	
		    
		    /*Inserindo a data de validade do produto*/
		    System.out.println("Inserindo a data de validade do produto");
		    driver.findElement(By.id("campo3")).click();
		    driver.findElement(By.className("day")).click();
		    
		    
		    /*Salvando o novo produto*/
		    System.out.println("Salvando o novo produto");
		    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		    
		    /*Clicando no alert de confirmação*/  
		    System.out.println("Clicando no alert de confirmação");
		    new WebDriverWait(driver, 10)
		    
		    /*Esperando o alert de confirmação aparecer para clicar*/
		    .until(ExpectedConditions.alertIsPresent());
		    driver.switchTo().alert().accept();
		    
		    System.out.println("Produto adicionado com sucesso!");
		    
		    
		  
		}
		catch(Exception e)  {  
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}	
		
}
