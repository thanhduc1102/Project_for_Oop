package com.company.TestManager.TestAPIs._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest2 extends UnitTest {

    public SignUpUnitTest2(Test test) {
        super(test, "Can not sign up with duplicated emails");
    }

    @Override
    public void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();

        this.sendPostRequest(SignUpResponse.class);
        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);

        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.data, null);
    }
}
