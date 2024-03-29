package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public interface ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

//    WebDriver wd = new ChromeDriver();
//    EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());
    EventFiringWebDriver wd = System.getProperty("browser", BrowserType.CHROME)
            .equals(BrowserType.FIREFOX) ?
            new EventFiringWebDriver(new FirefoxDriver()) :
            new EventFiringWebDriver(new ChromeDriver());
    Properties properties = new Properties();


    default void init() throws IOException {
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
        String target = System.getProperty("target", "pre_prod");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        String link = properties.getProperty("web.baseURL");

        wd.register(new WDListener());
//        wd.navigate().to("https://ilcarro.web.app/search");
        wd.navigate().to(link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        helperUser = new HelperUser(wd);
    }

    default void tearDown(){
        wd.quit();
    }


    default String getEmail(){
        return properties.getProperty("web.email");
    }
    default String getPassword(){
        return properties.getProperty("web.password");
    }

}
