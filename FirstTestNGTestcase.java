import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class FirstTestNGTestcase {
    WebDriver driver; //Driver initilization

    //THIS IS TESTCASES & ALL YOUR SCENARIO.THIS IS FRAMEWORK

    @Test(priority = 1)

    void openBrowser()  //BROWSER SCENARIO
    {
        System.out.println("OPen Browser");
         System.setProperty("webdriver.chrome.driver", "C:\\Software\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();


    }

 @Test(priority = 2)
    void register() throws InterruptedException
 {

     driver.findElement(By.id("gender-female")).click();
     driver.findElement(By.id("FirstName")).sendKeys("Hemantika");
     driver.findElement(By.id("LastName")).sendKeys("Patel");

     WebElement day=driver.findElement(By.name("DateOfBirthDay"));
     WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
     WebElement year=driver.findElement(By.name("DateOfBirthYear"));

     Select select = new Select(day);
     select.selectByIndex(5);
     Select select1 = new Select(month);
     select1.selectByIndex(7);
     Select select2 = new Select(year);
     select2.selectByIndex(73);

     driver.findElement(By.id("Email")).sendKeys("hemarpatel@gmail.com");
     driver.findElement(By.name("Company")).sendKeys("Unify");

     driver.findElement(By.id("Password")).sendKeys("Tester8381");
     Thread.sleep(2000);

     driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("Tester8381");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
 }

    @Test(priority = 3)
    void Login() //lOGIN SCENARIO
    {
        System.out.println("User Login");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("hemrpatel@gmail.co.uk");
        driver.findElement(By.id("Password")).sendKeys("Tester8381");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }

   @Test(priority = 4)

    void closeBrowser () throws InterruptedException //CLOSEBROWSER SCENARIO
        {
        System.out.println("Close Browser");
        Thread.sleep(100);
        driver.quit();

    }


}
