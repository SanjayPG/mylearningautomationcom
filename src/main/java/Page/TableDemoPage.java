package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class TableDemoPage {

    private final WebDriver driver;

    public TableDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void goTo()
    {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    }

    public void TableDemoPage(Predicate<List<WebElement>> predicateWebElement) throws Exception
    {
        Thread.sleep(2000);
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(tr->tr.findElements(By.tagName("td")))
                .filter(predicateWebElement)
                .map(tdlist->tdlist.get(3))
                .map(td-> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }


}


