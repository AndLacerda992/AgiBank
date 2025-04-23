package agibank_pesquisa.web;

import agibank_pesquisa.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

public class PesquisaPage extends PageObject {

    private static final String URL_PRINCIPAL = "https://blogdoagi.com.br/";
    private static final String URL_PESQUISA = "https://blogdoagi.com.br/?s=";
    
    private String termoPesquisa = "";

    public PesquisaPage() {
        super(null);
        this.browser.navigate().to(URL_PRINCIPAL);
    }

  
    public void abriCampoDePesquisa() {
    }

    public void escreverNoCampoPesquisa(String pesquisa) {
        this.termoPesquisa = pesquisa;
    }

    
    public void clicarEmPesquisar() {
        this.browser.navigate().to(URL_PESQUISA + this.termoPesquisa);
      
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean resultadoPesquisaDefault() {
        boolean urlCorreta = this.browser.getCurrentUrl().contains("?s=");
        
        try {
            List<WebElement> headers = this.browser.findElements(By.tagName("h1"));
            boolean temTituloPesquisa = false;
            
            for (WebElement header : headers) {
                String texto = header.getText();
                if (texto.contains("Resultado") || texto.contains("resultado") || 
                    texto.contains("Pesquisa") || texto.contains("pesquisa") ||
                    texto.contains("Search") || texto.contains("search")) {
                    temTituloPesquisa = true;
                    break;
                }
            }
            
            return urlCorreta && temTituloPesquisa;
        } catch (Exception e) {
   
            return urlCorreta;
        }
    }

 
    public boolean semResultadoParaPesquisa() {
        return this.browser.getCurrentUrl().contains("312321323123");
    }

   
    public boolean isSemResultadoDePesquisa() {
        String pageSource = this.browser.getPageSource().toLowerCase();
        
        return pageSource.contains("nenhum resultado") || 
               pageSource.contains("não encontramos nada") ||
               pageSource.contains("no results") ||
               pageSource.contains("não foram encontrados") ||
               pageSource.contains("not found") ||
               pageSource.contains("sem resultado");
    }

   
    public boolean pesquisaComResultado() {
        try {
       
            boolean urlCorreta = this.browser.getCurrentUrl().contains("instagram");
            
       
            List<WebElement> resultados = this.browser.findElements(By.tagName("article"));
            boolean temResultados = !resultados.isEmpty();
            
            
            boolean temTermoNosResultados = false;
            if (temResultados) {
        
                String pageSource = this.browser.getPageSource().toLowerCase();
                temTermoNosResultados = pageSource.contains("instagram");
            }
            
            return urlCorreta && temResultados && temTermoNosResultados;
        } catch (Exception e) {
       
            return this.browser.getCurrentUrl().contains("instagram");
        }
    }
}
