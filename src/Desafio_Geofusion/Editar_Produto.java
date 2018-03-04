package Desafio_Geofusion;




import java.util.List;
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

public class Editar_Produto {

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



	public void editar_produto() throws Exception {

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

			/*Clique no botão para editar um produto*/
			System.out.println("Editando um novo produto");
			WebElement Editar_produto = driver.findElement(By.linkText("Editar"));
			Editar_produto.click();

			/*Inserindo o nome do novo produto*/
			System.out.println("Inserindo o nome do produto");
			WebElement produto = driver.findElement(By.name("name"));
			produto.clear();
			produto.sendKeys(Variaveis.nome_produto_editar);	

			/*Inserindo o preço do novo produto*/
			System.out.println("Inserindo o preço do produto");
			WebElement preço = driver.findElement(By.name("price"));
			preço.clear();
			preço.sendKeys(Variaveis.preço_produto_editar);	

			/*Inserindo a data de validade do produto*/
			System.out.println("Inserindo a data de validade do produto");
			WebElement data_validade = driver.findElement(By.id("campo3"));
			data_validade.click();

			List<WebElement> allDates=driver.findElements(By.className("day"));
			for(WebElement selecionar_dia:allDates)
			{

				String date=selecionar_dia.getText();

				if(date.equalsIgnoreCase("19"))
				{
					selecionar_dia.click();
					break;
				}

			}


			/*Salvando o novo produto*/
			System.out.println("Salvando o novo produto");
			WebElement salvar_produto = driver.findElement(By.cssSelector("button.btn.btn-primary"));
			salvar_produto.click();

			/*Clicando no alert de confirmação*/  
			System.out.println("Clicando no alert de confirmação");
			new WebDriverWait(driver, 10)

			/*Esperando o alert de confirmação aparecer para clicar*/
			.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();

			System.out.println("Produto editado com sucesso!");   





		}

		catch(Exception e)  {  
			System.out.println(e);
		}
	}
}
