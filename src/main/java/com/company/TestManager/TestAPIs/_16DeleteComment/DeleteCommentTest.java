package com.company.TestManager.TestAPIs._16DeleteComment;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Objects.Comment;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._14CreateComment.CreateCommentResponse;
import com.company.TestManager.TestAPIs._14CreateComment.CreateCommentTest;
import com.company.TestManager.TestAPIs._15GetListComments.GetListCommentResponse;
import com.company.TestManager.TestAPIs._15GetListComments.GetListCommentsTest;
import com.company.TestManager.TestAPIs._16DeleteComment.UnitTest.DeleteCommentUnitTest1;
import com.company.TestManager.TestAPIs._16DeleteComment.UnitTest.DeleteCommentUnitTest2;
import com.company.TestManager.TestAPIs._16DeleteComment.UnitTest.DeleteCommentUnitTest3;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DeleteCommentTest extends Test {
    public DeleteCommentTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }
    public static String access_token;
    public static String comment_id;
    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new DeleteCommentUnitTest1(this),
                new DeleteCommentUnitTest2(this),
                new DeleteCommentUnitTest3(this)));
    }


    @Override
    protected void beforeAll() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "Cube@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = Connection.sendPostRequest(EndpointConstants.DEFAULT_BASE_URL + "/" + EndpointConstants.LOG_IN, tempParams, LoginResponse.class, null);
        DeleteCommentTest.access_token = res.data.access_token;
        tempParams= CreateCommentTest.generateDefaultParams();
        CreateCommentResponse res1=Connection.sendPostRequest(this.baseURLString+"/"+EndpointConstants.CREATE_COMMENT+"/12",tempParams,CreateCommentResponse.class,access_token);
        tempParams= GetListCommentsTest.generateDefaultParams();
        GetListCommentResponse res2=Connection.sendGetRequest(this.baseURLString+"/"+EndpointConstants.GET_LIST_COMMENTS+"/12",tempParams,GetListCommentResponse.class,null);
        //DeleteCommentTest.comment_id=res2.data.comments.
        for (Comment s : res2.data.comments) {
            DeleteCommentTest.comment_id = s.comment_id;
        }
    }
}
