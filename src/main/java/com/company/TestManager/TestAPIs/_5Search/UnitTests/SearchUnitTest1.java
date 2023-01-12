package com.company.TestManager.TestAPIs._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._5Search.SearchResponse;
import com.company.TestManager.TestAPIs._5Search.SearchTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest1 extends UnitTest {
    public SearchUnitTest1(Test test) {
        super(test, "Can search for existed auctions by name (type = 4)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "4");
        this.params.put("key", SearchTest.testAuctionData.title);
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);
        this.assertion.assertTrue(res.data.size() > 0);
    }
}
