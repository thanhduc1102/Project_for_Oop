package com.company.TestManager.TestAPIs._18GetListBids;

import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.Bid;

import java.util.ArrayList;

public class GetListBidsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Bid> bids;
        public String total;
    }


}
