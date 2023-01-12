package com.company.TestManager.TestAPIs._27ReadNews.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._27ReadNews.ReadNewsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class ReadNewsUnitTest1 extends UnitTest {
    public ReadNewsUnitTest1(Test test) {
        super(test, "Response code should be 1000, Read the notice from the version auction");
    }

    @Override
    public void test() throws IOException {
        ReadNewsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, ReadNewsResponse.class, getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data.is_read, null);
        this.assertion.assertTrue(res.data.new_id.length() > 0);
        this.assertion.assertTrue(res.data.content.length() > 0);
        this.assertion.assertNotEquals(res.data.user_id, null);
        this.assertion.assertTrue(res.data.title.length() > 0);
        this.assertion.assertTrue(res.data.user_create_name.length() > 0);
        this.assertion.assertNotEquals(res.data.updated_at, null);
    }
}
