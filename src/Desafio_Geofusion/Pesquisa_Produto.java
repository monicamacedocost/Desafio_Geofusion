package Desafio_Geofusion;




import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * @author Costa, Monica
 * version 1.0  01 de Março 2018.
 * 
 */
public class Pesquisa_Produto {


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



	public void pesquisar_produto() throws Exception {

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

			/*Adicionando o nome do produto para pesquisar*/
			System.out.println("Pesquisando um produto");
			WebElement Pesquisar_campo_produto = driver.findElement(By.name("data[search]"));
			Pesquisar_campo_produto.click();
			Pesquisar_campo_produto.sendKeys(Variaveis.nome_produto_editar);
			WebElement Pesquisar_lupa = driver.findElement(By.cssSelector(".input-group-btn > button:nth-child(1)"));
			Pesquisar_lupa.click();

			/*Verificando o resultado da pesquisa*/
			System.out.println("Verificando o resultado da pesquisa");
			WebElement resultado_pesquisa = driver.findElement(By.xpath("//*[@id=\"list\"]/div/table/tbody/tr[1]/td[2]"));
			resultado_pesquisa.getText();
			
			/*Validando o resultado da pesquisa*/
			if(resultado_pesquisa.getText().equals(Variaveis.nome_produto_editar)) { 
				System.out.println("Produto encontrado!");
			}

			else {
				System.out.println("O produto não foi encontrado!");
			}


		}
		catch(Exception e)  {  
			System.out.println(e);
		}
	}
}



