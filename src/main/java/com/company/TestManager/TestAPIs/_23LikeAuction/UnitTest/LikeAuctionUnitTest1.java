package com.company.TestManager.TestAPIs._23LikeAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._23LikeAuction.LikeAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class LikeAuctionUnitTest1 extends UnitTest {
    public LikeAuctionUnitTest1(Test test) {
        super(test, "Loggined, response code should be 1000, data should not be null and Did you like the auction?");
    }

    @Override
    public void test() throws IOException {
        LikeAuctionResponse res = Connection.sendPostRequest(this.fullURLString + "/5", this.params, LikeAuctionResponse.class, getAccessToken());
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data.user_id, null);
        this.assertion.assertEquals(res.data.auction_id, "5");
    }
}
