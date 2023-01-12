package com.company.TestManager.TestAPIs._25TotalLikesOfAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._25TotalLikesOfAuction.TotalLikesOfAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class TotalLikesOfAuctionUnitTest1 extends UnitTest {
    public TotalLikesOfAuctionUnitTest1(Test test) {
        super(test, " Response code should be 1000 and data should not be null and Auction total likes");
    }

    @Override
    public void test() throws IOException {
        TotalLikesOfAuctionResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, TotalLikesOfAuctionResponse.class, getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertTrue(res.data.auction_id.equals("1"));
        this.assertion.assertTrue(Integer.parseInt(res.data.total_liked) >= 0);
    }
}
