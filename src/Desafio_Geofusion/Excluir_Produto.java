package Desafio_Geofusion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * @author Costa, Monica
 * version 1.0  01 de Março 2018.
 * 
 */

public class Excluir_Produto {

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
		driver.close();
	}



	public void excluir_produto() throws Exception {

		try {

			/*Acessando a url do desafio Geofusion*/
			String url="http://desafio.geofusion.tech";
			System.out.println("Acessando a home");
			driver.get("http://desafio.geofusion.tech");
			driver.get(url);

			/*Preenchendo o campo nome completo*/
			System.out.println("Preenchendo o nome do participante");
			WebElement elemento_data = driver.findElement(By.name("data[owner]"));
			elemento_data.clear();
			WebElement nome_completo = driver.findElement(By.name("data[owner]"));
			nome_completo.sendKeys(Variaveis.nome);	

			/*Enviando o fomulário com o nome*/
			System.out.println("Clicando no submit");
			WebElement buttonSubmitName = driver.findElement(By.className("input-group-btn"));
			buttonSubmitName.click();	

			/*Clique no botão para excluir um produto*/
			System.out.println("Excluindo um novo produto");
			WebElement Excluir_produto = driver.findElement(By.linkText("Excluir"));
			Excluir_produto.click();



			/*Confirmando a exclusão do produto*/
			System.out.println("Confirmando a exclusão do produto");
			WebElement confirmar_exclusao = driver.findElement(By.xpath("//div[@id='delete-modal']/div/div/div[3]/button"));
			confirmar_exclusao.click();

			/*Clicando no alert de confirmação*/  
			System.out.println("Clicando no alert de confirmação");
			new WebDriverWait(driver, 10)

			/*Esperando o alert de confirmação aparecer para clicar*/
			.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();


			System.out.println("Produto excluido com sucesso!");






		}
		catch(Exception e)  {  
			System.out.println(e);
		}
	}
}
