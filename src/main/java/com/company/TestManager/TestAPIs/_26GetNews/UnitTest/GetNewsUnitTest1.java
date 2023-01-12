package com.company.TestManager.TestAPIs._26GetNews.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._26GetNews.GetNewsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetNewsUnitTest1 extends UnitTest {
    public GetNewsUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data List of news that admin added ");
    }

    @Override
    public void test() throws IOException {
        this.params.put("index", "0");
        this.params.put("count", "1");

        GetNewsResponse res = Connection.sendGetRequest(this.fullURLString, this.params, GetNewsResponse.class, getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertTrue(res.data.news.size() > 0);
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 0);
    }
}
