package com.company.TestManager.TestAPIs._10GetDetailsAuctions;

import com.company.TestManager.Objects.Auction;
import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.Category;
import com.company.TestManager.Objects.Item;

public class GetDetailsAuctionsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public Auction auctions;
        public Category category;
        public Item items;
        public Selling_user selling_user;
        public Buying_user buying_user;
        public String max_bid;
        public String like;

    }

    public static class Selling_user {
        public String selling_user_id;
        public String selling_user_name;
        public String selling_user_avatar;

    }

    public static class Buying_user {
        public String buying_user_id;
        public String buying_user_name;
        public String buying_user_phone;
        public String buying_user_address;

    }

}