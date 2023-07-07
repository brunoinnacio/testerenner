package automatizado.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

    public static void main(String[] args) {
        // Configurar o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/java/automatizado/resource/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Abrir a página desejada
            driver.get("https://automationexercise.com/");

            // Localizar o elemento de login usando XPath
            WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
            loginLink.click();

            // Aguardar até que o campo de e-mail esteja visível
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@data-qa,'login-email')]")));

            // Enviar o valor para o campo de e-mail
            emailInput.sendKeys("brunoinacio@teste.com");

            // Aguardar até que o campo de senha esteja visível
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@type,'password')]")));

            // Enviar o valor para o campo de senha
            passwordInput.sendKeys("1234");

            // Clicar no botão de login
            WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
            loginButton.click();

            // Aguardar até que a página de produtos esteja carregada
            wait.until(ExpectedConditions.urlContains("/products"));

            // Pesquisar e adicionar o primeiro produto (Stylish Dress)
            WebElement productSearchInput = driver.findElement(By.xpath("//input[contains(@id,'search_product')]"));
            productSearchInput.sendKeys("Stylish Dress");

            WebElement submitSearchButton = driver.findElement(By.xpath("//button[contains(@id,'submit_search')]"));
            submitSearchButton.click();

            WebElement viewProductLink = driver.findElement(By.xpath("//a[contains(@href,'/product_details/')]"));
            viewProductLink.click();

            WebElement quantityInput = driver.findElement(By.xpath("//input[contains(@id,'quantity')]"));
            quantityInput.sendKeys("3");

            WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(.,'Add to cart')]"));
            addToCartButton.click();

            // Voltar à página de produtos e adicionar mais produtos
            driver.navigate().back();

            productSearchInput.clear();
            productSearchInput.sendKeys("Beautiful Peacock Blue Cotton Linen Saree");
            submitSearchButton.click();

            viewProductLink = driver.findElement(By.xpath("//a[contains(@href,'/product_details/')]"));
            viewProductLink.click();

            quantityInput.clear();
            quantityInput.sendKeys("2");

            addToCartButton.click();

            // Voltar à página de produtos e adicionar mais produtos
            driver.navigate().back();

            productSearchInput.clear();
            productSearchInput.sendKeys("Men Tshirt");
            submitSearchButton.click();

            viewProductLink = driver.findElement(By.xpath("//a[contains(@href,'/product_details/')]"));
            viewProductLink.click();

            quantityInput.clear();
            quantityInput.sendKeys("1");

            addToCartButton.click();
        } finally {
            // Fechar o navegador após a conclusão do teste
            driver.quit();
        }
    }
}
