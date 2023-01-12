package com.company.TestManager.TestAPIs._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._5Search.SearchResponse;
import com.company.TestManager.TestAPIs._5Search.SearchTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest4 extends UnitTest {
    public SearchUnitTest4(Test test) {
        super(test, "Can search for existed auctions by end date (type = 3)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "3");
        this.params.put("key", SearchTest.testAuctionData.end_date);
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertTrue(res.data.size() > 0);
    }
}
