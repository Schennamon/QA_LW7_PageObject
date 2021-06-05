package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComparePage {
    List<WebElement> items;
    private WebDriver driver;

    public ComparePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean getURL() {
        boolean checkURL = true;
        Pattern namePatternCompare = Pattern.compile("compare");
        Matcher nameMatcher = namePatternCompare.matcher(driver.getCurrentUrl());
        if(nameMatcher.find()) {
            System.out.print("URL - true");
        }else{
            System.out.print("URL - false");
            checkURL = false;
        }
        return checkURL;
    }

    public int getCountItems(){
        items = driver.findElements(By.xpath(".//tr[@class='goods-line']/th"));
        return items.size();
    }
}
