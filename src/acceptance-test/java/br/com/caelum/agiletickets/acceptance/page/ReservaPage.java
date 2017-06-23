package br.com.caelum.agiletickets.acceptance.page;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservaPage {
	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;

	public ReservaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessaTelaReserva() {
		driver.get(BASE_URL + "/sessao/30");
	}

	
	public void fazReserva(String quantidade) {
		WebElement form = form();
		form.findElement(By.id("qtde")).sendKeys(quantidade);
		
		form.submit();
	}
	
	public void mensagemDeveConter(String texto, String tipoMensagem) {
		WebElement msg = driver.findElement(By.id(tipoMensagem));
		assertThat(msg.getText(), containsString(texto));
	}
	
	private WebElement form() {
		return driver.findElement(By.id("frmSessao"));
	}
	
}
