package com.company.TestManager.TestAPIs._29ReadNotifications.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._29ReadNotifications.ReadNotificationsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;
import java.util.List;

public class ReadNotificationsUnitTest1 extends UnitTest {
    public ReadNotificationsUnitTest1(Test test) {
        super(test, "If user logged in, response code should be 1000 and user can read refused notification from admin side");
    }

    @Override
    public void test() throws IOException {
        ReadNotificationsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, ReadNotificationsResponse.class, getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertEquals(res.data.auction_id, "1");
        this.assertion.assertTrue(Integer.parseInt(res.data.is_read) >= 0);
        this.assertion.assertTrue(List.of("1", "2").contains(res.data.type));
        this.assertion.assertNotEquals(res.data.auctions, null);
        this.assertion.assertNotEquals(res.data.items, null);
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 0);
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 0);
    }

}
