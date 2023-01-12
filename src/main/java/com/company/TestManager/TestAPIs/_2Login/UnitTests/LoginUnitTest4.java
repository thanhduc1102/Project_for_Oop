package com.company.TestManager.TestAPIs._2Login.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class LoginUnitTest4 extends UnitTest {
    public LoginUnitTest4(Test test) {
        super(test, "Can not login with more than 255 characters in email or empty email");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("email", Util.randomAlphabetOrNumberString(200, 60) + "@gmail.com");
        this.params.put("password", Util.randomAlphabetOrNumberString(10, 10));
        LoginResponse res = this.sendPostRequest(LoginResponse.class);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);

        this.params.put("email", "");
        res = this.sendPostRequest(LoginResponse.class);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
    }
}
