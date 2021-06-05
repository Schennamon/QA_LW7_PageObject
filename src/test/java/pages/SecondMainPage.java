package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.ComparePage;

public class SecondMainPage {
    private WebDriver driver;
    @FindBy(xpath = ".//div[1]/div/div[2]/div/div/div[2]/div[2]/section/div[3]/article[1]/div[2]/div[3]/span[2]/a")
    private WebElement firstItem;

    @FindBy(xpath = ".//div[1]/div/div[2]/div/div/div[2]/div[2]/section/div[3]/article[2]/div[2]/div[3]/span[2]/a")
    private WebElement secondItem;

    @FindBy(xpath = ".//div[1]/div/div[2]/div/div/div[2]/div[2]/section/div[1]/div[1]/a")
    private WebElement compare;

    public SecondMainPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        firstItem.click();
        Thread.sleep(100);
        secondItem.click();
        Thread.sleep(100);
        compare.click();
        Thread.sleep(100);
    }

    public ComparePage choiceItemsCompare(){
        return new ComparePage(driver);
    }
}
