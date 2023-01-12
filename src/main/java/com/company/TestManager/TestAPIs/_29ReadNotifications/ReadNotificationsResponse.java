package com.company.TestManager.TestAPIs._29ReadNotifications;

import com.company.TestManager.Objects.BaseResponse;
import com.company.TestManager.Objects.Category;

public class ReadNotificationsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String auction_id;
        public String is_read;
        public String type;
        public Object auctions;
        public Category category;
        public Object items;
        public String total_not_read;
        public String total;
    }
}
