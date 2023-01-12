package com.company.TestManager.TestAPIs._29ReadNotifications.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._29ReadNotifications.ReadNotificationsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class ReadNotificationsUnitTest2 extends UnitTest {
    public ReadNotificationsUnitTest2(Test testClass) {
        super(testClass, "If not logged in, user can not read notifications");
    }

    @Override
    protected void test() throws IOException {
        ReadNotificationsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, ReadNotificationsResponse.class, "wrong access token");

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertEquals(res.data, null);

    }
}
