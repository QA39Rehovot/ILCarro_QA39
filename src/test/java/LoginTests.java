import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
    if(isLogged()) logout();
    }

    @Test
    public void loginPositiveTest(){
        openLoginForm();
        fillLoginForm("asd@fgh.com", "$Asdf1234");
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }
    @Test
    public void loginPositiveTest1(){
        openLoginForm();
        fillLoginForm("asd@fgh.com", "$Asdf1234");
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }

}
