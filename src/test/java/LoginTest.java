import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standart_user");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("login-button")).click();

        String masssage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(masssage, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }

    @Test
    public void testLogin1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standart_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String masssage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(masssage, "Epic sadface: Password is required");
        driver.quit();
    }

    @Test
    public void testLogin2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String masssage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(masssage, "Epic sadface: Username is required");
        driver.quit();
    }

    @Test
    public void testLogin3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("1234");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String masssage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(masssage, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }

    @Test
    public void testLogin4() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("12345");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("login-button")).click();

        String masssage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(masssage, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
    @Test
    public void testLogin5() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String masssage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(masssage, "Epic sadface: Username is required");
        driver.quit();
    }

}
