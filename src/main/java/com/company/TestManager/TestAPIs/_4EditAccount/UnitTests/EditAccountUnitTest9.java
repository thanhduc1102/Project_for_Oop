package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.ChangePassResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest9 extends UnitTest {
    public EditAccountUnitTest9(Test testClass) {
        super(testClass, "Can not change password with empty old pass or old pass with more than 255 characters");
    }

    @Override
    protected void test() throws IOException {
        this.params = EditAccountTest.generateDefaultParams2();
//        empty password
        this.params.put("old_pass", "");
        ChangePassResponse res = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CHANGE_PASSWORD, this.params, ChangePassResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
        this.assertion.assertTrue(res.message.length() > 0);

//        more than 255 chars in password
        this.params.put("old_pass", Util.randomAlphabetString(260));
        res = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CHANGE_PASSWORD, this.params, ChangePassResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);
    }
}
