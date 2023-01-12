package com.company.TestManager.TestAPIs._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest4 extends UnitTest {

    public SignUpUnitTest4(Test test) {
        super(test, "Can not sign up with empty name");
    }

    @Override
    protected void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();
        this.params.put("name", "");
        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
