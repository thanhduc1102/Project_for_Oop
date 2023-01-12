package com.company.TestManager.TestAPIs._21AcceptMaxBid;

import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.User;

import java.util.ArrayList;

public class AcceptMaxBidResponse extends BaseResponse {
    public Data data;

    public static class Data{
        public Item_info item_info;
        public ArrayList<Auction_info> auction_info;
    }
    public static class Auction_info{
        public String title;
        public String start_date;
        public String end_date;
    }
    public static class Item_info{
        public String name;
        public User selling_user;
        public User buying_user;
        public String brand;
        public String series;
        public String starting_price;
        public String max_price;
        public String selling_info;

    }


}
