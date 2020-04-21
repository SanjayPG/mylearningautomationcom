package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PriceDemoPage {

    private final WebDriver driver;


    @FindBy(id="status")
    private WebElement status;


    public PriceDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMinimumPrice() throws Exception {
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");

        Thread.sleep(2000);
        List<WebElement> rowList = this.driver.findElements(By.tagName("tr"));
        System.out.println(rowList.get(0).toString());

        Optional<List<WebElement>> minRow = rowList.stream()
                .skip(1)
                .map(row -> row.findElements(By.tagName("td")))
                .min(Comparator.comparing(tdlist -> Integer.parseInt(tdlist.get(2).getText())));

        if (minRow.isPresent()) {
            List<WebElement> cells = minRow.get();
            cells.get(3).findElement(By.tagName("input")).click();
        }

    }
        public String getStatus()
        {

            return this.status.getText().trim();

        }

    }


