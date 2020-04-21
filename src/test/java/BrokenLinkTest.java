import Page.TableDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import suppliers.DriverFactory;
import util.LinkUtil;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void SetDriver(@Optional("chrome") String browser)
    {
        this.driver= DriverFactory.getDriver(browser);


    }

    @Test
    public void LinkTest()
    {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
                       List<String> list=driver.findElements(By.xpath("//*[@src]"))
                               .stream()
                               .map(e-> e.getAttribute("src"))
                               .filter(link -> LinkUtil.getResponseCode(link)!=200)
                               .collect(Collectors.toList());
                       Assert.assertEquals(list.size(),0,list.toString());
    }
//   @AfterTest
//    public void tearDown()
//   {
//       this.driver.quit();
//   }


}


