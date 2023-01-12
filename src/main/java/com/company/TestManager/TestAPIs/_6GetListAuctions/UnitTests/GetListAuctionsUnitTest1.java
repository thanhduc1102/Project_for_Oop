package com.company.TestManager.TestAPIs._6GetListAuctions.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._6GetListAuctions.GetListAuctionsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;
import java.util.stream.IntStream;

public class GetListAuctionsUnitTest1 extends UnitTest {
    public GetListAuctionsUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000, data should not be null and number of auctions should be smaller or equal to count");
    }

    @Override
    public void test() throws IOException {
        String index = "1";
        String count = "5";
        this.params.put("index", index);
        this.params.put("count", count);
        GetListAuctionsResponse res = this.sendGetRequest(GetListAuctionsResponse.class);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.data.auctions.size() <= Integer.parseInt(count));
        this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.auction_id != null && auction.selling_user_id != null && auction.title.length() > 0 && IntStream.range(1, 7).boxed().toList().contains(Integer.parseInt(auction.statusId))));
    }
}
