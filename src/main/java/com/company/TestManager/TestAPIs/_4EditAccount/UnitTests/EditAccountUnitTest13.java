package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.ChangePassResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest13 extends UnitTest {
    public EditAccountUnitTest13(Test testClass) {
        super(testClass, "Can not change password with wrong repass");
    }

    @Override
    protected void test() throws IOException {
        this.params = EditAccountTest.generateDefaultParams2();
        this.params.put("re_pass", Util.randomAlphabetString(12));
        ChangePassResponse res = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CHANGE_PASSWORD, this.params, ChangePassResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);
    }
}
