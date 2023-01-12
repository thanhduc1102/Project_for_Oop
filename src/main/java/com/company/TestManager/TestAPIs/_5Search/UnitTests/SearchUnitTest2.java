package com.company.TestManager.TestAPIs._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest2 extends UnitTest {
    public SearchUnitTest2(Test test) {
        super(test, "Empty result when searching for auction names doesnt exist (type = 4)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "4");
        this.params.put("key", "sklfskf");
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 9998);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);
    }
}
