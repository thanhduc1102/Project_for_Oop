package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest4 extends UnitTest {
    public EditAccountUnitTest4(Test test) {
        super(test, "Can not edit account with wrong email format or with more than 255 characters in email or empty email");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAccountTest.generateDefaultParams();
        this.params.put("email", Util.randomAlphabetString(260));
        EditAccountResponse res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);

        this.params.put("email", "");
        res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);

        this.params.put("email", "wrong email format");
        res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}

