package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @BeforeMethod
    public void preconditionsLogin() {
        // app.getUserHelper().refreshPage();
        //  app.navigateToMainPage();
        logoutIfLogin();

        // user login
        // user open web not login
    }
        @AfterMethod
                public void postconditionsLogin(){
         if(app.getUserHelper().getTextAlert() != null) {
             app.getUserHelper().acceptAlert();
         }
    }

    UserDTOWith userDTOWith = new UserDTOWith()
            .withEmail("qwerty@qwer.ty")
            .withPassword("Qwerty!1");
    UserDTO userDTO = new UserDTO("qwerty@qwer.ty", "Qwerty!1");

    @Test
    public void positiveLoginUserDto() {
        app.getUserHelper().fillLoginUserDto(userDTO);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void positiveLoginUserDtoWith() {
        app.getUserHelper().fillLoginUserDtoWith(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void positiveLoginUserDtoLombok() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("qwerty@qwer.ty")
                .password("Qwerty!1")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void negativeWrongPasswordWrongSymbol() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("qwerty@qwer.ty")
                .password("Qwerty)1")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrect()); // Wrong email or password
    }

    @Test
    public void negativeWrongPasswordNoLetters() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("qwerty@qwer.ty")
                .password("1234567!1")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrect()); // Wrong email or password
    }

    @Test
    public void negativeWrongPasswordNoDigits() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("qwerty@qwer.ty")
                .password("Qwerty!!")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrect()); // Wrong email or password
    }

    @Test
    public void negativeNoPassword() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("qwerty@qwer.ty")
                .password("")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrect()); // Wrong email or password
    }

    @Test
    public void negativeNoAtInEmail() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("qwertyqwer.ty")
                .password("Qwerty!1")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrect()); // Wrong email or password
    }

    @Test
    public void negativeNoData() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("")
                .password("")
                .build();
        app.getUserHelper().fillLoginUserDtoLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrect()); // Wrong email or password
    }

}