package com.company.TestManager.TestAPIs._16DeleteComment.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentResponse;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;
import java.util.HashMap;

public class DeleteCommentUnitTest3 extends UnitTest {
    public DeleteCommentUnitTest3(Test test){
        super(test,"No editing permission (Auctions not created by the user),response code should be 1006 and data should be null");
    }
    @Override
    public void test() throws IOException {
        DeleteCommentResponse res = Connection.sendPostRequest(this.fullURLString + "/" + Util.randomNumberString(1, 54, 58), new HashMap<>(), DeleteCommentResponse.class, DeleteCommentTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1006);
        this.assertion.assertEquals(res.data, null);

    }
}
