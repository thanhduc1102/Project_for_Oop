package com.company.TestManager.TestAPIs._2Login.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class LoginUnitTest3 extends UnitTest {
    public LoginUnitTest3(Test test) {
        super(test, "With wrong email format, response code should be 1001 and data should be null");
    }

    @Override
    public void test() throws IOException {
        this.params.put("email", Util.randomAlphabetOrNumberString(5, 5));
        this.params.put("password", Util.randomAlphabetOrNumberString(4, 4));

        LoginResponse res = this.sendPostRequest(LoginResponse.class);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
    }
}
