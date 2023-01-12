package com.company.TestManager.TestAPIs._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest12 extends UnitTest {
    public SignUpUnitTest12(Test test) {
        super(test, "Can not sign up when password and re_pass are not matched");
    }

    @Override
    protected void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();
        this.params.put("password", Util.randomAlphabetOrNumberString(10, 10));
        this.params.put("re_pass", Util.randomAlphabetOrNumberString(10, 10));

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
