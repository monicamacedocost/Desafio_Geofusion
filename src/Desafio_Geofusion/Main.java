
package Desafio_Geofusion;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;





/**
 * @author Costa, Monica
 * version 1.0  01 de Março 2018.
 * 
 */


public class Main {


	/** Variável utilizada para carregar o Web Driver, inicializa o navegador */
	static WebDriver driver;

	/** Variável utilizada para carregar o Web Driver Selenium*/
	static WebDriverBackedSelenium selenium;




	public static void startSelenium() {
		driver = new FirefoxDriver();
		String baseUrl = "http://desafio.geofusion.tech";
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}


	public void stopSelenium() {
		driver.close();
	}



	public static void main(String[] args) throws Exception {

		Adicionar_Produto adicionar = new Adicionar_Produto();
		adicionar.startSelenium();
		adicionar.cadastrar_produto();
		adicionar.stopSelenium();

		Editar_Produto editar = new Editar_Produto();
		editar.startSelenium();
		editar.editar_produto();
		editar.stopSelenium();

		Pesquisa_Produto Pesquisar = new Pesquisa_Produto();
		Pesquisar.startSelenium();
		Pesquisar.pesquisar_produto();
		Pesquisar.stopSelenium();

		Excluir_Produto excluir = new Excluir_Produto();
		excluir.startSelenium();
		excluir.excluir_produto();
		excluir.stopSelenium();




		System.out.println("Teste finalizado!");

	}
}
