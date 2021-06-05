import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ComparePage;
import pages.ComputerPage;
import pages.HomePage;
import pages.SecondMainPage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class Main {
    String siteHomePage = "https://pn.com.ua";
    String secondMainPage = "https://pn.com.ua/ct/1221/";
    private static WebDriver driver;
    private HomePage homePage;
    private ComputerPage computerPage;
    private SecondMainPage secondPage;
    private ComparePage comparePage;


    @BeforeClass
    public static void testBeforeClass() throws Exception{
        System.setProperty("webdriver.gecko.driver", "/home/schennamon/Документы/QA/Лаб5/geckodriver/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testComputerCategory(){
        driver.get(siteHomePage);
        homePage = PageFactory.initElements(driver, HomePage.class);
        computerPage = homePage.choiceComputerCategory();
        System.out.println(computerPage.getTextITService());
        computerPage.getTextITService();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        Assert.assertThat(computerPage.getTextITService(), is("IT услуги"));
    }

    @Test
    public void testTaskThree(){
        driver.get(secondMainPage);
        secondPage = PageFactory.initElements(driver, SecondMainPage.class);
        comparePage = secondPage.choiceItemsCompare();
        Assert.assertEquals(comparePage.getCountItems()-1, 2);
        Assert.assertTrue(comparePage.getURL());
    }
}
