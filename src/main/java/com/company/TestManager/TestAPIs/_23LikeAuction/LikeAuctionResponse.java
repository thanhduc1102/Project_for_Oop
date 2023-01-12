package com.company.TestManager.TestAPIs._23LikeAuction;

import com.company.TestManager.Objects.BaseResponse;

public class LikeAuctionResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String user_id;
        public String auction_id;
        public Boolean is_liked;

    }
}
