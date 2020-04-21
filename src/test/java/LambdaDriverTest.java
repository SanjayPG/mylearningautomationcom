import Page.TableDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import suppliers.DriverFactory;

import java.sql.SQLOutput;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.Thread.*;

public class LambdaDriverTest {

    private WebDriver driver;
    private TableDemoPage demoPage;

    private Predicate<List<WebElement>> allMale= l-> l.get(1).getText().equalsIgnoreCase("Male");
    private Predicate<List<WebElement>> allFemale= l-> l.get(1).getText().equalsIgnoreCase("Female");

    @BeforeTest
    @Parameters("browser")
    public void SetDriver(@Optional("chrome") String browser)
    {
        driver=DriverFactory.getDriver(browser);
        demoPage=new TableDemoPage(driver);

    }

   @Test(dataProvider = "CriteriaProvider")
    public void googleTest(Predicate<List<WebElement>> criteria)  throws Exception
   {
          demoPage.goTo();
          demoPage.TableDemoPage(criteria);
   }

   @DataProvider(name="CriteriaProvider")
   public Object dataProvider()
   {
        Predicate<List<WebElement>> allMale= l-> l.get(1).getText().equalsIgnoreCase("Male");
        Predicate<List<WebElement>> allFemale= l-> l.get(1).getText().equalsIgnoreCase("Female");
        Predicate<List<WebElement>> allGender= allMale.or(allFemale);

       Predicate<List<WebElement>> CountryUSA= l-> l.get(2).getText().equalsIgnoreCase("USA");
       Predicate<List<WebElement>> maleStayinUSA= allMale.and(CountryUSA);

        Object[] data=new Object[]{
                allMale,
                allFemale,
                allGender,
                CountryUSA,
                maleStayinUSA
        };
return  data;

   }

//   @AfterTest
//    public void tearDown()
//   {
//       this.driver.quit();
//   }


}
