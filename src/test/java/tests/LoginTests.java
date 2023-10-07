package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("qwerty@qwer.ty", "Qwerty!1");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("ytrewq@ytre.wq")
                .withPassword("Ytrewq!1");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }
}
