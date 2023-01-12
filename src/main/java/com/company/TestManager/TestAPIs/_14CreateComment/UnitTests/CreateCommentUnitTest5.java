package com.company.TestManager.TestAPIs._14CreateComment.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._14CreateComment.CreateCommentResponse2;
import com.company.TestManager.TestAPIs._15GetListComments.GetListCommentResponse;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;
import java.util.HashMap;

public class CreateCommentUnitTest5 extends UnitTest {
    public CreateCommentUnitTest5(Test testClass) {
        super(testClass, "Test for user not miss any comments");
    }

    @Override
    protected void test() throws IOException {
        String accessToken = this.getAccessToken();
        GetListCommentResponse res = Connection.sendGetRequest(this.baseURLString + "/" + EndpointConstants.GET_LIST_COMMENTS + "/1", new HashMap<>(), GetListCommentResponse.class, accessToken);
        String comment_last_id = res.data.comments.get(0).comment_id;
        this.params.put("content", Util.randomAlphabetOrNumberString(10, 10));
        this.params.put("comment_last_id", comment_last_id);
        CreateCommentResponse2 res2 = Connection.sendPostRequest(this.fullURLString + "/1", this.params, CreateCommentResponse2.class, accessToken);
        this.assertion.assertNotEquals(res2, null);
        this.assertion.assertNotEquals(res2.data, null);
        this.assertion.assertEquals(res2.code, 1000);
        this.assertion.assertTrue(res2.message.length() > 0);
        this.assertion.assertEquals(res2.data.auction_id, "1");
        this.assertion.assertNotEquals(res2.data.user_id, null);
        this.assertion.assertTrue(res2.data.content.equals(this.params.get("content")));
        this.assertion.assertTrue(Integer.parseInt(res2.data.total) > 0);
    }
}
