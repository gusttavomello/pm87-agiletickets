package br.com.caelum.agiletickets.acceptance;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.acceptance.page.ReservaPage;

public class ReservaTest {
	
	public static String BASE_URL = "http://localhost:8080";
	private static WebDriver browser;
	private ReservaPage reserva;

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		reserva = new ReservaPage(browser);
	}

	@AfterClass
	public static void teardown() {
		browser.close();
	}
	
	
	
	@Test
	public void reservaDeUmIngressoUltimosCincoDeveCustar55() {
		reserva.acessaTelaReserva();
		reserva.fazReserva("1");
		reserva.mensagemDeveConter("55,00", "message");
	}
	
	@Test
	public void reservaQntMaiorQueIngressosDisponiveis() {
		reserva.acessaTelaReserva();
		reserva.fazReserva("1001");
		reserva.mensagemDeveConter("Não existem ingressos disponíveis", "errors");
	}
}
