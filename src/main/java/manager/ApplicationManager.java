package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public interface ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd = new ChromeDriver();

    default void init(){
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        helperUser = new HelperUser(wd);
    }

    default void tearDown(){
        wd.quit();
    }



}
