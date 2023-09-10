import models.User;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

@Test
    public void registrationPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;

    User user = new User(
            "John",
            "Silver",
            "john_" + i + "@mail.com",
            "$Asdf1234"
    );

    openRegistrationForm();
    fillRegistrationForm(user);
    submitRegistration();
}


}
