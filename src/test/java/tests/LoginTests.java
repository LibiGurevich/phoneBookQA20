package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import javafx.scene.control.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @BeforeTest
    public void preconditionsLogin(){

        logoutIfLogin();

    }


    @Test
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("qwerty@qwer.ty", "Qwerty!1");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("qwerty@qwer.ty")
                .withPassword("Qwerty!1");
        app.getUserHelper().loginWith(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserLombok(){
        UserDTOLombok user = UserDTOLombok.builder()
                .email("qwerty@qwer.ty")
                .password("Qwerty!1")
                .build();
        app.getUserHelper().loginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());

    }

    @Test
    public void negativeLoginUserLombokEmail(){
        UserDTOLombok user = UserDTOLombok.builder()
                .email("qwertyqwer.ty")
                .password("Qwerty!1")
                .build();
        app.getUserHelper().loginUserDtoLombok(user);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Wrong email or password");
        alert.accept();
    }
}
