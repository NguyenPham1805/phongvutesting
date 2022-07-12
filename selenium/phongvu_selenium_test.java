package test;

import drivers.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class TestPhongVu {
    @Test
    // Test thứ 1
    public static void Login(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);
            WebElement menu = driver.findElement(By.xpath("//div[@data-content-name='loginIcon']//*[name()='svg']"));
            actions.click(menu).perform(); Thread.sleep(500);
            WebElement login = driver.findElement(By.xpath("//button[@class='css-137bsbb']"));
            actions.click(login).perform();Thread.sleep(500);

            WebElement nhapsdt = driver.findElement(By.cssSelector("input[placeholder='Nhập số điện thoại']"));
            nhapsdt.sendKeys("0982931825");Thread.sleep(1000);

            WebElement gui = driver.findElement(By.xpath("//button[@class='css-1w14l2o']"));
            actions.click(gui).perform();Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
    // Test thứ 2
    @Test
    public static void loginwrong(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);
            WebElement menu = driver.findElement(By.xpath("//div[@data-content-name='loginIcon']//*[name()='svg']"));
            actions.click(menu).perform(); Thread.sleep(500);
            WebElement login = driver.findElement(By.xpath("//button[@class='css-137bsbb']"));
            actions.click(login).perform();Thread.sleep(500);

            WebElement nhapsdt = driver.findElement(By.cssSelector("input[placeholder='Nhập số điện thoại']"));
            nhapsdt.sendKeys("1245nghia");Thread.sleep(1000);

            WebElement gui = driver.findElement(By.xpath("//button[@class='css-1w14l2o']"));
            actions.click(gui).perform();Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
    // Test thứ 3
    @Test
    public static void SearchProduct(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);

            WebElement search = driver.findElement(By.cssSelector("input[placeholder='Nhập từ khoá cần tìm']"));
            search.sendKeys("Laptop");Thread.sleep(1000);

            WebElement tim = driver.findElement(By.xpath("//span[@class='css-squldw']"));
            actions.click(tim).perform();Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
    // Test thứ 5
    @Test
    public static void DisplayProduct(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);

            WebElement search0 = driver.findElement(By.xpath("//div[@type='caption'][normalize-space()='Laptop']"));
            actions.click(search0).perform();Thread.sleep(1000);

            WebElement search1 = driver.findElement(By.xpath("//div[@id='js-brands']//div[5]"));
            actions.click(search1).perform();Thread.sleep(1000);

            WebElement search2 = driver.findElement(By.xpath("//div[@class='css-eklmil'][contains(text(),'Bạc')]"));
            actions.click(search2).perform();Thread.sleep(1000);

            WebElement search3 = driver.findElement(By.xpath("//div[@id='js-attributes.laptop_seriescpu']//div[5]"));
            actions.click(search3).perform();Thread.sleep(1000);

            WebElement search4 = driver.findElement(By.xpath("//div[normalize-space()='Full HD']"));
            actions.click(search4).perform();Thread.sleep(5000);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
    // Test thứ 6 và 7
    @Test
    public static void addProduct(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);

            WebElement choce = driver.findElement(By.cssSelector("img[alt='Máy tính xách tay/ Laptop Asus A415EA-EB1474W (i5-1135G7) (Đen)']"));
            actions.click(choce).perform();Thread.sleep(1000);

            WebElement addproduct = driver.findElement(By.xpath("//button[@class='css-1t37g70']//div[@class='css-157jl91']"));
            actions.click(addproduct).perform();Thread.sleep(1000);
            WebElement checkCart = driver.findElement(By.xpath("//a[@target='_self']//div[@class='button css-1e18qtw']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]"));
            actions.click(checkCart).perform();Thread.sleep(5000);

            WebElement remove = driver.findElement(By.xpath("//div[@type='body'][normalize-space()='Xóa']"));
            actions.click(remove).perform();Thread.sleep(3000);

            WebElement accept5 = driver.findElement(By.cssSelector("button.css-1b6a47k"));
            actions.doubleClick(accept5).perform();Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

    // Test thứ 8
    @Test
    public static void checkcode(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);

            WebElement choce = driver.findElement(By.cssSelector("img[alt='Máy tính xách tay/ Laptop Asus A415EA-EB1474W (i5-1135G7) (Đen)']"));
            actions.click(choce).perform();Thread.sleep(1000);

            WebElement addproduct = driver.findElement(By.xpath("//button[@class='css-1t37g70']//div[@class='css-157jl91']"));
            actions.click(addproduct).perform();Thread.sleep(1000);
            WebElement checkCart = driver.findElement(By.xpath("//a[@target='_self']//div[@class='button css-1e18qtw']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]"));
            actions.click(checkCart).perform();Thread.sleep(3000);

            WebElement click = driver.findElement(By.cssSelector("div[class='css-4cffwv'] div[class='css-8x68m']"));
            actions.click(click).perform();Thread.sleep(2000);

            WebElement search = driver.findElement(By.cssSelector("input[placeholder='Nhập mã của bạn']"));
            search.sendKeys("Code Sai Ne");Thread.sleep(3000);

            WebElement apdung = driver.findElement(By.cssSelector("div.css-157jl91"));
            actions.click(apdung).perform();Thread.sleep(5000);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

    // Test thứ 9
    @Test
    public static void Acceptsale(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);

            WebElement choce = driver.findElement(By.cssSelector("img[alt='Chuột máy tính Dareu EM908']"));
            actions.click(choce).perform();Thread.sleep(3000);

            WebElement check= driver.findElement(By.cssSelector("div.css-1aa534q"));
            actions.click(check).perform();Thread.sleep(2000);
            WebElement check2 = driver.findElement(By.cssSelector("div.css-1aa534q"));
            actions.click(check2).perform();Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }


    // Test thứ 10
    @Test
    public static void Yourproduct(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://phongvu.vn/");
            Actions actions = new Actions(driver);

            WebElement choce = driver.findElement(By.xpath("//a[5]//button[1]//div[1]"));
            actions.click(choce).perform();Thread.sleep(3000);

            WebElement check= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/button[1]"));
            actions.click(check).perform();Thread.sleep(2000);
            WebElement check2 = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/button[1]"));
            actions.click(check2).perform();Thread.sleep(3000);
            WebElement check3 = driver.findElement(By.cssSelector("span.css-1ezgv1"));
            actions.click(check3).perform();Thread.sleep(500);
            WebElement check4 = driver.findElement(By.cssSelector("span.css-1ezgv1"));
            actions.click(check4).perform();Thread.sleep(500);
            WebElement check5 = driver.findElement(By.cssSelector("span.css-1ezgv1"));
            actions.click(check5).perform();Thread.sleep(500);
            WebElement check6 = driver.findElement(By.cssSelector("span.css-1ezgv1"));
            actions.click(check6).perform();Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
