import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.quit();
    }

    @Test
    public void checkLogin () {

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
        String Email = "iaroslavishchuk@gmail.com";
        String Pass = "123qweASD";

        //------------ Находим элемент и создаем переменную
        By userName = By.xpath(".//input[@name='email']");
        By userPassword = By.xpath(".//input[@name='pass']");
        By submitButton = By.xpath(".//button[@name='login']");
        By nameAfterLogin = By.xpath(".//span[contains(text(), 'Ярослав Ищук')]");


        //------------ Этот блок с операциями над элементами
        driver.get("https://www.facebook.com/");
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
        driver.quit();

    }
}


//        //------------ Находим элемент и создаем переменную
//
//        By commentText = By.xpath(".//div[@data-qa-node='comment']");
//        By receiverAmount = By.xpath(".//div[@data-qa-node='receiver-amount']");
//        By payerCard = By.xpath(".//span[@data-qa-node='payer-card']");
//        By receiverCard = By.xpath(".//span[@data-qa-node='receiver-card']");
//        By cardNumberFrom = By.xpath(".//input[@data-qa-node='numberdebitSource']");
//
//        //------------ Этот блок с операциями над элементами
//
//        driver.get("https://next.privat24.ua/money-transfer/card");
//        // здесь создали переменную cardNumberFrom и присовили ей элемент по адрессу в DOM модели с помощью XPATH
//        driver.findElement(cardNumberFrom).sendKeys("4552331448138217");
//        //в примере ниже мы не создаем переменную, а сразу работаем с элементом по его XPATH локатору
//        driver.findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']")).sendKeys("0524");
//        driver.findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']")).sendKeys("111");
//        driver.findElement(By.xpath(".//input[@data-qa-node='firstNamedebitSource']")).sendKeys("Shayne");
//        driver.findElement(By.xpath(".//input[@data-qa-node='lastNamedebitSource']")).sendKeys("McConnell");
//        driver.findElement(By.xpath(".//input[@data-qa-node='numberreceiver']")).sendKeys("4567739561253907");
//        driver.findElement(By.xpath(".//input[@data-qa-node='firstNamereceiver']")).sendKeys("Ruth");
//        driver.findElement(By.xpath(".//input[@data-qa-node='lastNamereceiver']")).sendKeys("Montalvo");
//        driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).clear();
//        driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).sendKeys("300");
//        driver.findElement(By.xpath(".//span[@data-qa-node='toggle-comment']")).click();
//        driver.findElement(By.xpath(".//textarea[@data-qa-node='comment']")).sendKeys("На текилу");
//        driver.findElement(By.xpath(".//button[contains(text(), 'Переказати')]")).click();
//
//        /**
//         *
//         *  Эта часть для создания проверок в тесте
//         *
//         * */
//
//        Assert.assertEquals("На текилу", driver.findElement(commentText).getText());
//        Assert.assertEquals("300 UAH", driver.findElement(receiverAmount).getText());
//        Assert.assertEquals("* 8217", driver.findElement(payerCard).getText());
//        Assert.assertEquals("* 3907", driver.findElement(receiverCard).getText());
//
//        // -------------- После проверки экрана прогноза платежа, переходим к оплате в Корзину
//
//        driver.findElement(By.xpath(".//button[contains(text(), 'В кошик')]")).click();
