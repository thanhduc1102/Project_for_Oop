package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;

public class EditAccountUnitTest5 extends UnitTest {
    public EditAccountUnitTest5(Test test) {
        super(test, "Can not edit account with new email that is duplicated");
    }

    public void test() throws IOException {
//        sign up a new account
        HashMap<String, String> tempParams = SignUpTest.generateDefaultParams();
        SignUpResponse signUpRes = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.SIGN_UP, tempParams, SignUpResponse.class);

        this.params = EditAccountTest.generateDefaultParams();
        this.params.put("email", signUpRes.data.email);
        EditAccountResponse res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
