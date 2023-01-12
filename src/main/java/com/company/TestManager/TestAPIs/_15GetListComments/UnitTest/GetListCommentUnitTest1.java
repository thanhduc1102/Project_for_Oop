package com.company.TestManager.TestAPIs._15GetListComments.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._15GetListComments.GetListCommentResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class GetListCommentUnitTest1 extends UnitTest {
    public GetListCommentUnitTest1(Test test) {
        super(test, "Response code should be 1000, the auction's comment book");
    }

    @Override
    public void test() throws IOException {
        this.params.put("index", "1");
        this.params.put("count", Util.randomNumberString(1, 1, 10));
        GetListCommentResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, GetListCommentResponse.class, getAccessToken());
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertTrue(res.data.comments.size() > 0);
        this.assertion.assertTrue(res.data.comments.size() <= Integer.parseInt(this.params.get("count")));
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 0);
    }
}
