package br.trescon.steps;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.trescon.utils.Constants;

public class BaseSteps {

	protected static WebDriver driver;

	private static boolean initialized = false;

	private String parentWindowHandler;

	protected BaseSteps() {

		if (!initialized) {
			initiateChrome();
			initialized = true;
		}
	}

	protected BaseSteps(boolean pLogin) {

		if (!initialized) {
			initiateChrome();

			if (pLogin) {
				login(Constants.USER, Constants.PWD, Constants.EMP);
			}

			initialized = true;
		}
	}

	private void initiateChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby25-x64\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// guarda o handle da janela para voltar a janela principal
		parentWindowHandler = driver.getWindowHandle();
	}

	protected void navigateTo(String pUrl) {
		driver.navigate().to(pUrl);
	}

	protected void login(String pUser, String pPwd, String pEmpresa) {
		navigateTo(Constants.URL);
		driver.findElement(By.id("txtUserName")).sendKeys(pUser);
		driver.findElement(By.id("txtPassword")).sendKeys(pPwd);
		driver.findElement(By.id("txtCompany")).sendKeys(pEmpresa);
		driver.findElement(By.id("LogonButton")).click();
	}

	protected void withinFrame(String pFrameName) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(pFrameName);
	}

	protected void clicaMenu(String pNomeMenu) {
		withinFrame("ToolbarFrame");
		driver.findElement(By.xpath(pNomeMenu)).click();
		withinFrame("MainContents");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void mudarContextoPopUp() {
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // obtém todos os handles de janela
		Iterator<String> iterator = handles.iterator();
		
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		
		driver.switchTo().window(subWindowHandler);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void mudarContextoJanelaPrincipal() {
		driver.switchTo().window(parentWindowHandler);
		withinFrame("MainContents");
	}
	
	protected void preencherCampo(String pTexto, String pXpath) {
		driver.findElement(By.xpath(pXpath)).sendKeys(pTexto);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
