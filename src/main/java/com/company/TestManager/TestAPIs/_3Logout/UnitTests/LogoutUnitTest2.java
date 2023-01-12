package com.company.TestManager.TestAPIs._3Logout.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._3Logout.LogoutResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class LogoutUnitTest2 extends UnitTest {
    public LogoutUnitTest2(Test test) {
        super(test, "Can not log out with wrong access token");
    }

    @Override
    public void test() throws IOException {
        String accessToken = "djsldfgdfdsfsdgdfwrong214fgjksldfgjsdaNiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5cdgjdfgdklzfg"; //wrong access token
        LogoutResponse res = Connection.sendPostRequest(this.fullURLString, this.params, LogoutResponse.class, accessToken);
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
