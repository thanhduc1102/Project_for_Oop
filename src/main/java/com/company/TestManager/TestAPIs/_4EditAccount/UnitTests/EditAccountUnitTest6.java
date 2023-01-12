package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest6 extends UnitTest {
    public EditAccountUnitTest6(Test test) {
        super(test, "Can not edit account with more than 60 characters in phone or empty phone");
    }

    public void test() throws IOException {
        this.params = EditAccountTest.generateDefaultParams();
        this.params.put("phone", Util.randomAlphabetString(61));
        EditAccountResponse res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);

        this.params.put("phone", "");
        res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
