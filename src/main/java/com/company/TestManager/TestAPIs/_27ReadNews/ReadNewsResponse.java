package com.company.TestManager.TestAPIs._27ReadNews;

import com.company.TestManager.Objects.BaseResponse;

public class ReadNewsResponse extends BaseResponse {
    public Data data;

    public static class Data {

        public String is_read;
        public String new_id;
        public String content;
        public String user_id;
        public String title;
        public String updated_at;
        public String user_create_name;
    }
}
