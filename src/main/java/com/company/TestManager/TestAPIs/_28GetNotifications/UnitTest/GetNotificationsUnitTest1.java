package com.company.TestManager.TestAPIs._28GetNotifications.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._28GetNotifications.GetNotificationsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;
import java.util.List;

public class GetNotificationsUnitTest1 extends UnitTest {
    public GetNotificationsUnitTest1(Test test) {
        super(test, "Notification list of rejected auctions, code should be 1000");
    }

    @Override
    public void test() throws IOException {
        this.params.put("index", "1");
        this.params.put("count", "1");

        GetNotificationsResponse res = this.sendGetRequestWithAccessToken(GetNotificationsResponse.class);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertTrue(res.data.denys.size() > 0);
        this.assertion.assertTrue(Integer.parseInt(res.data.total_not_read) >= 0);
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 0);
        this.assertion.assertTrue(res.data.denys.stream().allMatch(denys -> denys.title.length() > 0 && denys.auction_id != null && List.of("1", "2").contains(denys.type) && denys.reason.length() > 0));

    }
}
