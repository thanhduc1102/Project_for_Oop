package com.company.TestManager.TestAPIs._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest7 extends UnitTest {

    public SignUpUnitTest7(Test test) {
        super(test, "Can not sign up with more than 255 characters");
    }

    @Override
    protected void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();
        this.params.put("address", Util.randomAlphabetOrNumberString(130, 130));

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
