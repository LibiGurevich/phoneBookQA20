package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class RegistrationTests extends BaseTests{

        @Test
        public void positiveRegistration() {
            String email = randomUtils.generateEmail(7);

            UserDTOLombok user = UserDTOLombok.builder()
                    .email(email)
                    .password("123456Aa$")
                    .lastName("abdfg")
                    .name("test")
                    .build();

            app.getUserHelper().login(user);
            Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
        }
}
