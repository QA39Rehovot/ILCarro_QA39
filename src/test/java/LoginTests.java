import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void loginPositiveTest(){
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
