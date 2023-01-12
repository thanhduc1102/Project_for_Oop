package com.company.TestManager.TestAPIs._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest6 extends UnitTest {
    public SearchUnitTest6(Test test) {
        super(test, "Empty result when searching for auctions with wrong starting price (type = 1)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "1");
        this.params.put("key", "40395");
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 9998);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

        this.params.put("key", "lksf98ds");
        res = this.sendGetRequest(SearchResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 9998);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);
    }
}
