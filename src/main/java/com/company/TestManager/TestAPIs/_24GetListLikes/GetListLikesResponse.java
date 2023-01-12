package com.company.TestManager.TestAPIs._24GetListLikes;

import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.Category;

import java.util.ArrayList;

public class GetListLikesResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Auction> auctions;
        public String total;
    }

    public static class Auction {
        public String auction_id;
        public String title;
        public String start_Date;
        public String end_date;
        public String statusId;
        public String status;
        public ArrayList<Category> categories;
        public Boolean is_liked;

    }
}
