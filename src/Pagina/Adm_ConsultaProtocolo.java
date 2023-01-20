package Pagina;

import org.openqa.selenium.By;

import java.lang.Thread;
import java.util.List;


//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Adm_ConsultaProtocolo{
	public static  String Adm_ConsultaProtocolo_Registro(String nr_Prot,String dt_Data) {
		// Não funcional - numero de atendimento e data da autuação. Falta teste de unidade. 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luizperez\\Documents\\Demandas Kelly\\Migração\\Nova pasta (2)\\chromedriver.exe");

		
		
    //    String test_url = "https://online.saovicente.sp.gov.br/pmsaovicente/websis/siapegov/administrativo/aten/aten_valida.php?consulta";
		String test_url = "Processo não encontrado. Número do Protocolo e/ou Data Incorretos!";

			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
			
	//	driver.get("https://online.saovicente.sp.gov.br/pmsaovicente/websis/siapegov/administrativo/aten/aten_valida.php?consulta");
		driver.get("https://online.saovicente.sp.gov.br/pmsaovicente/websis/siapegov/administrativo/gpro/protocolo_consulta.php");
			
		
		
		// Verificar campos
		//WebElement numero = driver.findElement(By.xpath("//*[@id=\"mytab2\"]/form/div[1]/div/input"));
		WebElement numero = driver.findElement(By.xpath("//*[@id='main-container']/div[1]/form/div[1]/div[1]/div[1]/div/input"));
		numero.click();
		numero.sendKeys(nr_Prot);
	    numero.isDisplayed();
//		numero.sendKeys("001665");
		
	   
		
		
		
		
		WebElement data = driver.findElement(By.name("data_autuacao"));
		data.isDisplayed();
		data.isEnabled();
	//	data.click();
		data.sendKeys(dt_Data);
//		data.sendKeys("03/10/2017");

		WebElement pesquisa = driver.findElement(By.name("Pesquisar"));
		// pesquisa.click();
		pesquisa.submit();
		
		String curr_window_title = driver.getCurrentUrl();
		
		
	
		 WebElement dadoNulo = driver.findElement(By.className("page-content"));
		
	    
	  if(!dadoNulo.getText().contains(test_url))
	  {
		  curr_window_title = "REGISTRO";
	  }
	  else
	  {
		  curr_window_title = "VAZIO";   
	  }
		
	//	System.out.println(test_url);
	//	System.out.println(curr_window_title);
		
		driver.close();
		
	
		
		return curr_window_title;
				
		
	}

}
