package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest7 extends UnitTest {
    public EditAccountUnitTest7(Test test) {
        super(test, "Can not edit account with more than 255 characters in address");
    }

    public void test() throws IOException {
        //        create request object
        this.params = EditAccountTest.generateDefaultParams();
        this.params.put("address", Util.randomAlphabetString(256));
        EditAccountResponse res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
