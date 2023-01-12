package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest2 extends UnitTest {
    public EditAccountUnitTest2(Test test) {
        super(test, "Can not edit account with wrong access token");
    }

    public void test() throws IOException {
        this.params = EditAccountTest.generateDefaultParams();
        EditAccountResponse res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN + Util.randomAlphabetString(5));
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
