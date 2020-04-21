package suppliers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Supplier<WebDriver> chromedriver = ()->{
        System.setProperty("webdriver.chrome.driver","F:\\mylearningautomationcom\\target\\Driver\\chromedriver.exe");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxdriver = ()->{
        System.setProperty("webdriver.gecko.driver","F:\\mylearningautomationcom\\target\\Driver\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static final Map<String,Supplier<WebDriver>> MAP = new HashMap<String, Supplier<WebDriver>>();

    static {
        MAP.put("chrome", chromedriver);
        MAP.put("firefox", firefoxdriver);
    }

    public static WebDriver getDriver(String browser){
     return MAP.get(browser).get();
    }











}
