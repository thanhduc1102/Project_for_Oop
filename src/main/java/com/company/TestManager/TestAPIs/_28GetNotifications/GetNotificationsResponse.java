package com.company.TestManager.TestAPIs._28GetNotifications;

import com.company.TestManager.Objects.BaseResponse;

import java.util.ArrayList;

public class GetNotificationsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Denys> denys;
        public String total_not_read;
        public String total;
    }

    public static class Denys {
        public String title;
        public String start_date;
        public String end_date;
        public String reason;
        public String auction_id;
        public String updated_at;
        public String type;
        public String is_read;
    }
}
