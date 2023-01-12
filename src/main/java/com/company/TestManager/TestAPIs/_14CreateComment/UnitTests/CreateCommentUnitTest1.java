package com.company.TestManager.TestAPIs._14CreateComment.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._14CreateComment.CreateCommentResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class CreateCommentUnitTest1 extends UnitTest {
    //    content
//            comment_last_id
    public CreateCommentUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null and comment contains submitted comment ");
    }

    @Override
    public void test() throws IOException {
        String comment = Util.randomAlphabetOrNumberString(5, 15);
        this.params.put("content", comment);
        this.params.put("comment_last_id", "10");

        CreateCommentResponse res = Connection.sendPostRequest(this.fullURLString + "/1", this.params, CreateCommentResponse.class, this.getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 1);
        this.assertion.assertTrue(res.data.comments.size() >= 1);
        this.assertion.assertTrue(res.data.comments.stream().map(cm -> cm.content).toList().contains(comment));
    }
}
