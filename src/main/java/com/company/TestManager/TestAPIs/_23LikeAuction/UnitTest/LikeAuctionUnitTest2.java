package com.company.TestManager.TestAPIs._23LikeAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._23LikeAuction.LikeAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class LikeAuctionUnitTest2 extends UnitTest {
    public LikeAuctionUnitTest2(Test test) {
        super(test, "Not loggined, response code should be 1004, data should be null ");
    }

    @Override
    public void test() throws IOException {
        String accessToken = "sdfijosdfjosfjossdfsdfkpospodkfposdkfoewr9034jisofjosdjfois";

        LikeAuctionResponse res = Connection.sendPostRequest(fullURLString + "/5", this.params, LikeAuctionResponse.class, accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.code, 1004);
    }
}
