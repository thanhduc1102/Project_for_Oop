package com.company.TestManager.TestAPIs._16DeleteComment;

import com.company.TestManager.Objects.BaseResponse;

public class DeleteCommentResponse extends BaseResponse {
    public Data data;
    public static class Data{
        public String total;
        public String message;
    }
}
