import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
class CodePoltegist{

    public static void main(String args[]) throws InterruptedException, IOException {
        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://Users//amitkumar376//Desktop//MavenBugWar//chromedriver_win32chromedriver.exe");
//Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Amit");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='updatingButton']")).click();
        String keyText = driver.findElement(By.xpath("//input[@type='text']")).getText();
        String buttonText = driver.findElement(By.xpath("//button[@id='updatingButton']")).getText();
        CodePoltegist.screenshot();
        if(keyText.equals(buttonText)){
            System.out.println("Equal");
        }else
        {
            System.out.println("Not Equal");
        }

        driver.findElement(By.xpath("//button[@id='startButton']")).click();
        if(driver.findElement(By.xpath("//div[@class= 'progress']/child::div[contains(text()= '70')]")).equals()){
            CodePoltegist.screenshot();
        }
        driver.findElement(By.xpath("//button[@id='stopButton']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("input[@name='UserName']")).sendKeys("name");
        driver.findElement(By.xpath("input[@name='Password']")).sendKeys("pwd");
        driver.findElement(By.xpath("input[@name='login']")).click();
        CodePoltegist.screenshot();
    }



    public static void screenshot() throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = "Reports\\extentReport\\"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        String relativePath=".\\"+screenshotName+dateName+".png";
    }
}