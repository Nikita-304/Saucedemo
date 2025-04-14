import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    public void testLogin6() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement homePageElement = driver.findElement(By.id("root"));
        if (homePageElement.isDisplayed()) {
            System.out.println("Позитивный тест: Пользователь успешно вошел на домашнюю страницу!");
        } else {
            System.out.println("Ошибка: Вход не удался или пользователь не на домашней странице.");
        }
        driver.quit();
    }
    @Test
    public void testLoginCart() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement homePageElement = driver.findElement(By.id("root"));
        if (homePageElement.isDisplayed()) {
            System.out.println("Позитивный тест: Пользователь успешно вошел на домашнюю страницу!");
        } else {
            System.out.println("Ошибка: Вход не удался или пользователь не на домашней странице.");
        }

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();

        WebElement element = driver.findElement(By.id("item_0_title_link"));
        if (element.isDisplayed()) {
            System.out.println("Товар в корзине!");
        } else {
            System.out.println("Ошибка: товара нет в корзине.");
        }

        driver.quit();
    }
    @Test
    public void testLoginCart1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement homePageElement = driver.findElement(By.id("root"));
        if (homePageElement.isDisplayed()) {
            System.out.println("Позитивный тест: Пользователь успешно вошел на домашнюю страницу!");
        } else {
            System.out.println("Ошибка: Вход не удался или пользователь не на домашней странице.");
        }

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();

        WebElement element = driver.findElement(By.id("item_0_title_link"));
        if (element.isDisplayed()) {
            System.out.println("Товар в корзине!");
        } else {
            System.out.println("Ошибка: товара нет в корзине.");
        }

        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("nikita");
        driver.findElement(By.id("last-name")).sendKeys("sherbakov");
        driver.findElement(By.id("postal-code")).sendKeys("428000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.cssSelector("#finish")).click();

        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html")) {
            System.out.println("Заказ оформлен");
        } else {
            System.out.println("Ошибка: заказ не оформлен");
        }

        driver.quit();
    }

}

