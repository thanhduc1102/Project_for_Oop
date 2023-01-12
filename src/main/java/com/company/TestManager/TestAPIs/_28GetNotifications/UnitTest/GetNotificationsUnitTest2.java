package com.company.TestManager.TestAPIs._28GetNotifications.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._28GetNotifications.GetNotificationsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetNotificationsUnitTest2 extends UnitTest {
    public GetNotificationsUnitTest2(Test test) {
        super(test, "Not Loggined, code should be 1004, data should be null");
    }

    @Override
    public void test() throws IOException {
        String accessToken = "fskdfnsdjflksdfjlskdfklksdfjlsdklfsdklfksl";

        GetNotificationsResponse res = Connection.sendGetRequest(fullURLString, this.params, GetNotificationsResponse.class, accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertTrue(res.message.length() > 0);

    }
}
