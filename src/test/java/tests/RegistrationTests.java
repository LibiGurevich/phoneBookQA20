package tests;

import dto.UserDTOLombok;
import javafx.scene.control.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests{

        @Test
        public void positiveRegistration() {
            String email = randomUtils.generateEmail(7);
            UserDTOLombok user = UserDTOLombok().builder()
                    .email(email)
                    .password("slkru!Yi$")
                    .build();

            app.getUserHelper().loginUserDtoLombok(user);
            Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
        }

    @Test
    public void negativeRegistrationPasswordLetters() {
        String email = randomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok().builder()
                .email(email)
                .password("fffffffff")
                .build();

        app.getUserHelper().loginUserDtoLombok(user);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Wrong email or password format");
        alert.accept();
    }


}
