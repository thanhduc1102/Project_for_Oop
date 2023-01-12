package com.company.TestManager.TestAPIs._6GetListAuctions;

import com.company.TestManager.Objects.Auction;
import com.company.TestManager.Objects.BaseResponse;

import java.util.ArrayList;

public class GetListAuctionsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Auction> auctions;
        public Integer total;
    }
}
