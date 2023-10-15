package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[contains(@href, '/login')]");
    By inputEmailLoginForm = By.xpath("//input[@name='email']");
    By inputPasswordLoginForm = By.xpath("//input[@name='password']");
    By btnLoginForm = By.xpath("//button[@type='submit']");
    By textSuccessLogin = By.xpath("//*[text()='CONTACTS'] ");

    By btnLogout = By.xpath("//*[text()='Sign Out']");


    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public void loginWith(UserDTOWith userDTOWith) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTOWith.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTOWith.getPassword());
        clickBase(btnLoginForm);
    }

    public void loginUserDtoLombok(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickByXY(btnLoginForm, 422, 277);
    }



    public boolean validateMessageSuccessAfterLogin() {
        return isTextEqual(textSuccessLogin, "CONTACTS");
    }

    public boolean btnLogoutExist() {
        return isElementExist(btnLogout);
    }


    public void logout() {
        clickBase(btnLogout);
    }
}
