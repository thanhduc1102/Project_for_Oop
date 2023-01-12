package com.company.TestManager.TestAPIs._15GetListComments;

import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.Comment;

import java.util.ArrayList;

public class GetListCommentResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Comment> comments;
        public String total;
    }
}
