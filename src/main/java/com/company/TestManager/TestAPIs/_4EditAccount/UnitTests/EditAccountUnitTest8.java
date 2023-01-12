package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.TestManager.TestAPIs._4EditAccount.ChangePassResponse;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;
import java.util.HashMap;

public class EditAccountUnitTest8 extends UnitTest {
    public EditAccountUnitTest8(Test testClass) {
        super(testClass, "Can change password with correct params");
    }

    @Override
    protected void test() throws IOException {
//        sign up a new account
        HashMap<String, String> signUpParams = SignUpTest.generateDefaultParams();
        Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.SIGN_UP, signUpParams, SignUpResponse.class, null);
        String accessToken = Connection.getAccessToken(this.baseURLString, signUpParams.get("email"), signUpParams.get("password"));

//        edit password
        String pass = Util.randomAlphabetOrNumberString(6, 6);
        this.params.put("old_pass", signUpParams.get("password"));
        this.params.put("new_pass", pass);
        this.params.put("re_pass", pass);
        ChangePassResponse editRes = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CHANGE_PASSWORD, this.params, ChangePassResponse.class, accessToken);
        this.assertion.assertNotEquals(editRes, null);
        this.assertion.assertEquals(editRes.code, 1000);
        this.assertion.assertTrue(editRes.message.length() > 0);
        this.assertion.assertTrue(editRes.data.length() > 0);

//        check if account can login again after change password
        HashMap<String, String> loginParams = new HashMap<>();
        loginParams.put("email", signUpParams.get("email"));
        loginParams.put("password", pass);
        LoginResponse loginRes = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.LOG_IN, loginParams, LoginResponse.class);
        this.assertion.assertNotEquals(loginRes.data, null);
        this.assertion.assertTrue(loginRes.data.access_token.length() > 0);
        this.assertion.assertTrue(loginRes.data.token_type.length() > 0);
        this.assertion.assertTrue(loginRes.data.expires_in.length() > 0);
        this.assertion.assertNotEquals(loginRes.data.user, null);
    }
}
