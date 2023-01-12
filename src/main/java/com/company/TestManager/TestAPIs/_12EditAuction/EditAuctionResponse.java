package com.company.TestManager.TestAPIs._12EditAuction;

import com.company.TestManager.Objects.BaseResponse;

public class EditAuctionResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String category_id;
        public String start_date;
        public String end_date;
        public String title;
        public String auction_id;
        public String selling_user_id;
        public String status;
        public String reason;


    }
}
