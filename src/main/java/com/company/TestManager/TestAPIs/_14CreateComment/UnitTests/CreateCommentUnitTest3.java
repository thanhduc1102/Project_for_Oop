package com.company.TestManager.TestAPIs._14CreateComment.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._14CreateComment.CreateCommentResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateCommentUnitTest3 extends UnitTest {
    public CreateCommentUnitTest3(Test test) {
        super(test, "Not logged in, response code should be 1004 and data should be null and comment not contains submitted comment ");
    }

    @Override
    public void test() throws IOException {
        String comment = "Hello";
        this.params.put("content", comment);
        this.params.put("comment_last_id", "10");
        String accessToken = "djsldfgdfdsfsdgdfwrong214fgjksldfgjsdaNiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3fwpMeJf36POk6yJV_adQssw5cdgjdfgdadasdwdwdadeawklzfg";

        CreateCommentResponse res = Connection.sendPostRequest(this.fullURLString + "/1", this.params, CreateCommentResponse.class, accessToken);

        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);
    }
}
