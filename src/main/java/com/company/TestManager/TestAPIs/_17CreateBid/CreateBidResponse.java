package com.company.TestManager.TestAPIs._17CreateBid;

import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.Bid;

import java.util.ArrayList;

public class CreateBidResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Bid> bids;
        public String total;
    }

}
