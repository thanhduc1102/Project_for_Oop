package com.company.TestManager.TestAPIs._14CreateComment;

import com.company.TestManager.Objects.BaseResponse;


public class CreateCommentResponse2 extends BaseResponse {
    public Data data;

    public static class Data {
        public String auction_id;
        public String user_id;
        public String content;
        public String update_at;
        public String total;
    }
}