import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void checkLoginWithError() {

        /**
         *
         *  Эта часть для создания драйвера - образа движка определенного браузера
         *  так же, здесь указали точно, где взять движок через setProperty
         *  так же здесь указали, что нужно ожидать элемент на UI в течение 3 сек прежде, чем с ним взаимодействовать
         * */

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        /**
         *
         *  Эта часть для заполнения данных, здесь нет проверок
         *
         * */
        //------------кредлы
        String wrongEmail = "yaroslavischuck@gmail.com";
        String wrongPass = "1122334455";

        //------------ Находим элемент и создаем переменную
        By userName = By.xpath(".//input[@name='email']");
        By userPassword = By.xpath(".//input[@name='pass']");
        By submitButton = By.xpath(".//button[@name='login']");
        By textErrorLogin = By.xpath(".//a[@href=\'https://www.facebook.com/recover/initiate?lwv=120&lwc=1348092&ars=facebook_login_pw_error\']");


        //------------ Этот блок с операциями над элементами
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(userName).sendKeys(wrongEmail);
        driver.findElement(userPassword).sendKeys(wrongPass);
        driver.findElement(submitButton).click();
        /**
         *
         *  Эта часть для создания проверок в тесте
         *
         * */
        Assert.assertEquals("Забыли пароль?", driver.findElement(textErrorLogin).getText());

        //------------Выходим из браузера
        //driver.quit();
    }

    @Test
    public void checkLogin () {

        /**
         *
         *  Эта часть для создания драйвера - образа движка определенного браузера
         *  так же, здесь указали точно, где взять движок через setProperty
         *  так же здесь указали, что нужно ожидать элемент на UI в течение 3 сек прежде, чем с ним взаимодействовать
         * */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        /**
         *
         *  Эта часть для заполнения данных, здесь нет проверок
         *
         * */
        //------------кредлы
        String Email = "iaroslavishchuk@gmail.com";
        String Pass = "123qweASD";

        //------------ Находим элемент и создаем переменную
        By userName = By.xpath(".//input[@name='email']");
        By userPassword = By.xpath(".//input[@name='pass']");
        By submitButton = By.xpath(".//button[@name='login']");
        By nameAfterLogin = By.xpath(".//span[contains(text(), 'Ярослав Ищук')]");


        //------------ Этот блок с операциями над элементами
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(userName).sendKeys(Email);
        driver.findElement(userPassword).sendKeys(Pass);
        driver.findElement(submitButton).click();
        /**
         *
         *  Эта часть для создания проверок в тесте
         *
         * */
        Assert.assertEquals("Ярослав Ищук", driver.findElement(nameAfterLogin).getText());

        //------------Выходим из браузера
        //driver.quit();

    }
}
