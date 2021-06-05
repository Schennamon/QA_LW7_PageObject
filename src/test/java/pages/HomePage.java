package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.ComputerPage;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = ".//*[@id='column-center']/section/div[1]/a")
    private WebElement computerCategory;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComputerPage choiceComputerCategory(){
        computerCategory.click();
        return new ComputerPage(driver);
    }
}
