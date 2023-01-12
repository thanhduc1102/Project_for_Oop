package com.company.TestManager.TestAPIs._16DeleteComment.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentResponse;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;
import java.util.HashMap;

public class DeleteCommentUnitTest1 extends UnitTest {

    public DeleteCommentUnitTest1(Test test){
        super(test,"With correct params, response code should be 1000 and data should not be null ");
    }
    public void test() throws IOException{
        DeleteCommentResponse res= Connection.sendPostRequest(this.fullURLString+"/"+ DeleteCommentTest.comment_id,new HashMap<>(),DeleteCommentResponse.class,DeleteCommentTest.access_token);

        this.assertion.assertEquals(res.code,1000);
        this.assertion.assertNotEquals(res,null);
        this.assertion.assertNotEquals(res.data,null);
        this.assertion.assertTrue(res.message.length()>0);
    }
}
