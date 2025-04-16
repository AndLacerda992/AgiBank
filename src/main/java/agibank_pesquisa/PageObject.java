package agibank_pesquisa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        if (browser == null) {
            this.browser = new ChromeDriver(options);
            this.browser.manage().window().maximize();
        } else {
            this.browser = browser;
        }
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.manage().window().maximize();
    }

    public void fechar() {
        this.browser.quit();
    }
}
