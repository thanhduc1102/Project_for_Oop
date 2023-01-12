package com.company.TestManager.TestAPIs._22ContactUs;

import com.company.TestManager.Objects.BaseResponse;

public class ContactUsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String name;
        public String phone;
        public String email;
        public String content;
        public String report_type;
    }
}

