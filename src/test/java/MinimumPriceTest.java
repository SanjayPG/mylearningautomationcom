import Page.PriceDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import suppliers.DriverFactory;
import util.LinkUtil;

import java.util.List;
import java.util.stream.Collectors;

public class MinimumPriceTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void SetDriver(@Optional("chrome") String browser)
    {
        this.driver= DriverFactory.getDriver(browser);


    }

    @Test
    public void minPriceTest() throws Exception
    {

        PriceDemoPage pr=new PriceDemoPage(driver);
        pr.clickOnMinimumPrice();
       String status=pr.getStatus();

       Assert.assertEquals("PASS",status);

    }




}
