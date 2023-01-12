package com.company.TestManager.TestAPIs._2Login.UnitTests;

import com.company.TestManager.Objects.User;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.TestManager.TestAPIs._2Login.LoginTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class LoginUnitTest1 extends UnitTest {
    //  constructor cần phải thêm expectation
    public LoginUnitTest1(Test test) {
        super(test, "With correct email and password, response code should be 1000 and data should not be null and data contains not null fields");
    }

    @Override
    public void test() throws IOException {
//        truyền các params để gọi request đến server
        String tempEmail = LoginTest.email;
        this.params.put("email", tempEmail);
        this.params.put("password", LoginTest.password);

//        gửi request và truyền vào class của object cần trả về
        LoginResponse res = this.sendPostRequest(LoginResponse.class);

//        đưa ra các giả định
        this.assertion.assertNotEquals(res, null);

        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertInstanceOf(res.message, String.class);

        LoginResponse.Data data = res.data;
        this.assertion.assertNotEquals(data, null);
        this.assertion.assertTrue(data.access_token.length() > 0);
        this.assertion.assertTrue(data.token_type.length() > 0);
        this.assertion.assertTrue(data.expires_in.length() > 0);

        User user = res.data.user;
        this.assertion.assertNotEquals(user, null);
        this.assertion.assertTrue(user.name.length() > 0);
        this.assertion.assertEquals(user.role, "2");
        this.assertion.assertTrue(user.avatar.length() > 0);
        this.assertion.assertEquals(user.email, tempEmail);
        this.assertion.assertTrue(user.phone.length() > 0);

    }
}
