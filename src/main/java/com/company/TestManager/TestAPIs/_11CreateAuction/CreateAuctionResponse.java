package com.company.TestManager.TestAPIs._11CreateAuction;

import com.company.TestManager.Objects.BaseResponse;

public class CreateAuctionResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String auction_id;
        public String title;
        public String category_id;
        public String selling_user_id;
        public String start_date;
        public String end_date;
        public String status;
        public String reason;
    }
}
