package com.company.TestManager.TestAPIs._16DeleteComment.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentResponse;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;
import java.util.HashMap;

public class DeleteCommentUnitTest2 extends UnitTest {
    public DeleteCommentUnitTest2(Test test){
        super(test,"If you are not logged in, the server will return code 1004");
    }
    @Override
    public void test() throws IOException {
        DeleteCommentResponse res = Connection.sendPostRequest(this.fullURLString + "/" + DeleteCommentTest.comment_id, new HashMap<>(), DeleteCommentResponse.class, null);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertEquals(res.data, null);
    }
}
