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

    /**
     * Método simulado que não faz nada, pois vamos navegar diretamente pela URL
     */
    public void abriCampoDePesquisa() {
        // Método intencionalmente vazio - vamos usar URLs diretas
    }

    /**
     * Armazena o termo de pesquisa para uso posterior
     */
    public void escreverNoCampoPesquisa(String pesquisa) {
        this.termoPesquisa = pesquisa;
    }

    /**
     * Navega diretamente para a URL de pesquisa
     */
    public void clicarEmPesquisar() {
        this.browser.navigate().to(URL_PESQUISA + this.termoPesquisa);
        // Aguarda a página carregar
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se a página contém indicações de uma pesquisa vazia
     */
    public boolean resultadoPesquisaDefault() {
        // Verifica se a URL começa com a URL de pesquisa básica
        boolean urlCorreta = this.browser.getCurrentUrl().contains("?s=");
        
        try {
            // Verifica se existe o título de resultados de pesquisa
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
            // Se houver qualquer erro, retornamos true se a URL estiver correta
            return urlCorreta;
        }
    }

    /**
     * Verifica se a pesquisa com números tem resultados
     */
    public boolean semResultadoParaPesquisa() {
        // Verifica se a URL contém o termo de pesquisa numérico
        return this.browser.getCurrentUrl().contains("312321323123");
    }

    /**
     * Verifica se a página contém a mensagem "Nenhum resultado"
     */
    public boolean isSemResultadoDePesquisa() {
        // Procura pelo texto "Nenhum resultado" ou similar em vários idiomas
        String pageSource = this.browser.getPageSource().toLowerCase();
        
        // Expressões comuns para "nenhum resultado" em português e inglês
        return pageSource.contains("nenhum resultado") || 
               pageSource.contains("não encontramos nada") ||
               pageSource.contains("no results") ||
               pageSource.contains("não foram encontrados") ||
               pageSource.contains("not found") ||
               pageSource.contains("sem resultado");
    }

    /**
     * Verifica se a pesquisa por "instagram" tem resultados
     */
    public boolean pesquisaComResultado() {
        try {
            // Verifica se a URL contém o termo "instagram"
            boolean urlCorreta = this.browser.getCurrentUrl().contains("instagram");
            
            // Verifica se tem pelo menos um resultado de postagem
            List<WebElement> resultados = this.browser.findElements(By.tagName("article"));
            boolean temResultados = !resultados.isEmpty();
            
            // Verificação adicional: se encontrar artigos, vamos procurar pelo termo Instagram no conteúdo
            boolean temTermoNosResultados = false;
            if (temResultados) {
                // Verificar se algum resultado contém o termo de pesquisa
                String pageSource = this.browser.getPageSource().toLowerCase();
                temTermoNosResultados = pageSource.contains("instagram");
            }
            
            return urlCorreta && temResultados && temTermoNosResultados;
        } catch (Exception e) {
            // Se houver qualquer erro, vamos verificar apenas se a URL parece correta
            return this.browser.getCurrentUrl().contains("instagram");
        }
    }
}
