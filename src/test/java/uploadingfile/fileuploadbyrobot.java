package uploadingfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class fileuploadbyrobot {

        WebDriver driver;
        @Test

           void uploadingfile() throws AWTException, InterruptedException {

            driver.findElement(By.xpath("//*[@id='registerThemeDefault']/div/div[3]/div/div/div/form/div[1]/div[2]/div/div/div[1]/div/label/i")).click();
            Thread.sleep(2000);

            Robot robo=new Robot();

            //copy filepath into the clipboard
            StringSelection str=new StringSelection("E:\\My Folder\\RESUME.docx");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);

            //pressing control+v
            robo.keyPress(KeyEvent.VK_CONTROL);
            robo.keyPress(KeyEvent.VK_V);

            //releasing copntrol+v
            robo.keyPress(KeyEvent.VK_CONTROL);
            robo.keyPress(KeyEvent.VK_V);

            //pressing enter
            robo.keyPress(KeyEvent.VK_ENTER);

            //releasing enter
            robo.keyPress(KeyEvent.VK_ENTER);

    }

        @BeforeTest
        void openurl() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://www.monsterindia.com/seeker/registration");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @AfterTest
        void closeBrowser() {
                System.out.println("File Upload Successfully");

                driver.quit();
        }


}