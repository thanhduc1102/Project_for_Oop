package com.company.TestManager.TestAPIs._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest3 extends UnitTest {
    public SignUpUnitTest3(Test test) {
        super(test, "Can not sign up with more than 255 characters in name");
    }


    @Override
    protected void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();
        this.params.put("name", Util.randomAlphabetString(269));
        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
