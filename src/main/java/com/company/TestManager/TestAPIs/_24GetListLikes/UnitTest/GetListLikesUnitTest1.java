package com.company.TestManager.TestAPIs._24GetListLikes.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._24GetListLikes.GetListLikesResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetListLikesUnitTest1 extends UnitTest {
    public GetListLikesUnitTest1(Test test) {
        super(test, "Loggined, Response code should be 1000, data should be not null and list of auctions that the person who is logged in likes");
    }

    @Override
    public void test() throws IOException {
        this.params.put("index", "1");
        this.params.put("count", "1");

        GetListLikesResponse res = this.sendGetRequestWithAccessToken(GetListLikesResponse.class);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.auction_id != null));
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 0);
    }
}
