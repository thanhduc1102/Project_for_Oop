package com.company.TestManager.TestAPIs._25TotalLikesOfAuction;

import com.company.TestManager.Objects.BaseResponse;

public class TotalLikesOfAuctionResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String auction_id;
        public String total_liked;
    }
}
