package com.intellif.auto_opreation;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenChrome {

    public static void OpenChromeTest() throws InterruptedException {
        // 定义firefox驱动程序chrome.driver的安装路径
        System.setProperty("webdriver.chrome.driver", "D:\\6.svn\\workspace\\Selenium_operaTool\\Tools\\chromedriver.exe");

        //初始化一个谷歌浏览器实例，实例名称叫driver
        WebDriver driver =new ChromeDriver();
        //最大化窗口
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //get()打开一个站点
        driver.get("http://190.35.192.2/ifaas/WebClient");
        //getTitle()获取当前页面title的值
        //System.out.println("当前打开页面的标题是：" + driver.getTitle());

        driver.findElement(By.name("username")) .sendKeys("superuser");

        //文本框内输入密码
        driver.findElement(By.name("password")).sendKeys("123456");

        //点击登录
        driver.findElement(By.xpath("//*[@id='login']")).click();



        driver.findElement(By.xpath("//*[@id='system-Face_Detection']")).click();

        Set<String> winHandels = driver.getWindowHandles(); // 得到当前窗口的set集合
        List<String> it = new ArrayList<String>(winHandels); // 将set集合存入list对象
        driver.switchTo().window(it.get(1)); // 切换到弹出的新窗口
        Thread.sleep(1000);
        String url=driver.getCurrentUrl(); //获取新窗口的url
        //System.out.println(url);
        //System.out.println(driver.getPageSource());

        driver.findElement(By.id("input-filterCameraForArea")).sendKeys("丽山路与留仙大道交界处1");
        driver.findElement(By.id("input-filterCameraForArea")).sendKeys(Keys.ENTER);

        String sdf = driver.findElement(By.xpath("//*[@id='alarmList']/li/div/div[1]/h3")).getText();
        System.out.println(sdf);
        String sdf2 = driver.findElement(By.xpath("//*[@id='alarmList']/li/div/div[2]/div[1]/div/div/span")).getText();
        System.out.println(sdf2);

        /*WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div:contains('丽山路与留仙大道交界处1')+div:contains('时间')>div>div>div>div+span:first")));
        WebElement element = driver.findElement(By.cssSelector("div:contains('丽山路与留仙大道交界处1')+div:contains('时间')>div>div>div>div+span:first"));
        System.out.println(element.getText());*/

        //测验可行
        driver.findElement(By.id("select_pic")).sendKeys("C:\\Users\\ADMIN\\Pictures\\Saved Pictures\\2017-10-17-15-44-20-743_format_f.jpg");

        driver.switchTo().frame("ymprompt");
        driver.findElement(By.name("rName")).click();
        driver.findElement(By.xpath("//*[@data-id='4']")).click();
        driver.findElement(By.id("reasonDetail")) .sendKeys("运维自动化检测——开发测试阶段");
        driver.findElement(By.cssSelector(".btn")).click();

        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='barTip search all']")));
        Thread.sleep(1);
        WebElement element = driver.findElement(By.xpath("//*[@class='barTip search all']"));
        System.out.println(element.getText());
        //System.out.println(driver.getPageSource());

        //退出浏览器
        driver.quit();

    }
}