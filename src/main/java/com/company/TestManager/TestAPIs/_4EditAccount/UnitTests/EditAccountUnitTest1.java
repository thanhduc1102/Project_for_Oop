package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class EditAccountUnitTest1 extends UnitTest {
    public EditAccountUnitTest1(Test test) {
        super(test, "Can edit account with correct access token");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAccountTest.generateDefaultParams();
        EditAccountResponse res = Connection.sendPostRequest(this.fullURLString, this.params, EditAccountResponse.class, EditAccountTest.ACCESS_TOKEN);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);
        this.assertion.assertEquals(res.data.name, this.params.get("name"));
        this.assertion.assertEquals(res.data.email, this.params.get("email"));
        this.assertion.assertEquals(res.data.phone, this.params.get("phone"));
        this.assertion.assertEquals(res.data.address, this.params.get("address"));
        this.assertion.assertEquals(res.data.avatar, this.params.get("avatar"));
    }
}

