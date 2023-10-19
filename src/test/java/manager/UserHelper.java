package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnOpenLoginForm = By.xpath("//a[@href='/login']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//button[@name='login']");
    String btnRegistration = "document.querySelector('[name=\"registration\"]').click();\n";
    By textContacts = By.xpath("//a[@href='/contacts']");

  By btnSignOut = By.xpath("//button");

    public void fillLoginUserDto(UserDTO userDTO) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, userDTO.getEmail());
        typeTextBase(inputPassword, userDTO.getPassword());
        clickBase(btnLogin);
    }

    public void fillLoginUserDtoWith(UserDTOWith userDTOWith) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, userDTOWith.getEmail());
        typeTextBase(inputPassword, userDTOWith.getPassword());
        clickBase(btnLogin);
    }

    public boolean validateContactTextDisplaysMainMenu() {
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textContacts, expectedResult);
    }

    public void fillLoginUserDtoLombok(UserDtoLombok user) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, user.getEmail());
        typeTextBase(inputPassword, user.getPassword());
        clickBase(btnLogin);
    }

    public void fillRegUserDtoLombok(UserDtoLombok user) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, user.getEmail());
        typeTextBase(inputPassword, user.getPassword());
        jsClickBase(btnRegistration);
    }

    public boolean validateMessageAlertWrongEmailPasswordCorrect() {
        String expectedResult = "Wrong email or password".toUpperCase();
        String actualResult = getTextAlert();
        return isTextEqualGet2Strings(expectedResult, actualResult);
    }

    public boolean validateMessageAlertWrongEmailPasswordCorrectReg() {
        String expectedResult = "WRONG EMAIL OR PASSWORD FORMAT\n" +
                "            EMAIL MUST CONTAINS ONE @ AND MINIMUM 2 SYMBOLS AFTER LAST DOT\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE UPPERCASE LETTER!\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE LOWERCASE LETTER!\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE DIGIT!\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE SPECIAL SYMBOL FROM [‘$’,’~’,’-‘,’_’]!";
        String actualResult = getTextAlert();
        return isTextEqualGet2Strings(expectedResult, actualResult);
    }

    public boolean buttonSignOutExist() {
        return isElementExist(textContacts);
    }

    public String getTextAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText().toUpperCase().trim();
    }

    public void acceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void logout() {
        clickBase(btnSignOut);
    }
}