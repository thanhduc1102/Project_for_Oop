package com.company.TestManager.TestAPIs._1SignUp.UnitTests;

import com.company.TestManager.Objects.User;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest1 extends UnitTest {
    public SignUpUnitTest1(Test test) {
        super(test, "With correct params format, the response code should be 1000 and message strings shall be not null as well as non-empty", 1);
    }

    @Override
    public void test() throws IOException {
        //        create request object
        this.params = SignUpTest.generateDefaultParams();

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);


        User user = res.data;
        this.assertion.assertNotEquals(user, null);
        this.assertion.assertEquals(user.name, this.params.get("name"));
        this.assertion.assertEquals(user.role, "2");
        this.assertion.assertTrue(user.avatar.length() > 0);
        this.assertion.assertEquals(user.address, this.params.get("address"));
        this.assertion.assertEquals(user.email, this.params.get("email"));
        this.assertion.assertEquals(user.phone, this.params.get("phone"));
        this.assertion.assertEquals(user.avatar, this.params.get("avatar"));
    }
}
